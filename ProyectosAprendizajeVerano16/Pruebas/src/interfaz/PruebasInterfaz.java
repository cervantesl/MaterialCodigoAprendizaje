/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import javax.swing.JFrame;

/**
 *
 * @author Lucas
 */
public class PruebasInterfaz {
    
    private static final int alto = 600;
    
    private static final int ancho = 800;
    
    public JFrame ventana;
    
    public static PruebasInterfaz pruebasInterfaz;
    
    public PruebasInterfaz() {
        ventana = new JFrame("Pruebas");
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(ancho, alto);
    }
    
    public static void main(String[] args) {
        pruebasInterfaz = new PruebasInterfaz();
    }
}
