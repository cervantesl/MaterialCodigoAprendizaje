package registronotaslucascervantes;

import java.util.Scanner;
/**
 *
 * @author Lucas
 */
public class RegistroNotasLucasCervantes {
    
    public static void main(String[] args) {
        int cantidadAlumno = cantidadAlumno();
        //Creo vector de estudiantes
        Alumno[] estudiantes = new Alumno[cantidadAlumno];
        
        //Guardo memoria
        for (int i = 0; i < estudiantes.length; i++) {
            estudiantes[i] = new Alumno();
        }
        altaAlumno(estudiantes);
        MostrarAlumno(estudiantes);
    }
    static int cantidadAlumno(){
        System.out.println("Dime la cantidad de alumnos que tienes");
        int cantidadAlumno = leerInt();
        return cantidadAlumno;
    }
    static int leerInt(){
        Scanner teclado = new Scanner(System.in);
        int numero = teclado.nextInt();
        return numero;
    }
    static String leerString(){
        Scanner teclado = new Scanner(System.in);
        String palabra= teclado.next();
        return palabra;
    }
    static void altaAlumno(Alumno[] estudiantes){
        for (int i = 0; i < estudiantes.length; i++) {
            System.out.println("Dime el nombre del estudiante "+i);
            estudiantes[i].setNombre(leerString());
            System.out.println("Dime el telefono del estudiante "+estudiantes[i].getNombre());
            estudiantes[i].setTelefono(leerInt());
            System.out.println("Dime la direccion del estudiante  "+estudiantes[i].getNombre());
            estudiantes[i].direccion.setCalle(leerString());
        }
    }
    static void MostrarAlumno(Alumno[] estudiantes){
        for (int i = 0; i < estudiantes.length; i++) {
            System.out.println(estudiantes[i].getNombre());
        }
    }
    
}
