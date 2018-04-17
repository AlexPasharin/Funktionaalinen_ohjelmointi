package Teht2;

import java.util.EnumSet;
import java.util.Set;
import java.util.function.*;
import java.util.stream.Collector;

/**
 *
 * @author aleksandrpasharin
 * @param <T> any class
 */
public class CountingCollector<T> implements Collector<T, LongAccumulator, Long> {
    
    private final boolean concurrent;

    public CountingCollector(boolean concurrent) {
        this.concurrent = concurrent;
    }
    
    @Override
    public Supplier<LongAccumulator> supplier() {
        return () -> new LongAccumulator();
    }

    @Override
    public BiConsumer<LongAccumulator, T> accumulator() {
        return (acc, val) -> acc.addOne();
    }

    @Override
    public BinaryOperator<LongAccumulator> combiner() {
        return (acc1, acc2) -> {
            System.out.println("combining"); 
// tämän tulostuksen avulla nähdään Mainissa, että combineria käytetään ainoastaan kun collectori ei ole concurrent ja vuo on rinnakkainen
            return acc1.add(acc2);
        };
    }

    @Override
    public Function<LongAccumulator, Long> finisher() {
        return acc -> acc.getValue();
    }
    
    @Override
    public Set<Characteristics> characteristics() {
        return this.concurrent ?
                EnumSet.of(Characteristics.CONCURRENT) : EnumSet.noneOf(Characteristics.class);
    }
    
}
