/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Lucas
 */
public class Amigo {
    private int id;
    public static int idSiguiente = 1;
    private String nombre;
    private String apellidos;
    private int telefono;
    private String direccion;
    
    public Amigo(){
        Scanner teclado = new Scanner(System.in); //quitar lo del scanner
        System.out.println("Nombre:");
        this.nombre = teclado.next();
        System.out.println("Apellidos:");
        this.apellidos = teclado.next();
        System.out.println("Telefono:");
        this.telefono = teclado.nextInt();
        System.out.println("Direccion:");
        this.direccion = teclado.next();
        this.id = idSiguiente;
        idSiguiente++;
    }
    
    public Amigo(String nombre, String apellidos){
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    @Override
    public boolean equals(Object obj) {
        Amigo a = (Amigo)obj;
        return this.nombre.equalsIgnoreCase(a.nombre) && this.apellidos.equalsIgnoreCase(a.apellidos);
    }

    @Override
    public String toString() {
        return "\nAMIGO: "+id+"\n" + "nombre:" + nombre + "\n apellidos: " + apellidos + "\n telefono: " + telefono + "\n direccion: " + direccion;
    }

    
    
}
