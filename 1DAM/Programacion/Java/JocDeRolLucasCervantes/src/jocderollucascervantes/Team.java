/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jocderollucascervantes;

import java.util.ArrayList;
import personajes.Player;

/**
 *
 * @author LUCAS1
 */
public class Team {
    private String nombreEquipo;
    private ArrayList<Player> players = new ArrayList<>();
    
    public Team(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }
    
    public void add(Player p){
        players.add(p);
    }
    
    public void remote(Player p){
        players.remove(p);
    }
    
    public ArrayList<Player> getMembers(){
        return players;
    }

    public String toString(){
        String mensaje = nombreEquipo + players.toString();
        return mensaje;
    }
    @Override
    public boolean equals(Object t) {
        Team tO = (Team)t;
        return this.nombreEquipo.equals(tO.nombreEquipo);
    }
    
    
   
}
