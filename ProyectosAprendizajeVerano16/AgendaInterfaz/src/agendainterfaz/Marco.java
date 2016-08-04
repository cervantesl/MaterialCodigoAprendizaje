/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendainterfaz;

import javax.swing.JFrame;

/**
 *
 * @author Lucas
 */
public class Marco extends JFrame{
    public Marco(){
        setTitle("Agenda - Lucas Cervantes");
        setBounds(300, 600, 500, 550);
        
        Lamina lamina = new Lamina();
        add(lamina);
    }
}
