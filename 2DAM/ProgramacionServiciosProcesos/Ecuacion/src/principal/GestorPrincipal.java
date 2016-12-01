/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import graficos.SuperficieDibujo;
import graficos.Ventana;
import herramientas.Constantes;

/**
 *
 * @author Lucas
 */
public class GestorPrincipal {

    public static SuperficieDibujo sd;
    private Ventana ventana;

    private String titulo;
    private int ancho;
    private int alto;

    public GestorPrincipal(final String titulo, final int ancho, final int alto) {
        this.titulo = titulo;
        this.ancho = ancho;
        this.alto = alto;
    }

    public static void main(String[] args) {
        GestorPrincipal gp = new GestorPrincipal("Ecuacion", Constantes.ANCHO_VENTANA, Constantes.ALTO_VENTANA);
        
        gp.inicializar();
    }

    private void inicializar() {
        sd = new SuperficieDibujo(ancho, alto);
        ventana = new Ventana(titulo, sd);
    }
}
