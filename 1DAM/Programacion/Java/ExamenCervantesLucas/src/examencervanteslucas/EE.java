//***********************************************************************
//           FUNCIONES DE ESCRITURAS, LECTURAS Y FICHEROS EN JAVA
//***********************************************************************
package examencervanteslucas; //SI COPIAS ESTA CLASE A OTRA TIENES QUE ACORDARTE DE CAMBIAR EL NOMBRE DEL PAQUETE DESTINO

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;




/**
 *
 * @author Lucas Cervantes Leonez 
 */
public class EE {
//***********************************************************************
//           FUNCIONES ESCRITURA (IMPRIMIR) 
//***********************************************************************
    public static void imprimir(int i){
        System.out.println(i);
    }
    public static void imprimir(float f){
        System.out.println(f);
    }
    public static void imprimir(double d){
        System.out.println(d);
    }
    public static void imprimir(char c){
        System.out.println(c);
    }
    public static void imprimir(String c){
        System.out.println(c);
    }
    public static void imprimir(File d){
        listarFicheros(d);
    }
    public static void imprimir(FileReader fr){
        mostrarFichero(fr);
    }
    public static void imprimir(BufferedReader br){
        mostrarFicheroALineas(br);
    }

    /**Imprime lista de ficheros de un directorio pasado por parametro**/
    /**NOTA: primero hay que crear el constructor ( File D = new file(" ");**/
    //---------------------------------------------------------------
    //sus metodos importantes son:
    //length() Devuelve la grandarie del fichero
    //isDirectory() Comprueba que es un directorio
    //isFile() Comprueba que es un fichero
    //---------------------------------------------------------------
    public static void listarFicheros(File d){
        if (d.isDirectory()) {
            String [] nombreFicheros = d.list();
            
            for (int i = 0; i < nombreFicheros.length; i++) {
                System.out.println(nombreFicheros[i]);
            }
        }
        else{
            System.out.println("No es un directorio");
        }
    }
    
//***********************************************************************
//           CREAR CONSTRUCTORES DE FICHEROS
//***********************************************************************
    //Constructor para leer fichero por caracteres
    public static FileReader crearConstructorFR(){
        FileReader fr = null;
         
        System.out.println("Dime el nombre del fichero que quieres mostrar");
        String nombre = EE.leerCadena();
        try {
            fr = new FileReader("C:\\Users\\Lucas\\Documents\\1DAM\\Programacion\\Tema12\\"+nombre+".txt");
        } catch (FileNotFoundException ex) {
            System.out.println("No se ha podido crear");
        }
        return fr;
    }
    
    //Crear constructor para leer fichero por lineas
    public static BufferedReader crearConstructorBR(FileReader fr){
        BufferedReader br= null;    
        br = new BufferedReader(fr);
        return br;
    }
    
    //Crear constructor para escribir fichero
    public static FileWriter crearConstructorFW(String nombre){
       
        
        FileWriter fw = null;
        try {
            fw = new FileWriter("C:\\Users\\Lucas\\Documents\\1DAM\\Programacion\\Tema12\\"+nombre+".txt");
        } catch (IOException ex) {
            Logger.getLogger(EE.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fw;
    }
    
    //Crear construr para escribir fichero por linea
    public static BufferedWriter crearConstructorBW(FileWriter fw){
        BufferedWriter bw = new BufferedWriter(fw);
        return bw;
    }
    
    //Crear constructor para importar fichero al programa
    public static FileInputStream crearConstructorFIS(String nombre){

        FileInputStream fis= null;
        
        try {
            fis = new FileInputStream("C:\\Users\\Lucas\\Documents\\1DAM\\Programacion\\Tema12\\"+nombre+".txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EE.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return fis;   
    }
    //Crear constructor para importar fichero al programa
    public static ObjectInputStream crearConstructorOIS(FileInputStream fis){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(fis);
        } catch (IOException ex) {
            Logger.getLogger(EE.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ois;
    }
    
    //crear constructor para exportar datos del programa al fichero
    public static FileOutputStream crearConstructorFOS(String nombre){
        
        FileOutputStream fos= null;
        
        try {
            fos = new FileOutputStream("C:\\Users\\Lucas\\Documents\\1DAM\\Programacion\\Tema12\\"+nombre+".txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EE.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return fos;
    }
    
    //Crear constructor para exportar datos del programa al fichero
    
    public static ObjectOutputStream crearConstructorOOS(FileOutputStream fos){
        ObjectOutputStream oos = null;
        
        try {
            oos = new ObjectOutputStream(fos);
        } catch (IOException ex) {
            Logger.getLogger(EE.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return oos;
    }
    
//***********************************************************************
//           FIN DE CREAR CONSTRUCTORES DE FICHEROS
//***********************************************************************
    
    /**Imprimir contenido de un fichero pasado por parametro**/
    /**NOTA: primero hay que crear el constructor ( FileReader fr = new FileReader(" ");**/
    //---------------------------------------------------------------
    //sus metodos importantes son:
    //read() Devuelve un entero que es el codigo del caracter o -1 que no ha podido leer el fichero
    //---------------------------------------------------------------
    public static void mostrarFichero(FileReader fr){
        int c;
        try {
            while( (c=fr.read()) != -1 ){
                System.out.print((char)c); //NOTA: hay que hacer el casting para poder imprimirlo
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    /**Imprimir contenido de un fichero linea a linea pasado por parametro**/
    /**NOTA: PRIMERO HAY QUE CREAR EL CONTRUCTOR( BufferedReader br = NEW BufferedReader(" ");**/
    //---------------------------------------------------------------
    //sus metodos importantes son:
    //ready() nos informa que aun quendan datos por leer
    //readLine() para leer el fichero
    //---------------------------------------------------------------
    public static void mostrarFicheroALineas(BufferedReader br){
        String s = "";
        try {
            while(br.ready()){ 
                System.out.println(s = br.readLine()); 
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    
//***********************************************************************
//           FUNCIONES DE LECTURA (LEER)
//***********************************************************************
    
    public static String leerCadena(){
        Scanner teclado = new Scanner(System.in);
        String c = teclado.nextLine();
        return c;
    }
    
    public static int leerInt(){
        Scanner teclado = new Scanner(System.in);
        int i = teclado.nextInt();
        return i;
    }
   
    
    

    
}
    

