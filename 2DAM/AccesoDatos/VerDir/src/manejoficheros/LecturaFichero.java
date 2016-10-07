/*
 * Crear un fichero de texto con nombre apellidos y telefonos de alumnos de clase.
 * Mostrar la informacion en columnas
 * se debe mostrar el metodo read() de FileReader y readLine() de BufferReader
 */
package manejoficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Lucas Cervantes 2DAM
 */
//Fichero : Lucas, Cervantes, 64354343 +
public class LecturaFichero {

    public static String leerArchivoTextoCaracter(final String ruta) {
        String contenido = "";


        try {
            File f = new File(ruta);
            FileReader fr = new FileReader(f);
            int c;

            try {
                while ((c = fr.read()) != -1) {
                    contenido += ""+ (char) c;
                }
            } catch (IOException ex) {
                Logger.getLogger(LecturaFichero.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(LecturaFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contenido;
    }

    public static String leerArchivoTextoLinea(final String ruta) {
        String contenido = "";

        try {
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);

            while (br.ready()) {
                contenido = br.readLine();
                // System.out.println(contenido);
            }
            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LecturaFichero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LecturaFichero.class.getName()).log(Level.SEVERE, null, ex);
        }

        return contenido;
    }
    
    public static String leerArchivoTexto(final String ruta) {
        String contenido = "";
        
        //Flujo de bytes del archivo
        InputStream entradaBytes = ClassLoader.class.getResourceAsStream(ruta);
        
        //El buffered lee los bytes
        BufferedReader lector = new BufferedReader(new InputStreamReader(entradaBytes));
        
        String linea;
        
        try {
            while((linea = lector.readLine()) != null){
                contenido += linea + "\n";
            }
        } catch (IOException ex) {
            Logger.getLogger(LecturaFichero.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
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

    public static String extraerDatoUsuarioEntero(String contenidoFichero) {
        String[] partesFichero = contenidoFichero.split("\\*");
        String datoUsuarioEntero = "";

        for (int i = 0; i < partesFichero.length; i++) {
            datoUsuarioEntero = partesFichero[i];
        }

        return datoUsuarioEntero;
    }

    public static void main(String[] args) {
        //TABLA

        //nombre (40char)          //apellidos   (40char)  //Telefono (40char)
       String contenidoFichero = leerArchivoTextoCaracter("C:\\Users\\Lucas\\Documents\\MaterialCodigoAprendizaje\\2DAM\\AccesoDatos\\VerDir\\Recursos\\texto\\alumnos.txt");

       String[] partesFichero = contenidoFichero.split(",");

        //String datoUsuarioEntero = partesFichero[1];

        //String[] datoUsuarioSeparado = datoUsuarioEntero.split(",");

        //String[] datoUsuarioSeparado = contenidoFichero.split("\\*");
        
//        for (int i = 0; i < datoUsuarioSeparado.length; i++) {
//            if (datoUsuarioSeparado[i].length() <= 10) {
//                while (datoUsuarioSeparado[i].length() <= 10) {
//                    datoUsuarioSeparado[i] = "+" + datoUsuarioSeparado[i];
//                }
//            }
//        }

//        for (int i = 0; i < datoUsuarioSeparado.length; i++) {
//            System.out.print(datoUsuarioSeparado[i]);
//        }

  for (int i = 0; i < partesFichero.length; i++) {
            if (partesFichero[i].length() <= 20) {
                while(partesFichero[i].length() <= 20) {
                    partesFichero[i] = partesFichero[i] + " ";
                }
            }
        } 
        
        for (int i = 0; i < partesFichero.length; i++) {
            System.out.print(partesFichero[i]);
        }




//FUNCIONA

//        String contenidoFichero = leerArchivoTexto("/texto/alumnos.txt");
//        
//        String[] partes = contenidoFichero.split(",");
//        
//        for (int i = 0; i < partes.length; i++) {
//            if (partes[i].length() <= 20) {
//                while(partes[i].length() <= 20) {
//                    partes[i] = partes[i] + " ";
//                }
//            }
//        }
//        
//        for (int i = 0; i < partes.length; i++) {
//            System.out.print(partes[i]);
//        }

    }

}
