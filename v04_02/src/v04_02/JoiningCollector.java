/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v04_02;

import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 *
 * @author aleksandrpasharin
 */
public class JoiningCollector implements Collector<CharSequence, StringBuffer, String>{
    
    private final CharSequence delimiter;
    private final CharSequence prefix; 
    private final CharSequence suffix;

    public JoiningCollector(CharSequence delimiter, CharSequence prefix, CharSequence suffix) {
        this.delimiter = delimiter;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    @Override
    public Supplier<StringBuffer> supplier() {
        return () -> new StringBuffer(this.prefix);        
    }

    @Override
    public BiConsumer<StringBuffer, CharSequence> accumulator() {
        return (sb, seq) -> sb.append(seq).append(delimiter);
    }

    @Override
    public BinaryOperator<StringBuffer> combiner() {
        return (sb1, sb2) -> sb1.append(sb2);
    }

    @Override
    public Function<StringBuffer, String> finisher() {
        return sb -> {
            sb.setLength(sb.length() - this.delimiter.length()); // remove last delimiter, if needed
            return sb.append(suffix).toString();
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Characteristics.CONCURRENT, Characteristics.UNORDERED);
    }
    
}
