/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlite;

/**
 *
 * @author Lucas
 */
public class Sqlite {

    public static void main(String[] args) {

        Conector conector = new Conector();
        Alumno alumno = new Alumno(3, "Pepe", "Perez Benito");

        conector.connect();
        conector.guardarAlumno(alumno);
        conector.mostrarAlumnos();
        conector.close();
    }

}
