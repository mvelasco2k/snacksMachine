/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Mateo Velasco
 */
public class WriteFile {
    public static void main(String[] args) {
        boolean append = false;
        var nameFile = "miArchivo.txt";
        var file = new File(nameFile);
        
        try{
            append = file.exists();
            var output = new PrintWriter(new FileWriter(file, append));
            var newContent = "nuevo\ncontenido";
            output.println(newContent);
            //Save lines into file
            output.close();
            System.out.println("Se agrego contenido al archivo");
        }catch(Exception e){
            e.getMessage();
        }
    }
}
