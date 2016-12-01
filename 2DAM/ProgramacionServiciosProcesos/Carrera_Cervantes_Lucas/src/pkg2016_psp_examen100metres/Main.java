/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2016_psp_examen100metres;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas Cervantes
 */
public class Main {

    public static int tiempoInicio;

    public static void main(String args[]) {

        try {
            // Creem l'objecte que controla la carrera
            Carrera c = new Carrera("100 metres llisos");
            System.out.println(c.getNom());
            System.out.println("ON YOUR MARKS !!!!");

            // crear els atletes
            Atleta a1 = new Atleta(1, c);
            System.out.println(a1.getName() + " preparado...");
            Atleta a2 = new Atleta(2, c);
            System.out.println(a2.getName() + " preparado...");
            Atleta a3 = new Atleta(3, c);
            System.out.println(a3.getName() + " preparado...");
            Atleta a4 = new Atleta(4, c);
            System.out.println(a4.getName() + " preparado...");
            Atleta a5 = new Atleta(5, c);
            System.out.println(a5.getName() + " preparado...");
            Atleta a6 = new Atleta(6, c);
            System.out.println(a6.getName() + " preparado...");
            Atleta a7 = new Atleta(7, c);
            System.out.println(a7.getName() + " preparado...");
            Atleta a8 = new Atleta(8, c);
            System.out.println(a8.getName() + " preparado...");

            Thread.sleep(20);
            System.out.println("PREPARADOS   !!!!");
            Thread.sleep(1000);
            System.out.println("LISTOS       !!!!");
            Thread.sleep(1000);
            System.out.println("YA           !!!!");

            //long comienzo = System.currentTimeMillis();
            // començar la carrera
            a1.start();
            a2.start();
            a3.start();
            a4.start();
            a5.start();
            a6.start();
            a7.start();
            a8.start();

        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
