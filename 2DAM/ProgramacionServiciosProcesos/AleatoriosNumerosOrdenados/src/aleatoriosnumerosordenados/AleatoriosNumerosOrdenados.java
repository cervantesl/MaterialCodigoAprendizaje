/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aleatoriosnumerosordenados;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class AleatoriosNumerosOrdenados {

    public static void main(String[] args) throws IOException{

        ArrayList<String> numerosAleatorios = new ArrayList<>();

        Process generarNumerosaleatorios = Runtime.getRuntime().exec("java -jar "
                + "C:\\Users\\Lucas\\Documents\\MaterialCodigoAprendizaje"
                + "\\2DAM\\ProgramacionServiciosProcesos\\GenerarNumerosAleatorios\\dist\\GenerarNumerosAleatorios.jar " + Integer.parseInt(args[0])+ " " + args[1].charAt(0));

        InputStream is = generarNumerosaleatorios.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String linea;

        while ((linea = br.readLine()) != null) {
            numerosAleatorios.add(linea);
        }
        
        String[] numeros = new String[numerosAleatorios.size()];
        numeros = numerosAleatorios.toArray(numeros);


        //-----------------------------------------------------
        Process ordenarNumerosAleatorios = Runtime.getRuntime().exec("java -jar "
                + "C:\\Users\\Lucas\\Documents\\MaterialCodigoAprendizaje"
                + "\\2DAM\\ProgramacionServiciosProcesos\\OrdenarNumerosAleatorios\\dist\\OrdenarNumerosAleatorios.jar " + Integer.parseInt(args[0]));

        OutputStream os = ordenarNumerosAleatorios.getOutputStream(); //obtenemos la entrada del p2
        OutputStreamWriter osw = new OutputStreamWriter(os);
        PrintStream ps = new PrintStream(os);

        for (String numeroleatorio : numerosAleatorios) {
            System.out.println("Enviando " + numeroleatorio + " a p2");
            ps.println(numeroleatorio);
            ps.flush();
        }

        InputStream iss = ordenarNumerosAleatorios.getInputStream();
        InputStreamReader isrr = new InputStreamReader(iss);
        BufferedReader brr = new BufferedReader(isrr);

        ArrayList<String> numerosAleatoriosOrdenados = new ArrayList<>();

        while ((linea = brr.readLine()) != null) {
            numerosAleatoriosOrdenados.add(linea);
        }

        String[]numerosOrdenados = new String[numerosAleatoriosOrdenados.size()];
        numerosOrdenados = numerosAleatoriosOrdenados.toArray(numerosOrdenados);
        
        for (int i = 0; i < numerosOrdenados.length; i++) {
            System.out.println(numerosOrdenados[i]);
        }
    }

}
