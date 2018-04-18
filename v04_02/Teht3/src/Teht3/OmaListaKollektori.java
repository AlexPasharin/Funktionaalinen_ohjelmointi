package Teht3;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import static java.util.stream.Collector.Characteristics.*;


public class OmaListaKollektori<T> implements Collector<T, List<T>, List<T>> {
    @Override
    public Supplier<List<T>> supplier() {
        return () -> { 
            System.out.println();
            System.out.println("A new empty list is created");
            System.out.println();
            
            return new ArrayList<>(); // toimii tälläkin, ei tarvitse olla CopyOnWriteArrayList
        }; 
    }


    @Override
    public BiConsumer<List<T>, T> accumulator() {  // T, U -> void
        return (list, item) -> { 
            System.out.println("\nAn item " + item + " is added to the list " + list + "\n");
            
            list.add(item);
        };
    }

    @Override
    public BinaryOperator<List<T>> combiner() {   // T, T -> T
        return (list1, list2) -> {     
            System.out.println("\nCombining lists:\nList 1: " + list1 + "\nList 2: " + list2 + "\n");
            
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Function<List<T>, List<T>> finisher() { 
        return list -> { // ei kutsuttu lopussa, koska IDENTITY_FINISH on yksi kollektorin karateristikoista
            System.out.println("\nFinishing with the list\n" + list + "\n");
            
            return list;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(
            IDENTITY_FINISH, 
            CONCURRENT
        ));
    }
}

