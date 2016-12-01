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
    extends Thread{
    
    private boolean acabar;
    private int interval;
    private Banc elBanc;
    
    public Porta(Banc b, int i){
        this.elBanc=b;
        this.interval=i;
        this.setName("Porta");
    }
    
    public void run(){
        while (!acabar){

            try {
                Thread.sleep(interval);
                
                // cree un client
                Client c=new Client(LaBarberia.getAleatorio(1, 3));
                
                // fem entrar al client
                // fins que no entre el client c no deixe d'intentar-ho
                while(!elBanc.afegirClient(c))
                    ;
                
                //elBanc.afegirClient(c);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Porta.class.getName()).log(Level.SEVERE, null, ex);
            }

        }   
        
    }
    
    public void acabar(){
        acabar=true;
        elBanc.avisaBarbers();
    }
    

}
