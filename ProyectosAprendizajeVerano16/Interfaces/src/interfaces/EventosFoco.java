/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Lucas
 */
public class EventosFoco {
    public static EventosFoco eventosFoco;
    
    public Foco foco;
    
    public EventosFoco(){
        JFrame jframe = new JFrame();
        foco = new Foco();
        
        jframe.setSize(800, 800);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
        jframe.setResizable(false);
        jframe.add(foco);
        
    }
    public static void main(String[] args) {
        eventosFoco = new EventosFoco();
    }
}

class Foco extends JPanel{
        
    JTextField cuadro = new JTextField(); //TextBOX
    JTextField cuadro2 = new JTextField();
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        setLayout(null); //Quitar donde se pone los elementos por defecto
        
        cuadro = new JTextField(); 
        cuadro2 = new JTextField();
        
        cuadro.setBounds(120, 10, 150, 20);
        
        cuadro2.setBounds(120, 50, 150, 20);
        
        add(cuadro);
        add(cuadro2);
        
        LanzaFoco lanzaFoco = new LanzaFoco();
        
        cuadro.addFocusListener(lanzaFoco);
        cuadro2.addFocusListener(lanzaFoco);
    }
    
    class LanzaFoco implements FocusListener{
        
        @Override
        public void focusGained(FocusEvent fe) { //Si gana el foco
            //System.out.println("Has ganado el foco");
        }

        @Override
        public void focusLost(FocusEvent fe) { //Si pierde el foco
            //System.out.println("He perdido el foco");
            
            String email = cuadro.getText(); //Almacena el texto
            boolean comprobacion = false;
            
            for (int i = 0; i < email.length(); i++) {
                if (email.charAt(i) == '@') {
                    comprobacion = true;
                }
            }
            
            if (!comprobacion) {
                System.out.println("Error al introducir email");
            }
            else{
                System.out.println("Correcto");
            }
            
        }
    
    }

}


