package edu.neu.coe.info6205.sort.simple;

import edu.neu.coe.info6205.util.Config;
import edu.neu.coe.info6205.util.SorterBenchmark;
import edu.neu.coe.info6205.util.TimeLogger;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;

public class InsertionSortBenchmark {
    SorterBenchmark<Integer> benchmark = null;
    public static void main(String[] args) throws IOException {
        InsertionSortBenchmark insertionSortBenchmark=new InsertionSortBenchmark();
        insertionSortBenchmark.insertionBenchmark();
    }

    public void insertionBenchmark() throws IOException {
        Random random = new Random();
        Integer[] num=new Integer[50000];
        for(int i=0;i<50000;i++){
            num[i]=i;
        }
        int n=8000;
        for(int count=0;count<5;count++){
            int finalN=n;
            benchmark = new SorterBenchmark<>(
                    Integer.class,
                    new InsertionSort<>(Config.load(getClass())),
                    num,
                    100,
                    new TimeLogger[]{new TimeLogger("test", (x, a) -> x / a)});
            final Supplier<Integer[]> randomIntegersSupplier = () -> {
                Integer[] result = (Integer[]) Array.newInstance(Integer.class, finalN);
                for (int i = 0; i < finalN; i++) result[i] = random.nextInt();
                return result;
            };
            System.out.println("random array of "+finalN+" numbers:" +benchmark.runFromSupplier(randomIntegersSupplier,100));
            final Supplier<Integer[]> orderedIntegersSupplier = () -> {
                Integer[] result = (Integer[]) Array.newInstance(Integer.class, finalN);
                for (int i = 0; i < finalN; i++) result[i] = i;
                return result;
            };
            System.out.println("ordered array of "+finalN+" numbers:" +benchmark.runFromSupplier(orderedIntegersSupplier,100));
            final Supplier<Integer[]> reverseOrderedIntegersSupplier = () -> {
                Integer[] result = (Integer[]) Array.newInstance(Integer.class, finalN);
                for (int i = 0; i < finalN; i++) result[i] = 10000 - i;
                return result;
            };
            System.out.println("reverse ordered array of "+finalN+" numbers:" +benchmark.runFromSupplier(reverseOrderedIntegersSupplier,100));
            final Supplier<Integer[]> halfOrderedIntegersSupplier = () -> {
                Integer[] result = (Integer[]) Array.newInstance(Integer.class, finalN);
                for (int i = 0; i < finalN; i++) {
                    if(i<finalN/2) result[i] = i;
                    else result[i] = random.nextInt();
                }
                return result;
            };
            System.out.println("half ordered array of "+finalN+" numbers:" +benchmark.runFromSupplier(halfOrderedIntegersSupplier,100));
            n=n*2;
        }




//        Random random = new Random();
//        Integer[] num=new Integer[50000];
//        for(int i=0;i<50000;i++){
//            num[i]=i;
//        }
//        final Supplier<Integer[]> randomIntegersSupplier = () -> {
//            Integer[] result = (Integer[]) Array.newInstance(Integer.class, 10000);
//            for (int i = 0; i < 10000; i++) result[i] = random.nextInt();
//            return result;
//        };
//        final Supplier<Integer[]> orderedIntegersSupplier = () -> {
//            Integer[] result = (Integer[]) Array.newInstance(Integer.class, 10000);
//            for (int i = 0; i < 10000; i++) result[i] = i;
//            return result;
//        };
//
//        final Supplier<Integer[]> reverseOrderedIntegersSupplier = () -> {
//            Integer[] result = (Integer[]) Array.newInstance(Integer.class, 10000);
//            for (int i = 0; i < 10000; i++) result[i] = 10000 - i;
//            return result;
//        };
//
//        benchmark = new SorterBenchmark<>(
//                Integer.class,
//                new InsertionSort<>(Config.load(getClass())),
//                num,
//                100,
//                new TimeLogger[]{new TimeLogger("test", (x, n) -> x / n)});
//        System.out.println(benchmark.runFromSupplier(orderedIntegersSupplier,100));
    }
}
