/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2016_psp_agencianoticies;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class Tauler {
    
    private Queue<String> noticias;
    
    public Tauler() {
        noticias = new LinkedList<>();
    }
    
    public synchronized boolean añadirNoticia(String noticia) {
        boolean conseguir = false;
        
        if (noticias.size() == 5) {
            try {
                this.wait();
                System.out.println("Tablero lleno, espera: " + Thread.currentThread().getName());
            } catch (InterruptedException ex) {
                ex.getMessage();
            }
        } else {
            noticias.add(noticia);
            this.notify();
            System.out.println("Hay hueco en el tablero " + Thread.currentThread().getName());
            conseguir = true;
        }
        
        return conseguir;
    }
    
    public synchronized String leerNoticia() {
        String noticia = null;
        
        if (noticias.size() == 0) {
            try {
                this.wait();
                System.out.println("Espera no hay noticias " + Thread.currentThread().getName());
            } catch (InterruptedException ex) {
                ex.getMessage();
            }
        } else {
            noticia = noticias.poll();
            this.notify();
        }
        
        return noticia;
    }
    
    public int obtenerCantidadNoticias() {
        return noticias.size();
    }
    
}
