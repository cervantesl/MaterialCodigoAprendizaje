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
    
    public synchronized boolean afegirClient(Client c) {
        boolean aconseguit=false;
        if (quants()==max_clients){
            try {
                // no podem afegir
                System.out.println(Thread.currentThread().getName() + " a dormir.");
                this.wait();
            } catch (InterruptedException ex) {
                System.out.println(ex.toString());
            }
        }
        else{
            elsClients.add(c);
            this.notify(); // desperte a algun barber
            System.out.println(Thread.currentThread().getName() + " desperta barbers.");
            aconseguit=true;
        }
        return aconseguit;
    }
    
    public synchronized Client recuperarClient(){
        Client c=null;
        if (quants()==0){
            try {
                System.out.println(Thread.currentThread().getName() + " a dormir 1.");
                this.wait();
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
        else{
            c=elsClients.poll();
            this.notify(); // permetem que la porta en pose de nous
            System.out.println(Thread.currentThread().getName() + " obri la porta.");
        }
        return c;
    }
    
    public synchronized void avisaBarbers(){
        this.notifyAll();
    }

    
    public int quants(){
        return elsClients.size();
    }
    
}
