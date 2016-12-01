/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_carrera;

/**
 *
 * @author Lucas
 */
public class Tortuga extends Animal {
    
    public Tortuga(int meta) {
        super(meta);
    }
    
    @Override
    public void mover() {
        int num = r.nextInt(100);
        
        if(num < 50) {
            pos += 3;
        }
        else if(num < 70) {
            pos -= 6;
        } else {
            pos++;
        }
        comprobarPos();
        
        if(pos == meta) {
            this.acabar();
        }
    }
}
