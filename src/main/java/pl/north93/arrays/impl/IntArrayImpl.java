package pl.north93.arrays.impl;

import pl.north93.arrays.IntArray;
import pl.north93.arrays.jvm.MemoryAccess;

class IntArrayImpl extends BaseArrayImpl<Integer> implements IntArray
{
    public IntArrayImpl(final MemoryAccess memoryAccess, final Object storage, final int size)
    {
        super(memoryAccess, storage, size);
    }

    @Override
    public int getInt(final int index)
    {
        this.checkIndex(index);
        return this.memoryAccess.readIntFrom(this.storage, index);
    }

    @Override
    public void setInt(final int index, final int value)
    {
        this.checkIndex(index);
        this.memoryAccess.setIntIn(this.storage, index, value);
    }

    @Override
    public Integer get(final int index)
    {
        return this.getInt(index);
    }

    @Override
    public void set(final int index, final Integer value)
    {
        this.setInt(index, value);
    }
}
