
package psp_supermercado;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class PSP_Supermercado {
    
    private static int cantidadCajeras = 3;

    public static void main(String[] args) {
        
        ColaClientes cc = new ColaClientes();
        
        GenerarCliente gc = new GenerarCliente(cc);
        
        gc.start();
        
        Cajera c1 = new Cajera(cc, 1);
        c1.start();
        System.out.println(c1.obtenerID() +" se mete en caja");
        
        Cajera c2 = new Cajera(cc, 2);
        c2.start();
        System.out.println(c2.obtenerID() +" se mete en caja");
        
        Cajera c3 = new Cajera(cc, 3);
        c3.start();
        System.out.println(c3.obtenerID() +" se mete en caja");
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            ex.getMessage();
        }
        
        gc.acabar();
        System.out.println("Cola cerrada "  +Thread.activeCount());
        
        while(cc.obtenerTamañoClientes() > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(PSP_Supermercado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(PSP_Supermercado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Cajeras acabado " + Thread.activeCount());
        
        c1.acabar();
        System.out.println(c1.getName() +" sale de caja");
        
        c2.acabar();
        System.out.println(c2.getName() +" sale de caja");
        
        c3.acabar();
        System.out.println(c3.getName() +" sale de caja");
    }
    
}
