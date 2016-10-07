/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class LecturaEscrituraFichero {

    public static void escribirArchivoTexto(final String ruta) {
        File f = new File(ruta);
        FileWriter fw = null;

        String[] nombres = {"Pepe", "Luis", "Sergio", "Carlos", "Lucas"};
        String[] apellidos = {"Rodriguez", "Gonzalez", "Cabreras", "Martinez", "Cervantes"};
        String[] edades = {"5", "4", "3", "22", "23"};

        //Comprobamos si el fichero existe
        if (f.exists()) {
            try {
                fw = new FileWriter(f, true); //Si existe ponemos true para que no sobreescriba los datos

                for (int i = 0; i < nombres.length; i++) {
                    fw.write(nombres[i] + "," + apellidos[i] + "," + edades[i] + ", \n");
                }

            } catch (IOException ex) {
                Logger.getLogger(LecturaEscrituraFichero.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fw.close();
                } catch (IOException ex) {
                    Logger.getLogger(LecturaEscrituraFichero.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            try {
                fw = new FileWriter(f);

                for (int i = 0; i < nombres.length; i++) {
                    fw.write(nombres[i] + "," + apellidos[i] + "," + edades[i] + ", \n");
                }

            } catch (IOException ex) {
                Logger.getLogger(LecturaEscrituraFichero.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fw.close();
                } catch (IOException ex) {
                    Logger.getLogger(LecturaEscrituraFichero.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static String leerArchivoTextoLinea(final String ruta) {
        String contenido = "";

        //Flujo de bytes del archivo
        InputStream entradaBytes = ClassLoader.class.getResourceAsStream(ruta);

        //El buffered lee los bytes
        BufferedReader lector = new BufferedReader(new InputStreamReader(entradaBytes));

        String linea;

        try {
            while ((linea = lector.readLine()) != null) {
                contenido += linea + "\n";
            }
        } catch (IOException ex) {
            Logger.getLogger(LecturaFichero.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (entradaBytes != null) {
                try {
                    entradaBytes.close();
                } catch (IOException ex) {
                    Logger.getLogger(LecturaFichero.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (lector != null) {
                try {
                    lector.close();
                } catch (IOException ex) {
                    Logger.getLogger(LecturaFichero.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return contenido;
    }

    public static String leerArchivoTextoCaracter(final String ruta) {
        String contenido = "";

        try {
            File f = new File(ruta);
            FileReader fr = new FileReader(f);
            int c;

            try {
                while ((c = fr.read()) != -1) {
                    contenido += "" + (char) c;
                }
            } catch (IOException ex) {
                Logger.getLogger(LecturaFichero.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (fr != null) {
                    try {
                        fr.close();
                    } catch (IOException ex) {
                        Logger.getLogger(LecturaFicheros.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(LecturaFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contenido;
    }

    public static void mostrarContenidoFichero(final String contenidoFichero) {

        final int cantidadCaracteresCol = 20;

        //Parto el fichero por las ","
        String[] partes = contenidoFichero.split(",");

        //Poner un tamaño por columna
        for (int i = 0; i < partes.length; i++) {
            if (partes[i].length() <= cantidadCaracteresCol) {
                while (partes[i].length() <= cantidadCaracteresCol) {
                    partes[i] = partes[i] + " ";
                }
            }
        }

        //Mostrar
        System.out.println("NOMBRE  \t\t APELLIDOS \t EDAD");
        System.out.println("----------------------------------------------------");

        for (int i = 0; i < partes.length; i++) {
            System.out.print(partes[i]);
        }
    }

    public static void main(String[] args) {

        //Escribir fichero
        escribirArchivoTexto("Recursos/texto/alumnos.txt");

        //Leer fichero por Caracteres (comento la linea ya que lo meto en el mismo String)
        //String contenidoFichero = leerArchivoTextoCaracter("Recursos/texto/alumnos.txt");
        
        //Leer fichero por linea
        String contenidoFichero = leerArchivoTextoLinea("/texto/alumnos.txt");

        //Mostrar el fichero
        mostrarContenidoFichero(contenidoFichero);

    }
}
