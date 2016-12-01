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
    
    
    public Perruquer(Banc b,String nom){
        elBanc=b;
        acabar=false;
        this.setName(nom);
    }
    
    public void run(){
        while(!acabar){
            // agafe client
            Client c=elBanc.recuperarClient();
            if (c!=null){
                try {
                    // arreglar-lo
                    Thread.sleep(c.getTemps());
                    System.out.println(getName() + " He trigar "+c.getTemps());
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
