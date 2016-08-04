/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Lucas
 */
public class Imagenes {

    public static Imagenes imagenes;
    public static Renderer renderer;
    public final int WIDTH = 500, HEIGHT = 500;
    
    
    public Imagenes(){
        JFrame jframe = new JFrame("Imagen");
        
        jframe.setSize(WIDTH, HEIGHT);
        jframe.setVisible(true);
        jframe.setResizable(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        renderer = new Renderer();
        
        jframe.add(renderer);
    }
    public static void main(String[] args) {
        imagenes = new Imagenes();
    }
}

 class Renderer extends JPanel{
    private Image imagen;
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        File miImagen = new File("src/interfaces/imagen.jpg");
        try {
            imagen = ImageIO.read(miImagen);
        } catch (Exception e) {
            System.out.println("La imagen no se encuentra");
        }
        
        g.drawImage(imagen, 20, 20, null);
        
        //g.copyArea(WIDTH, WIDTH, WIDTH, WIDTH, WIDTH, WIDTH); Sirve para coopiar la imagen en varios sitios
        
        //getWidth y getHeight sirve para saber el tamaño de una imagen
    }
    
}
