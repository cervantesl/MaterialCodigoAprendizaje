/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personajes;

/**
 *
 * @author Lucas
 */
public class Human extends Player{
    
    //Contructor
    public Human(String name, int attackPoints, int defensePoints, int life) {
        super(name, attackPoints, defensePoints, life);
        
        if (this.getLife() > 100) {
            this.setLife(100);
        }
        
    }
    public Human(String name){
        super(name);
    }

    
}
