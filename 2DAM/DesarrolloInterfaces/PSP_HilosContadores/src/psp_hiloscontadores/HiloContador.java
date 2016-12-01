/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_hiloscontadores;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class HiloContador extends Thread { //Extender Thread
    
    private Resultado r;
    private String fichero;
    
    public HiloContador(Resultado r, String fichero) {
        this.r = r;
        this.fichero = fichero;
    }
    
    @Override
    public void run() {
        long caracteres = 0;
        long palabras = 0;
        long lineas = 0;
        
        try {
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
            
            String linea;
            
            while((linea = br.readLine()) != null) {
                lineas++;
                caracteres += linea.length() -1;
                
                String[] arrayPalabras = linea.split("[ ]+");
                palabras += arrayPalabras.length;
            }
            
            br.close();
            fr.close();
            
            r.incrementar(lineas, palabras, caracteres);
            
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }
}
