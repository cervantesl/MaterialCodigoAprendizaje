/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ditema3;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Lucas
 */
public class MultiplesPaneles extends JFrame {

    ArrayList<JPanel> paneles;
    int indice = 0;
    JPanel panelPrincipal;
    JLabel panelActualLabel;

    public MultiplesPaneles() {

        paneles = new ArrayList<JPanel>();

        panelActualLabel = new JLabel("Estas en el Panel 1");
        panelActualLabel.setFont(new Font("Verdana", Font.BOLD, 14));

        for (int i = 0; i < 10; i++) {
            JPanel p = new JPanel();
            p.setLayout(new BorderLayout());
            JButton bsiguiente = new JButton("Siguiente");
            bsiguiente.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (indice < 9) {
                        indice++;
                        panelPrincipal.removeAll();
                        panelPrincipal.add(paneles.get(indice));
                        panelActualLabel.setText("Estas en el Panel " + (indice + 1));

                        JPanel petiqueta = new JPanel();
                        petiqueta.add(panelActualLabel);
                        panelPrincipal.add(petiqueta, BorderLayout.SOUTH);
                        
                        SuperficieDibujoPanel s = new SuperficieDibujoPanel();
                        panelPrincipal.add(s, BorderLayout.SOUTH);

                        panelPrincipal.updateUI();
                        panelPrincipal.repaint();
                        repaint();
                    }
                }

            });

            JButton batras = new JButton("Atras");
            batras.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (indice > 0) {
                        indice--;
                        panelPrincipal.removeAll();
                        panelPrincipal.add(paneles.get(indice));
                        panelActualLabel.setText("Estas en el Panel " + (indice + 1));
                        JPanel petiqueta = new JPanel();
                        petiqueta.add(panelActualLabel);
                        panelPrincipal.add(petiqueta, BorderLayout.SOUTH);
                        panelPrincipal.updateUI();
                        panelPrincipal.repaint();
                    }
                }

            });

            JPanel pbotones = new JPanel();

            pbotones.add(batras);
            pbotones.add(bsiguiente);

            p.add(pbotones, BorderLayout.NORTH);


            
            SuperficieDibujo s = new SuperficieDibujo();
            
            p.add(s, BorderLayout.CENTER);
            paneles.add(p);
        }

        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(paneles.get(0), BorderLayout.CENTER);
        JPanel petiqueta = new JPanel();
        petiqueta.add(panelActualLabel);
        panelPrincipal.add(petiqueta, BorderLayout.SOUTH);
        add(panelPrincipal);

        setVisible(true);
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        MultiplesPaneles p = new MultiplesPaneles();

    }
}

class SuperficieDibujoPanel extends JPanel {
    
    public JTextField f;

    public SuperficieDibujoPanel() {
        setLayout(new BorderLayout());
        f = new JTextField();
        f.setText("1");
        add(f, BorderLayout.CENTER);
    }
}
