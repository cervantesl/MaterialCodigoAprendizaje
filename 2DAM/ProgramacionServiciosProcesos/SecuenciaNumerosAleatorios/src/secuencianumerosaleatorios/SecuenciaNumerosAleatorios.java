package secuencianumerosaleatorios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


/**
 *
 * @author Lucas
 */
public class SecuenciaNumerosAleatorios {

    static ArrayList<Integer> generarNumerosAleatorios(int cantidadNumerosAleatorios, char opcion) throws IOException {

        ArrayList<Integer> numerosAleatorios = new ArrayList<>();

        File f = new File("C:\\Users\\Lucas\\Documents\\MaterialCodigoAprendizaje\\2DAM"
                + "\\ProgramacionServiciosProcesos\\SecuenciaNumerosAleatorios\\src\\secuencianumerosaleatorios\\aleatorios.txt");
        FileWriter fw = new FileWriter(f, false);

        switch (opcion) {
            case 'p':
                System.out.println("Elementos desordenados:");
                for (int i = 0; i < cantidadNumerosAleatorios; i++) {
                    numerosAleatorios.add((int) (Math.random() * 1000) + 1000);
                }

                for (int i = 0; i < numerosAleatorios.size(); i++) {
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

    static ArrayList<Integer> ordenarNumeros(ArrayList numerosAleatorios) {
        
        ArrayList<Integer> numerosAleatoriosOrdenados = new ArrayList<>();

        for (int i = 0; i < numerosAleatorios.size(); i++) {
            numerosAleatoriosOrdenados.add((Integer) numerosAleatorios.get(i));
        }

        Collections.sort(numerosAleatoriosOrdenados);

        System.out.println("Cantidad de elementos: " + numerosAleatoriosOrdenados.size());
        
        return numerosAleatoriosOrdenados;
    }
    
    static void aleatoriosOrdenados(int numeros, char opcion) throws IOException {
            ArrayList <Integer>listaOrdenada;
            listaOrdenada = ordenarNumeros(generarNumerosAleatorios(numeros, opcion));
            
            System.out.println(listaOrdenada.toString());
    }

    public static void main(String[] args) throws IOException {

        aleatoriosOrdenados(Integer.parseInt(args[0]), args[1].charAt(0));
        
        Process p=Runtime.getRuntime().exec("");

    }

}
