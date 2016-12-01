package com.example.lucas.maths;

/**
 * Created by Lucas on 25/10/2016.
 */
public class Funciones {

    public static boolean esPrimo(int numero) {

        int contador = 2;
        boolean primo=true;

        while ((primo) && (contador!=numero)){
            if (numero % contador == 0)
                primo = false;
            contador++;
        }

        return primo;
    }
}
