package pl.north93.arrays.impl;

import java.util.Iterator;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
final class ArrayIterator<T> implements Iterator<T>
{
    private final BaseArrayImpl<T> array;
    private int index;

    @Override
    public boolean hasNext()
    {
        return this.index < this.array.size();
    }

    @Override
    public T next()
    {
        return this.array.get(this.index++);
    }
}
