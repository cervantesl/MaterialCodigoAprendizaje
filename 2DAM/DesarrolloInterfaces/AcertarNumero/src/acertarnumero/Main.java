package acertarnumero;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    
    boolean acabar = false;

    public static void main(String[] args) {

        Arbitro a = new Arbitro();

        int numero = a.obtenerNumeroAleatorio();
        int numeroJugadores = a.obtenerNumeroJugadores();

        System.out.println("Arbitro: Todos a buscar el <" + numero + "> !!!!!!!!");
        
        Jugador j1 = new Jugador(1, a);
        Jugador j2 = new Jugador(2, a);
        Jugador j3 = new Jugador(3, a);
        
        j1.start();
         System.out.println("Jugador: " + j1.getName() + " creado!");
        j2.start();
         System.out.println("Jugador: " + j2.getName() + " creado!");
        j3.start();
         System.out.println("Jugador: " + j3.getName() + " creado!");

        /*for (int i = 1; i <= numeroJugadores; i++) {
            j = new Jugador(i, a);
            j.start();

            System.out.println("Jugador: " + j.getName() + " creado!");
            
        }*/

        while(!a.acabar) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        j1.acabar();
        System.out.println("Jugador: " + j1.getName() + " finalizado!");
        j2.acabar();
        System.out.println("Jugador: " + j2.getName() + " finalizado!");
        j3.acabar();
        System.out.println("Jugador: " + j3.getName() + " finalizado!");


        
  
    }

}
