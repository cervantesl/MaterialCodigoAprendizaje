/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generarnumerosaleatorios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class GenerarNumerosAleatorios {

    static ArrayList<Integer> generarNumerosAleatorios(int cantidadNumerosAleatorios, char opcion) throws IOException {

        ArrayList<Integer> numerosAleatorios = new ArrayList<>();

        File f = new File("C:\\Users\\Lucas\\Documents\\MaterialCodigoAprendizaje\\2DAM"
                + "\\ProgramacionServiciosProcesos\\SecuenciaNumerosAleatorios\\src\\secuencianumerosaleatorios\\aleatorios.txt");
        FileWriter fw = new FileWriter(f, false);

        switch (opcion) {
            case 'p':
                for (int i = 0; i < cantidadNumerosAleatorios; i++) {
                    numerosAleatorios.add((int) (Math.random() * 1000) + 1000);
                    System.out.println(numerosAleatorios.get(i));
                }
                break;
            case 'f':
                for (int i = 0; i < cantidadNumerosAleatorios; i++) {
                    fw.write((int) (Math.random() * 1000) + 1000);
                }
                fw.close();
                break;
        }

        
        return numerosAleatorios;

    }

    public static void main(String[] args) throws IOException {
        generarNumerosAleatorios(Integer.parseInt(args[0]), args[1].charAt(0));
        //generarNumerosAleatorios(3,'p');
    }

}
