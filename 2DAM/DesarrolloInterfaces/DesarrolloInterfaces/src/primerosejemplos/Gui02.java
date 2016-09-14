package primerosejemplos;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

//FlowLayout

public class Gui02 extends JFrame{

    public Gui02() {
        
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
        for (int i = 0; i < 10; i++) {
            add(new JButton("Componente " + i));
        }
        
        setSize(300, 300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        Gui02 aplicacion = new Gui02();
    }
}
