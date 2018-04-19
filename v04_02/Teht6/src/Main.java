
import java.util.Arrays;
import java.util.function.*;
import java.util.stream.Collectors;

/**
 *
 * @author aleksandrpasharin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UnaryOperator<String> normalizer = s -> Arrays.stream(s.trim().split(" +")).collect(Collectors.joining(" "));
        
        UnaryOperator<String> scandicKiller = s -> 
            s.replaceAll("[äå]", "a")
             .replaceAll("[ÄÅ]", "A")
             .replace("ö", "o")
             .replace("Ö", "O");
        
        UnaryOperator<String> spellChecker = s -> 
            Arrays.stream(s.trim().split(" +")).map(str -> str.replaceAll("^sturct$", "struct")).collect(Collectors.joining(" "));
        
        Function<String, String> chain = normalizer.andThen(scandicKiller).andThen(spellChecker);
       
        String test = "  sturct   Önä sturcta   sturct åboÄ  Ålandsö fsturct sturct    ";
        System.out.println(chain.apply(test));
    }
    
}
