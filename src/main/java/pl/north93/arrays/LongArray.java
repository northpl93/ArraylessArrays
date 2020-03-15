package pl.north93.arrays;

public interface LongArray extends Array<Long>
{
    long getLong(int index);

    void setLong(int index, long value);
}
