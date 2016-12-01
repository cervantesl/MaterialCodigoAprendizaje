package com.example.lucas.plantilla;

/**
 * Created by Lucas on 06/11/2016.
 */
public class ClaseMath {

    public static boolean esPrimo(long n) {
        //Comprobamos si es múltiplo de 2
        if (n%2==0) return false;
        //Si no es múltiplo de 2, comprobamos si es divisible por algún número impar
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }
}
