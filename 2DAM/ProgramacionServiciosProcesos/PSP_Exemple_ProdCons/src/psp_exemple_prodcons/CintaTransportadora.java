/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_exemple_prodcons;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author professor
 */
public class CintaTransportadora {

    private final int TAM;
    private ArrayList<Integer> elsNumeros;

    public CintaTransportadora(int TAM) {
        this.TAM = TAM;
        elsNumeros = new ArrayList<Integer>();
    }

    public synchronized void afegirNumero(int n) {

        if (elsNumeros.size() < TAM) {
            elsNumeros.add(n);
            this.notify();  // si hi ha algú esperant, l'avise
        } else {
            try {
                // NO PODEM AFEGIR
                System.out.println("Es bloqueja " + Thread.currentThread().getName());
                this.wait();
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

    public synchronized int llegirNumero() {
        int num=-99999;
        
        if (elsNumeros.size() > 0) {
            num = elsNumeros.get(0);
            elsNumeros.remove(0);
            this.notify(); // hi ha lloc per a afegir-ne de nous
        }
        else{
            try {
                // NO PODEM TREURE
                System.out.println("Es bloqueja " + Thread.currentThread().getName());
                this.wait();
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return num;
    }

}
