/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation;

import java.util.List;
import java.util.Scanner;
import domain.Snack;
import java.util.ArrayList;
import service.IServiceSnacks;
import service.ServiceSnacksFiles;
import service.ServiceSnacksList;

/**
 *
 * @author Mateo Velasco
 */
public class SnacksMachine {
    public static void main(String[] args) {
        snacksMachine();
    }
    
    public static void snacksMachine(){
        var close = false;
        var console = new Scanner(System.in);
        IServiceSnacks serviceSnacks = new ServiceSnacksFiles();
        
        //Create the new Snack list
        List<Snack> products = new ArrayList<>();
        System.out.println("***Máquina de Snacks***");
        serviceSnacks.showSnacks(); //We show the inventory of the machine
        
        while(!close){
            try{
                var option = showMenu(console);
                close = executeOptions(option, console, products, serviceSnacks);
            }catch(Exception e){
                System.out.println("Ocurrio un error: "+e.getMessage());
            }finally{
                System.out.println(); //Print a line break after each iteration
            }
        }
    }
    
    private static int showMenu(Scanner console){
        System.out.print("""
                           Menu:
                           1. Comprar Snack
                           2. Mostrar Ticket
                           3. Agregar Nuevo Snack
                           4. Mostrar Inventario
                           5. Salir
                           Elije una opción:\s """);
        
        //Read and return the number option
        return Integer.parseInt(console.nextLine());
    }
    
    private static boolean executeOptions(int option, Scanner console, List<Snack> products, IServiceSnacks serviceSnacks){
        var close = false;
        switch(option){
            case 1 -> buySnack(console, products, serviceSnacks);
            case 2 -> showTicket(products);
            case 3 -> addSnack(console, serviceSnacks);
            case 4 -> listInventorySnack(console, serviceSnacks);
            case 5 -> {
                System.out.println("Regresa pronto!");
                close = true;
            }
            default -> System.out.println("Opción inválida: "+option);
        }
        
        return close;
    }
    private static void listInventorySnack(Scanner console, IServiceSnacks serviceSnacks){
        serviceSnacks.showSnacks();
    }
    private static void buySnack(Scanner console, List<Snack> products, IServiceSnacks serviceSnacks){
        System.out.print("Que snack quieres comprar (id)? ");
        var idSnack = Integer.parseInt(console.nextLine());
        
        //Check if the product already exists
        var isFind = false;
        for(var snack: serviceSnacks.getSnacks()){
            if(idSnack == snack.getIdSnack()){
                //Add the product to the list
                products.add(snack);
                System.out.println("Ok, Snack agregado: "+snack);
                isFind = true;
                break;
            }
        }
        
        if(!isFind){
            System.out.println("Id de Snack no encontrado: "+idSnack);
        }
    }
    
    private static void showTicket(List<Snack> products){
        var ticket =  "***Ticket de Venta***";
        var total = 0.0;
        for(var product: products){
            ticket += "\n\t- "+ product.getName() + " - $"+ product.getPrice();
            total += product.getPrice();
        }
        
        ticket += "\n\tTotal -> $"+total;
        System.out.println(ticket);
    }
    
    private static void addSnack(Scanner console, IServiceSnacks serviceSnacks){
        System.out.print("Nombre del snack: ");
        var name = console.nextLine();
        System.out.print("Precio del snack: ");
        var price = Double.parseDouble(console.nextLine());
        serviceSnacks.addSnack(new Snack(name, price));
        System.out.println("Tu snack se agrego correctamente");
        serviceSnacks.showSnacks();
    }
}
