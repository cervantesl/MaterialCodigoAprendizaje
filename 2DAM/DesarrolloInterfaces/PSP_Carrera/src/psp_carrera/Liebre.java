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
public class Liebre extends Animal{
    
    public Liebre(int meta) {
        super(meta);
    }
    
    public void mover() {
        int num = r.nextInt(100);
        
        if(num < 20) {
            
        }
        else if(num < 40) {
            pos += 9;
        }
        else if(num < 50) {
            pos -= 12;
        }
        else if(num <80) {
            pos++;
        } else {
            pos -= 2;
        }
        
        comprobarPos();
        
        if(pos == meta) {
            this.acabar();
        }
        
    }
}
