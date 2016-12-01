/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenarnumerosaleatorios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Lucas
 */
public class OrdenarNumerosAleatorios {

    static ArrayList<Integer> ordenarNumeros(ArrayList<Integer> numerosAleatorios) {

        ArrayList<Integer> numerosAleatoriosOrdenados = new ArrayList<>();

        for (int i = 0; i < numerosAleatorios.size(); i++) {
            numerosAleatoriosOrdenados.add(numerosAleatorios.get(i));
        }

        Collections.sort(numerosAleatoriosOrdenados);
        
        System.out.println(numerosAleatoriosOrdenados.toString());
        
        return numerosAleatoriosOrdenados;
    }

    public static void main(String[] args) throws IOException {
       
        int cantidadNumerosAPedir = Integer.parseInt(args[0]);
        
        Scanner teclado = new Scanner(System.in);
       
        ArrayList<Integer>numeros = new ArrayList<Integer>();
        
        
        for (int i = 0; i < cantidadNumerosAPedir; i++) {
            numeros.add(teclado.nextInt());
        }
      
       ordenarNumeros(numeros);
      
    }

}
