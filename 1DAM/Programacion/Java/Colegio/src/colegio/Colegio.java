/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package colegio;

import java.util.ArrayList;

/**
 *
 * @author LUCAS1
 */
public class Colegio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList <Alumno> alumnos = new ArrayList<Alumno>();
        
        alumnos.add(new Alumno("Alberto",512154));
        alumnos.add(new Alumno("pep",534454));
        
        if (alumnos.indexOf(new Alumno("Alberto",512154)) == -1) {
            alumnos.add(new Alumno("Jose",512154));
        }
        
        
        
        System.out.println(alumnos);
        
        
    }
    
    
    
}
