package pl.north93.arrays.impl;

import pl.north93.arrays.LongArray;
import pl.north93.arrays.jvm.MemoryAccess;

class LongArrayImpl extends BaseArrayImpl<Long> implements LongArray
{
    public LongArrayImpl(final MemoryAccess memoryAccess, final Object storage, final int size)
    {
        super(memoryAccess, storage, size);
    }

    @Override
    public long getLong(final int index)
    {
        this.checkIndex(index);
        return this.memoryAccess.readLongFrom(this.storage, index);
    }

    @Override
    public void setLong(final int index, final long value)
    {
        this.checkIndex(index);
        this.memoryAccess.setLongIn(this.storage, index, value);
    }

    @Override
    public Long get(final int index)
    {
        return this.getLong(index);
    }

    @Override
    public void set(final int index, final Long value)
    {
        this.setLong(index, value);
    }
}
