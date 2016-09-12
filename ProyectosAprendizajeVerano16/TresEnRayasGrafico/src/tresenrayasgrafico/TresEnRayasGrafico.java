/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresenrayasgrafico;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author Lucas
 */
public class TresEnRayasGrafico implements ActionListener, MouseListener, KeyListener {

    public final int WIDTH = 800, HEIGHT = 800;

    public static TresEnRayasGrafico tenrg;

    public Renderer renderer;

    public int gameStatus, turno, cuadro, jugador;

    public char pieza;

    public char[][] tablero;

    public boolean start;

    public TresEnRayasGrafico() {

        JFrame jframe = new JFrame("Tres en Rayas");
        Timer timer = new Timer(20, this);
        renderer = new Renderer();

        jframe.setVisible(true);
        jframe.setResizable(false);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(WIDTH, HEIGHT);
        jframe.add(renderer);
        jframe.addMouseListener(this);
        jframe.addKeyListener(this);
        
        start();
        turno();
        timer.start();

    }

    public void start() {
        tablero = new char[3][3];
        gameStatus = 0;
        turno = 0;
        start = false;
        cuadro = 99;
        pieza = 'X';
        jugador = 0;
    }

    public static void main(String[] args) {

        tenrg = new TresEnRayasGrafico();

    }

    public void turno() {

        if (turno % 2 == 1) {
            pieza = 'X';
            jugador = 1;
        } else {
            pieza = 'O';
            jugador = 2;
        }

        turno++;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        switch (cuadro) {
            case 0:
                tablero[0][0] = pieza;
                break;
            case 1:
                tablero[0][0] = pieza;
                break;
            case 2:
                tablero[0][0] = pieza;
                break;
            case 3:
                tablero[0][0] = pieza;
                break;
            case 4:
                tablero[0][0] = pieza;
                break;
        }

        renderer.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent me) {

        int x = me.getX();
        int y = me.getY();
        System.out.println("X: " + x + " " + "Y:" + y);

        //Inicio
        if (x >= 1 && y >= 1) {
            gameStatus = 3;
        }

        //Primer cuadro
        if (x >= 4 && y <= 325 && x <= 300) {

            cuadro = 0;

        }

        //Segundo cuadro
        //X: 306 Y:132
        //X: 498 Y:326
        if (x >= 306 && x <= 498 && y >= 132 && y <= 326) {

            cuadro = 1;
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    public void render(Graphics2D g) {

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, WIDTH);

        if (gameStatus == 0) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", 1, 50));
            g.drawString("Tres en Rayas", WIDTH / 2 - 150, 100);

            g.setFont(new Font("Arial", 1, 30));
            g.drawString("Aprieta ESPACIO para empezar", WIDTH / 2 - 200, 300);

            g.setFont(new Font("Arial", 1, 30));
            g.drawString("Hecho por: Lucas Cervantes", WIDTH / 2 - 200, 700);
        }

        if (start) {

            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WIDTH, WIDTH);

            g.setColor(Color.WHITE);
            g.setStroke(new BasicStroke(5f));
            g.drawLine(WIDTH / 2 - 100, 100, WIDTH / 2 - 100, HEIGHT - 100);

            g.setColor(Color.WHITE);
            g.drawLine(WIDTH / 2 + 100, 100, WIDTH / 2 + 100, HEIGHT - 100);

            g.setColor(Color.WHITE);
            g.drawLine(WIDTH - 100, HEIGHT / 2 - 100, 100, HEIGHT / 2 - 100);
            g.setColor(Color.WHITE);
            g.drawLine(WIDTH - 100, HEIGHT / 2 + 100, 100, HEIGHT / 2 + 100);
        }

        g.setFont(new Font("Arial", 1, 30));
        g.drawString("Jugador 1: X \t Jugador 2: O", WIDTH / 2 - 200, 40);

        if (cuadro == 0 && jugador == 1) {

            g.setColor(Color.WHITE);
            g.setStroke(new BasicStroke(2f));
            g.drawLine(250, 250, 90, 100);

            g.setColor(Color.WHITE);
            g.setStroke(new BasicStroke(2f));
            g.drawLine(250, 100, 100, 250);

        }

        if (cuadro == 0 && jugador == 2) {

            g.setColor(Color.WHITE);
            g.setStroke(new BasicStroke(2f));
            g.drawOval(150, 130, 100, 120);

        }

        if (cuadro == 1 && jugador == 1) {

            g.setColor(Color.WHITE);
            g.setStroke(new BasicStroke(2f));
            g.drawLine(250, 250, 600, 300);

            g.setColor(Color.WHITE);
            g.setStroke(new BasicStroke(2f));
            g.drawLine(250, 100, 400, 250);

        }

    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {

        int id = ke.getKeyCode();

        if (id == KeyEvent.VK_SPACE) {

            start = true;
            gameStatus = 2;
        }

    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

}
