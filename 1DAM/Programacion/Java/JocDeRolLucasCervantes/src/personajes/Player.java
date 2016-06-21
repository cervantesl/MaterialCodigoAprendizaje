/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personajes;

import java.util.ArrayList;
import jocderollucascervantes.Item;

/**
 *
 * @author Lucas
 */
public class Player {
    //Atributos 
    private String name = "";
    private int attackPoints;
    private int defensePoints;
    private int life;
    private ArrayList <Item> items = new ArrayList<>();
    
    //Constructor
    public Player(String name){
        this.name = name;
    }
    public Player(String name, int attackPoints, int defensePoints, int life) {
        this.name = name;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.life = life;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public void setDefensePoints(int defensePoints) {
        this.defensePoints = defensePoints;
    }

    //Metodos
    public String getName() {
        return name;
    }

    public int getAttackPoints() {
        int puntosItem = 0;
        for (int i = 0; i < items.size(); i++) {
            puntosItem += items.get(i).getAttackBonus();
        }
        return attackPoints + puntosItem;
    }

    public int getDefensePoints() {
        int puntosItem = 0;
        for (int i = 0; i < items.size(); i++) {
            puntosItem += items.get(i).getDefenseBonus();
        }
        return defensePoints;
    }

    public int getLife() {
        return life;
    }
    
    public void setLife(int life) {
        this.life = life;
    }
    
    
    
    //Metodo mostrar info
    @Override
    public String toString(){
        String mensaje = "Nombre: "+name+" PA: "+attackPoints+
                " PD: "+defensePoints+" PV: "+life+ " Items: \n";
        for (Item i : this.items) {
            mensaje += i.toString()+"\n";
        }
        
        return mensaje;
    }
    
    //Metodo atacar
    public void attack(Player p){
        System.out.println("****ATAQUE****");
       //Vida del atacante
       System.out.println(this.toString());
       
       //Vida del que recibe el ataque
       System.out.println(p.toString());
       
       //Ataque del contrario
       this.hit(p.attackPoints);
       
       //Ataque que hago yo
       p.hit(this.attackPoints);
       
       //Vida del atacante
       System.out.println(this.toString());
       
       //Vida del que recibe el ataque
       System.out.println(p.toString());
        System.out.println("****ATAQUE****");
       
    }
    protected void hit(int attackPoints){
        int daño;
       
        daño = attackPoints - this.defensePoints;
        
        if (daño > 0) {
            System.out.println(this.name+ " ha golpeado con "+daño+" daño");
            this.life -= daño;
        }
        else{
            System.out.println("No ha recibido daño");
        }
        
    }
    
    //Metodo añadir item a un jugador
    public void add(Item i){
        items.add(i);
    }
    
    //Metodo para borrar el item a un jugador
    public void remove(Item i){
        items.remove(i);
    }
    
    @Override
    public boolean equals(Object obj){
        Player a = (Player)obj;
        return this.name.equals(a.name);
    }

    
}
