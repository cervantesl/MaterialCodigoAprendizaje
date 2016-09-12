package banco;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import control.Raton;
import graficos.SuperficieDibujo;
import graficos.Ventana;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;

public class Banco implements ActionListener {

    public static ArrayList<Cuenta> cuentas = new ArrayList();
    public static Scanner teclado = new Scanner(System.in);
    private Ventana ventana;
    private SuperficieDibujo sd;
    private Raton raton;

    public static JButton botonComienzo;

    private static boolean start = false;

    public Banco() {
        raton = new Raton();

    }

    public static void main(String[] args) {

        Banco banco = new Banco();
        banco.inicializar();
        pruebas();
    }

    public void inicializar() {
        sd = new SuperficieDibujo();
        ventana = new Ventana("Banco", sd, 640, 350);

        botonComienzo = new JButton("Empezar");
                ventana.add(botonComienzo);
        addMouseListener(raton);

    }

    public static void pintar(Graphics g) {

        if (start) {

            g.setFont(new Font("Arial", 20, 20));

            for (int i = 0; i < cuentas.size(); i++) {
                g.drawString(cuentas.get(i).toString() + "saldo: " + cuentas.get(i).obtenerSaldo(), 20, (i + 1) * 20);
                g.drawString("\n", 0, 0);
            }
        }

    }

    public void menu(Graphics g) {
        g.setColor(Color.GRAY);
        g.drawString("Banco", 20, 20);

    }

    public static void crearCuenta() {

        System.out.println("Nombre: ");
        String nombre = teclado.next();

        System.out.println("Apellido: ");
        String apellido = teclado.next();

        System.out.println("Edad: ");
        int edad = teclado.nextInt();

        int numCuenta = cuentas.size() + 1;

        cuentas.add(new Cuenta(nombre, apellido, edad, numCuenta));
    }

    public static void mostrarCuentas() {
        for (Cuenta cuenta : cuentas) {
            System.out.println(cuenta.toString());
        }
    }

    public static void eliminarCuenta() {
        Cuenta cuentaBorrar = elegirCuenta(pedirNumCuenta());

        if (cuentas.contains(cuentaBorrar) == true) {
            cuentas.remove(cuentaBorrar);
            System.out.println("La cuenta se ha borrado satisfactoriamente");
        } else {
            System.out.println("El numero de cuenta no existe.");
        }

    }

    public static void mostrarCuenta() {
        Cuenta cuentaMostrar = elegirCuenta(pedirNumCuenta());
        System.out.println(cuentaMostrar.toString());

    }

    public static Cuenta elegirCuenta(int numCuenta) { //Arreglar que no devuelva null
        Cuenta cuentaDevolver = null;

        for (int i = 0; i < cuentas.size(); i++) {
            if (cuentas.indexOf(new Cuenta(numCuenta)) != -1) {
                cuentaDevolver = cuentas.get(i);
            }
        }

        return cuentaDevolver;
    }

    public static int pedirNumCuenta() {
        System.out.println("Numero de Cuenta a elegir: ");
        int numCuenta = teclado.nextInt();

        return numCuenta;
    }

    public static void pruebas() {

        cuentas.add(new Cuenta("Lucas", "Cervantes", 23, 0));
        cuentas.get(0).hacerIngreso(750);
        cuentas.add(new Cuenta("Jose", "Cervantes", 52, 1));
        cuentas.get(0).transferir(300, cuentas.get(1));
    }

    @Override
    public void actionPerformed(ActionEvent ae) { //Le pasamos un evento
        if (ae.getSource() == botonComienzo) {
            start = true;
        }
    }

}
