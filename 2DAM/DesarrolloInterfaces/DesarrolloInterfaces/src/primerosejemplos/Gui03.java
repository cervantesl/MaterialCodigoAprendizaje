package primerosejemplos;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Gui03 extends JFrame{
    
    public Gui03() {
        setLayout(new BorderLayout(5,10));
        
        add(new JButton("1"), BorderLayout.EAST);
        add(new JButton("2"), BorderLayout.SOUTH);
        add(new JButton("3"), BorderLayout.WEST);
        add(new JButton("4"), BorderLayout.NORTH);
        add(new JButton("5"), BorderLayout.CENTER);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(200, 200);
    }
    
    public static void main(String[] args) {
        Gui03 aplicacion = new Gui03();
    }
}
