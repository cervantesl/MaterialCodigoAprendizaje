/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2016_psp_agencianoticies;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Lucas
 */
public class Periodista extends Thread {

    private boolean acabar;
    private Tauler tablaNoticias;
    private int id;

    public Periodista(Tauler tablaNoticias, int id) {
        this.tablaNoticias = tablaNoticias;
        this.id = id;

        setName("Periodista " + this.id);
    }

    @Override
    public void run() {
        while (!acabar) {
            
            
            String noticia = tablaNoticias.leerNoticia();

            if (noticia != null) {
              
                try {
                    Thread.sleep(500);
                    System.out.println(getName() + " ha leido una noticia ");
                    System.out.println(noticia);
                } catch (InterruptedException ex) {
                    ex.getMessage();
                }
            }
        }
    }

    public void acabar() {
        acabar = true;
    }

}
