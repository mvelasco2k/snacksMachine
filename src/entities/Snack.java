/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Mateo Velasco
 */

//JavaBeans Standar: *Implement Serializable, encapsulation and empty constructor
public class Snack implements Serializable{
    private static int counterSnack = 0;
    private int idSnack;
    private String name;
    private double price;
    
    public Snack(){
        this.idSnack = ++Snack.counterSnack;
    }
    
    public Snack(String name, double price){
        this(); //Call the empty constructor for init the idSnack. It could be the first line.
        this.name = name;
        this.price = price;
    }

    public int getIdSnack() {
        return idSnack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static int getCounterSnack() {
        return counterSnack;
    }

    @Override
    public String toString() {
        return "Snack{" + "idSnack=" + idSnack + ", name=" + name + ", price=" + price + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idSnack;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        return hash;
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
        final Snack other = (Snack) obj;
        if (this.idSnack != other.idSnack) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        return Objects.equals(this.name, other.name);
    }
    
    
}
