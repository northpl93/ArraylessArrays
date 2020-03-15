package pl.north93.arrays.impl;

import pl.north93.arrays.BooleanArray;
import pl.north93.arrays.jvm.MemoryAccess;

class BooleanArrayImpl extends BaseArrayImpl<Boolean> implements BooleanArray
{
    public BooleanArrayImpl(final MemoryAccess memoryAccess, final Object storage, final int size)
    {
        super(memoryAccess, storage, size);
    }

    @Override
    public boolean getBoolean(final int index)
    {
        this.checkIndex(index);
        return this.memoryAccess.readBooleanFrom(this.storage, index);
    }

    @Override
    public void setBoolean(final int index, final boolean value)
    {
        this.checkIndex(index);
        this.memoryAccess.setBooleanIn(this.storage, index, value);
    }

    @Override
    public Boolean get(final int index)
    {
        return this.getBoolean(index);
    }

    @Override
    public void set(final int index, final Boolean value)
    {
        this.setBoolean(index, value);
    }
}
