package Teht1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class Main {

    private static final List<Omena> OMENAT = new ArrayList<>();
    
    static {
        Omena o1 = new Omena("vihreä", 100);
        Omena o2 = new Omena("vihreä", 110);
        Omena o3 = new Omena("punainen", 101);
        Omena o4 = new Omena("punainen", 105);
          
        OMENAT.add(o1);
        OMENAT.add(o2);
        OMENAT.add(o3);
        OMENAT.add(o4);        
    }
    
    public static void main(String[] args) throws IOException {
        // Teht 1, a
        
        Collector<CharSequence, ?, String> joiningCollector1 = OmatKollektorit.joining();
        Collector<CharSequence, ?, String> joiningCollector2 = OmatKollektorit.joining("\n");
        Collector<CharSequence, ?, String> joiningCollector3 = OmatKollektorit.joining(
                "\n", "This collector has a prefix\n", "\nThis collector also has a suffix"
        );
        
        System.out.println("\nStraightforward join: ");
        System.out.println(joinApples(joiningCollector1));
                
        System.out.println("\nJoin with new line delimiter:\n");
        System.out.println(joinApples(joiningCollector2));
                
        System.out.println("\nJoin with new line delimiter, prefix and suffix:\n");
        System.out.println(joinApples(joiningCollector3));      
        
        // Teht 1, b
        // käytetään samaa Kalevala tekstiä, parsataan se ensin listaksi sanoja, kuten aikaisemmissa harjoituksissa
        String [] words = Files.lines(Paths.get("../../data/Kalevala.txt"))
            .reduce("", (a, b) -> a + b)
            .toLowerCase()
            .split("[\\s,.:;?!]+");
        
        List<String> listOfWords = Arrays.asList(words);
        
        Stream<String> nonParallelStream = listOfWords.stream();
        Stream<String> parallelStream = listOfWords.parallelStream();
        
        String result = nonParallelStream.collect(OmatKollektorit.joining(" "));
        String parallelResult = parallelStream.collect(OmatKollektorit.joining(" "));
        
        
        System.out.println("\nNon parallel joining:\n");
        System.out.println(result);
        
        System.out.println("\nParallel joining:\n");
        System.out.println(parallelResult);
        
        /* Ero ei-rinnakkaisen ja rinnakaisen välillä näkyy ainoastaan kun collectorin characteristics sisältävät kumpikin 
            UNORDERED ja CONCURRENT
            
            Kokeilin käyttää myös StringBuilderia, mutta se ei toimii rinnakkaisessa tapauksessa 
            kun sekä UNORDERED että CONCURRENT ovat voimassa. Johtuu varmaan siitä, että StringBuilder ei ole thread-safe
        */       
    }   
    
    private static String joinApples(Collector<CharSequence, ?, String> collector) {
        return OMENAT.stream().map(o -> o.toString()).collect(collector);
    }        
}
