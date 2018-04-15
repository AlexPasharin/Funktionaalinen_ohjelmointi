package v04_02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // Teht 1
        OmenaList list = new OmenaList();
        list.demonstrateJoiningCollectors();
        
        String [] words = Files.lines(Paths.get("../data/Kalevala.txt"))
            .reduce("", (a, b) -> a + b)
            .toLowerCase()
            .split("[\\s,.:;?!]+");
        
        List<String> listOfWords = Arrays.asList(words);
        
        String result = listOfWords.stream().collect(OmatKollektorit.joining(" "));
        String parallelResult = listOfWords.parallelStream().collect(OmatKollektorit.joining(" "));
        
        System.out.println("\nNon parallel joining:\n");
        System.out.println(result);
        
        System.out.println("\nParallel joining:\n");
        System.out.println(parallelResult);
        
    }   
}
