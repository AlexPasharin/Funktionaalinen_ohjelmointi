package Teht2;

import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Stream;
/**
 *
 * @author aleksandrpasharin
 */
public class Main {

 
       
    public static void main(String[] args) {

        Collector<Character, ?, Long> counter = new CountingCollector<>(true);
        Long THRESHOLD = 1_000_000_000L;
        
        long start = System.nanoTime();
        Long result = Stream.generate(() -> 'a').limit(THRESHOLD).collect(counter);
        long duration = (System.nanoTime() - start) / 1_000_000;
        
        System.out.println(result);
        System.out.println("Non-parallel concurrent done in " + duration + " ms");
        
        start = System.nanoTime();
        result = Stream.generate(() -> 'a').parallel().limit(THRESHOLD).collect(counter); 
        duration = (System.nanoTime() - start) / 1_000_000;
        
        System.out.println(result);
        System.out.println("Parallel concurrent done in " + duration + " ms");
        
        counter = new CountingCollector<>(false);
        
        start = System.nanoTime();
        result = Stream.generate(() -> 'a').limit(THRESHOLD).collect(counter);
        duration = (System.nanoTime() - start) / 1_000_000;
        
        System.out.println(result);
        System.out.println("Non-parallel non-concurrent done in " + duration + " ms");
        
        start = System.nanoTime();
        result = Stream.generate(() -> 'a').parallel().limit(THRESHOLD).collect(counter); 
        duration = (System.nanoTime() - start) / 1_000_000;
        
        System.out.println(result);
        System.out.println("Parallel non-concurrent done in " + duration + " ms");
        
        /* Concurrent nopeampi kuin non-concurrent, mutta rinnakkaisen vuo tapauksessa antaa väärän tuloksen!
           Non-concurrent hitaampi mutta antaa oikeita tuloksia
        */ 
    }
    
    private static <T, R> long measurePerf(Function<T, R> f, T input) {
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
}
