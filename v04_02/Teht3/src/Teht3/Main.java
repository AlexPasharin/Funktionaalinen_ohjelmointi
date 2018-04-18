package Teht3;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class Main {
    
    /*
        Tässä tarkastellaan välitulosten avulla sekä tavallista että rinnakaista tapausta
    
        Tavallisessa edetään suoraviivaisesti aloittaen tyhjästä listasta ja siihen kerätään alkiot yksi kerralla accumalatorilla.
        Combineria ei kutsuta kertakaan.
    
        Rinnakkaisessa edetään rekurssiivisesti - luodaan tyhjä lista jokaista vuon alkiota varten.
        Accumulatorin avulla vai lisätään yksi alkio tähän tyhjään listaan, loput työstä tekee combiner.
    
    */

    public static void main(String[] args) {        
        Collector<Integer, List<Integer>, List<Integer>> collector = new OmaListaKollektori<>();
        
        System.out.println("Non-parallel case:");
        
        List<Integer> lista = Stream.iterate(1, i -> i + 1).limit(10).collect(collector);
        
        System.out.println();
        System.out.println("Result list: ");
        System.out.println(lista); 
        System.out.println();
        
        System.out.println("Parallel case:");
        
        lista = Stream.iterate(1, i -> i + 1).parallel().limit(10).collect(collector);
        
        System.out.println();
        System.out.println("Result list: ");
        System.out.println(lista);        
    }
    
}
