/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Lucas
 */
public class SuperficieDibujo extends JPanel{
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        banco.Banco.pintar(g);
    }
}
