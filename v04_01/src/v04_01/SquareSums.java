/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v04_01;

import java.util.*;
import java.util.stream.LongStream;
import static v04_01.MeasurePerf.measurePerf;

/**
 *
 * @author aleksandrpasharin
 */
public class SquareSums {
    
     public static void squareSums() {
        final long THRESHOLD = 2_000_000L;
        
        System.out.println("Iterative Sum done in: " + measurePerf(SquareSums::iterativeSquareSum, THRESHOLD) + " msecs");
        System.out.println("Linked list, no parallel, done in: " + measurePerf(SquareSums::linkedListSquareSum, THRESHOLD) + " msecs");       
        System.out.println("Linked list, parallel, done in: " + measurePerf(SquareSums::linkedListParallelSquareSum, THRESHOLD) + " msecs");
        System.out.println("Array list, no parallel, done in: " + measurePerf(SquareSums::arrayListSquareSum, THRESHOLD) + " msecs");
        System.out.println("Array list, parallel, done in: " + measurePerf(SquareSums::arrayListParallelSquareSum, THRESHOLD) + " msecs");
        System.out.println("Range done in: " + measurePerf(SquareSums::rangedSum, 10_000_000L) + " msecs");
        System.out.println("Parallel range done in: " + measurePerf(SquareSums::parallelRangedSum, 10_000_000L) + " msecs" );
    }
     
    public static long iterativeSquareSum(long n) {
        long result = 0;
        for (long i = 0; i <= n; i++) {
            result += i * i;
        }
        return result;
    }
     
    public static long linkedListSquareSum(long n) {
        LinkedList<Long> list = new LinkedList<>();
        for (long i = 0; i <= n; i++) {
            list.add(i);
        }
        
        return list.stream()
                .map(x -> x * x)
                .reduce(0L, (acc, x) -> acc + x);
    }
    
    public static long linkedListParallelSquareSum(long n) {
        LinkedList<Long> list = new LinkedList<>();
        for (long i = 0; i <= n; i++) {
            list.add(i);
        }
        
        return list.parallelStream()
                .map(x -> x * x)
                .reduce(0L, (acc, x) -> acc + x);
    }
    
    public static long arrayListSquareSum(long n) {
        ArrayList<Long> list = new ArrayList<>();
        for (long i = 0; i <= n; i++) {
            list.add(i);
        }
        
        return list.stream()
                .map(x -> x * x)
                .reduce(0L, (acc, x) -> acc + x);
    }
    
    public static long arrayListParallelSquareSum(long n) {
        ArrayList<Long> list = new ArrayList<>();
        for (long i = 0; i <= n; i++) {
            list.add(i);
        }
        
        return list.parallelStream()
                .map(x -> x * x)
                .reduce(0L, (acc, x) -> acc + x);
    }
    
    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n).map(x -> x * x).reduce(Long::sum).getAsLong();
    }

    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n).parallel().map(x -> x * x).reduce(Long::sum).getAsLong();
    }
}
