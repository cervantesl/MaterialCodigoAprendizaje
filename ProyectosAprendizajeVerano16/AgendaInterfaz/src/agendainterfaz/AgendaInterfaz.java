/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendainterfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author Lucas
 */
public class AgendaInterfaz{

    public static void main(String[] args) {
        Marco agenda = new Marco();
        
        agenda.setVisible(true);
        agenda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
