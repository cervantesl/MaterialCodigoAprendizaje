/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Lucas
 */
public class Ventana extends JFrame {

    private String titulo;
    private int ancho;
    private int alto;

    public Ventana(final String titulo, final SuperficieDibujo sd, final int ancho, final int alto) {
        this.titulo = titulo;
        configuracionVentana(sd, ancho, alto);
        this.ancho = ancho;
        this.alto = alto;
    }

    private void configuracionVentana(final SuperficieDibujo sd, final int ancho, final int alto) {
        setTitle(titulo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);
        setSize(ancho, alto);
        add(sd, BorderLayout.CENTER);
    }
}
