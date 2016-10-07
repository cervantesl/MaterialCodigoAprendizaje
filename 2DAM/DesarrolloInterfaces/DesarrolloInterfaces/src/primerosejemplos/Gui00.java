package primerosejemplos;

import javax.swing.JFrame;

public class Gui00 {

    public Gui00() {
        JFrame jframe = new JFrame();

        jframe.pack(); // hace que la ventana coja el tamaño más pequeño posible que permita ver todos los componentes.
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(500, 500);

    }

    public static void main(String[] args) {
        Gui00 aplicacion = new Gui00();
    }
}
