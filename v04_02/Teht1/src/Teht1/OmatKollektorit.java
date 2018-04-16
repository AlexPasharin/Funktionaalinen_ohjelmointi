package Teht1;

import java.util.stream.Collector;

/**
 *
 * @author aleksandrpasharin
 */
public class OmatKollektorit {
    
    public static Collector<CharSequence, ?, String> joining() {
        return new JoiningCollector("", "", "");
    }
    
    public static Collector<CharSequence, ?, String> joining(CharSequence delimiter) {
        return new JoiningCollector(delimiter, "", "");
    }
    
    public static Collector<CharSequence, ?, String> joining(CharSequence delimiter, CharSequence prefix, CharSequence suffix) {
        return new JoiningCollector(delimiter, prefix, suffix);
    }
    
}
