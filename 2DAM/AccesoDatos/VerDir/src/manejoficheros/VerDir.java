package manejoficheros;

import java.io.File;

public class VerDir {

    public static void main(String[] args) {

//        System.out.println("Ver directorio actual:");
//
//        File f = new File(".");
//
//        System.out.println(f.getAbsoluteFile());
//
//        String[] archivos = f.list();
//
//        for (int i = 0; i < archivos.length; i++) {
//            System.out.println(archivos[i]);
//        }
        //verInf();
        listarDirectorio("C:\\Users\\Lucas\\Documents", 2);
    }

    public static void listarDirectorio(String directorio, int tipoLista) {

        System.out.println("Informacion sobre el directorio: " + directorio);

        File f = new File(directorio);
        switch (tipoLista) {
            case 1:
                verDirectorioLista(f);
                break;

            case 2:
                verDirectorioColumna(f);
                break;

            case 3:
                verDirectorioTabla(f);
                break;
        }
    }

    public static void verDirectorioLista(File f) {
        if (f.isDirectory()) {
            System.out.println(f.getAbsoluteFile());

            String[] archivos = f.list();

            for (int i = 0; i < archivos.length; i++) {
                System.out.println(archivos[i]);
            }

        } else {
            System.out.println("No es un directorio");
        }

    }

    public static void verDirectorioColumna(File f) {

        String[] archivos = f.list();
        
        final int MAX_NUM_ELEMENTOS_COL = 5;
        final int COLUMNAS = archivos.length / MAX_NUM_ELEMENTOS_COL;

        String[][] mostrar = new String[MAX_NUM_ELEMENTOS_COL][COLUMNAS];
        
        for (int i = 0; i < mostrar.length; i++) {
            for (int j = 0; j < mostrar[0].length; j++) {
                mostrar[i][j] = archivos[j * MAX_NUM_ELEMENTOS_COL + i];
            }
        }
        
        if (f.isDirectory()) {
            for (int i = 0; i < mostrar.length; i++) {
                for (int j = 0; j < mostrar[0].length; j++) {
                    System.out.print(mostrar[i][j] + " \t\t");
                }
                System.out.println("");
            }
        } else {
            System.out.println("No es un directorio");
        }
    }

    public static void verDirectorioTabla(File f) { //Para que pasas el direcotrio

        if (f.isDirectory()) {
            File[] archivos = f.listFiles();

            System.out.println("(WRX)" + "\t KB" + "\t Nombre");
            System.out.println("--------------------------------------------------------");
            for (int i = 0; i < archivos.length; i++) {
                if (archivos[i].canWrite()) {
                    System.out.print("x");
                } else {
                    System.out.print("-");
                }
                if (archivos[i].canRead()) {
                    System.out.print("x");
                } else {
                    System.out.print("-");
                }
                if (archivos[i].canExecute()) {
                    System.out.print("x");
                } else {
                    System.out.print("-");
                }
                System.out.println("\t" + archivos[i].length() + "\t" + archivos[i].getName());
            }
        } else {
            System.out.println("No es un directorio");
        }
    }

    public static void verInf() {

        System.out.println("Informacion sobre fichero: ");

        File f = new File("src\\verDir.java");

        System.out.println("Nombre de fichero: " + f.getName());
        System.out.println("Ruta: " + f.getPath());
        System.out.println("Ruta absoluta: " + f.getAbsolutePath());
        System.out.println("Se puede escribir: " + f.canWrite());
        System.out.println("Se puede leer: " + f.canRead());
        System.out.println("Tamaño: " + f.length());
        System.out.println("Es un fichero: " + f.isFile());
    }

}
