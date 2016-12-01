/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acertarnumero;

import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class Arbitro {

    private static int numeroAleatorio;
    private static int turno = 1;
    public boolean acabar = false;
    private static final int NUM_JUGADORES = 3;
    public ArrayList<Integer> listadoNumeros = new ArrayList<>();
    
    public int inicio;
    public int fin;

    public Arbitro() {
        numeroAleatorio = (int) (Math.random() * 10 + 1);
        turno = (int) (Math.random() * NUM_JUGADORES + 1);
        
         inicio = 1;
         fin = 10;
    }

    public static int obtenerNumeroAleatorio() {
        return numeroAleatorio;
    }

    public int obtenerTurno() {
        return turno;
    }

    public void fin() {
        acabar = true;
    }

    public boolean turnos(int id) {
        if (!acabar) {

            if (id == turno) {
                System.out.println("ARBITRO: Es el turno de " + turno);
                turno++;
                return true;
            }

            if (turno > NUM_JUGADORES) {
                turno = 1;
            }
        }

        return false;

    }

    public int obtenerNumeroJugadores() {
        return NUM_JUGADORES;
    }

    public boolean obtenerAcabar() {
        return acabar;
    }

    public void responderNumero(int numero) {
        if (numero == numeroAleatorio) {
            System.out.println("ARBITRO: SI, CORRECTO EL NUMERO TUYO " + numero + " COINCIDE CON EL MIO " + numeroAleatorio);

            fin();
        } else {
            if (numero > numeroAleatorio) {
                //fin = numero;
                System.out.println("ARBITRO: NO EL NUMERO ES MENOR!");
            } else {
                //inicio = numero;
                System.out.println("ARBITRO: NO EL NUMERO ES MAYOR!");
            }
            
        }
    }

}
