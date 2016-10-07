package secuencianumerosaleatorios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


/**
 *
 * @author Lucas
 */
public class SecuenciaNumerosAleatorios {

    static ArrayList generarNumerosAleatorios(int cantidadNumerosAleatorios, char opcion) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> numerosAleatorios = new ArrayList<>();

        File f = new File("C:\\Users\\Lucas\\Documents\\MaterialCodigoAprendizaje\\2DAM"
                + "\\ProgramacionServiciosProcesos\\SecuenciaNumerosAleatorios\\src\\secuencianumerosaleatorios\\aleatorios.txt");
        FileWriter fw = new FileWriter(f, false);

        System.out.println("MENU");
        System.out.println("p : mostrar numeros por pantalla entre [1000-2000]");
        System.out.println("f : almacenar numeros en archivo");
        System.out.println("Selecciona: ");
        opcion = (char) br.read();

        switch (opcion) {
            case 'p':
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

    static ArrayList ordenarNumeros(ArrayList numerosAleatorios) {
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
    
    static void prueba() throws IOException {
        ArrayList prueba = new ArrayList();
        
        for (int i = 0; i < 1000; i++) {
            prueba.add((int) (Math.random() * 1000) + 1000);
        }
        
        System.out.println(prueba.toString());
    }

    public static void main(String[] args) throws IOException {
//(char) Integer.parseInt(args[1])
        aleatoriosOrdenados(Integer.parseInt(args[0]),'p' );

    }

}
