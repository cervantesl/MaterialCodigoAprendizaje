/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lucas
 */
public class Agenda {
    
    public static void main(String[] args) {
        ArrayList <Amigo> amigos = new ArrayList<>();
        ArrayList <Familia> familias = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        
        int opcion = 0;
        do {            
            System.out.println("MENU");
            System.out.println("1)Alta amigo");
            System.out.println("2)Consultar amigo");
            System.out.println("3)Mostrar toda la agenda");
            System.out.println("4)Borrar amigo");
            System.out.println("5)Modificar amigo");
            System.out.println("99)Salir");
            System.out.println("Opcion: ");
            opcion = teclado.nextInt();
            switch(opcion){
                case 1: AltaAmigo(amigos, familias); break;
                case 2: consultaAmigo(amigos); break;
                case 3: mostrarAgenda(amigos, familias); break;
                case 4: borrarAmigo(amigos); break;
                case 5: modificarAmigo(amigos); break;
            }
        } while (opcion != 99);
        
    } 
    //Cambiar que devuelva boolean por si hay otro contacto creado con el mismo nombre
    static void AltaAmigo(ArrayList <Amigo> amigos, ArrayList <Familia> familias){
        Scanner teclado = new Scanner (System.in);
        System.out.println("Es familiar? (S/N)");
        String respuesta = teclado.next();
        
        if (respuesta.equalsIgnoreCase("n")) {
            amigos.add(new Amigo());
        }
        else{
            familias.add(new Familia());
        }
        
    }
    
 
    static int consultaAmigo(ArrayList <Amigo> amigos){
        Scanner teclado = new Scanner (System.in);
        System.out.println("Nombre: ");
        String nombre = teclado.next();
        System.out.println("Apellidos:");
        String apellidos = teclado.next();
        
        int posicion = -1;
        
        posicion = amigos.indexOf(new Amigo(nombre, apellidos));
        
        if (posicion != -1) {
            System.out.println("La persona existe");
            System.out.println("Informacion:");
            System.out.println(amigos.get(posicion));
        }
        else{
            System.out.println("No existe");
        }
        return posicion;
    }
    static void mostrarAgenda(ArrayList <Amigo> amigos, ArrayList <Familia> familias){
        System.out.println(amigos.toString());
        System.out.println(familias.toString());
        
    }
    
    static void borrarAmigo(ArrayList <Amigo> amigos){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Nombre: ");
        String nombre = teclado.next();
        System.out.println("Apellidos:");
        String apellidos = teclado.next();
        
        if (amigos.remove(new Amigo(nombre,apellidos))) {
            System.out.println("Se ha borrado con exito");
        }
        else{
            System.out.println("No se ha borrado");
        }
    }
    
    static void modificarAmigo(ArrayList <Amigo> amigos){
        int posicion = consultaAmigo(amigos);
        if (posicion != -1) {
            System.out.println("Dime los nuevos datos: ");
            amigos.set(posicion, new Amigo());
        }
        else{
            System.out.println("No existe");
        }
    }
}
