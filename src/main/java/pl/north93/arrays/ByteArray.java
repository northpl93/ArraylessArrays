package pl.north93.arrays;

public interface ByteArray extends Array<Byte>
{
    byte getByte(int index);

    void setByte(int index, byte value);
}
