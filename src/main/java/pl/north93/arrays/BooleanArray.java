package pl.north93.arrays;

public interface BooleanArray extends Array<Boolean>
{
    boolean getBoolean(int index);

    void setBoolean(int index, boolean value);
}
