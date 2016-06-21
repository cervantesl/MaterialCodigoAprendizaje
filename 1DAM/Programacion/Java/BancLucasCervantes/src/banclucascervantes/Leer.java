/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banclucascervantes;

import java.util.Scanner;

/**
 *
 * @author Lucas
 */
public class Leer {
    static int leerInt(){
        Scanner teclado = new Scanner(System.in);
        int numero = teclado.nextInt();
        return numero;
    }
    static String leerString(){
        Scanner teclado = new Scanner(System.in);
        String palabra = teclado.next();
        return palabra;
    }
}
