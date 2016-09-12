/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JuegoPrueba;

import java.util.Random;

/**
 *
 * @author Lucas
 */
public class ToboganEscalera {
    
    private static final int ALTO = 6;
    
    private static final int ANCHO = 5;
    
    private static char[][] tablero = new char[ALTO][ANCHO];
    
    public static final char VACIO = '_';
    
    private static final char JUGADOR = 'O';
    
    private static final char PC = 'o';
    
    public static void main(String[] args) {
        iniciarTablero();
        mostrarTablero();
        tirar();
        colocarPieza();
        mostrarTablero();
    }
    
    public static void iniciarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                tablero[i][j] = VACIO;
            }
        }
    }
    
    public static void mostrarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                System.out.print(tablero[i][j] + "|");
            }
            System.out.println("");
        }
    }
    
    public static int tirar(){
        Random r = new Random();
        int tirada = r.nextInt(5) + 1;
        
        return tirada;
    }
    
    public static void colocarPieza() {
        int tirada = tirar();
        tablero[0][tirada] = JUGADOR;
    }
}
