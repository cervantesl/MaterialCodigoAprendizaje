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
 * @author joange
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Tauler tablaNoticias = new Tauler();

        AgenciaNoticias an = new AgenciaNoticias(tablaNoticias);
        an.start();
        System.out.println(an.getName() + " empezieza a redactar");

        Periodista p1 = new Periodista(tablaNoticias, 1);
        p1.start();
        System.out.println(p1.getName() + " empieza a leer");

        Periodista p2 = new Periodista(tablaNoticias, 2);
        p2.start();
        System.out.println(p2.getName() + " empieza a leer");

        Periodista p3 = new Periodista(tablaNoticias, 3);
        p3.start();
        System.out.println(p3.getName() + " empieza a leer");

        try {
            Thread.sleep(15000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        an.acabar();
        System.out.println("Agencia cerrada");

        while (tablaNoticias.obtenerCantidadNoticias() > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        p1.acabar();
        System.out.println("Periodista " + p1.getName() + " deja de leer por hoy");
        
        p2.acabar();
        System.out.println("Periodista " + p2.getName() + " deja de leer por hoy");
        
        p2.acabar();
        System.out.println("Periodista " + p2.getName() + " deja de leer por hoy");
    }

}
