package Teht2;

/**
 *
 * @author aleksandrpasharin
 */
public class LongAccumulator {
    
    private long value = 0;

    public void addOne(){
        this.value++;
    }
    
    public long getValue(){
        return this.value;
    }
    
    public LongAccumulator add(LongAccumulator other){
        this.value += other.value;
        return this;
    }
}
