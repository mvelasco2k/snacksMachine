/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author Mateo Velasco
 */
public class ReadFile {
    public static void main(String[] args) {
        var nameFile = "miArchivo.txt";
        var file = new File(nameFile);
        
        try{
            System.out.println("Contenido del archivo");
            var entrance = new BufferedReader(new FileReader(file));
            //Read line to line the file
            var line = entrance.readLine();
            //Read all lines to the file
            while(line != null){
                System.out.println(line);
                //Move to the next line
                line = entrance.readLine();
            }
            entrance.close();
        }catch(Exception ex){
            System.out.println("Error al leer archivo: "+ex.getMessage());
        }
    }
}
