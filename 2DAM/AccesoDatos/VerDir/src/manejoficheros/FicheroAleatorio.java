/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class FicheroAleatorio {

    static int posicion = 0;
    static int id, dep;
    static char[] apellido = new char[10];
    static char auxApellido;
    static double salario;

    static File fichero = null;
    static RandomAccessFile raf = null;

    static void insertarDatos(final String ruta) {
        String[] apellidos = {"Fernandez", "Gil", "Lopez", "Ramos", "Sevilla", "Castilla", "Rey"};
        int[] departamentos = {10, 20, 10, 10, 30, 30, 20};
        double[] salarios = {1000.45, 2400.60, 3000.0, 1500.56, 2200.0, 1435.87, 2000.0};

        StringBuffer buffer = null; //bufer para almacenar apellido
        fichero = new File(ruta);

        try {
            raf = new RandomAccessFile(fichero, "rw");

            for (int i = 0; i < apellidos.length; i++) {
                try {
                    raf.writeInt(i + 1);
                    buffer = new StringBuffer(apellidos[i]);
                    buffer.setLength(10);
                    raf.writeChars(buffer.toString());
                    raf.writeInt(departamentos[i]);
                    raf.writeDouble(salarios[i]);
                } catch (IOException ex) {
                    Logger.getLogger(FicheroAleatorio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FicheroAleatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void mostrarDatos(final String ruta) {

        try {
            fichero = new File(ruta);
            raf = new RandomAccessFile(fichero, "r");

            try {
                while (raf.getFilePointer() < fichero.length()) {
                    raf.seek(posicion);
                    id = raf.readInt();
                    for (int i = 0; i < apellido.length; i++) {
                        auxApellido = raf.readChar();
                        apellido[i] = auxApellido;

                    }

                    String apellidos = new String(apellido);

                    dep = raf.readInt();
                    salario = raf.readDouble();

                    System.out.println("ID: " + id + " Apellido: " + apellidos + ", Dep: " + dep + " Salario: " + salario);

                    posicion += 36;

                }
            } catch (IOException ex) {
                Logger.getLogger(FicheroAleatorio.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FicheroAleatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void consultarDatos(int id) {

        try {
            int identificador = id;
            posicion = (id - 1) * 36;

            if (posicion >= raf.length()) {
                System.out.println("ID: " + id + " no existe empleado");
            } else {
                raf.seek(posicion);
                id = raf.readInt();

                for (int i = 0; i < apellido.length; i++) {
                    auxApellido = raf.readChar();
                    apellido[i] = auxApellido;

                }
                String apellidoUnico = new String(apellido);
                dep = raf.readInt();
                salario = raf.readDouble();

                System.out.println("ID: " + id + " Apellido: " + apellidoUnico + " Departamento: " + dep + " Salario: " + salario);
            }

        } catch (IOException ex) {
            Logger.getLogger(FicheroAleatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void añadirDatos() {
        StringBuffer buffer = null;
        fichero = new File("Recursos/texto/empleados.txt");

        try {
            raf = new RandomAccessFile(fichero, "rw");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FicheroAleatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        String apellido = "GONZALEZ";
        salario = 1230.87;

        dep = 10;

        try {

            posicion = (id - 1) * 36;
            raf.seek(posicion);
            raf.writeInt(8);
            buffer = new StringBuffer(apellido);
            buffer.setLength(10);
            raf.writeChars(buffer.toString());
            raf.writeInt(dep);
            raf.writeDouble(salario);
        } catch (IOException ex) {
            Logger.getLogger(FicheroAleatorio.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        insertarDatos("Recursos/texto/empleados.txt");
        mostrarDatos("Recursos/texto/empleados.txt");
        añadirDatos();
        consultarDatos(8); //Actividad 3 - Le paso por parametro el id y lo muestro

        System.out.println("Mostrar datos 2: ");
        mostrarDatos("Recursos/texto/empleados.txt");
    }
}
