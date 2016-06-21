/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package t13e01provesbd;

import io.IO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class T13E01ProvesBD {

    /**
     * @param args the command line arguments
     */
    
    static Connection conn;  // global per a no passar-la com a paràmetre cada volta
    public static void main(String[] args) {
            int opcio, q;
            Connexio connexio;
            
            // Exercici 1:
            Connexio.driver("mysql");  // ojo: crec que no cal
            connexio = new Connexio("root", "", "");
            conn = connexio.getConnection();
            crearBD("proves");            

            // Exercici 2:
            do {
                System.out.println("\n\n\n");
                System.out.println("------------------------------------------");
                System.out.println("      M E N Ú");
                System.out.println("------------------------------------------");
                System.out.println(" 0. Crear base de dades");
                System.out.println(" 1. Quants clients");
                System.out.println(" 2. Deute total dels clients");
                System.out.println(" 3. Sou mig dels empleats");
                System.out.println(" 4. Mostrar clients (a partir del codi)");
                System.out.println(" 5. Mostrar clients (a partir del nom)");
                System.out.println(" 6. Mostrar empleats (a partir del codi)");
                System.out.println(" 7. Mostrar empleats (a partir del nom)");
                System.out.println(" 8. Inserir client");
                System.out.println(" 9. Inserir empleat");
                System.out.println("10. Incrementar % sou empleats");
                System.out.println("11. Esborrar empleat");
                System.out.println("12. Eixir");
                System.out.println("------------------------------------------");
                System.out.print("Tria opció: ");
                opcio = IO.llegirEnter();
                System.out.println("");
                
                switch (opcio){
                    case 0:
                        crearBD("proves");
                        break;
                    case 1: System.out.println("Quant. clients: " + quantsClients());
                        break;
                    case 2: System.out.println("Deute: " + deuteClients());
                        break;
                    case 3: System.out.println("Sou mig empleats: " + souMigEmpleats());
                        break;
                    case 4:
                        System.out.print("Codi client ( tots = -1 ): ");
                        int codiCli = IO.llegirEnter();
                        q = mostrarClientsPerCodi(codiCli);
                        System.out.println("He mostrat " + q + " clients");
                        break;
                    case 5:
                        System.out.print("Nom client: ");
                        String nomCli = IO.llegirCadena();
                        q = mostrarClientsPerNom(nomCli);
                        System.out.println("He mostrat " + q + " clients");
                        break;
                    case 6: 
                        System.out.print("Codi empleat ( tots = -1 ): ");
                        int codiEmp = IO.llegirEnter();
                        q = mostrarEmpleatsPerCodi(codiEmp);
                        System.out.println("He mostrat " + q + " empleats");
                        break;
                    case 7: 
                        System.out.print("Nom empleat: ");
                        String nomEmp = IO.llegirCadena();
                        q = mostrarEmpleatsPerNom(nomEmp);
                        System.out.println("He mostrat " + q + " empleats");
                        break;
                    case 8: 
                        if (insClient()) 
                            System.out.println("Client inserit");
                        else    
                            System.out.println("Client no inserit");
                        break;
                    case 9:
                        if (insEmpleat()) 
                            System.out.println("Empleat inserit");
                        else    
                            System.out.println("Empleat no inserit");
                        break;
                    case 10: incrPercSou();
                        break;
                    case 11: esborrarEmpleat();
                        break;
                    case 12: // Eixir
                        break;
                    default: System.out.println("Opció incorrecta");
                        
                }
               
            } while (opcio!=12);
     
    }
    


    static void crearBD(String bd){
        
        Statement s = null;
        try {
            s = conn.createStatement();
            System.out.println("Vols crear la bd "+ bd + "? (s/n): ");
            if (IO.acceptar()) {
                s.executeUpdate("drop database if exists " + bd);
                s.executeUpdate("create database if not exists " + bd);
                System.out.println("BD " + bd + " creada (o ja estava creada)");
                
                s.executeUpdate("use " + bd);
                System.out.println("BD " + bd + " seleccionada");
                
                s.executeUpdate("create table clients(codi int primary key, "
                            + "nom varchar(10), edat int, deute int);");
                System.out.println("Taula clients creada");
                
                s.executeUpdate("create table empleats(codi int primary key, "
                            + "nom varchar(10), sou int , cap int, "
                            + "foreign key (cap) references empleats(codi))"); 
                System.out.println("Taula empleats creada");
                
                System.out.println("Vols inserir dades de prova automàticament?");
                if (IO.acceptar()) {
                    s.executeUpdate("insert into clients values "
                        + "(1, 'Pep', 22, 100),"
                        + "(2, 'Pepa', 22, 200),"
                        + "(3, 'Pepet', 22, 300)");
                    System.out.println("Clients inserits");
                
                    s.executeUpdate("insert into empleats values "
                        + "(11, 'JOSEP', 1000, null),"
                        + "(12, 'MARIA', 700, 11),"
                        + "(13, 'ANTÒNIA', 700, 11),"
                        + "(14, 'JOSEPA', 500, 12)");
                    System.out.println("Empleats inserits");
                }
              
            }
            else {
                s.executeUpdate("use " + bd);
                System.out.println("BD " + bd + " seleccionada");
            }
                
        } catch (SQLException e){
            System.out.println(e.getMessage());
            System.out.println("Error amb la base de dades " + bd);                
        }                             
                    
    }
       
    
    static int quantsClients(){
        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("select count(*) from clients");
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            return -1;
        }
    }
    
    static int deuteClients(){
        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("select sum(deute) from clients");
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            return -1;
        }        
    }
    
    static float souMigEmpleats(){
        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("select avg(sou) from empleats");
            rs.next();
            return rs.getFloat(1);
        } catch (SQLException ex) {
            return -1;
        }        
    }   
    
    static int mostrarClientsPerCodi(int codi){
        String sentencia = "select * from clients";
        if (codi != -1)
            sentencia = sentencia + " where codi = " + codi;

        return mostrarClients(sentencia);         
    }
    
    static int mostrarClientsPerNom(String nom){
        int qcli=0;

        String sentencia = "select * from clients where nom = '" + nom + "'";

        qcli = mostrarClients(sentencia);
         
        return qcli;
    }
    

    static int mostrarClients(String sentencia){
        int qcli=0;
        try {
            // CONSTRUÏM LA SENTÈNCIA
            Statement s = conn.createStatement();
            
            // EXECUTEM LA SENTÈNCIA
            ResultSet rs = s.executeQuery(sentencia);
            
            // RECORREM EL RESULT SET
            System.out.println("\tCODI\tNOM\tEDAT\tDEUTE");
            System.out.println("\t----\t---\t----\t-----");
            while (rs.next()){
                qcli++;
                
                System.out.print("\t" + rs.getInt(1));
                System.out.print("\t" + rs.getString(2));
                System.out.print("\t" + rs.getInt(3));
                System.out.println("\t" + rs.getFloat(4));
            }
            
             
        } catch (SQLException ex) {
            Logger.getLogger(T13E01ProvesBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return qcli;
    }

    static int mostrarEmpleatsPerCodi(int codi){
        String sentencia = "select * from empleats";
        if (codi != -1)
            sentencia = sentencia + " where codi = " + codi;

        return mostrarEmpleats(sentencia);         
    }
    
    static int mostrarEmpleatsPerNom(String nom){
        int qEmp=0;

        String sentencia = "select * from empleats where nom = '" + nom + "'";

        qEmp = mostrarEmpleats(sentencia);
         
        return qEmp;
    }
    

    static int mostrarEmpleats(String sentencia){
        int qEmp=0;
        try {
            // CONSTRUÏM LA SENTÈNCIA
            Statement s = conn.createStatement();
            
            // EXECUTEM LA SENTÈNCIA
            ResultSet rs = s.executeQuery(sentencia);
            
            // RECORREM EL RESULT SET
            System.out.println("\tCODI\tNOM\tSOU\tCAP");
            System.out.println("\t----\t---\t----\t-----");
            while (rs.next()){
                qEmp++;
                
                System.out.print("\t" + rs.getInt(1));
                System.out.print("\t" + rs.getString(2));
                System.out.print("\t" + rs.getInt(3));
                System.out.println("\t" + rs.getInt(4));
            }
            
             
        } catch (SQLException ex) {
            Logger.getLogger(T13E01ProvesBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return qEmp;
    }
        
    
    static boolean insClient(){
        try {
            int nouCodi;
            String nom;
            int edat;
            float deute;
            // demanar dades del client per teclat:
            System.out.print("Nom: ");
            nom = IO.llegirCadena();
            System.out.print("Edat: ");
            edat = IO.llegirEnter();
            System.out.print("Deute: ");
            deute = IO.llegirReal();
            
            // Obtindre el nou valor de codi de client (màxim + 1)
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("select max(codi)+1 from clients");
            rs.next();// M'apunta a la 1a (i única) fila del resultSet
            nouCodi = rs.getInt(1);
            
            // Fer l'insert
            
            Statement s2 = conn.createStatement();
            s2.executeUpdate(        
             "insert into clients values (" + nouCodi
                                    + "," + "'" + nom + "',"
                                    + edat + "," + deute + ")"
                        );
      
        } catch (SQLException ex) {
            return false;
        }
        
        return true;              
    }

    static boolean insEmpleat(){
        try {
            int nouCodi;
            String nom;
            int sou;
            int cap;
            // demanar dades del client per teclat:
            System.out.print("Nom: ");
            nom = IO.llegirCadena();
            System.out.print("Sou: ");
            sou = IO.llegirEnter();
            
            cap = triarEmpleat("Quin d'estos empleats és el seu cap? ");
            
            if (cap < 0){
                return false;
            }
            else {
                    // Obtindre el nou valor de codi d'empleat (màxim + 1)
                    Statement s = conn.createStatement();
                    ResultSet rs = s.executeQuery("select max(codi)+1 from empleats");
                    rs.next();// M'apunta a la 1a (i única) fila del resultSet
                    nouCodi = rs.getInt(1);

                    // Fer l'insert
                    Statement s2 = conn.createStatement();
                    s2.executeUpdate("insert into empleats values (" + nouCodi
                               + "," + "'" + nom + "'," + sou + "," + cap + ")" );
                    return true;
                }
            
      
        } catch (SQLException ex) {
            return false;
        }
        
    }    
    
    static int triarEmpleat(String pregunta){        
        // Retorna codi empleat o -2 si s'ha triat un empleat inexistent
        // o bé -1 si es volen triar tots els empleats
        System.out.println(pregunta);
        mostrarEmpleatsPerCodi(-1);
        System.out.print("Codi: ");
        int codi = IO.llegirEnter(); 
        if (codi < 0) return -1; // Tots els empleats
        System.out.println("Dades de l'empleat que que has triat:");
        if (mostrarEmpleatsPerCodi(codi) == 0){
            System.out.println("Codi d'empleat inexistent. No pot ser.");
            return -2;
        }
        else {
            System.out.println("Segur? (s/n): ");
            if (IO.acceptar()) {
                return codi;
            }
            else {
                System.out.println("Operació d'inserció cancelada per l'usuari.");
                return -2;
            }
        }
    }
    
    
    static void incrPercSou(){
        int codiEmp = triarEmpleat("Codi empleat (tots = -1): ");
        if (codiEmp != -2){
            System.out.print("Percentatge d'increment del sou: ");
            int perc = IO.llegirEnter();
            int qEmp = incrPercSou(codiEmp, perc);
            if (qEmp == 1) {
                System.out.println("S'ha modificat el sou a 1 empleat.");
            }
            else {
                System.out.println("S'ha modificat el sou a " + qEmp  +" empleats.");
            };
        }
    }
    
    static int incrPercSou(int codi, int perc){
        int qEmp = 0;
        try {
            Statement s = conn.createStatement();
            String sentencia = "update empleats set sou = sou + sou*" + (perc/100.0);
            if (codi>=0){
                sentencia = sentencia + " where codi = " + codi;
            }
            qEmp = s.executeUpdate(sentencia);            
        } catch (SQLException ex) {
                Logger.getLogger(T13E01ProvesBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return qEmp;
    }
    
    static void esborrarEmpleat(){
        // ojo: comprovar que no dóna error per clau aliena, etc.
        int codiEmp = triarEmpleat("Codi empleat a esborrar (tots = -1): ");
        if (codiEmp != -2){
            int qEmp = esborrarEmpleat(codiEmp);
            if (qEmp == 1) {
                System.out.println("S'ha esborrat 1 empleat.");
            }
            else {
                System.out.println("S'han esborrat " + qEmp + " empleats.");
            };
        }
        
    }
    
    static int esborrarEmpleat(int codi){
        int qEmp = 0;
        try {
            Statement s = conn.createStatement();
            String sentencia = "delete from empleats";
            if (codi>=0){
                sentencia = sentencia + " where codi = " + codi;
            }
            try {
                qEmp = s.executeUpdate(sentencia); 
            }
            catch (SQLException ex){
                System.out.println("Empleat no esborrat perquè és cap d'altres");
            }
        } catch (SQLException ex) {
                Logger.getLogger(T13E01ProvesBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return qEmp;  
    }

    
}
