/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Lucas
 */
public class Interfaz {
    public static Interfaz interfaz;
    
    public int width = 700, height = 700;

    
    public Interfaz (){
        JFrame jframe = new JFrame("Primer marco");
        jframe.setSize(width,height);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLocation(500, 300); //Posicion donde saldra la ventana
        jframe.setResizable(true); //Redimensionar la ventana o no
        //jframe.setExtendedState(Frame.MAXIMIZED_BOTH);//Para que se abra a pantalla completa
        jframe.setTitle("Agenda"); //Nombre de la ventana

        //=========================================
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Dimension tamañoPantalla = miPantalla.getScreenSize(); //Almacenamos el tamaño pantalla

        //Estas dos variables se puede utilizar en setSize para colocarlo en algun punto especifico dependiendo de la pantalla
        int alturaPantalla = tamañoPantalla.height;
        int anchoPantalla = tamañoPantalla.width;

        //=========================================
        //Image icono = miPantalla.getImage("icono.png"); //Para cambiar el icono de la ventana
        //jframe.setIconImage(icono); //Establecer el icono
        
        //============
        Lamina lamina = new Lamina();
        jframe.add(lamina);
        
        

    }
    
    public class Lamina extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawString("Prueba escribir en una lamina", 100, 100); //Escribir
            g.drawRect(50, 50, 200, 200); //Dibujar un cuadrado
            g.drawLine(100, 100, 300, 200); //Dibujar linea
            g.drawArc(50, 100, 200, 200, 120, 150);
            g.setColor(Color.RED);
        }
    }
            
    public static void main(String[] args) {
        interfaz = new Interfaz();
        
        

    }

    
    
}
