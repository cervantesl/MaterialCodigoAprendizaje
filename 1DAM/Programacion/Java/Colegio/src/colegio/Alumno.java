/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package colegio;

import java.util.Objects;

/**
 *
 * @author LUCAS1
 */
public class Alumno {
    private String nombre;

   
    private int dni;
    
     public Alumno(String nombre, int dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    @Override
    public String toString() {
        return  "nombre=" + nombre + ", dni=" + dni ;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        Alumno a = (Alumno)obj;
        return this.dni == a.dni && this.nombre == a.nombre;
    }
     
}
