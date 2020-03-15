package pl.north93.arrays.impl;

import pl.north93.arrays.CharArray;
import pl.north93.arrays.jvm.MemoryAccess;

class CharArrayImpl extends BaseArrayImpl<Character> implements CharArray
{
    public CharArrayImpl(final MemoryAccess memoryAccess, final Object storage, final int size)
    {
        super(memoryAccess, storage, size);
    }

    @Override
    public char getChar(final int index)
    {
        this.checkIndex(index);
        return this.memoryAccess.readCharFrom(this.storage, index);
    }

    @Override
    public void setChar(final int index, final char value)
    {
        this.checkIndex(index);
        this.memoryAccess.setCharIn(this.storage, index, value);
    }

    @Override
    public Character get(final int index)
    {
        return this.getChar(index);
    }

    @Override
    public void set(final int index, final Character value)
    {
        this.setChar(index, value);
    }
}
