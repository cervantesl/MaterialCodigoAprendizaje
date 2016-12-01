/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Lucas
 */
public class SecuenaNumerosAleatoriosPrograma {
    
    static ArrayList<Integer> ordenarNumeros(ArrayList numerosAleatorios) {
        
        ArrayList<Integer> numerosAleatoriosOrdenados = new ArrayList<>();

        for (int i = 0; i < numerosAleatorios.size(); i++) {
            numerosAleatoriosOrdenados.add((Integer) numerosAleatorios.get(i));
        }

        Collections.sort(numerosAleatoriosOrdenados);

        System.out.println("Cantidad de elementos: " + numerosAleatoriosOrdenados.size());
        
        return numerosAleatoriosOrdenados;
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> numerosAleatoriosOrdenados = null;
        ordenarNumeros(numerosAleatoriosOrdenados);
    }
}
