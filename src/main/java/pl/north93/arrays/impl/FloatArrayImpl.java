package pl.north93.arrays.impl;

import pl.north93.arrays.FloatArray;
import pl.north93.arrays.jvm.MemoryAccess;

class FloatArrayImpl extends BaseArrayImpl<Float> implements FloatArray
{
    public FloatArrayImpl(final MemoryAccess memoryAccess, final Object storage, final int size)
    {
        super(memoryAccess, storage, size);
    }

    @Override
    public float getFloat(final int index)
    {
        this.checkIndex(index);
        return this.memoryAccess.readFloatFrom(this.storage, index);
    }

    @Override
    public void setFloat(final int index, final float value)
    {
        this.checkIndex(index);
        this.memoryAccess.setFloatIn(this.storage, index, value);
    }

    @Override
    public Float get(final int index)
    {
        return this.getFloat(index);
    }

    @Override
    public void set(final int index, final Float value)
    {
        this.setFloat(index, value);
    }
}
