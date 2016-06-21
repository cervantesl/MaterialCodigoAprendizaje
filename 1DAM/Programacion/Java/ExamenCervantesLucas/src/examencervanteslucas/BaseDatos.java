/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examencervanteslucas;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class BaseDatos {
    Scanner teclado = new Scanner(System.in);
    Connection conn = null;
    
    
    public void abrirConexion(){
        System.out.println("ABRIR CONEXION");
        System.out.println("Dime el host");
        String host = teclado.nextLine();
        
        System.out.println("Dime la base de datos");
        String bd = teclado.nextLine();
        
        System.out.println("Dime el usuario");
        String usuario = teclado.nextLine();
        
        System.out.println("Dime el password");
        String contraseña = teclado.nextLine();
        
        
        try {
            conn = DriverManager.getConnection("jdbc:"+host+"://localhost/"+bd+"",""+usuario+"","");
        } catch (SQLException ex) {
            System.out.println("Error de parametros");
        }
   }
    
    public void crearDB(){
        System.out.println("CREAR BD");
        System.out.println("Nombre BD:");
        String bd = teclado.nextLine();
        Statement s = null;
        
        try {
            s = conn.createStatement();
            s.executeUpdate("create database " + bd);
            s.executeUpdate("use " + bd);
            System.out.println("BD " + bd + " seleccionada");
//            s.executeUpdate("create table personajes(codi int primary key, "
//                           + "nom varchar(10), vida int);");
            
        } catch (SQLException ex) {
            System.out.println("Error");
        }
    }
    
    public void crearTablas(){
       Statement s = null;
        try {
            s = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
         s.executeUpdate("CREATE table alumnes("
                 + "codi int primary key, "
                 + "nom varchar(20), "
                 + "edat varchar(20))Engine=InnoDB;");
     } catch (SQLException ex) {
            System.out.println("Error");
     }
    }
 
    
    public void almacenarDatos(Alumne a){
      
        int codi = a.codi;
        String nombre = a.nom;
        int edat = a.edat;
        Statement s = null;
        
        try {
            s = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            s.executeUpdate("insert into alumnes values "
                    + "("+codi+", '"+nombre+"', "+edat+")");
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
       
    public void modificarTablas(){
        System.out.println("Dime el nuevo nombre del personaje que quieras modificar");
        String nombre = teclado.nextLine();
        
        Statement s = null;
        try {
            s = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            s.executeUpdate("update personajes set nom ='"+nombre+"' where codi ="+4+";" );
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        {
           
    }

}
