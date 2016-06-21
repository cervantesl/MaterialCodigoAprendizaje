/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jocderollucascervantes;

import java.util.ArrayList;
import personajes.*;
import teclado.*;

/**
 *
 * @author Lucas
 */
public class JocDeRolLucasCervantes {
    static ArrayList <Player> players = new ArrayList<>();
    static ArrayList <Team> teams = new ArrayList<>();
    static ArrayList <Item> iteams = new ArrayList<>();
    
    static final int ATAQUE_DEFECTO = 50;
    static final int DEFENSA_DEFECTO = 50;
    static final int VIDA_DEFECTO = 100;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int opcion;
        do {            
            System.out.println("==MENU PRINCIPAL==");
            System.out.println("1)Configuracion");
            System.out.println("2)Jugar");
            System.out.println("3)Salir");
            System.out.println("Elige una opcion: ");
            opcion = Leer.leerInt();
            switch(opcion){
                case 1: 
                    int opcionConfigurtacion;
                    do {                        
                        System.out.println("CONFIGURACION");
                        System.out.println("1.1)Gestion jugadores");
                        System.out.println("1.2)Gestion equipos");
                        System.out.println("1.3)Gestion objetos");
                        System.out.println("1.4)Atras");
                        opcionConfigurtacion = Leer.leerInt();
                        switch(opcionConfigurtacion){
                            case 1: 
                                int opcionJugadores;
                                do {                                    
                                    System.out.println("JUGADORES");
                                    System.out.println("1.1.1)Crear jugador");
                                    System.out.println("1.1.2)Mostrar jugadores");
                                    System.out.println("1.1.3)Borrar jugador");
                                    System.out.println("1.1.4)Asignar jugador a equipo");
                                    System.out.println("1.1.5)Asignar objeto a equipo");
                                    System.out.println("1.1.6)Atras");
                                    System.out.println("Elegir opcion:");
                                    opcionJugadores = Leer.leerInt();
                                    switch(opcionJugadores){
                                        case 1: crearPersonaje(); break;
                                        case 2: mostrarPersonajes(); break;
                                        case 3: borrarJugador(); break;
                                        case 4: asignarJugadorAEquipo(); break;
                                        case 5: break;
                                        case 6: System.out.println("Atras");break;
                                    }
                                } while (opcionJugadores != 6);
                            break;
                            case 2: 
                                int opcionEquipos;
                                do { 
                                    System.out.println("EQUIPOS");
                                    System.out.println("1.2.1)Crear equipo");
                                    System.out.println("1.2.2)Mostrar equipos");
                                    System.out.println("1.2.3)Borrar equipo");
                                    System.out.println("1.2.4)Asignar equipo a jugador");
                                    System.out.println("1.2.5 Atras");
                                    System.out.println("Elige opcion");
                                    opcionEquipos = Leer.leerInt();
                                    switch(opcionEquipos){
                                        case 1: crearEquipo(); break;
                                        case 2: mostrarEquipos(); break;
                                        case 3: borrarEquipo(); break;
                                        case 4: asignarJugadorAEquipo(); break;
                                        case 5: System.out.println("Atras"); break;
                                    }
                                } while (opcionEquipos != 5);
                            case 3: break;
                            case 4: System.out.println("Atras");break;
                        }
                    } while (opcionConfigurtacion != 4);
                break;
                case 2: jugar(); break;
                case 3: System.out.println("Adios"); break;
            }
        } while (opcion != 3);
       
    }

    static void crearPersonaje(){
        int opcion;

        System.out.println("Dime el nombre que le quieres poner a tu personaje:");
        String nombre = Leer.leerString();
        System.out.println("Que personaje quieres crear?");
        System.out.println("==TIPO PERSONAJES==");
        System.out.println("1)Humano");
        System.out.println("2)Alien");
        System.out.println("3)Warrior");
        System.out.println("Elige una opcion: ");
        opcion = Leer.leerInt();
        switch(opcion){
            case 1: 
                System.out.println("Has elegido un Humano!");

                if (players.indexOf(new Human(nombre)) == -1) {
                    players.add(new Human(nombre,ATAQUE_DEFECTO,DEFENSA_DEFECTO,VIDA_DEFECTO));    
                }
                else{
                    System.out.println("Lo siento, el jugador ya existe");
                }
            break;
            case 2:
                System.out.println("Has elegido un Alien!");
               
                if (players.indexOf(new Alien(nombre)) == -1) {
                    players.add(new Alien(nombre,ATAQUE_DEFECTO,DEFENSA_DEFECTO,VIDA_DEFECTO));    
                }
                else{
                    System.out.println("Lo siento, el jugador ya existe");
                }
            break;
            case 3:
                System.out.println("Has elegido un Warrior!");

                if (players.indexOf(new Warrior(nombre)) == -1) {
                    players.add(new Warrior(nombre,ATAQUE_DEFECTO,DEFENSA_DEFECTO,VIDA_DEFECTO));    
                }
                else{
                    System.out.println("Lo siento, el jugador ya existe");
                }
                
        }
        
    }
    
    static void mostrarPersonajes(){
//        for (Player p : players) {
//            System.out.println(p.toString());
//        }
        System.out.println(players);
    }
    
    static void borrarJugador(){
        int opcion;
        System.out.println("Dime el nombre del jugador que quieres borrar");
        String nombre = Leer.leerString();
        System.out.println("Dime de que clase es:");
        System.out.println("1)Humano");
        System.out.println("2)Alien");
        System.out.println("3)Warrior");
        System.out.println("Elige una opcion: ");
        opcion = Leer.leerInt();
        switch(opcion){
            case 1:
                if (players.contains(new Human(nombre))) {
                    players.remove(new Human(nombre));
                    System.out.println("El jugador "+nombre+" ha sido borrado");
                }
                else{
                    System.out.println("El jugador no existe");
                }
            case 2:
                if (players.contains(new Alien(nombre))) {
                    players.remove(nombre);
                    System.out.println("El jugador "+nombre+" ha sido borrado");
                }
                else{
                    System.out.println("El jugador no existe");
                }
            case 3: 
                if (players.contains(new Warrior(nombre))) {
                    System.out.println("El jugador "+nombre+" ha sido borrado");
                }
                else{
                    System.out.println("El jugador no existe");
                }
                    
                    
        }
        
    }
    
    static void asignarJugadorAEquipo(){
        System.out.println("Dime el nombre del equipo: ");
        String nombreEquipo = Leer.leerString();
        System.out.println("Dime el nombre del jugador que quieres meter en el equipo");
        String nombreJugador = Leer.leerString();
        
        int posicionEquipo = teams.indexOf(new Team(nombreEquipo));
        teams.get(posicionEquipo).add(new Player(nombreJugador));
    }
    
    static void asignarObjetoAEquipo(){
        System.out.println("");
    }
    
    static void crearEquipo(){
        System.out.println("Dime el nombre del equipo");
        String nombre = Leer.leerString();
        
        if (!teams.contains(new Team(nombre))) {
            teams.add(new Team(nombre));
            System.out.println("Se ha creado el equipo");
        }
        else{
            System.out.println("No se ha podido crear el equipo ");
        }
    }
    
    static void mostrarEquipos(){
        
        for(Team t: teams){
            System.out.println(t.toString());
        }
        
    }
    
    static void borrarEquipo(){
        System.out.println("Dime el equipo que quieres borrar");
        String nombre = Leer.leerString();
        
        if (teams.contains(nombre)) {
            teams.remove(nombre);
            System.out.println("Se ha podido borrar el equipo");
        }
        else{
            System.out.println("No se ha podido borrar el equipo");
        }
    }
    
    static void jugar(){
  
        System.out.println("Dime el nombre de tu personaje: ");
        String nombreJugador = Leer.leerString();
        int iJugador = players.indexOf(new Player(nombreJugador));
        
        System.out.println("Dime el rival al que quieres atacar: ");
        String nombreRival = Leer.leerString();
        int iRival = players.indexOf(new Player(nombreRival));
        
        if (iJugador == -1 || iRival == -1) {
            System.out.println("No se ha creado el numero minimo de jugadores");
        } else {
             do {       
            
            players.get(iJugador).attack(players.get(iRival));
            players.get(iRival).attack(players.get(iJugador));
            
            players.get(iJugador).toString();
            players.get(iRival).toString();
        } while (players.get(iJugador).getLife() > 0 || players.get(iRival).getLife() > 0);
        }
       
    }
    
   
