package ad_crearbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Lucas
 */
public class AD_CrearBD {

    public static void main(String[] args) {
        
        String motor = "mysql";
        
        cargarDriver(motor);

        Connection conn = conectarBD(motor, "localhost", "root", "");

        crearBD("EJEMPLO", conn);
    }

    public static void cargarDriver(String motor) {

        switch (motor.toLowerCase()) {
            case "mysql":
                try {
                    Class.forName("com.mysql.jdbc.Driver");

                    System.out.println("Driver " + motor + " cargado!");
                } catch (ClassNotFoundException ex) {
                    ex.getMessage();
                }
                break;

            case "sqlserver":
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    System.out.println("Driver " + motor + " cargado!");
                } catch (ClassNotFoundException ex) {
                    ex.getMessage();
                }
                break;

            case "oracle":
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    System.out.println("Driver " + motor + " cargado!");
                } catch (ClassNotFoundException ex) {
                    ex.getMessage();
                }
                break;
        }
    }

    public static Connection conectarBD(String motor, String host, String usuario, String password) {
        Connection conn = null;

        switch (motor) {
            case "mysql":
                try {
                    conn = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/", usuario, password);
                    System.out.println(motor + " conectado!");
                } catch (SQLException ex) {
                    ex.getMessage();
                }

            case "sqlserver":
                try {
                    conn = DriverManager.getConnection("jdbc:sqlserver://localhost;database=AdventureWorks;integratedSecurity=true;");
                    System.out.println(motor + " conectado!");
                } catch (SQLException ex) {
                    ex.getMessage();
                }
                break;

            case "oracle":
                try {
                    conn = DriverManager.getConnection("jdbc:oracle:thin:" + host + ":1521/");
                    
                    System.out.println(motor + " conectado!");
                } catch (SQLException ex) {
                    ex.getMessage();
                }
                break;

        }

        return conn;
    }

    public static void crearBD(String nombreBD, Connection conn) {
        Statement s = null;
        try {
            s = conn.createStatement();

            s.executeUpdate("drop database if exists " + nombreBD);
            s.executeUpdate("create database if not exists " + nombreBD);

            System.out.println("creado la BD: " + nombreBD);

            //CREAR TABLAS
            s.executeUpdate("use " + nombreBD);

            s.executeUpdate("CREATE TABLE departamentos ( "
                    + "dept_no TINYINT(2) NOT NULL PRIMARY KEY, "
                    + "dnombre VARCHAR(15), "
                    + "loc VARCHAR(15)"
                    + ");");

            s.executeUpdate("CREATE TABLE empleados ("
                    + "emp_no SMALLINT(4) UNSIGNED NOT NULL PRIMARY KEY, "
                    + "apellido VARCHAR(10), "
                    + "oficio VARCHAR(15), "
                    + "dir SMALLINT, "
                    + "fecha_alt DATE, "
                    + "salario FLOAT(6,2), "
                    + "comision FLOAT(6,2), "
                    + "dept_no TINYINT(2) NOT NULL REFERENCES departamentos(dept_no)"
                    + ");");

            //INSERTAR DATOS
            s.executeUpdate("INSERT INTO departamentos VALUES ("
                    + "10, 'CONTABILIDAD', 'SEVILLA'"
                    + ");");
            s.executeUpdate("INSERT INTO departamentos VALUES ("
                    + "20, 'INVESTIGACION', 'MADRID'"
                    + ");");
            s.executeUpdate("INSERT INTO departamentos VALUES ("
                    + "30, 'VENTAS', 'BARCELONA'"
                    + ");");
            s.executeUpdate("INSERT INTO departamentos VALUES ("
                    + "40, 'PRODUCCION', 'BILBAO'"
                    + ");");

            //MOSTRAR DATOS
            mostrarDatosEmpleados(s);

            insertarDatosEmpleados(conn, nombreBD);

            //MOSTRAR DATOS ACT 6 
            mostrarDatosBDEspecifico(s);

        } catch (SQLException ex) {
            ex.getMessage();
        } finally {
            try {
                s.close();
                conn.close();
            } catch (SQLException ex) {
                ex.getMessage();
            }
        }
    }

    public static void mostrarDatosEmpleados(Statement s) {
        ResultSet rs = null;

        try {
            rs = s.executeQuery("SELECT * FROM departamentos");

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " "
                        + rs.getString(3));
            }
        } catch (SQLException ex) {
            ex.getMessage();
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
                ex.getMessage();
            }
        }
    }

    public static void mostrarDatosBDEspecifico(Statement s) {
        ResultSet rs = null;

        try {
            rs = s.executeQuery("SELECT apellido, oficio, salario FROM departamentos WHERE dept_no = 10");
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    public static void insertarDatosEmpleados(Connection conn, String nombreBD) {
        Statement s = null;

        try {
            s = conn.createStatement();

            s.executeUpdate("use " + nombreBD);

            s.executeUpdate("INSERT INTO empleados VALUES ("
                    + "1, 'Alvarez', 'programador', 46722, 2006-05-2, 1005, 200, 10"
                    + ");");

        } catch (SQLException ex) {
            ex.getMessage();
        } finally {
            try {
                s.close();
            } catch (SQLException ex) {
                ex.getMessage();
            }
        }
    }
}
