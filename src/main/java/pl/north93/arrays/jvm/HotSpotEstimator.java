package pl.north93.arrays.jvm;

import java.lang.reflect.Field;

import lombok.ToString;
import lombok.experimental.UtilityClass;
import sun.misc.Unsafe;

@UtilityClass
class HotSpotEstimator
{
    public static long estimateHeaderSize(final Unsafe unsafe)
    {
        final Field firstField = FieldHolder.class.getDeclaredFields()[0];
        return unsafe.objectFieldOffset(firstField);
    }

    public static long estimateOopSize(final Unsafe unsafe)
    {
        final Field[] fields = FieldHolder.class.getDeclaredFields();

        final long firstOffset = unsafe.objectFieldOffset(fields[0]);
        final long secondOffset = unsafe.objectFieldOffset(fields[1]);

        return secondOffset - firstOffset;
    }

    @ToString(onlyExplicitlyIncluded = true)
    private static class FieldHolder
    {
        private final Object oop1 = null, oop2 = null;
    }
}
