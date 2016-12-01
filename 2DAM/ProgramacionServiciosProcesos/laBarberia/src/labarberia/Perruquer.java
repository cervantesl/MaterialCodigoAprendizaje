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
public class Perruquer 
    extends Thread{
    
    private Banc elBanc;
    private boolean acabar;
    
    public Perruquer(Banc b){
        elBanc=b;
        acabar=false;
    }
    
    public void run(){
       
        // completar
        while(!acabar) {
            Client c = elBanc.recuperarClient();
            if(c != null) {
                try {
                    //arreglar al cliente
                    Thread.sleep(c.getTemps());
                } catch (InterruptedException ex) {
                    Logger.getLogger(Perruquer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void fi(){
        acabar=true;
    }
}
