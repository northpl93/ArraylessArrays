package pl.north93.arrays.impl;

import pl.north93.arrays.ByteArray;
import pl.north93.arrays.jvm.MemoryAccess;

class ByteArrayImpl extends BaseArrayImpl<Byte> implements ByteArray
{
    public ByteArrayImpl(final MemoryAccess memoryAccess, final Object storage, final int size)
    {
        super(memoryAccess, storage, size);
    }

    @Override
    public byte getByte(final int index)
    {
        this.checkIndex(index);
        return this.memoryAccess.readByteFrom(this.storage, index);
    }

    @Override
    public void setByte(final int index, final byte value)
    {
        this.checkIndex(index);
        this.memoryAccess.setByteIn(this.storage, index, value);
    }

    @Override
    public Byte get(final int index)
    {
        return this.getByte(index);
    }

    @Override
    public void set(final int index, final Byte value)
    {
        this.setByte(index, value);
    }
}