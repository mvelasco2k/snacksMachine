/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domain.Snack;
import java.io.File;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mateo Velasco
 */
public class ServiceSnacksFiles implements IServiceSnacks{
    private final String NAME_FILE = "snacks.txt";
    private List<Snack> snacks = new ArrayList<>();
    
    public ServiceSnacksFiles(){
        var file = new File(NAME_FILE);
        var exists = false;
        
        try{
            exists = file.exists();
            if(file.exists()){
                this.snacks = getSnacksFile();
            }else{
                var output = new PrintWriter(new FileWriter(file));
                output.close();
                System.out.println("Se ha creado el archivo.");
            }
        }catch(Exception e){
            System.out.println("Error al crear el archivo: "+e.getMessage());
        }
        //Charge into the file, snacks by default
        if(!exists){
            chargeSnacksDefault();
        }
    }
    private void chargeSnacksDefault(){
        this.addSnack(new Snack("Papas",70));
        this.addSnack(new Snack("Refresco",50));
        this.addSnack(new Snack("Sandwich",120));
    }
    @Override
    public void addSnack(Snack snack) {
        //Add snack in memory
        this.snacks.add(snack);
        //Save into file
        this.addSnackFile(snack);
    }
    private void addSnackFile(Snack snack){
        boolean added = false;
        var file = new File(NAME_FILE);
        try{
            added = file.exists();
            var output = new PrintWriter(new FileWriter(file, added));
            output.println(snack.writeSnack());
            output.close();
            
        }catch(Exception e){
            System.out.println("Error al crear el archivo: "+e.getMessage());
        }
    }
    @Override
    public void showSnacks() {
        System.out.println("--- Snacks en el inventario ---");
        var inventorySnack = "";
        for(var snack: this.snacks){
            inventorySnack += snack.toString() + "\n";
        }
        System.out.println(inventorySnack   );
    }

    @Override
    public List<Snack> getSnacks() {
        return this.snacks;
    }
    private List<Snack> getSnacksFile(){
        var snacks = new ArrayList<Snack>();
        try{
            List<String> lines = Files.readAllLines(Paths.get(NAME_FILE));
            for(String line : lines){
                String[] lineSnack = line.split(",");
                var name = lineSnack[1];
                var price = Double.parseDouble(lineSnack[2]);
                var snack = new Snack(name, price);
                snacks.add(snack);
            }
            
        }catch(Exception e){
            System.out.println("Error al leer el archivo: "+e.getMessage());
            e.printStackTrace();
        }
        return snacks;
    }
}
