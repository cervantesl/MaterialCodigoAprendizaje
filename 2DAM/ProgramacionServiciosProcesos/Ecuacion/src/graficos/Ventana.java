/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import herramientas.Constantes;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Lucas
 */
public class Ventana extends JFrame {

    private String titulo;

    public Ventana(final String titulo, final SuperficieDibujo sd) {
        this.titulo = titulo;

        configurarVentana(sd);
    }

    private void configurarVentana(final SuperficieDibujo sd) {
        setTitle(titulo);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new GridBagLayout());
        add(sd);
        pack(); 
        setSize(Constantes.ANCHO_VENTANA, Constantes.ALTO_VENTANA);
        
        
    }

}
