package pl.north93.arrays;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

import lombok.ToString;
import pl.north93.arrays.impl.ArrayFactory;

@Fork(1)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 5)
@Measurement(iterations = 3)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class ObjectBenchmarks
{
    // WRITE benchmarks

    //@Benchmark
    public void arraylessArrayFill1000(final ArraysHolder arraysHolder)
    {
        final Array<Object> arraylessArray = arraysHolder.arraylessArray;
        for (int i = 0; i < 1000; i++)
        {
            arraylessArray.set(i, arraysHolder);
        }
    }

    @Benchmark
    public void arraylessArraySetOne(final ArraysHolder arraysHolder)
    {
        final Array<Object> arraylessArray = arraysHolder.arraylessArray;
        arraylessArray.set(100, arraysHolder);
    }

    //@Benchmark
    public void javaArrayFill1000(final ArraysHolder arraysHolder)
    {
        final Object[] javaArray = arraysHolder.javaArray;
        for (int i = 0; i < 1000; i++)
        {
            javaArray[i] = arraysHolder;
        }
    }

    @Benchmark
    public void javaArraySetOne(final ArraysHolder arraysHolder)
    {
        final Object[] javaArray = arraysHolder.javaArray;
        javaArray[100] = arraysHolder;
    }

    // READ benchmarks

    //@Benchmark
    public void arraylessArrayRead1000(final Blackhole blackhole, final ArraysHolder arraysHolder)
    {
        final Array<Object> arraylessArray = arraysHolder.arraylessArray;
        for (int i = 0; i < 1000; i++)
        {
            blackhole.consume(arraylessArray.get(i));
        }
    }

    @Benchmark
    public void arraylessArrayReadOne(final Blackhole blackhole, final ArraysHolder arraysHolder)
    {
        final Array<Object> arraylessArray = arraysHolder.arraylessArray;
        blackhole.consume(arraylessArray.get(100));
    }

    //@Benchmark
    public void javaArrayRead1000(final Blackhole blackhole, final ArraysHolder arraysHolder)
    {
        final Object[] javaArray = arraysHolder.javaArray;
        for (int i = 0; i < 1000; i++)
        {
            blackhole.consume(javaArray[i]);
        }
    }

    @Benchmark
    public void javaArrayReadOne(final Blackhole blackhole, final ArraysHolder arraysHolder)
    {
        final Object[] javaArray = arraysHolder.javaArray;
        blackhole.consume(javaArray[100]);
    }

    //@Benchmark
    //@Fork(jvmArgsAppend = { "-XX:+UnlockExperimentalVMOptions", "-XX:+TrustFinalNonStaticFields" })
    public void arraylessArrayWriteWithTrustFinalNonStaticFields(final ArraysHolder arraysHolder)
    {
        final Array<Object> arraylessArray = arraysHolder.arraylessArray;
        arraylessArray.set(100, arraysHolder);
    }

    @ToString
    @State(Scope.Benchmark)
    public static class ArraysHolder
    {
        public final Object[] javaArray;
        public final Array<Object> arraylessArray;

        public ArraysHolder()
        {
            this.javaArray = new Object[1000];

            final ArrayFactory arrayFactory = new ArrayFactory();
            this.arraylessArray = arrayFactory.getObjectArray(Object.class, 1000);
        }
    }
}

