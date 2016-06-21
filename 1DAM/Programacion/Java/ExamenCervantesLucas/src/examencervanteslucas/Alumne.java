/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examencervanteslucas;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class Alumne implements java.io.Serializable, Comparable {
    static ArrayList <Alumne> alumnes = new ArrayList<>();
    static Connection conn = null;
    int codi;
    String nom;
    int edat;

    public Alumne(int codi, String nom, int edat) {
        this.codi = codi;
        this.nom = nom;
        this.edat = edat;
    }

     static void taulaAFitxer(Connection conn, String nombreFichero){ 
        Statement s = null;
        try {
            s = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Alumne.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs = null;
        try {
            s.executeUpdate("use alumnes" );
            rs = s.executeQuery("select * from alumnes");
        } catch (SQLException ex) {
            Logger.getLogger(Alumne.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Exportar datos del arrayList al fichero
        FileOutputStream fos = EE.crearConstructorFOS(nombreFichero);
        ObjectOutputStream oos = EE.crearConstructorOOS(fos);
        Alumne alu = null;
        try {
            while ( rs.next() )
            {

            alu = new Alumne(rs.getInt(1) ,rs.getString(2),rs.getInt(3));
            
            try {
                oos.writeObject(alu);
            } catch (IOException ex) {
                System.out.println("Error");
            }

            try {
                fos.close();
            } catch (IOException ex) {
                System.out.println("Error");
            }
            try {
                oos.close();
            } catch (IOException ex) {
                System.out.println("Error");
            }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Alumne.class.getName()).log(Level.SEVERE, null, ex);
           }
        
    }
        
    static void fitxerATaula(Connection conn, String nombreFichero){ //Pasar info de fichero a arraylist del programa
        
        FileInputStream fis = EE.crearConstructorFIS(nombreFichero);
        ObjectInputStream ois = EE.crearConstructorOIS(fis);
        
        try {
            alumnes = (ArrayList<Alumne>)ois.readObject(); //Pasa los objetos al array
        } catch (IOException ex) {
            System.out.println("No se ha podidio acceder al fichero");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error escribiendo el fichero");
        }
        finally{
            try {
                fis.close();
            } catch (IOException ex) {
                System.out.println("Error");
            }
            try {
                ois.close();
            } catch (IOException ex) {
                System.out.println("Error");
            }
        }
    }
    
    static void alumneAXML(Connection conn, String nombreFichero){
        ResultSet rs = null;
        Statement s = null;
        Alumne alu = null;
        FileWriter fw = EE.crearConstructorFW(nombreFichero);
        BufferedWriter bw = EE.crearConstructorBW(fw);
        
        try {
            s = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Alumne.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            bw.write("<alumnes>");
             bw.newLine();
            while ( rs.next() )
            {
                
            alu.codi = rs.getInt(1);
            alu.nom = rs.getString(2);
            alu.edat = rs.getInt(3);
            alu = new Alumne(alu.codi ,alu.nom,alu.edat);
            
           try {
                
                bw.write("<alumne>");
                bw.newLine();
                bw.write("<codi>");
                bw.write(alu.codi);
                bw.write("</codi>");
                bw.newLine();
                bw.write("<nom>");
                bw.write(alu.nom);
                bw.write("</nom>");
                bw.newLine();
                bw.write("<edat>");
                bw.write(alu.edat);
                bw.write("</edat>");
                bw.newLine();
                bw.write("</alumne>");
                bw.newLine();
                
            } catch (IOException ex) {
                System.out.println("Error");
            } 
    
             bw.write("</alumnes>");
            
            }
            } catch (SQLException ex) {
                Logger.getLogger(Alumne.class.getName()).log(Level.SEVERE, null, ex);
           } catch (IOException ex) {
            Logger.getLogger(Alumne.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Alumne.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Alumne.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int compareTo(Object obj) {
        
        Alumne a = (Alumne)obj;

        if (this.nom.equals(a.nom)) {
            return this.nom.compareTo(a.nom);
        }
        else{
            return this.edat - a.edat;
        }
    }
    
    static Alumne alumneMenor(Alumne a, Alumne b){
        
        if (a.compareTo(b) < 0) {
            return a;
        }
        else{
            return b;
        }

    }
    
    static Alumne ordenarPersonas(ArrayList alumnes){
        Collections.sort(alumnes);
        Alumne a = (Alumne) alumnes.get(1);
        return a;
    }

}
