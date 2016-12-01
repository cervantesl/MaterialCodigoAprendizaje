/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labarberia;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joan Gerard
 */
public class Porta
        extends Thread {

    private boolean acabar;
    private int interval;
    private Banc elBanc;

    public Porta(Banc b, int i) {
        this.elBanc = b;
        this.interval = i;
    }

    public void run() {
        while (!acabar) {

            try {
                // espere
                Thread.sleep(interval);

                //creem client al banc de la perruqueria
                Client c = new Client(LaBarberia.getAleatorio(1, 3));

                // fem entrar al client
                while (!elBanc.afegirClient(c)); //Hasta que no entre el cliente c no dejo de intentarlo                    

            } catch (InterruptedException ex) {
                Logger.getLogger(Porta.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
    
    public void acabar() {
        acabar = true;
    }

}
