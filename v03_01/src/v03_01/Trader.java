/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v03_01;

/**
 *
 * @author aleksandrpasharin
 */
public class Trader {

    private String name;
    private String city;

    public Trader(String n, String c){
            this.name = n;
            this.city = c;
    }

    public String getName(){
            return this.name;
    }

    public String getCity(){
            return this.city;
    }

    public void setCity(String newCity){
            this.city = newCity;
    }

    @Override
    public String toString(){
            return "Trader:"+this.name + " in " + this.city;
    }
}
