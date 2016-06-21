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
public class Warrior extends Player{

    public Warrior(String name, int attackPoints, int defensePoints, int life) {
        super(name, attackPoints, defensePoints, life);
    }

    public Warrior(String name){
        super(name);
    }
    @Override
    protected void hit (int attackPoints){
        int daño;
        
        daño = attackPoints - this.getDefensePoints();
        if (daño > 5) {
            super.hit(attackPoints);
        }
        else{
            System.out.println("El daño ha sido absorbido.");
        }
    }
}
