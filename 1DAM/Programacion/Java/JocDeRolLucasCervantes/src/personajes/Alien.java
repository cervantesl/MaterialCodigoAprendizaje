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
public class Alien extends Player{

    public Alien(String name, int attackPoints, int defensePoints, int life) {
        super(name, attackPoints, defensePoints, life);
    }
    public Alien(String name){
        super(name);
    }
    
    @Override
    public void attack(Player p){
        if (this.getLife() > 20) {
            int puntosAtaques = this.getAttackPoints() + 3;
            int puntosDefensa = this.getDefensePoints() - 3;
            this.setAttackPoints(puntosAtaques);
            
            if (puntosDefensa < 0) {
                this.setDefensePoints(0);
            }
            else{
                this.setDefensePoints(puntosDefensa);
            }
        }
        
        super.attack(p);
        
    }

    
}
