/*
 * To change this template, choose Tools | Templates
 * and open the temprilate in the editor.
 */
package t13e01provesbd;

import io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Administrador
 */
public class Connexio {
    static String motor = null; // mysql, oracle
    Connection conn = null;    
    String bd = null;
    
    static void driver(){    
        System.out.println("Dis-me el motor SQL (mysql, oracle, ...): ");        
        driver(IO.llegirCadena());
    }
    
    static void driver(String motor){
        try {
            switch (motor.toLowerCase()){
                case "mysql":  Class.forName("com.mysql.jdbc.Driver"); break;
                case "oracle": Class.forName("oracle.jdbc.Driver.OracleDriver"); break;
                default: System.out.println("Error: no reconec el motor " + motor);
            }
            Connexio.motor = motor;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error carregant el driver per a " + motor);            
        }
    }
    
    void obri(){        
        System.out.println("Host: ");           String host = IO.llegirCadena();          
        System.out.println("Usuari: ");         String usu = IO.llegirCadena();
        System.out.println("Password: ");       String pass= IO.llegirCadena();
        System.out.println("Base de dades: ");  String bd = IO.llegirCadena();
        
        this.obri(host, usu, pass, bd);
    }  
    
    void obri(String host, String usuari, String password, String bd){
        String url = null;
        
        if (host == null || host.length() == 0) host = "localhost";
        if (motor == null || motor.length() == 0) motor = "mysql";
       
        switch (Connexio.motor){
            case "":
            case "mysql":  url = "jdbc:mysql://" + host + ":3306/" + bd; break;
            case "oracle": url = "jdbc:oracle:thin:" + host + ":1521:" + bd; break;
        }
        try {
            if (Connexio.motor.length()==0) {Connexio.driver();}
            this.conn = DriverManager.getConnection(url, usuari, password);
            this.bd = bd;
        } catch (SQLException ex) {
            System.out.println("Error. No s'ha pogut fer la connexió a la bd " + bd);
            System.out.println(ex.getMessage());
        }

    }
    
    public Connection getConnection(){
        return this.conn;
    }

    public Connexio() {
        obri();
    }
    
    public Connexio(String host, String usuari, String password, String bd) {
        obri(host, usuari, password, bd);
    }
    
    public Connexio(String usuari, String password, String bd){
        obri("localhost", usuari, password, bd);
    }
    
    public Connexio(String usuari, String password){
        obri("localhost", usuari, password, "");
    }
    
    public Connexio(String bd){
        obri("localhost", "root", "root", bd);
    }
    
    void tanca(){
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error en tancar la connexió");            
        }
    }
    
    void mostraBasesDeDades(){
        try {
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rs = dbmd.getCatalogs();

            while ( rs.next() )
            {
            System.out.println(rs.getObject(1));	// Nom del catàleg (BD)
            }   
        } catch (SQLException ex) {
            System.out.println("Error mostrant les BD existents");
        }

    }
    
    void mostraTaules(){
        this.mostraTaules(this.bd);
    }
    
    void mostraTaules(String bd){
        try {
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rs = dbmd.getTables(bd, null, null, null);
            System.out.println("");
            System.out.println("CATALEG  \tESQUEMA\tTAULA");
            while ( rs.next() ) {   
                String nomCataleg = rs.getString(1) ;
                String nomEsquema = rs.getString(2) ;
                String nomTaula   = rs.getString(3);
                System.out.println(nomCataleg + "\t" + nomEsquema + "\t" + nomTaula);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connexio.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    }
}

    
    
    
    

    



