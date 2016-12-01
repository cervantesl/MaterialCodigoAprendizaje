/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlite;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.management.remote.JMXConnectorFactory.connect;

/**
 *
 * @author Lucas
 */
public class Alumno {

    private int id;
    private String nombre;
    private String apellidos;

    public Alumno(final int id, final String nombre, final String apellidos) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public int obtenerId() {
        return id;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public String obtenerApellidos() {
        return apellidos;
    }

    public void establecerId(int id) {
        this.id = id;
    }

    public void establecerNombre(String nombre) {
        this.nombre = nombre;
    }

    public void establecerApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void guardar() {
        Conector con = new Conector();
        con.connect();
        con.guardarAlumno(this);
        con.close();
    }
}
