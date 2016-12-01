/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_hiloscontadores;

/**
 *
 * @author Lucas
 */
public class Resultado {
    
    private long totalLineas;
    private long totalPalabras;
    private long totalCaracteres;
    
    public void Resultado() {
        totalLineas = 0;
        totalPalabras = 0;
        totalCaracteres = 0;
    }
    
    public void incrementar(long lineas, long palabras, long caracteres) {
        totalLineas += lineas;
        totalPalabras += palabras;
        totalCaracteres += caracteres;
    }
    
    public long obtenerTotalLineas() {
        return totalLineas;
    }
    
    public long obtenerTotalPalabras() {
        return totalPalabras;
    }
    
    public long obtenerTotalCaracteres() {
        return totalCaracteres;
    }
}
