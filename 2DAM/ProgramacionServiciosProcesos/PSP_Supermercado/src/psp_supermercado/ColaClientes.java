/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_supermercado;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Lucas
 */
public class ColaClientes {
    
    private Queue<Cliente> clientes;
    
    public ColaClientes() {
        clientes = new LinkedList<>();
    }
    
    public synchronized boolean añadirCliente(Cliente c) {
        boolean conseguir = false;
        
        if (clientes.size() == 10) {
            try {
                this.wait();
                System.out.println("Duerme (generadorcliente) " + Thread.currentThread().getName());
            } catch (InterruptedException ex) {
                ex.getMessage();
            }
        } else {
            clientes.add(c);
            this.notify();
            System.out.println(Thread.currentThread().getName() + " despierta a cajera");
            conseguir = true;
        }
        
        return conseguir;
    }
    
    public synchronized Cliente recuperarCliente() {
        Cliente c = null;
        
        if (clientes.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException ex) {
                ex.getMessage();
            }
        } else {
            c = clientes.poll();
            this.notify();
        }
        
        return c;
    }
    
    public int obtenerTamañoClientes() {
        return clientes.size();
    }
}
