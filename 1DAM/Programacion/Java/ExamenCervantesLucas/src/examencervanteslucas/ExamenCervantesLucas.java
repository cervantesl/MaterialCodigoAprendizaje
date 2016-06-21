/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examencervanteslucas;

import java.sql.Connection;

/**
 *
 * @author Lucas
 */
public class ExamenCervantesLucas {
    static Connection conn;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Constructor de Alumne para trabajar
        Alumne a = new Alumne(1,"pep",40);
        
        
        //Constructor para trabajar con la BD
        BaseDatos bd = new BaseDatos();
        
        //Abrimos la conexion
        bd.abrirConexion();
        
        //prueba1(bd,a);

        //Pasamos los datos de la BD a un fichero
        prueba2();

    }
    
    static void prueba1(BaseDatos bd, Alumne a){ //FUNCIONA
        //Creamos la BD alumnes
        bd.crearDB();
        
        //Creamos la tabla alumnes (con los campos codi, nom, edat)
        bd.crearTablas();
        
        //Almacenamos datos a la BD
        bd.almacenarDatos(a);
    }
    
    static void prueba2(){
        //Pasamos los datos de la BD a un fichero
        System.out.println("Dime el nombre del fichero donde quieras almacenar los datos de la BD");
        String nombreFichero = EE.leerCadena();
        Alumne.taulaAFitxer(conn, nombreFichero);
    }
    
}
