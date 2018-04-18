package Teht4;

import java.util.*;


/**
 *
 * @author aleksandrpasharin
 */
public class Main {

    public static void main(String[] args) {
        Omena o1 = new Omena("vihreä", 100);
        Omena o2 = new Omena("vihreä", 110);
        Omena o3 = new Omena("punainen", 101);
        Omena o4 = new Omena("punainen", 105);
        
        List<Omena> omenat = new ArrayList<>();
        
        omenat.add(o1);
        omenat.add(o2);
        omenat.add(o3);
        omenat.add(o4);
        
        List<Omena> omenaLista = omenat.stream().collect(
            ArrayList::new,
            List::add,
            List::addAll
        );
        
        System.out.println(omenaLista);
        
        /* 
        API: 
        <R> R collect(Supplier<R> supplier,
              BiConsumer<R,? super T> accumulator,
              BiConsumer<R,R> combiner)
        
        Performs a mutable reduction operation on the elements of this stream. 
        A mutable reduction is one in which the reduced value is a mutable result container, such as an ArrayList, 
        and elements are incorporated by updating the state of the result rather than by replacing the result. 
        This produces a result equivalent to:

        R result = supplier.get();
        for (T element : this stream)
            accumulator.accept(result, element);
        return result;
        
        Toisin sanoen tässä kootaan streamin alkiot ikään kuin sellaisella kollektorella, jonka supplier on ArrayList::new, 
        accumulator on List::add ja combiner on List::addAll
        
        Toisin sanoen - koonti aloitetaan muodostamalla uusi tyhjä ArrayList list. 
        Vuosta lisätään alkio x siihen metodilla list.add(x)
        Rinnakaisessa laskennassa eri välilistat list1, list2 kombinoidaan suorittamalla list1.addAll(list2), joka palauttaa list1.
        
        Summa summarum tämä on ekvivalentti kutsun collect(Collectoris.toList()), 
        paitsi että viimemainitussa ei spesifioida minkälaiseen listaan alkiot kootaan, mutta lopputuloshan on ekvivalentti tämän kanssa. 

        
        */
    }    
    
}
