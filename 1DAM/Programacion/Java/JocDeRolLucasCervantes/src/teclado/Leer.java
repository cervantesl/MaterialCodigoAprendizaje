/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teclado;
import java.util.Scanner;
/**
 *
 * @author Lucas
 */
public class Leer {
    
    public static int leerInt(){
        Scanner teclado = new Scanner(System.in);
        int numero = teclado.nextInt();
        return numero;
    }
    public static String leerString(){
        Scanner teclado = new Scanner(System.in);
        String palabra = teclado.next();
        return palabra;
    }
    
}
