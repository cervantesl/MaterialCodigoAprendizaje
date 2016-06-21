//***********************************************************************
//           FUNCIONES DE ESCRITURAS Y LECTURAS GENERICAS EN JAVA
//***********************************************************************
package banclucascervantes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;




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
                s = br.readLine();
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
    
    public static void leerFichero(){
        
    }
    
    
    
    
}
    

