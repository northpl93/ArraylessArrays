package pl.north93.arrays.impl;

import pl.north93.arrays.Array;
import pl.north93.arrays.ArrayType;
import pl.north93.arrays.BooleanArray;
import pl.north93.arrays.ByteArray;
import pl.north93.arrays.CharArray;
import pl.north93.arrays.DoubleArray;
import pl.north93.arrays.FloatArray;
import pl.north93.arrays.IntArray;
import pl.north93.arrays.LongArray;
import pl.north93.arrays.ShortArray;
import pl.north93.arrays.jvm.HotSpotMemoryAccess;
import pl.north93.arrays.jvm.MemoryAccess;

public class ArrayFactory
{
    private final MemoryAccess memoryAccess = new HotSpotMemoryAccess();
    private final ClassGenerator classGenerator = new ClassGenerator();

    public <T> Array<T> getObjectArray(Class<T> type, final int size)
    {
        final Object storage = this.createStorageObject(ArrayType.OBJECT, size);
        return new ObjectArrayImpl<>(this.memoryAccess, storage, size);
    }

    public BooleanArray getBooleanArray(final int size)
    {
        final Object storage = this.createStorageObject(ArrayType.BOOLEAN, size);
        return new BooleanArrayImpl(this.memoryAccess, storage, size);
    }

    public ByteArray getByteArray(final int size)
    {
        final Object storage = this.createStorageObject(ArrayType.BYTE, size);
        return new ByteArrayImpl(this.memoryAccess, storage, size);
    }

    public CharArray getCharArray(final int size)
    {
        final Object storage = this.createStorageObject(ArrayType.CHAR, size);
        return new CharArrayImpl(this.memoryAccess, storage, size);
    }

    public ShortArray getShortArray(final int size)
    {
        final Object storage = this.createStorageObject(ArrayType.SHORT, size);
        return new ShortArrayImpl(this.memoryAccess, storage, size);
    }

    public IntArray getIntArray(final int size)
    {
        final Object storage = this.createStorageObject(ArrayType.INTEGER, size);
        return new IntArrayImpl(this.memoryAccess, storage, size);
    }

    public FloatArray getFloatArray(final int size)
    {
        final Object storage = this.createStorageObject(ArrayType.FLOAT, size);
        return new FloatArrayImpl(this.memoryAccess, storage, size);
    }

    public LongArray getLongArray(final int size)
    {
        final Object storage = this.createStorageObject(ArrayType.LONG, size);
        return new LongArrayImpl(this.memoryAccess, storage, size);
    }

    public DoubleArray getDoubleArray(final int size)
    {
        final Object storage = this.createStorageObject(ArrayType.DOUBLE, size);
        return new DoubleArrayImpl(this.memoryAccess, storage, size);
    }

    private Object createStorageObject(final ArrayType arrayType, final int size)
    {
        if (size < 0)
        {
            throw new IllegalArgumentException("Negative array size");
        }
        else if (size == 0)
        {
            return null;
        }

        final Class<?> clazz = this.classGenerator.getClassForArray(arrayType, size);
        return this.memoryAccess.instantiate(clazz);
    }
}
