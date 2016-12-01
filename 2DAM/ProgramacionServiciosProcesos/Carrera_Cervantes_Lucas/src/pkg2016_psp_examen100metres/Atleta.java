package pkg2016_psp_examen100metres;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas Cervantes
 */
public class Atleta extends Thread {

    private int dorsal;
    long tiempoacabar;
    public boolean acabar = false;
    private int tiempoInicio;

    Carrera c;

    public Atleta(final int dorsal, Carrera c) {
        this.dorsal = dorsal;
        this.c = c;

        setName("Atleta: " + dorsal);

    }

    @Override
    public void run() { 
        int tiempo = c.getTemps();
        try {
            
            Thread.sleep(tiempo);
          
        } catch (InterruptedException ex) {
            Logger.getLogger(Atleta.class.getName()).log(Level.SEVERE, null, ex);
        }

        //tiempoacabar = System.currentTimeMillis() - Main.tiempoInicio;
        
        System.out.println(getName() + " acaba en " + tiempo);

    }

}
