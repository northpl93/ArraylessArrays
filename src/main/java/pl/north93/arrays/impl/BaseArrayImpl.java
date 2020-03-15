package pl.north93.arrays.impl;

import java.util.Iterator;

import lombok.AllArgsConstructor;
import pl.north93.arrays.Array;
import pl.north93.arrays.jvm.MemoryAccess;

@AllArgsConstructor
abstract class BaseArrayImpl<T> implements Array<T>
{
    protected final MemoryAccess memoryAccess;
    protected final Object storage;
    private final int size;

    @Override
    public final int size()
    {
        return this.size;
    }

    protected final void checkIndex(final int index)
    {
        if (index < 0 || index > this.size)
        {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public Iterator<T> iterator()
    {
        return new ArrayIterator<>(this);
    }

    @Override
    public String toString()
    {
        final StringBuilder builder = new StringBuilder("[");

        final int lastElement = this.size - 1;
        for (int i = 0; i < this.size; i++)
        {
            builder.append(this.get(i));
            if (i != lastElement)
            {
                builder.append(", ");
            }
        }

        builder.append("]");
        return builder.toString();
    }
}
