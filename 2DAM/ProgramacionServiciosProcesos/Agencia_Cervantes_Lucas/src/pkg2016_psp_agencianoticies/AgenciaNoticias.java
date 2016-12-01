/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2016_psp_agencianoticies;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class AgenciaNoticias extends Thread {

    private boolean acabar = false;
    private Tauler tablaNoticias;

    public AgenciaNoticias(Tauler tablaNoticias) {
        this.tablaNoticias = tablaNoticias;

        setName("Redactor");
    }

    @Override
    public void run() {
        while (!acabar) {
        
            Noticia noticia = new Noticia();

            while (!tablaNoticias.añadirNoticia(noticia.getNoticia()));
        }
    }

    public void acabar() {
        acabar = true;
    }

}
