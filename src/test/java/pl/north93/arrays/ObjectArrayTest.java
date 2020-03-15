package pl.north93.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pl.north93.arrays.impl.ArrayFactory;

public class ObjectArrayTest
{
    private final ArrayFactory arrayFactory = new ArrayFactory();

    @Test
    public void createEmptyObjectArray()
    {
        final Array<Object> array = this.arrayFactory.getObjectArray(Object.class, 0);

        Assertions.assertEquals(0, array.size());
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.get(1));
    }

    @Test
    public void getAndSetValueFromObjectArray()
    {
        final Array<Object> array = this.arrayFactory.getObjectArray(Object.class, 1);

        Assertions.assertEquals(1, array.size());

        final Object object = new Object();
        array.set(0, object);

        Assertions.assertEquals(object, array.get(0));
    }
}
