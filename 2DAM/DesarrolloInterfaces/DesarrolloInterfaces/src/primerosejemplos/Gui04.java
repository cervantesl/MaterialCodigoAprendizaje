/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerosejemplos;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Lucas
 */
public class Gui04 extends JFrame{
    
    public Gui04() {
        setTitle("Horno microondas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //El frame sera un borderLayout
        setLayout(new BorderLayout());
        
        //p1 sera un gridLayout
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(4,3));//Fila y columnas
        
        for (int i = 1; i <= 9; i++) {
            p1.add(new JButton("" + i));
        }
        
        p1.add(new JButton("" + 0));
        p1.add(new JButton("Start"));
        p1.add(new JButton("Stop"));
        
        
        JPanel p2 = new JPanel();
        p2.setLayout(new BorderLayout());
        p2.add(new JTextField("Aqui el tiempo"), BorderLayout.NORTH);
        p2.add(p1, BorderLayout.CENTER);
        
        add(p2, BorderLayout.EAST);
        add(new Button("Aqui la comida"), BorderLayout.CENTER);
        
        setSize(400, 250);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        Gui04 app = new Gui04();
    }
}
