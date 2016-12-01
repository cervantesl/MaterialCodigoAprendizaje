/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package labarberia;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joan Gerard
 */
public class Banc {
    
    private int max_clients;
    
    private Queue<Client> elsClients;
    
    public Banc(int quants){
        max_clients=quants;
        elsClients=new LinkedList<Client>();
    }
    
    public synchronized boolean afegirClient(Client c) { //PORTA productor?
        boolean conseguir = false;
        
        if (quants() == max_clients) {
            try {
                //No podemos añadir
                this.wait();
            } catch (InterruptedException ex) {
                ex.getMessage();
            }
        } else {
            elsClients.add(c);
            this.notify();
            conseguir = true;
        }
        return conseguir;
    }
    
    public synchronized Client recuperarClient(){ //BARBER consumidor?
        Client c = null;
        
        if (quants() == 0) {
            try {
                this.wait();
            } catch (InterruptedException ex) {
                ex.getMessage();
            }
        } else {
            c = elsClients.poll();
            this.notify(); //permitimos que la PUERTA ponga de nuevo
        }
        return c;
    }
    
    public int quants(){
        return elsClients.size();
    }
}
