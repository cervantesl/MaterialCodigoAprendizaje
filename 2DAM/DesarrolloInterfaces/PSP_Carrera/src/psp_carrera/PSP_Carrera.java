/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_carrera;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class PSP_Carrera {

    private static final int META = 70;

    public static void main(String[] args) {
        Tortuga t = new Tortuga(META);
        Liebre l = new Liebre(META);

        t.start();
        l.start();

        long cont = 0;

        while (!t.obtenerAcabar() && !l.obtenerAcabar()) {
            try {
                Thread.sleep(900);
                System.out.println("Tortuga = "
                        + t.obtenerPos() + " Liebre = " + l.obtenerPos() + " c = " + (cont++));
            } catch (InterruptedException ex) {
            }

        }

        if (t.obtenerAcabar()) {
            l.acabar();
        } else {
            t.acabar();
        }
    }

}
