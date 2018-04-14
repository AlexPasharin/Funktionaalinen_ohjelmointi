/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v04_01;

import java.io.IOException;
import static v04_01.Debugging.testMoveAllPointsRightBy;
import static v04_01.Kalevala.*;

import static v04_01.SquareSums.squareSums;

/**
 *
 * @author aleksandrpasharin
 */
public class Main {
     public static void main(String[] args) throws IOException {         
        // Teht1
        System.out.println("Teht 1:");
        testMoveAllPointsRightBy();
        System.out.println();
        
        /* Teht 2 
            
            a) Kuinka monta kertaa filter-operaatio kutsuu lambdalauseketta?
        
            Vastaus: 10

            b) Kuinka monta kertaa map-operaatio kutsuu lambdalauseketta?
        
            Vastaus: 5

            c) Jos filter- ja map-operaatioiden järjestys vaihdetaan, kuinka monta kertaa map-operaatio kutsuu lambdalauseketta?
        
            Vastaus: 10
        
        */
        
        // Teht 3:
        
        System.out.println("Teht 3: ");
        squareSums();
        System.out.println();
        
        /* Typical results: straightforward loop without streams 1 ms, 
           Linked list performs worse than array list
           Parallel version with linked list is not essentially faster than not parallel version,
           but with array list parallel is better
       
           Range performs the best within stream versions, parallel version even in 3 ms       
        */
        
        // Teht 4
        
        System.out.println("Teht 4: ");
        kalevalaWordCountCompare();
        System.out.println();       
        
        // Paralelli vuo on tässä tapauksessa hitaampi kuin ei-paralelli!
    }
}
