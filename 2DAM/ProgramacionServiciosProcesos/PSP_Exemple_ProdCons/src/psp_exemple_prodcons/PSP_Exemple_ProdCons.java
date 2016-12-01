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
public class PSP_Exemple_ProdCons {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            CintaTransportadora laCinta=new CintaTransportadora(5);
            
            Productor p=new Productor(laCinta, 500);
            Consumidor c=new Consumidor(laCinta, 750);
            
            c.start();
            p.start();
            
            // deixem el programa  10 segons treballant

            Thread.sleep(10000);
            
            // aturem els treballadors
            
            p.acabar();
            c.acabar();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(PSP_Exemple_ProdCons.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    
}
