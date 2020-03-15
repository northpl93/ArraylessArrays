package pl.north93.arrays.impl;

final class ArrayClassLoader extends ClassLoader
{
    public Class<?> loadClass(final String name, final byte[] bytes)
    {
        final String withDots = name.replace('/', '.');
        return this.defineClass(withDots, bytes, 0, bytes.length);
    }

    public static String getClassName(final String simpleName)
    {
        final String originalName = ArrayClassLoader.class.getPackageName();

        final String nameWithSlashes = originalName.replace('.', '/');
        return nameWithSlashes + "/" + simpleName;
    }

    static
    {
        registerAsParallelCapable();
    }
}
