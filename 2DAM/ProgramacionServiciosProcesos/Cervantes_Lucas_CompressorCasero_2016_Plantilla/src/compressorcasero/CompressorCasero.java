/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compressorcasero;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.*;

/**
 *
 * @author joange
 */
public class CompressorCasero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        // 0.- Saber en quin SO estem executant el programa
        String SO = System.getProperty("os.name");

        // 1.- Recuperar la ruta on està executant-se l'aplicació
        String ruta = recuperarRuta(SO);
        System.out.println(ruta);
        // 2.- Entrar dins de la carpeta "arxius". Pensa que les barres depenen del SO
        String barra = System.getProperty("file.separator");

        // 3.- Comprovació dels arguments
        // 3.1.- Si no hi han eixim del programa amb codi d'erro 1
        if (args.length == 0) {
            System.out.println("Numero d'arguments incorrecte. Ús del programa");
            System.out.println("CompressorCasero carpeta [ext1, ext2,...]");
            System.exit(1);
        }

        // 3.2.- Comprovem que existeix la carpeta passada com argument
        String carpeta = args[0];
        System.out.println("carpeta:" + carpeta);
        if (SO.toUpperCase().contains("WIN")) {
            ruta = ruta + barra + carpeta + barra;
        } else {
            ruta = ruta + barra + barra + carpeta;
        }
        System.out.println("La ruta on buscaré els arxius és: " + ruta);

        // Completar. Comprovar que "ruta" existeix i és un directori
        //            Cas de no ser eixir amb codi d'error 2
        File fRuta = new File(ruta);

        if (!fRuta.isDirectory()) {
            System.out.println("No es un directorio");
            System.exit(2);
        } else {
            System.out.println("es directorio");
        }

        // 4.- Per a cada extensió que es passa com argument comprimir els fitxers
        for (int i = 1; i < args.length; i++) {

            // recuperem l'extensió apuntada per l'argument
            String ext = args[i];

            // recuperem els fitxers que tinguen eixa extensió. Ja implementat
            ArrayList<String> elsFitxers = llistarDirectori(ruta, ext);

            // Si no hi han fitxers d'eixa extensió informar i passar a la
            // següent extensió. En cas contrari comprimir-los
            if (elsFitxers.size() > 0) {
                comprimirFitxers(ruta, ext, elsFitxers);
            } else {
                System.out.println("\tNo hi han fitxers de l'extensio <" + ext + ">");
            }
        }

    }

//    }
    /**
     * Aquesta funció està totalment implementada
     *
     * @param ruta Descriu el path d'on voler obtenir els fitxers
     * @param extensio La extensio dels fitxers
     * @return Un String amb els fitxers separats per comes
     */
    private static ArrayList<String> llistarDirectori(String ruta, final String extensio) {
        ArrayList<String> res = new ArrayList<String>();

        File dir = new File(ruta);

        FilenameFilter filtre = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                String lowercaseName = name.toLowerCase();
                if (lowercaseName.endsWith("." + extensio)) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        File[] elsFitxers = dir.listFiles(filtre);

        for (File f : elsFitxers) {
            res.add(f.getName());
        }

        return res;
    }

    /**
     * Funció que retorna en quina carpeta està executant-se l'aplicaciçó
     *
     * @param SO El Sistema Operatiu sobre on s'executa l'aplicació
     * @return String qmb dita ruta
     */
    public static String recuperarRuta(String SO) {
        String res = "";
        try {
            String[] c = {"cmd.exe", "/c", "chdir"};
            Process ruta = Runtime.getRuntime().exec(c);

            InputStream is = ruta.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String linea;

            while ((linea = br.readLine()) != null) {
                res += linea;
            }

            // invocar al programa corresponent per saber la ruta on estem
            // en windows "chdir"
            // en linux-mac "pwd"
        } catch (IOException ex) {
            Logger.getLogger(CompressorCasero.class.getName()).log(Level.SEVERE, null, ex);
        }

        return res;
    }

    /**
     * Funció que comprimeix els fitxers de dita extensió en una carpeta
     *
     * @param ruta On estan i on guardarem el fitxer comprimit
     * @param extensio per composar el nom
     * @param fitxers Array amb els nom dels fitxers
     */
    public static void comprimirFitxers(String ruta, String extensio, ArrayList<String> fitxers) throws IOException {

        // Completar
        // 4.1 Generar el nom del fitxer
        String nomArxiuACrear = "";
        for (int i = 0; i < fitxers.size(); i++) {

            nomArxiuACrear = ruta + fitxers.get(i) + ".zip" + extensio;
            System.out.println(nomArxiuACrear);

//
//            OutputStream os = zip.getOutputStream(); //obtenemos la entrada del p2
//            OutputStreamWriter osw = new OutputStreamWriter(os);
//            PrintStream ps = new PrintStream(os);
//
//            ps.println(ruta);
//            ps.flush();
        }

        Process zip = Runtime.getRuntime().exec("zip " + nomArxiuACrear);
        mostrarEixidaProces(zip);

        // 4.2 Composar el comandament de zip.
        // Pots fer-ho amb les utilitats que més vullgues
        // 4.3 Executar el comandament
        // 4.4 Mostrar l'eixida del comandament
    }

    /**
     * Aquesta funció rep un procés per a mostrar la seua eixida per pantalla
     *
     * @param p Process a mostrar la seua eixida
     * @return no res. Ho mostra per pantalla
     */
    public static String mostrarEixidaProces(Process p) throws IOException {
        String res = "";
        InputStream is = p.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String linea;

        while ((linea = br.readLine()) != null) {
            res += linea;
        }
        // 5. Completar el codi
        return res;
    }
}
