/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author Mateo Velasco
 */
public class ReadAllFile {
    public static void main(String[] args) {
        var nameFile = "miArchivo.txt";
        
        try{
            //Read all lines to the file
            List<String> lines = Files.readAllLines(Paths.get(nameFile));
            System.out.println("Contenido del archivo");
            
            /*for(String line : lines){
                System.out.println(line);
            }*/
            lines.forEach(System.out::println);
        }catch(Exception e){
            e.getMessage();
        }
    }
}
