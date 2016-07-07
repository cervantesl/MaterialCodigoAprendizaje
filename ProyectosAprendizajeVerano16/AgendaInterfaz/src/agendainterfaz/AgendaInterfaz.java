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
public class AgendaInterfaz {

   public static AgendaInterfaz agenda;
   
   public AgendaInterfaz(){
       JFrame jframe = new JFrame();
       jframe.setSize(600, 900);
       jframe.setVisible(true);
       jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       jframe.setLocation(200, 100);
       jframe.setResizable(false);
       jframe.setTitle("Agenda");
   }
   
    public static void main(String[] args) {
        agenda = new AgendaInterfaz();
    }
    
}
