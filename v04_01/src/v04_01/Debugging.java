/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v04_01;

import java.util.*;
import static java.util.stream.Collectors.toList;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Debugging{    
    @Test
    public static void testMoveAllPointsRightBy(){
        List<Point> points = Arrays.asList(new Point(5, 5), new Point(10, 5));
        List<Point> expectedPoints = Arrays.asList(new Point(15, 5), new Point(20, 5));
        
        List<Point> newPoints = Point.moveAllPointsRightBy(points, 10);
        
        try {
            assertEquals(expectedPoints, newPoints);
            System.out.println("Tests are passed!");
        }catch(AssertionError e){
            System.out.println("Tests are not passed!");
        }    
    }


    private static class Point{
        private int x;
        private int y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }
        
        public Point moveRightBy(int x) {
            return new Point(this.x + x, this.y);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Point other = (Point) obj;
            if (this.x != other.x) {
                return false;
            }
            if (this.y != other.y) {
                return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 37 * hash + this.x;
            hash = 37 * hash + this.y;
            return hash;
        }
        
                
        public static List<Point> moveAllPointsRightBy(List<Point> points, int x){
            return points
                    .stream()
                    .map(p -> p.moveRightBy(x))
                    .collect(toList());
        }
    }
}
