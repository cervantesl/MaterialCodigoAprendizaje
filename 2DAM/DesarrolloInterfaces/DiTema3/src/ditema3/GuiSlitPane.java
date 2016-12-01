/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ditema3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author Lucas
 */
public class GuiSlitPane {

    JSplitPane split;

    JPanel panelIzquierdo;
    JPanel panelDerecho;

    public GuiSlitPane() {
        JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        split = new JSplitPane();
        split.setOneTouchExpandable(true);

        frame.add(split);

        panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new BorderLayout());
        JList<String> lista = new JList();
        DefaultListModel listModel = new DefaultListModel();

        listModel.addElement("1");
        listModel.addElement("2");
        listModel.addElement("3");

        lista.setModel(listModel);
        panelIzquierdo.add(lista, BorderLayout.CENTER);

        split.setLeftComponent(panelIzquierdo);

        panelDerecho = new JPanel(new BorderLayout());
        final JLabel label = new JLabel();
        
        lista.addListSelectionListener((ListSelectionEvent lse) -> {
            if (!lse.getValueIsAdjusting()) {
                String id = lista.getSelectedValue();
                int i = Integer.parseInt(id);
                ImageIcon icono;
                switch(i) {
                    case 1:
                        icono = new ImageIcon(getClass().getResource("/recursos/pig.png"));
                        System.out.println(i);
                        label.setIcon(icono);
                        break;
                    case 2:
                        icono = new ImageIcon(getClass().getResource("/recursos/pig.png"));
                        System.out.println(i);
                        label.setIcon(icono);
                        break;
                }
                
            }
        });

        panelDerecho.add(label, BorderLayout.CENTER);

        split.setRightComponent(panelDerecho);

        frame.pack();
    }

    public static void main(String[] args) {
        GuiSlitPane s = new GuiSlitPane();

    }
}
