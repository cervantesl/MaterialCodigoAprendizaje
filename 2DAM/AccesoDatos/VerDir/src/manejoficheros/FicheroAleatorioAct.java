package manejoficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 *
 * @author Lucas
 */
public class FicheroAleatorioAct {

    static void insertarDatos() throws FileNotFoundException, IOException {
        File fichero = new File("Recursos/texto/empleados.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");

        String[] apellidos = {"Fernandez", "Gil", "Lopez", "Ramos", "Sevilla", "Castilla", "Rey"};
        int[] departamentos = {10, 20, 10, 10, 30, 30, 20};
        Double[] salarios = {1000.45, 2400.60, 3000.0, 1500.56, 2200.0, 1435.87, 2000.0};

        StringBuffer buffer = null;

        for (int i = 0; i < apellidos.length; i++) {
            file.writeInt(i + 1);
            buffer = new StringBuffer(apellidos[i]);
            buffer.setLength(10);
            file.writeChars(buffer.toString());
            file.writeInt(departamentos[i]);
            file.writeDouble(salarios[i]);
        }

        file.close();
    }

    static void visualizarDatos() throws FileNotFoundException, IOException {
        File fichero = new File("Recursos/texto/empleados.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "r");

        int id, dep, posicion;
        Double salario;
        char[] apellido = new char[10];
        char aux;

        posicion = 0;

        while (file.getFilePointer() < file.length()) {
            file.seek(posicion);
            id = file.readInt();

            for (int i = 0; i < apellido.length; i++) {
                aux = file.readChar();
                apellido[i] = aux;
            }

            String apellidos = new String(apellido);
            dep = file.readInt();
            salario = file.readDouble();

            System.out.println("ID: " + id + ", Apellido: " + apellidos + ", Departamento: " + dep + ", Salario: " + salario);

            posicion += 36;
        }

        file.close();
    }

    static void consultarEmpleado(int empleado) throws FileNotFoundException, IOException {
        File fichero = new File("Recursos/texto/empleados.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "r");

        int identificador = empleado, posicion, id, dep;
        char aux;
        char[] apellido = new char[10];
        Double salario;

        posicion = (identificador - 1) * 36;

        if (posicion >= file.length()) {
            System.out.println("ID: " + identificador + ", NO EXISTE");
        } else {
            file.seek(posicion);
            id = file.readInt();

            for (int i = 0; i < apellido.length; i++) {
                aux = file.readChar();
                apellido[i] = aux;
            }

            String apellidoUnico = new String(apellido);
            dep = file.readInt();
            salario = file.readDouble();

            System.out.println("ID: " + id + ", Apellido: " + apellidoUnico + ", Departamento: " + dep + ", Salario: " + salario);
        }
        file.close();
    }

    static void añadirEmpleado() throws FileNotFoundException, IOException {
        File fichero = new File("Recursos/texto/empleados.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");

        long posicion = file.length();
        file.seek(posicion);

        StringBuffer buffer = null;
        String apellido = "GONZALEZ";
        Double salario = 1230.87;
        int id = 8, dep = 10;

        file.writeInt(id);
        buffer = new StringBuffer(apellido);
        buffer.setLength(10);
        file.writeChars(buffer.toString());
        file.writeInt(dep);
        file.writeDouble(salario);

        file.close();
    }

    static void modificarRegistro() throws FileNotFoundException, IOException {
        File fichero = new File("Recursos/texto/empleados.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");

        //EJEMPLO: MODIFICAR "DEPARTAMENTO"
        //id: 4 + apellido: 20 + departamento: 4 + salario: 8;

        int id = 4;

        long posicion = (id - 1) * 36;
        posicion += 4 + 20;
        file.seek(posicion); //Nos colocamos en la posision "dep"
        file.writeInt(40);
        file.writeDouble(4000.87);

        file.close();
    }

    static void actividad4(int empleado, Double plusSalario) throws FileNotFoundException, IOException {
        File fichero = new File("Recursos/texto/empleados.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");

        //id: 4 + apellido: 20 + departamento: 4 + salario: 8;
        int identificador = empleado;
        int dep;
        char[] apellido = new char[10];
        char aux;

        long posicion = (identificador - 1) * 36;

        if (posicion >= file.length()) {
            System.out.println("ID: " + identificador + ", NO EXISTE");
        } else {
            posicion += 4;
            file.seek(posicion);

            for (int i = 0; i < apellido.length; i++) {
                aux = file.readChar();
                apellido[i] = aux;
            }

            String apellidoUnico = new String(apellido);
            
            posicion += 20 + 4;

            file.seek(posicion); //posicion salario

            //Obtener salario actual 
            Double salarioActual = file.readDouble();

            file.seek(posicion); //posicion salario
            file.writeDouble(salarioActual + plusSalario);
            
            file.seek(posicion); //posicion salario
            Double salarioNuevo = file.readDouble();
            
            System.out.println("Apellido: " + apellidoUnico + ", Salario antiguo: " + salarioActual + " Salario nuevo: " + salarioNuevo);
        }
        
        file.close();
    }

    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        
        insertarDatos();
        visualizarDatos();

        System.out.println("Consulta: ");

        //pido el id por teclado
        System.out.println("Dime ID:");
        int id = teclado.nextInt();
        
        consultarEmpleado(id); //Actividad 3 <--------------------- id

        añadirEmpleado();

        System.out.println("Mostrar de nuevo los empleados (despues de añadir un empleado):");
        visualizarDatos();

        modificarRegistro();

        System.out.println("Mostrar de nuevo los empleados (despues de modificar un empleado):");
        visualizarDatos();
        
        //pido id y nuevo sueldo por pantalla
        System.out.println("Dime ID: ");
        id = teclado.nextInt();
        System.out.println("Dime plus sueldo: ");
        Double sueldoNuevo = teclado.nextDouble();
        
        actividad4(id, sueldoNuevo); //Actividad 4 <-------------------- id y plus sueldo
        
        System.out.println("Nuevo sueldo: ");
        visualizarDatos();
    }
}
