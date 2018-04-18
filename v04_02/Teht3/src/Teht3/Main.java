package Teht3;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {        
        Collector<Integer, List<Integer>, List<Integer>> collector = new OmaListaKollektori<>();
        
        List<Integer> lista = Stream.iterate(1, i -> i + 1).parallel().limit(10).collect(collector);
        
        System.out.println();
        System.out.println("Result list: ");
        System.out.println(lista);        
    }
    
}
