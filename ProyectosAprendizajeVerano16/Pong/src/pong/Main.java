
package pong;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    static final int VERTICAL = 21;
    static final int HORIZONTAL = 75;
    public static void main(String[] args) {
       //Definimos variables para el tablero
       //Pos Pelota
       int pelX = 10;
       int pelY = 37;
      
       //Anchura raqueta jugador
       int inicioRaquetaJugador = 8;
       int finRaquetaJugador = 12;
       
       //Anchura raqueta rival
       int inicioRaquetaRival = 8;
       int finRaquetaRival = 12;
       
       //Variables de modificaciones
       //Modificar pelota
       int modificarPosPelotaX = -1;
       int modificarPosPelotaY = -1;
       
       //Modificar raqueta rival
       int modificarPosRaquetaRival = -1;
       
       //Campo
       char [][] campo = new char[VERTICAL][HORIZONTAL];
       
        menu(campo, pelX, pelY, inicioRaquetaJugador, finRaquetaJugador, inicioRaquetaRival, finRaquetaRival, modificarPosPelotaX,
             modificarPosPelotaY,modificarPosRaquetaRival);
       //Funciones
       

    }
   
    //Funcion de inicio para llamar a los demas metodos
    static void inicio(char[][] campo, int pelX, int pelY, int inicioRaquetaJugador, int finRaquetaJugador,
            int inicioRaquetaRival, int finRaquetaRival){
        
        dibujarCampo(campo);
        dibujarRaquetaJugador(campo, inicioRaquetaJugador, finRaquetaJugador);
        dibujarRaquetaRival(campo, inicioRaquetaRival, finRaquetaRival);
        dibujarPelota(campo, pelX, pelY);

    }
    
    //Funcion para dar valores por defecto al campo
    static void dibujarCampo(char[][] campo){
        for (int fila = 0; fila < campo.length; fila++) {
            for (int col = 0; col < campo[0].length; col++) {
                if (fila == 0 || fila == campo.length -1) {
                    campo[fila][col] = '_';
                }
                else if(col == 0 || col == campo[0].length -1){
                    campo[fila][col] = '|';
                }
                else{
                    campo[fila][col] = ' ';
                }
            }
        }
    }
    
    static void dibujarRaquetaJugador(char[][] campo, int inicioRaquetaJugador, int finRaquetaJugador){
        for (int fila = inicioRaquetaJugador; fila < finRaquetaJugador  ; fila++) { //anchura de la raqueta
            for (int col = 38; col < 56; col++) { //Largura de la raqueta
                campo[fila][col] = 'X';
            }
        }
    }
    
    static void dibujarRaquetaRival(char[][] campo, int inicioRaquetaRival, int finRaquetaRival){
        for (int fila = inicioRaquetaRival; fila < finRaquetaRival; fila++) {
            for (int col = 10; col < 60; col++) {
                campo[fila][col] = 'X';
            }
        }
    }
    
    static void dibujarPelota(char[][] campo, int pelX, int pelY){
        campo[pelX][pelY] = 'O';
    }
    
    
    //Mostrar campo
    static void mostrarCampo(char[][] campo){
        for (int i = 0; i < campo.length; i++) {
            for (int j = 0; j < campo[0].length; j++) {
                System.out.print(campo[i][j]);
            }
            System.out.println("");
        }
    }
    
    static void gameLoop(char[][] campo, int pelX, int pelY, int inicioRaquetaJugador, int finRaquetaJugador,
            int inicioRaquetaRival, int finRaquetaRival, int modificarPosPelotaX, int modificarPosPelotaY, 
            int modificarRaquetaRival){
        
        boolean ganar = false;
        char tecla = '5';
        do {            
            dibujar(campo);
            
            //Verificamos y modificamos las posiciones de nuestros objetos
            //Verificamos si la pelota choca contra la banda e invertiremos la pos en vertical
            if (pelX == 1 || pelX == campo[0].length -2 ) {
                modificarPosPelotaX *= -1;
            }
            
            //Verificamos si se ha marcado un gol
            if (pelY == 1 || pelY == campo.length -2) {
                ganar = true;
            }
            
            //Verificamos si se ha chocado contra nuestra raqueta
            if (pelY == campo.length -6) {
                for (int fila = inicioRaquetaJugador; fila <= finRaquetaJugador; fila++) {
                    if (fila == pelY) {
                        modificarPosPelotaY *= -1;
                    }
                }
            }
            
            //Verificamos si se ha chocado contra la raqueta rival
            if (pelY == 4 ) {
                for (int fila = inicioRaquetaRival; fila < finRaquetaRival; fila++) {
                    modificarPosPelotaY *= -1;
                }
            }
            
            //Inteligencia artificial para la raqueta del rival
            if (inicioRaquetaRival == 1 || finRaquetaRival == campo[0].length -1) {
                modificarRaquetaRival *= -1;
            }
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if (ganar) {
                //Modificaciones
                //Modificar la posicion de la pelota
                pelX += modificarPosPelotaX;
                pelY += modificarPosPelotaY;

                //Modificar la raqueta del rival
                inicioRaquetaJugador += modificarRaquetaRival;
                finRaquetaRival += modificarRaquetaRival;
            }
            
            if (1 == 1) {
                try {
                    tecla = (char) System.in.read();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (tecla == '4') {
                    if (inicioRaquetaJugador != 1) {
                        inicioRaquetaJugador -= -1;
                        finRaquetaJugador -= -1;
                    }
                }
                if (tecla == '6') {
                    if (inicioRaquetaJugador != campo[0].length) {
                        inicioRaquetaJugador += 1;
                        finRaquetaRival += 1;
                    }
                }
            }
            
            dibujar(campo);
            inicio(campo, pelX, pelY, inicioRaquetaJugador, finRaquetaJugador, inicioRaquetaRival, finRaquetaRival);
        } while (!ganar);
    }
    
    static void dibujar(char [][] campo){
        System.out.println("\033[2J\n");
        mostrarCampo(campo);
    }
    
    static void menu(char[][] campo, int pelX, int pelY, int inicioRaquetaJugador, int finRaquetaJugador,
            int inicioRaquetaRival, int finRaquetaRival, int modificarPosPelotaX, int modificarPosPelotaY, 
            int modificarPosRaquetaRival){
        Scanner teclado = new Scanner(System.in);
        System.out.println("########   #######  ##    ##  ######   \n" +
"##     ## ##     ## ###   ## ##    ##  \n" +
"##     ## ##     ## ####  ## ##        \n" +
"########  ##     ## ## ## ## ##   #### \n" +
"##        ##     ## ##  #### ##    ##  \n" +
"##        ##     ## ##   ### ##    ##  \n" +
"##         #######  ##    ##  ######");
        System.out.println("====MENU====");
        System.out.println("1.-Jugar");
        System.out.println("2.-Creditos");
        System.out.println("Opcion:");
        int opcion = teclado.nextInt();
        switch(opcion){
            case 1: 
                inicio(campo, pelX, pelY, inicioRaquetaJugador, finRaquetaJugador, inicioRaquetaRival, finRaquetaRival);
                gameLoop(campo, pelX, pelY, inicioRaquetaJugador, finRaquetaJugador, inicioRaquetaRival, finRaquetaRival, modificarPosPelotaX,
                        modificarPosPelotaY,modificarPosRaquetaRival);
                break;
            case 2:
                System.out.println("Juego del PONG hecho por -Lucas Cervantes Leonez-");
                break;
        }
    }
    
}
