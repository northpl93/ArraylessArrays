package pl.north93.arrays;

public interface Array<T> extends Iterable<T>
{
    int size();

    T get(int index);

    void set(int index, T value);
}
