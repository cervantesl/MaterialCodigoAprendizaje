//13. Volem tindre una agenda on pugam guardar el nom, telèfon i adreça de cada
//amic. Fes un programa amb un bucle i un menú amb les següents opcions:
//a. Donar d’alta un amic
//b. Consultar un amic pel seu nom
//c. Saber la quantitat d’amics enregistrats
//d. Mostrar tota l’agenda per pantalla
//e. Esborrar un amic
//f. Modificar les dades d’un amic
//g. Importar dades
//h. Exportar dades
package agenda;

import java.util.ArrayList;
import Agenda.EE;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Lucas
 */
public class Agenda {
    static ArrayList <Persona> agenda = new ArrayList<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean salir = false;
        do {            
            switch(elegirOpcionMenu()){
                case 1:altaPersona(); break;
                case 2:consultaPorNombre(); break;
                case 3:cantidadPersonas(); break;
                case 4:mostrarPersonas(); break;
                case 5:modificarPersona();break;
                case 6:borrarPersona(); break;
                case 7:importarDatos(); break;
                case 8:exportarDatos(); break;
                case 0: salir = true;break;
            }
        } while (!salir);
    }
    
    static int elegirOpcionMenu(){
        System.out.println("1)Dar de alta un amigo");
        System.out.println("2)Consultar un amigo por su mombre");
        System.out.println("3)Cantidad de amigos en tu agenda");
        System.out.println("4)Mostrar toda la agenda por pantalla");
        System.out.println("5)Modificar datos de un amigo");
        System.out.println("6)borrar amigo");
        System.out.println("7)importar datos de un fichero al programa");
        System.out.println("8)exportar datos del programa a un fichero");
        System.out.println("0)Salir");
        System.out.println("Elegir opcion:");
        int opcion = EE.leerInt();
        return opcion;
    }
    
    static void altaPersona(){
        agenda.add(new Persona());
    }
    
    static int consultaPorNombre(){
        int posicion = -1;
        System.out.println("Nombre: ");
        String nombre = EE.leerCadena();
        
        posicion = agenda.indexOf(new Persona(nombre));
        
        if ( posicion != -1) {
            System.out.println("Existe!");
            System.out.println("Datos:");
            System.out.println(agenda.get(posicion));   
        }
        else{
            System.out.println("No existe");
        }
        return posicion;
    }
    
    static void cantidadPersonas(){
        System.out.println("Hay "+agenda.size()+" en la agenda");
    }
    
    static void mostrarPersonas(){ //Revisar
        System.out.println(agenda.toString());
    }
    
    static void modificarPersona(){
        int pos = consultaPorNombre();
        if ( pos != -1 ) {
            System.out.println("Dime los nuevos datos:");
            agenda.set(pos, new Persona());
        }
        else{
            System.out.println("La persona no existe");
        }
    }
    static void borrarPersona(){
        
        System.out.println("Nombre: ");
        if (agenda.remove(new Persona(EE.leerCadena()))) {
            System.out.println("Se ha borrado");
        }
        else{
            System.out.println("No se ha borrado");
        }
    }
    
    static void importarDatos(){ //Pasar info de fichero a arraylist del programa
        FileInputStream fis = EE.crearConstructorFIS();
        ObjectInputStream ois = EE.crearConstructorOIS(fis);
        
        try {
            agenda = (ArrayList<Persona>)ois.readObject(); //Pasa los objetos al array
        } catch (IOException ex) {
            System.out.println("No he pogut accedir al fitxer");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error escrivint al fitxer");
        }
        finally{
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                ois.close();
            } catch (IOException ex) {
                Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    static void exportarDatos(){
        FileOutputStream fos = EE.crearConstructorFOS();
        ObjectOutputStream oos = EE.crearConstructorOOS(fos);
        
        try {
            oos.writeObject(agenda);
        } catch (IOException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
