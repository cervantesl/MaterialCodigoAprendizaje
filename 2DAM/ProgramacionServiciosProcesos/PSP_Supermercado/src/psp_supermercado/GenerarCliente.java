/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_supermercado;

/**
 *
 * @author Lucas
 */
public class GenerarCliente extends Thread{
    
    private boolean acabar = false;
    private ColaClientes cc;
    
    public GenerarCliente(ColaClientes cc) {
        this.cc = cc;
        setName("jefe");
    }

    @Override
    public void run() {
        while(!acabar) {
            Cliente c = new Cliente();
            
            while(!cc.añadirCliente(c));
        }
    }
    
    public void acabar() {
        acabar = true;
    }
    
}
