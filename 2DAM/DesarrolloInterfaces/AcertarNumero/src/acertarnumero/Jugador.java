/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acertarnumero;


import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class Jugador extends Thread {

    private int id;

    private Arbitro a;
    static boolean acabar = false;
    
    public Jugador(int id, Arbitro a) {
        this.id = id;
        this.a = a;
        setName("" + id);
    }

    @Override
    public void run() {
        while (!acabar) {
            try {
                Thread.sleep(10);
                if(a.turnos(id)) {
                    System.out.println("JUGADOR " + this.id + ": ES MI TURNO!");
                    a.responderNumero(preguntarNumero());
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
    
    private int preguntarNumero() {
        //int numero =  (int) ((Math.random() * a.fin) + a.inicio);
        //System.out.println("[" + a.fin + "-" + a.inicio + "]");
        
        int numero =  (int) (Math.random() * 10 + 1);
        
        if (a.listadoNumeros.contains(numero)) {
            preguntarNumero(); //PROBLEMA DE STACK OVER FLOW.
        } else {
            a.listadoNumeros.add(numero);
            System.out.println("JUGADOR " + this.id + ": ES ESTE NUMERO? " + numero);
        }
        
        
        return numero;
    }
    
    public static void acabar() {
        acabar = true;
    }

}
