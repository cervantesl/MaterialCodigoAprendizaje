package verdir;

import java.io.File;

public class VerDir {

    public static void main(String[] args) {

        System.out.println("Ver directorio actual:");

        File f = new File(".");

        System.out.println(f.getAbsoluteFile());

        String[] archivos = f.list();

        for (int i = 0; i < archivos.length; i++) {
            System.out.println(archivos[i]);
        }
        
        verInf();

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
    
    public static void listarDirectorio(String directorio, int tipoLista) {
        //tipo lista
        //tipo columna
        //tipo tabla
    }
    
    
}
