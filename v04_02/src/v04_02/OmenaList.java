/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v04_02;

import java.util.*;
import java.util.stream.Collector;

/**
 *
 * @author aleksandrpasharin
 */
public class OmenaList {
    
    private final List<Omena> omenat = new ArrayList<>();
    
    public OmenaList() {
        Omena o1 = new Omena("vihreä", 100);
        Omena o2 = new Omena("vihreä", 110);
        Omena o3 = new Omena("punainen", 101);
        Omena o4 = new Omena("punainen", 105);
        
        omenat.add(o1);
        omenat.add(o2);
        omenat.add(o3);
        omenat.add(o4);
    }
    
    public void demonstrateJoiningCollectors(){
        Collector<CharSequence, ?, String> joiningCollector1 = OmatKollektorit.joining();
        Collector<CharSequence, ?, String> joiningCollector2 = OmatKollektorit.joining("\n");
        Collector<CharSequence, ?, String> joiningCollector3 = OmatKollektorit.joining("\n", "This collector has a prefix\n", "\nThis collector also has a suffix");
        
        System.out.println("\nStraightforward join: ");
        System.out.println(this.joinApples(joiningCollector1));
                
        System.out.println("\nJoin with new line delimiter:\n");
        System.out.println(this.joinApples(joiningCollector2));
                
        System.out.println("\nJoin with new line delimiter, prefix and suffix:\n");
        System.out.println(this.joinApples(joiningCollector3));       
    }
    
    private String joinApples(Collector<CharSequence, ?, String> collector) {
        return omenat.stream().map(o -> o.toString()).collect(collector);
    }        
}
