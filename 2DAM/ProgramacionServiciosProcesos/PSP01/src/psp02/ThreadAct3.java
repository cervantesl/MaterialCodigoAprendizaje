/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author Lucas
 */
public class ThreadAct3 {

    //Programa que le pasas archivos.txt, y diga las lineas, caracteres y palabras
    //nlinea++; <-- lineas
    //nchar = linea.length(); <-- caracteres
    //linea.split("[]+").length <-- palabras
    //[]+ por si hay mas espacios
    
    //1 fichero por hilo
    //Datos de cada fichero -> en cada hilo
    //DAtos totales variable comun
    public static void main(String[] args) throws IOException {
        String contenido = "";

        InputStream entradaBytes = ClassLoader.class.getResourceAsStream("/thread.txt");
        BufferedReader lector = new BufferedReader(new InputStreamReader(entradaBytes));

        String linea;

        int numeroLineas = 0;
        int numeroCaracteres = 0;
        int numerosPalabras = 0;
        long inicio = System.currentTimeMillis();
        
        

        while ((linea = lector.readLine()) != null) {
            numerosPalabras += linea.split(" ").length;
            numeroCaracteres += linea.length() + 1;
            numeroLineas++;
        }
        
        long fin = System.currentTimeMillis();
        
        System.out.println(inicio);
        System.out.println(fin);

        System.out.println("Numero Palabras: " + numerosPalabras);
        System.out.println("Numero Caracteres: " + numeroCaracteres);
        System.out.println("Numero Lineas: " + numeroLineas);
        System.out.println("Tiempo: " + (fin-inicio));
    }
}
