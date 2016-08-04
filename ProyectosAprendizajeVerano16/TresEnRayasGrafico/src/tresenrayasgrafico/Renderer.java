/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresenrayasgrafico;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author Lucas
 */
public class Renderer extends JPanel {
    
    @Override
    protected void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        TresEnRayasGrafico.tenrg.render((Graphics2D) g);
    }
}
