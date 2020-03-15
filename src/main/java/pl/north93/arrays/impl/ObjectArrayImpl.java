package pl.north93.arrays.impl;

import pl.north93.arrays.jvm.MemoryAccess;

class ObjectArrayImpl<T> extends BaseArrayImpl<T>
{
    public ObjectArrayImpl(final MemoryAccess memoryAccess, final Object storage, final int size)
    {
        super(memoryAccess, storage, size);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(final int index)
    {
        this.checkIndex(index);
        return (T) this.memoryAccess.readObjectFrom(this.storage, index);
    }

    @Override
    public void set(final int index, final T value)
    {
        this.checkIndex(index);
        this.memoryAccess.setObjectIn(this.storage, index, value);
    }
}
