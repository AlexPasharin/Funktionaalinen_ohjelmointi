/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v04_01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static v04_01.MeasurePerf.measurePerfExact;
/**
 *
 * @author aleksandrpasharin
 */
public class Kalevala {
    
    public static void kalevalaWordCountCompare() throws IOException{
        String[] words = kalevalaWords();
        System.out.println("Non-parallel kalevala words count done in: " + measurePerfExact(Kalevala::wordCount, words));
        System.out.println("Parallel kalevala words count done in: " + measurePerfExact(Kalevala::parallelWordCount, words));
    }
    
    public static Stream wordCount(String[] words) { 
        Map<String, Integer> wordCounter = Arrays.stream(words)
                .collect(Collectors.toMap(w -> w, w -> 1, Integer::sum));
        
        return wordCounter.keySet().stream().sorted();
    }
    
    public static Stream parallelWordCount(String[] words){ 
        Map<String, Integer> wordCounter = Arrays.stream(words).parallel()
                .collect(Collectors.toMap(w -> w, w -> 1, Integer::sum));
        
        return wordCounter.keySet().parallelStream().sorted();
    }
    
    public static String[] kalevalaWords() throws IOException {
        return Files.lines(Paths.get("../data/Kalevala.txt"))
            .reduce("", (a, b) -> a + b)
            .toLowerCase()
            .split("[\\s,.:;?!]+");
    }    
}
