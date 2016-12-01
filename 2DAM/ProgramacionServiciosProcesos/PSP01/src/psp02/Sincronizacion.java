/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp02;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
class Valor {
    
    private  int valor = 0;
    
    public synchronized int getValor() {
        return valor;
    }
    
    public synchronized void incrementarValor(int incremento) {
        try {
            int x;
            
            System.out.println("Soy: "  + Thread.currentThread().toString() + System.currentTimeMillis());
            
            x = valor;
            Thread.sleep(500);
            x += incremento;
            
            valor = x;
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
}

class HiloIncrementador extends Thread {

    Valor v;
    
    //No poner Valor v = new Valor() ya que sino cada hilo tendra su propio valor y no sera compartida
    
    public HiloIncrementador(Valor v) {
        this.v = v;
    }
    
    public void run() {
        v.incrementarValor(5000);
    }
}

public class Sincronizacion {
    
    public static void main(String[] args) {
        Valor v = new Valor();
        
        for (int i = 0; i < 4; i++) {
            HiloIncrementador h = new HiloIncrementador(v);
            h.start();
        }
        
        try {
            Thread.sleep(3000);
            System.out.println("La variable vale: " + v.getValor());
        } catch (InterruptedException ex) {
            Logger.getLogger(Sincronizacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
