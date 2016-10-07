/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerosejemplos;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Lucas
 */
class SuperficieDibujo2 extends JPanel {

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.white);

        int ancho = getWidth();
        int alto = getHeight();

        int mitadX = ancho / 2;
        int mitadY = alto / 2;

        //Horizontal
        g.setColor(Color.black);
        g.drawLine(0, mitadY, ancho, mitadY);

        //Vertical
        g.drawLine(mitadX, 0, mitadX, alto);

        //Desplazamineto
        int desplazamientoX = getWidth() / 2;
        int desplazamientoY = getHeight() / 2;

        int zoom = 5;

        //Ecuacion
        int a = 2;
        int b = 6;
        int c = 2;

        double min, max, x1 = 0, y1 = 0, x, y;
        int dentroRaiz = b * b - 4 * a * c;

        boolean primera = true;

        if (dentroRaiz < 0) {
            System.out.println("No se puede calcular");
        } else {
            int divisor = 2 * a;
            if (divisor == 0) {
                System.out.println("No se puede calcular");
            } else {
                double sol1 = ((-1) * b + Math.sqrt(dentroRaiz)) / divisor;
                double sol2 = ((-1) * b - Math.sqrt(dentroRaiz)) / divisor;

                if (sol1 < sol2) {
                    max = sol2;
                    min = sol1;
                } else {
                    max = sol1;
                    min = sol2;
                }
                for (x = min - 10; x < max + 10; x += 0.1) {

                    y = a * x * x + b * x + c;
                    g.setColor(Color.blue);
                    g.fillOval((int) (x * zoom + mitadX), (int) ((-1) * y * zoom + mitadY), 1, 1);

                    if (primera) {
                        primera = false;
                    } else {
                        g.drawLine((int) (x * zoom + mitadX), (int) ((-1) * y * zoom + mitadY), (int) (x1 * zoom + mitadX), (int) ((-1) * y1 * zoom + mitadY));
                    }
                    x1 = x;
                    y1 = y;
                }
            }
        }
    }
}

public class Ecuacion extends JFrame {

    public static final int ANCHO = 800, ALTO = 800;

    public Ecuacion() {
        setSize(ANCHO, ALTO);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        add(new SuperficieDibujo2());
    }

    public static void main(String[] args) {
        Ecuacion ecuacion = new Ecuacion();
    }
}
