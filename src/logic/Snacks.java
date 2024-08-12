/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.util.List;
import entities.Snack;
import java.util.ArrayList;
/**
 *
 * @author Mateo Velasco
 */
public class Snacks {
    private static final List<Snack> snacks;
    
    //Static block to init the static list
    static{
        snacks = new ArrayList<>();
        snacks.add(new Snack("Papas", 70));
        snacks.add(new Snack("Refresco", 50));
        snacks.add(new Snack("Sandwich", 120));
    }
    
    public static void addSnack(Snack s){
        snacks.add(s);
    }
    
    public static void showSnacks(){
        var inventorySnacks = "";
        for(var snack: snacks){
            inventorySnacks += snack.toString() + "\n";
        }
        System.out.println("---Snacks en el inventario---");
        System.out.println(inventorySnacks);
    }
    
    public static List<Snack> getSnacks(){
        return snacks;
    }
}
