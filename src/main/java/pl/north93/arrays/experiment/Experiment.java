package pl.north93.arrays.experiment;

import pl.north93.arrays.Array;
import pl.north93.arrays.impl.ArrayFactory;

public class Experiment
{
    //private static Array<Object> staticArray;

    public static void main(final String... args) throws Exception
    {
        scope();

        for (int i = 0; i < 5; i++)
        {
            System.gc();
            Thread.sleep(1000);
        }

//        staticArray = null;
//
//        for (int i = 0; i < 5; i++)
//        {
//            System.gc();
//            Thread.sleep(1000);
//        }

        Thread.sleep(5000);
    }

    private static void scope()
    {
        final ArrayFactory arrayFactory = new ArrayFactory();

        final Array<Object> array = arrayFactory.getObjectArray(Object.class, 10);
        //staticArray = array;

        System.out.println(array);

        for (int i = 0; i < 9; i++)
        {
            array.set(i, new Object());
            System.out.println(array.get(i));
        }
    }
}
