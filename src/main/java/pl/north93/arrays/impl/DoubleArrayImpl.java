package pl.north93.arrays.impl;

import pl.north93.arrays.DoubleArray;
import pl.north93.arrays.jvm.MemoryAccess;

class DoubleArrayImpl extends BaseArrayImpl<Double> implements DoubleArray
{
    public DoubleArrayImpl(final MemoryAccess memoryAccess, final Object storage, final int size)
    {
        super(memoryAccess, storage, size);
    }

    @Override
    public double getDouble(final int index)
    {
        this.checkIndex(index);
        return this.memoryAccess.readDoubleFrom(this.storage, index);
    }

    @Override
    public void setDouble(final int index, final double value)
    {
        this.checkIndex(index);
        this.memoryAccess.setDoubleIn(this.storage, index, value);
    }

    @Override
    public Double get(final int index)
    {
        return this.getDouble(index);
    }

    @Override
    public void set(final int index, final Double value)
    {
        this.setDouble(index, value);
    }
}
