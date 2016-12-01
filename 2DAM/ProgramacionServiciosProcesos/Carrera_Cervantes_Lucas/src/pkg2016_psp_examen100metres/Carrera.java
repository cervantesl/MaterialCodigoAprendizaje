package pkg2016_psp_examen100metres;


import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Lucas Cervantes
 */
public class Carrera {

    String nom;
    Random r;
    
    public Carrera(String nom) {
        this.nom = nom;
        r=new Random(System.currentTimeMillis());
    }

    
    public String getNom() {
        return nom;
    }
    
    // retorna un numero entre 9 i 11 segons
    int getTemps(){
        return r.nextInt(2000)+9001;
    }
    
    

}
