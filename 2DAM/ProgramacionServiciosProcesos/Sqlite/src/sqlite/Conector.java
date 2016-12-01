/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class Conector {

    String url = "C:\\Users\\Lucas\\Desktop\\alumnos.db";
    Connection connect;

    public void connect() {
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:" + url);
            
            if(connect != null) {
                System.out.println("Conectado!");
            }
        } catch (SQLException ex) {
            System.out.println("No se ha podido conectar a la BD");
        }       
    }
    
    public void close() {
        try {
            connect.close();
            System.out.println("Conexion cerrada");
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void guardarAlumno(Alumno alumno) {
        try {
            PreparedStatement st = connect.prepareStatement("insert into alumnos (id,nombre, apellidos) values (?,?,?)");   
            st.setInt(1, alumno.obtenerId());
            st.setString(2, alumno.obtenerNombre());
            st.setString(3, alumno.obtenerApellidos());
            st.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
        public void mostrarAlumnos() {
        ResultSet result = null;
        try {
            PreparedStatement st = connect.prepareStatement("select * from alumnos");
            result = st.executeQuery();
            
            while(result.next()) {
                System.out.print("ID: ");
                System.out.println(result.getInt("id"));
                
                System.out.print("Nombre ");
                System.out.println(result.getString("nombre"));
                
                System.out.print("Apellidos ");
                System.out.println(result.getString("apellidos"));
                
                System.out.println("==========================");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
