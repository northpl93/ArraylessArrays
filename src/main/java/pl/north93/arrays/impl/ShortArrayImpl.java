package pl.north93.arrays.impl;

import pl.north93.arrays.ShortArray;
import pl.north93.arrays.jvm.MemoryAccess;

class ShortArrayImpl extends BaseArrayImpl<Short> implements ShortArray
{
    public ShortArrayImpl(final MemoryAccess memoryAccess, final Object storage, final int size)
    {
        super(memoryAccess, storage, size);
    }

    @Override
    public short getShort(final int index)
    {
        this.checkIndex(index);
        return this.memoryAccess.readShortFrom(this.storage, index);
    }

    @Override
    public void setShort(final int index, final short value)
    {
        this.checkIndex(index);
        this.memoryAccess.setShortIn(this.storage, index, value);
    }

    @Override
    public Short get(final int index)
    {
        return this.getShort(index);
    }

    @Override
    public void set(final int index, final Short value)
    {
        this.setShort(index, value);
    }
}
