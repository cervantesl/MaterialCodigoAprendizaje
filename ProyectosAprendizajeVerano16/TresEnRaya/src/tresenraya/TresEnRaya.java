/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresenraya;

import java.util.Scanner;

/**
 *
 * @author Lucas
 */
public class TresEnRaya {

    public static final int WIDTH = 3, HEIGTH = 3;
    
    public static final char VACIO = '_';
    
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        char[][] tablero = new char[WIDTH][HEIGTH]; 
        
        tableroVacio(tablero);
        
        int turno = 0;
        
   
        int opcion;
        do {
            System.out.println("\t ====== TRES EN RAYA ======");
            System.out.println("========================");
            System.out.println("\t MENU");
            System.out.println("========================");
            System.out.println("1.- JUGAR");
            System.out.println("2.- CREDITOS");
            System.out.println("3.- SALIR");
            
            System.out.print("Elige opcion: ");
            opcion = teclado.nextInt();
            
            switch(opcion){
                case 1 : 
                    boolean ganar = false;
                    int cantidadPartidas = cantidadPartidas();
                    int contadorPartidas = 0;
                    int marcador[] = new int[2];
                    
                    while(contadorPartidas <= cantidadPartidas){
                        
                        
                        mostrarTablero(tablero);
                        ponerFicha(tablero, turno(turno));
                        ganar = ganar(tablero, turno);
                        
                        if (ganar) {
                            marcador = marcador(tablero, turno, marcador);
                            System.out.println("X: " + marcador[0]);
                            System.out.println("O: " + marcador[1]);
                            mostrarTablero(tablero);
                            tableroVacio(tablero);
                            contadorPartidas++;
                        }
                        
                         
                         turno++; 
                    }
                   
                   break;
                    
                case 2 : creditos(); break;
                
                case 3 : System.out.println("Adios!"); break;
                
                case 4 : default: System.out.println("La opcion no existe"); break;
            }
            
            
            
        } while (opcion != 3);
        
    }
    
    public static void tableroVacio(char[][] tablero){
        
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                tablero[i][j] = VACIO;
            }
        }
    }
    
    public static void mostrarTablero(char[][] tablero){
        for (int i = 0; i < tablero.length; i++) {
            System.out.print("  " + i);
        }
        System.out.println("");
        for (int i = 0; i < tablero.length; i++) {
            
            for (int j = 0; j < tablero[0].length; j++) {
                System.out.print(tablero[i][j]+"_|");
                
            }
            System.out.print(i);
            System.out.println("");
        }
    }
    
    public static int[] pedirPosicion(char ficha){
        
        Scanner teclado = new Scanner(System.in);
        int [] posicion = new int [2];
        System.out.println("Le toca a la ficha: " + ficha);
        System.out.println("Donde quieres poner la ficha");
        
     
        System.out.print("Fila: ");
        int fila = teclado.nextInt();
        
        if (fila >= 0 && fila <= 2) {
             posicion[0] = fila;
        }

         System.out.print("Columna: ");
        int col = teclado.nextInt();
       
        if (col >= 0 && col <= 2) {
              posicion[1] = col;
        }
        
        return posicion;
    }
    
    public static void ponerFicha(char[][] tablero, char ficha){
        
        boolean posCorrecto = false;

            int[] posicion = pedirPosicion(ficha);
            if (tablero[posicion[0]][posicion[1]] == VACIO) {
                tablero[posicion[0]][posicion[1]] = ficha;
                posCorrecto = true;
            }
            else{
                System.out.println("Posicion incorrecta, vuelva a intentarlo");
                posCorrecto = false;
            }
        
    }
    
    public static char turno(int turno){
        
        char ficha = 'X';
       
            if (turno % 2 == 0) {
                ficha = 'X';
            }
            else{
                ficha = 'O';
            }
            
            turno++;
        
        
        return ficha;
    }
    
    public static boolean ganar(char[][] tablero, int turno){
        int fila = 0;
        int col = 0;
        char ficha = turno(turno);
        //Arriba ->
        if (tablero[fila][0] == ficha && tablero[fila][1] == ficha && tablero[fila][2] == ficha) {
            System.out.println("Han ganado las: " + ficha);
            return true;
        }
        
        //En medio ->
        if (tablero[1][0] == ficha && tablero[1][1] == ficha && tablero[1][2] == ficha) {
            System.out.println("Han ganado las: " + ficha);
            return true;
        }
        
        //Abajo ->
        if (tablero[2][0] == ficha && tablero[2][1] == ficha && tablero[2][2] == ficha) {
            System.out.println("Han ganado las: " + ficha);
            return true;
        }
        
        //Abajo izquierda 
        if (tablero[0][col] == ficha && tablero[1][col] == ficha && tablero[2][col] == ficha) {
            System.out.println("Han ganado las: " + ficha);
            return true;
        }
        
        //Abajo en medio
        if (tablero[0][1] == ficha && tablero[1][1] == ficha && tablero[2][1] == ficha) {
            System.out.println("Han ganado las: " + ficha);
            return true;
        }
        
        //Abajo derecha
         if (tablero[0][2] == ficha && tablero[1][2] == ficha && tablero[2][2] == ficha) {
            System.out.println("Han ganado las: " + ficha);
            return true;
        }
         
         //Diagonal
         if (tablero[0][0] == ficha && tablero[1][1] == ficha && tablero[2][2] == ficha) {
            System.out.println("Han ganado las: " + ficha);
            return true;
        }
         
         //Diagonal
         if (tablero[2][0] == ficha && tablero[1][1] == ficha && tablero[0][2] == ficha) {
            System.out.println("Han ganado las: " + ficha);
            return true;
        }
        
        return false;
    }
    
    public static void creditos(){
        System.out.println("================================================");
        System.out.println("=== Juego hecho por: LUCAS CERVANTES LEONEZ ===");
        System.out.println("================================================");
        System.out.println("");
        System.out.println("");
    }
    
    
    
    //Añadir marcador y volver a jugar.
    
    public static int[] marcador(char[][] tablero, int turno, int[] marcador){
        boolean ganar = ganar(tablero, turno);
        char ficha = turno(turno);
        int marcadorX = marcador[0];
        int marcadorO = marcador[1];
        
        if (ganar && ficha == 'O') {
            marcadorO += 1;
        }
        if (ganar && ficha == 'X') {
            marcadorX += 1;
        }

        int [] marcadorActualizado = new int[2];
        
        marcadorActualizado[0] += marcadorX;
        marcadorActualizado[1] += marcadorO;
        
        return marcadorActualizado;
    }
    
    public static int cantidadPartidas(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("A cuantas partidas quereis jugar");
        int num = teclado.nextInt();
        
        return num - 1;
    }
}
