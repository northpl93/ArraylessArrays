package pl.north93.arrays.jvm;

public interface MemoryAccess
{
    Object instantiate(Class<?> clazz);

    Object readObjectFrom(Object object, int index);

    void setObjectIn(Object object, int index, Object value);

    boolean readBooleanFrom(Object object, int index);

    void setBooleanIn(Object object, int index, boolean value);

    byte readByteFrom(Object object, int index);

    void setByteIn(Object object, int index, byte value);

    short readShortFrom(Object object, int index);

    void setShortIn(Object object, int index, short value);

    char readCharFrom(Object object, int index);

    void setCharIn(Object object, int index, char value);

    int readIntFrom(Object object, int index);

    void setIntIn(Object object, int index, int value);

    long readLongFrom(Object object, int index);

    void setLongIn(Object object, int index, long value);

    double readDoubleFrom(Object object, int index);

    void setDoubleIn(Object object, int index, double value);

    float readFloatFrom(Object object, int index);

    void setFloatIn(Object object, int index, float value);
}
