package pl.north93.arrays.jvm;

import java.lang.reflect.Field;
import java.text.MessageFormat;

import sun.misc.Unsafe;

public final class HotSpotMemoryAccess implements MemoryAccess
{
    private static final Unsafe UNSAFE;
    private static final long LONG_SIZE = 8;
    private static final long DOUBLE_SIZE = 8;
    private static final long INTEGER_SIZE = 4;
    private static final long FLOAT_SIZE = 4;
    private static final long SHORT_SIZE = 2;
    private static final long CHAR_SIZE = 2;
    private static final long BYTE_SIZE = 1;
    private static final long BOOLEAN_SIZE = 1;
    private static final long OOP_SIZE;
    private static final long HEADER_SIZE;

    @Override
    public Object instantiate(final Class<?> clazz)
    {
        try
        {
            return UNSAFE.allocateInstance(clazz);
        }
        catch (final InstantiationException e)
        {
            throw new RuntimeException("Failed to instantiate class via Unsafe", e);
        }
    }

    @Override
    public Object readObjectFrom(final Object object, final int index)
    {
        //System.out.println("get(" + object + ", " + offset + ")");
        final long offset = this.getFieldLocation(OOP_SIZE, index);
        return UNSAFE.getObject(object, offset);
    }

    @Override
    public void setObjectIn(final Object object, final int index, final Object value)
    {
        //System.out.println("set(" + object + ", " + offset + ", " + value + ")");
        final long offset = this.getFieldLocation(OOP_SIZE, index);
        UNSAFE.putObject(object, offset, value);
    }

    @Override
    public boolean readBooleanFrom(final Object object, final int index)
    {
        final long offset = this.getFieldLocation(BOOLEAN_SIZE, index);
        return UNSAFE.getBoolean(object, offset);
    }

    @Override
    public void setBooleanIn(final Object object, final int index, final boolean value)
    {
        final long offset = this.getFieldLocation(BOOLEAN_SIZE, index);
        UNSAFE.putBoolean(object, offset, value);
    }

    @Override
    public byte readByteFrom(final Object object, final int index)
    {
        final long offset = this.getFieldLocation(BYTE_SIZE, index);
        return UNSAFE.getByte(object, offset);
    }

    @Override
    public void setByteIn(final Object object, final int index, final byte value)
    {
        final long offset = this.getFieldLocation(BYTE_SIZE, index);
        UNSAFE.putByte(object, offset, value);
    }

    @Override
    public short readShortFrom(final Object object, final int index)
    {
        final long offset = this.getFieldLocation(SHORT_SIZE, index);
        return UNSAFE.getShort(object, offset);
    }

    @Override
    public void setShortIn(final Object object, final int index, final short value)
    {
        final long offset = this.getFieldLocation(SHORT_SIZE, index);
        UNSAFE.putShort(object, offset, value);
    }

    @Override
    public char readCharFrom(final Object object, final int index)
    {
        final long offset = this.getFieldLocation(CHAR_SIZE, index);
        return UNSAFE.getChar(object, offset);
    }

    @Override
    public void setCharIn(final Object object, final int index, final char value)
    {
        final long offset = this.getFieldLocation(CHAR_SIZE, index);
        UNSAFE.putChar(object, offset, value);
    }

    @Override
    public int readIntFrom(final Object object, final int index)
    {
        final long offset = this.getFieldLocation(INTEGER_SIZE, index);
        return UNSAFE.getInt(object, offset);
    }

    @Override
    public void setIntIn(final Object object, final int index, final int value)
    {
        final long offset = this.getFieldLocation(INTEGER_SIZE, index);
        UNSAFE.putInt(object, offset, value);
    }

    @Override
    public long readLongFrom(final Object object, final int index)
    {
        final long offset = this.getFieldLocation(LONG_SIZE, index);
        return UNSAFE.getLong(object, offset);
    }

    @Override
    public void setLongIn(final Object object, final int index, final long value)
    {
        final long offset = this.getFieldLocation(LONG_SIZE, index);
        UNSAFE.putLong(object, offset, value);
    }

    @Override
    public double readDoubleFrom(final Object object, final int index)
    {
        final long offset = this.getFieldLocation(DOUBLE_SIZE, index);
        return UNSAFE.getDouble(object, offset);
    }

    @Override
    public void setDoubleIn(final Object object, final int index, final double value)
    {
        final long offset = this.getFieldLocation(DOUBLE_SIZE, index);
        UNSAFE.putDouble(object, offset, value);
    }

    @Override
    public float readFloatFrom(final Object object, final int index)
    {
        final long offset = this.getFieldLocation(FLOAT_SIZE, index);
        return UNSAFE.getFloat(object, offset);
    }

    @Override
    public void setFloatIn(final Object object, final int index, final float value)
    {
        final long offset = this.getFieldLocation(FLOAT_SIZE, index);
        UNSAFE.putFloat(object, offset, value);
    }

    private long getFieldLocation(final long fieldSize, final int index)
    {
        return fieldSize * index + HEADER_SIZE;
    }

    static
    {
        try
        {
            final Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
            unsafeField.setAccessible(true);

            UNSAFE = (Unsafe) unsafeField.get(null);
        }
        catch (final Exception e)
        {
            throw new RuntimeException("Can't access Unsafe", e);
        }

        OOP_SIZE = HotSpotEstimator.estimateOopSize(UNSAFE);
        HEADER_SIZE = HotSpotEstimator.estimateHeaderSize(UNSAFE);

        System.out.println(MessageFormat.format("OOP_SIZE: {0}, HEADER_SIZE: {1}", OOP_SIZE, HEADER_SIZE));
    }
}
