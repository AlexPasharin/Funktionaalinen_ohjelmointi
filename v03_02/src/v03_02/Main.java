package v03_02;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

/**
 *
 * @author aleksandrpasharin
 */
public class Main {
        
    static DoubleUnaryOperator makePistelaskuri(double kPiste, double lisapisteet){
            return result -> 60 + (result - kPiste) * lisapisteet;
    }
    
    static class GeneratorFIF {
    
        private final IntSupplier supplier;

        public GeneratorFIF(IntSupplier supplier) {
            this.supplier = supplier;
        }

        public int get() {
            return this.supplier.getAsInt();
        }
    
    }
    
    @FunctionalInterface
    static interface GeneratorFIFOld{
        public abstract int get();
    }
    
    
    private static class Piste {
        
        private double x;
        private double y;

        public Piste(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

              
        private static Function<Piste, Piste> makeSiirto(double dx, double dy) {
            return (Piste p) -> new Piste(p.getX() + dx, p.getY() + dy);
        }

        private static Function<Piste, Piste> makeSkaalaus(double zoom) {
            return (Piste p) -> new Piste(p.getX() * zoom, p.getY() * zoom);
        }

        private static Function<Piste, Piste> makeKierto(double angle) {
            return (Piste p) -> new Piste(
                    p.getX() * Math.cos(angle) - p.getY() * Math.sin(angle),
                    p.getX() * Math.sin(angle) + p.getY() * Math.cos(angle)
            );
        }
        
        @Override
        public String toString() {
            return "(" + this.x + ", " + this.y + ")";
        }
    } 

    public static void main(String[] args) {
        // Teht1
        
        // Vanha generaattori on tunnin esimerkki ja on interface
        GeneratorFIFOld genOld = new GeneratorFIFOld() {
            @Override
            public int get() {
                return 3;
            }
        };
        
        // Uusi on luokka ja käyttää IntSupplier raja-pintaa sisäisesti
        GeneratorFIF genNew = new GeneratorFIF(() -> 3);
        
        // Vielä järkevämpi tapa olisi käyttää IntSuppleria suoraan
        // Tällöin kuitenkin perusoperaation nimi on getAsInt, ei get
        IntSupplier supplier = () -> 3;
        
        System.out.println("Teht 1: ");
        System.out.println("Old generator returns: " + genOld.get());
        System.out.println("New generator returns: " + genNew.get());
        System.out.println("Int supplier returns: " + supplier.getAsInt());
        System.out.println();
        
        
        
        // Teht2 
        DoubleUnaryOperator normaaliLahti = makePistelaskuri(90, 2.0);      
        System.out.println("Teht 2: "); 
        System.out.println(normaaliLahti.applyAsDouble(100));
        System.out.println(normaaliLahti.applyAsDouble(80));
        System.out.println();
        
        // Teht3
        
        Random gen = new Random();
        IntStream lottoRiviLambda = IntStream.generate(() -> gen.nextInt(40) + 1).distinct().limit(7).sorted();
        
        IntStream lottoRiviAnonym = IntStream.generate(new IntSupplier() {
            @Override
            public int getAsInt() {
                return gen.nextInt(40) + 1;
            }
        }).distinct().limit(7).sorted();
        
        System.out.println("Teht 3: ");
        
        System.out.print("Lambda tuottaa rivin ");
        lottoRiviLambda.forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        System.out.print("Anonyymi luokka tuottaa rivin ");
        lottoRiviAnonym.forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        System.out.println();
        
        // Teht4 
        
        IntSupplier fibo = new IntSupplier() {
            
            private int prev = -1;
            private int next = 1;
            
            @Override
            public int getAsInt() {
                int temp = this.next;
                this.next += this.prev;
                this.prev = temp;
                
                return this.next;
            }
        };
        
        System.out.println("Teht 4: ");
        IntStream.generate(fibo).limit(10).forEach((n) -> System.out.print(n + " "));
        System.out.println();
        System.out.println();
        
        //Teht5: 
        
        Function<Piste, Piste> siirto = Piste.makeSiirto(1, 2);
        Function<Piste, Piste> skaalaus = Piste.makeSkaalaus(2);
        Function<Piste, Piste> kierto = Piste.makeKierto(Math.PI);
        Function<Piste, Piste> muunnos = siirto.andThen(skaalaus).andThen(kierto);
       
        Piste[] pisteet = {new Piste(1,1), new Piste(2,2), new Piste(3,3)};
        
        List<Piste> uudetPisteet = new CopyOnWriteArrayList();
       
        for (Piste p: pisteet){
            uudetPisteet.add(muunnos.apply(p));
        } 
        
        System.out.println("Teht5: ");
        uudetPisteet.forEach(p -> System.out.println(p));
    }
   
}
