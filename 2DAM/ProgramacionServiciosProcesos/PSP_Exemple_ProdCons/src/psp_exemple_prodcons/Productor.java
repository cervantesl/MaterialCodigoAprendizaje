/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_exemple_prodcons;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author professor
 */
public class Productor extends Thread {

    private CintaTransportadora laCinta;
    private int lapse;
    private boolean fi;

    public Productor(CintaTransportadora laCinta, int lapse) {
        this.laCinta = laCinta;
        this.lapse = lapse;
        fi = false;
    }

    @Override
    public void run() {
        while (!fi) {
            try {
                int numero = (int) (Math.random() * 100);
                laCinta.afegirNumero(numero);
                sleep(lapse);
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void acabar(){
        fi=true;
    }

}
