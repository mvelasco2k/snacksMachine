/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Mateo Velasco
 */
public class CreateFile {
    public static void main(String[] args) {
        var nameFile = "miArchivo.txt";
        var file = new File(nameFile);
        try {
            if(file.exists()){
                System.out.println("El archivo ya existe");
            }else{
                //We create the file
                var output = new PrintWriter(new FileWriter(file));
                //Save the file into disk
                output.close();
                System.out.println("Se ha creado el archivo");
            }
        
        } catch (IOException ex) {
            System.out.println("Error en el archivo: "+ex.getMessage());
            ex.printStackTrace();
        }
    }
}
