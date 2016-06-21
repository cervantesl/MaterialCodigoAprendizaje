/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;
import Agenda.EE;
import java.io.*;
/**
 *
 * @author Lucas
 */
public class Persona implements java.io.Serializable {
    String nombre;
    int telefono;
    String direccion;

    public Persona() {
        System.out.println("Nombre:");
        this.nombre = EE.leerCadena();
        System.out.println("telefono:");
        this.telefono = EE.leerInt();
        System.out.println("Direccion:");
        this.direccion = EE.leerCadena();
    }

    public Persona(String nombre){
        this.nombre = nombre;
    } 
    
    @Override
    public boolean equals(Object obj) {
        return this.nombre.equals(((Persona)obj).nombre);
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion + '}';
    }
    
    
}
