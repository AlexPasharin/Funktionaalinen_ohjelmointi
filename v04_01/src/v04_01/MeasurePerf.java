/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v04_01;

import java.util.function.*;

/**
 *
 * @author aleksandrpasharin
 */
public class MeasurePerf {
    
    public static <T, R> long measurePerf(Function<T, R> f, T input) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            R result = f.apply(input);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + result);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }
    
    public static <T> long measurePerfExact(Consumer<T> f, T input) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            f.accept(input);
            long duration = System.nanoTime() - start;
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }
}
