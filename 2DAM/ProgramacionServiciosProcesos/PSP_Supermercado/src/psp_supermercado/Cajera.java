/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_supermercado;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class Cajera extends Thread {
    
    private boolean acabar;
    private ColaClientes cc;
    private int id;
    
    public Cajera(ColaClientes cc, int id) {
        this.cc = cc;
        acabar = false;
        this.id = id;
        
        setName("Cajera" + this.id);
    }

    @Override
    public void run() {
        while(!acabar) {
            Cliente c = cc.recuperarCliente();
            
            if (c != null) {
                try {
                    Thread.sleep(500);
                    System.out.println(getName() + " ha atendido a " +c.nombreCliente());
                } catch (InterruptedException ex) {
                    Logger.getLogger(Cajera.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void acabar() {
        acabar = true;
    }
    
    public int obtenerID() {
        return id;
    }
    
}
