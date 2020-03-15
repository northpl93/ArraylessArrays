Arrayless Arrays
================

Have you ever dreamed about a programming language without arrays?
It's your lucky day.

Project inspired by [worse arrays](https://github.com/natanbc/worse-arrays).

Example
------

```java
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
```

Benchmark
---------

```
Benchmark                          Mode  Cnt     Score     Error  Units
Benchmarks.arraylessArrayFill1000  avgt    3  1787.231 ±  16.024  ns/op
Benchmarks.arraylessArraySetOne    avgt    3     2.631 ±   1.011  ns/op
Benchmarks.javaArrayFill1000       avgt    3   754.024 ± 114.484  ns/op
Benchmarks.javaArraySetOne         avgt    3     1.651 ±   0.461  ns/op
```

Only one nanosecond lose on each set operation in comparison to native Java arrays.