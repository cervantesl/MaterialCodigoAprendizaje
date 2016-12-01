/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_carrera;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public abstract class Animal extends Thread {
    
    protected int pos;
    private boolean acabar;
    protected Random r;
    protected int meta;
    
    public Animal(int meta) {
        this.meta = meta;
        pos = 1;
        acabar = false;
        r = new Random(System.currentTimeMillis());
    }
    
    @Override
    public void run() {
        while(!acabar) {
            try {
                sleep(500);
                mover();
            } catch (InterruptedException ex) {
            }
            
        }
    }
    
    public abstract void mover();
    
    public void acabar() {
        acabar = true;
    }
    
    public boolean obtenerAcabar() {
        return acabar;
    }
    
    public int obtenerPos() {
        return pos;
    }
    
    public void comprobarPos() {
        if(pos< 1) {
            pos = 1;
        }
        
        if(pos > meta) {
            pos = meta;
        }
    }
}
