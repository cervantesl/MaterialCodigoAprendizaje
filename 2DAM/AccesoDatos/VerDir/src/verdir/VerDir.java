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

    }

}
