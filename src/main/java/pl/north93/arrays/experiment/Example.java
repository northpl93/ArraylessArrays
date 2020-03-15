package pl.north93.arrays.experiment;

import pl.north93.arrays.Array;
import pl.north93.arrays.BooleanArray;
import pl.north93.arrays.impl.ArrayFactory;

public class Example
{
    public static void main(final String[] args)
    {
        final ArrayFactory factory = new ArrayFactory();

        final Array<String> stringArray = factory.getObjectArray(String.class, 10);
        stringArray.set(0, "it works");

        final BooleanArray booleanArray = factory.getBooleanArray(10);
        booleanArray.setBoolean(0, true);
    }
}