//    
//    static void provaFase1(){
//        //Creacion objetos
//        Player h = new Human("Pepe",50,40,29);
//        Player a = new Alien("Keke",30,66,33);
//        Player w = new Warrior("Pepa",50,39,30);
//        
//        //Informacion de los objetos
//        System.out.println(h.toString());
//        System.out.println(a.toString());
//        System.out.println(w.toString());
//        
//        //Prueba ataque
//        h.attack(w);
//    }
//    static void provaFase3(){
//        crearObjetos();
//        
//        
//        for(Player p : players){
//            System.out.println(p.toString());
//        }
//        players.get(0).attack(players.get(1));
//        players.get(1).attack(players.get(2));
//        players.get(2).attack(players.get(0));
//        
//        
//        
//    }
//    
//    static void crearObjetos(){
//        
//        //Creacion objetos
//        players.add(new Human("Pepe",50,40,29));
//        players.add(new Alien("Keke",30,66,33));
//        players.add(new Warrior("Pepa",50,39,30));
//   
//    }
//    static void provaFase5(){
//        crearObjetos();
//        
//        System.out.println("Creo un team");
//        teams.add(new Team ("Microsoft"));
//
//        int iApple = teams.indexOf(new Team("Microsoft"));
//        System.out.println(iApple);
//        System.out.println(teams.contains(new Team("Microsoft")));
//        
//        players.get(0).add(new Item("espada",5,5));
//        
//        System.out.println(players.get(0).toString());
//        
//        
//        
//    }
//  
    
}
