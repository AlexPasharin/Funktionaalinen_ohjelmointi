/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v03_01;

import java.util.*;
import java.util.function.Function;
import static java.util.stream.Collectors.toList;
import static v03_01.Dish.menu;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author aleksandrpasharin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        // Teht1: 
        Function<Double, Double> toCelsius = fahrenheit -> (fahrenheit-32) * 5/9;
        Function<Double, Double> area = radius -> Math.PI * Math.pow(radius, 2);
        
        System.out.println("Teht 1:");
        System.out.println(map(toCelsius, 36.6));
        System.out.println(map(area, 4.5));
        System.out.println();
        
        // Teht 2
        
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
		
        List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300), 
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),	
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );
        
        List<Transaction> filteredTransactions = transactions
                .stream()
                .filter(transaction -> transaction.getYear() >= 2012 && transaction.getValue() > 900)
                .collect(toList());
        
        // tää on kyllä hyvin omituinen tapa laskea menu.size()... %)
        int menuNbr = menu.stream().map(dish -> 1).reduce(0, (a, b) -> a + b);
               
        System.out.println("Teht 2:");
        System.out.println(filteredTransactions);
        System.out.println("Ruokalajien määrä: " + menuNbr);
        System.out.println();
        
        //Teht 3
        
        Random gen = new Random();
        long amountOfSixes = Stream
            .generate(() -> gen.nextInt(6) + 1)
            .limit(20)
            .filter(x -> x == 6)
            .count();
        
        System.out.println("Teht 3:");
        System.out.println("Kuutosia tuli: " + amountOfSixes);
        System.out.println();
        
        // Teht 4
        
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(3, 4);
        
        System.out.println("Teht 4:");
        print2DimIntArray(carteseanProduct(list1, list2));
        System.out.println();
        
        // Teht 5
        String [] words = Files.lines(Paths.get("../data/Kalevala.txt"))
            .reduce("", (a, b) -> a + b)
            .toLowerCase()
            .split("[\\s,.:;?!]+");
        
                
        Map<String, Integer> wordCounter = Arrays.stream(words)
                .collect(Collectors.toMap(w -> w, w -> 1, Integer::sum));

        System.out.println("Teht 5:");
        // tulostetaan järjestyksessä
         wordCounter.keySet().stream().sorted()
             .forEach(key -> System.out.println(key + ":" + wordCounter.get(key)));
    }     
    
    // käytetään tehtävässä 1
    public static Double map(Function<Double, Double> func, Double number) {
        return func.apply(number);
    }
    
    // käytetään tehtävässä 4
    public static List<int[]> carteseanProduct(List<Integer> arr1, List<Integer> arr2) {        
        return arr1
                .stream()
                .flatMap(i -> arr2.stream().map(j -> new int[]{i, j}))
                .collect(toList());
    }
    
    // apufunktiot 
    private static void print2DimIntArray(List<int[]> matrix){
        System.out.print("[");
        for (int i = 0; i < matrix.size(); i++){
            printIntArr(matrix.get(i));
            if (i < matrix.size() - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
    
    private static void printIntArr(int[] arr){
        System.out.print("(");
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.print(")");
    }
}
