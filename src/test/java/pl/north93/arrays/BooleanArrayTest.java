package pl.north93.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pl.north93.arrays.impl.ArrayFactory;

public class BooleanArrayTest
{
    private final ArrayFactory arrayFactory = new ArrayFactory();

    @Test
    public void createEmptyBooleanArray()
    {
        final BooleanArray array = this.arrayFactory.getBooleanArray(0);

        Assertions.assertEquals(0, array.size());
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.get(1));
    }

    @Test
    public void getAndSetValueFromBooleanArray()
    {
        final BooleanArray array = this.arrayFactory.getBooleanArray(1);

        Assertions.assertEquals(1, array.size());

        array.setBoolean(0, true);
        Assertions.assertEquals(true, array.get(0));
    }
}
