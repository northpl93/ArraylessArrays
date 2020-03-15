package pl.north93.arrays.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import lombok.ToString;
import pl.north93.arrays.ArrayType;

@ToString
final class ClassGenerator implements Opcodes
{
    private final Map<ClassCacheKey, Class<?>> classCache = new ConcurrentHashMap<>();
    private final ArrayClassLoader classLoader = new ArrayClassLoader();

    public Class<?> getClassForArray(final ArrayType arrayType, final int fields)
    {
        final ClassCacheKey cacheKey = new ClassCacheKey(fields, arrayType);
        return this.classCache.computeIfAbsent(cacheKey, this::generateClass);
    }

    private Class<?> generateClass(final ClassCacheKey cacheKey)
    {
        final ClassWriter classWriter = new ClassWriter(0);

        final String className = this.generateClassName(cacheKey);
        classWriter.visit(V11, ACC_PUBLIC + ACC_FINAL, className, "Ljava/lang/Object;", "java/lang/Object", null);

        // we don't need constructor because we're using Unsafe#allocateInstance
        //this.generateConstructor(classWriter);

        for (int i = 0; i < cacheKey.getSize(); i++)
        {
            final String fieldName = Integer.toString(i);
            final String fieldDescriptor = cacheKey.getType().getFieldDescriptor();

            final FieldVisitor fieldVisitor = classWriter.visitField(ACC_PUBLIC, fieldName, fieldDescriptor, null, null);
            fieldVisitor.visitEnd();
        }

        classWriter.visitEnd();

        final byte[] byteCode = classWriter.toByteArray();
        return this.classLoader.loadClass(className, byteCode);
    }

    private String generateClassName(final ClassCacheKey cacheKey)
    {
        final String typeName = cacheKey.getType().name();
        return ArrayClassLoader.getClassName("ARRAY_" + typeName + "_" + cacheKey.getSize());
    }

    private void generateConstructor(final ClassWriter classWriter)
    {
        final MethodVisitor visitor = classWriter.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
        visitor.visitCode();
        visitor.visitVarInsn(ALOAD, 0);
        visitor.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        visitor.visitInsn(RETURN);
        visitor.visitMaxs(1, 1);
        visitor.visitEnd();
    }
}