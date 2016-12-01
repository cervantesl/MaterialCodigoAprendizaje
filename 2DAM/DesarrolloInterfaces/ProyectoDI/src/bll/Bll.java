/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dao.Dao;
import dao.Excepciones;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import vista.SuperficieDibujo;
import vista.VentanaPrincipal;

/**
 *
 * @author Lucas
 */
public class Bll {

    static ArrayList<Nodo> puntosEje = new ArrayList<>();
    static SuperficieDibujo sd = new SuperficieDibujo();
    static ImageIcon imagen;

    public static void autentificarse(String usuario, String password) throws Excepciones {
        Dao.autentificarse(usuario, password);
    }

    public static void calculadora() {
        VentanaPrincipal.botonNum1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                VentanaPrincipal.campoCalculadora.setText(VentanaPrincipal.campoCalculadora.getText() + "1");
            }

        });
        VentanaPrincipal.b0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                VentanaPrincipal.campoCalculadora.setText(VentanaPrincipal.campoCalculadora.getText() + "0");
            }

        });
        VentanaPrincipal.b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                VentanaPrincipal.campoCalculadora.setText(VentanaPrincipal.campoCalculadora.getText() + "2");
            }
        });
        VentanaPrincipal.b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                VentanaPrincipal.campoCalculadora.setText(VentanaPrincipal.campoCalculadora.getText() + "3");
            }

        });
        VentanaPrincipal.b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                VentanaPrincipal.campoCalculadora.setText(VentanaPrincipal.campoCalculadora.getText() + "4");
            }

        });
        VentanaPrincipal.b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                VentanaPrincipal.campoCalculadora.setText(VentanaPrincipal.campoCalculadora.getText() + "5");
            }

        });
        VentanaPrincipal.b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                VentanaPrincipal.campoCalculadora.setText(VentanaPrincipal.campoCalculadora.getText() + "6");
            }

        });
        VentanaPrincipal.b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                VentanaPrincipal.campoCalculadora.setText(VentanaPrincipal.campoCalculadora.getText() + "7");
            }

        });
        VentanaPrincipal.b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                VentanaPrincipal.campoCalculadora.setText(VentanaPrincipal.campoCalculadora.getText() + "8");
            }

        });
        VentanaPrincipal.b9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                VentanaPrincipal.campoCalculadora.setText(VentanaPrincipal.campoCalculadora.getText() + "9");
            }

        });
        VentanaPrincipal.bMenos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                VentanaPrincipal.campoCalculadora.setText(VentanaPrincipal.campoCalculadora.getText() + "-");
            }

        });
        VentanaPrincipal.bMas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                VentanaPrincipal.campoCalculadora.setText(VentanaPrincipal.campoCalculadora.getText() + "+");
            }

        });
        VentanaPrincipal.bMult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                VentanaPrincipal.campoCalculadora.setText(VentanaPrincipal.campoCalculadora.getText() + "*");
            }

        });
        VentanaPrincipal.bPunto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                VentanaPrincipal.campoCalculadora.setText(VentanaPrincipal.campoCalculadora.getText() + ".");
            }

        });
    }

    public static void añadirElementosComboBox() {
        VentanaPrincipal.añadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String dato = VentanaPrincipal.campoElementoPelicula.getText().trim();
                VentanaPrincipal.cbElementosPeliculas.addItem(dato);
            }
        });
    }

    public static void cambiarEstadoSlider() {
        VentanaPrincipal.slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                JSlider source = (JSlider) ce.getSource();
                if (!source.getValueIsAdjusting()) {
                    int fps = (int) source.getValue();
                    VentanaPrincipal.campoSlider.setText("" + fps);
                }
            }
        });
    }

    public static void calcularGrafica() {
        VentanaPrincipal.botonCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                puntosEje = sd.calcularPuntos(obtenerCampoA(), obtenerCampoB(), obtenerCampoC());
                pintar(sd.getGraphics(), puntosEje);
            }
        });
    }

    public static void espejo() {
        VentanaPrincipal.cbOpcion4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                VentanaPrincipal.cbOpcion4Espejo.setSelected(VentanaPrincipal.cbOpcion4.isSelected());
            }
        });

        VentanaPrincipal.cb5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                VentanaPrincipal.cb5Espejo.setSelected(VentanaPrincipal.cb5.isSelected());
            }
        });

        VentanaPrincipal.cb6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                VentanaPrincipal.cb6Espejo.setSelected(VentanaPrincipal.cb6.isSelected());
            }
        });

        VentanaPrincipal.rb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                VentanaPrincipal.rb1Espejo.setSelected(VentanaPrincipal.rb1.isSelected());
            }
        });
        VentanaPrincipal.rb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                VentanaPrincipal.rb2Espejo.setSelected(VentanaPrincipal.rb2.isSelected());
            }
        });
        VentanaPrincipal.rb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                VentanaPrincipal.rb3Espejo.setSelected(VentanaPrincipal.rb3.isSelected());
            }
        });

        VentanaPrincipal.tf1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                VentanaPrincipal.tfEspejo.setText(VentanaPrincipal.tf1.getText());
            }

            @Override
            public void focusLost(FocusEvent fe) {

            }
        });

        VentanaPrincipal.cb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                VentanaPrincipal.cb1Espejo.setSelectedItem(VentanaPrincipal.cb1.getSelectedItem());
            }
        });

        VentanaPrincipal.jSpinner1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                VentanaPrincipal.jSpinner1Espejo.setValue(VentanaPrincipal.jSpinner1.getValue());
            }
        });

    }

    public static void checkBox() {

        /*
        *Se que hay otra manera mas eficiente utilizando los titulos de las imagenes
        *y algunos metodos como StringBuffer. Pero esta es la manera como he pensado yo.
         */
        imagen = new ImageIcon(Bll.class.getResource("/imagenes/geek-----.gif"));

        VentanaPrincipal.jLabel17.setIcon(imagen);

        VentanaPrincipal.chin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) { //2
                if (VentanaPrincipal.chin.isSelected()
                        && !VentanaPrincipal.glasses.isSelected()
                        && !VentanaPrincipal.hair.isSelected()
                        && !VentanaPrincipal.teeth.isSelected()) {
                    imagen = new ImageIcon(Bll.class.getResource("/imagenes/geek-c---.gif"));
                    VentanaPrincipal.jLabel17.setIcon(imagen);
                }
                if (VentanaPrincipal.chin.isSelected() //3
                        && VentanaPrincipal.glasses.isSelected()
                        && !VentanaPrincipal.hair.isSelected()
                        && !VentanaPrincipal.teeth.isSelected()) {
                    imagen = new ImageIcon(Bll.class.getResource("/imagenes/geek-cg--.gif"));
                    VentanaPrincipal.jLabel17.setIcon(imagen);
                }
                if (VentanaPrincipal.chin.isSelected() //4
                        && VentanaPrincipal.glasses.isSelected()
                        && VentanaPrincipal.hair.isSelected()
                        && !VentanaPrincipal.teeth.isSelected()) {
                    imagen = new ImageIcon(Bll.class.getResource("/imagenes/geek-cgh-.gif"));
                    VentanaPrincipal.jLabel17.setIcon(imagen);
                }
                if (VentanaPrincipal.chin.isSelected() //5
                        && VentanaPrincipal.glasses.isSelected()
                        && VentanaPrincipal.hair.isSelected()
                        && VentanaPrincipal.teeth.isSelected()) {
                    imagen = new ImageIcon(Bll.class.getResource("/imagenes/geek-cght.gif"));
                    VentanaPrincipal.jLabel17.setIcon(imagen);
                }
                if (VentanaPrincipal.chin.isSelected() //12
                        && !VentanaPrincipal.glasses.isSelected()
                        && !VentanaPrincipal.hair.isSelected()
                        && VentanaPrincipal.teeth.isSelected()) {
                    imagen = new ImageIcon(Bll.class.getResource("/imagenes/geek-c--t.gif"));
                    VentanaPrincipal.jLabel17.setIcon(imagen);
                }
                if (VentanaPrincipal.chin.isSelected() //13
                        && !VentanaPrincipal.glasses.isSelected()
                        && VentanaPrincipal.hair.isSelected()
                        && !VentanaPrincipal.teeth.isSelected()) {
                    imagen = new ImageIcon(Bll.class.getResource("/imagenes/geek-c-h-.gif"));
                    VentanaPrincipal.jLabel17.setIcon(imagen);
                }
                if (VentanaPrincipal.chin.isSelected() //15
                        && !VentanaPrincipal.glasses.isSelected()
                        && VentanaPrincipal.hair.isSelected()
                        && VentanaPrincipal.teeth.isSelected()) {
                    imagen = new ImageIcon(Bll.class.getResource("/imagenes/geek-c-ht.gif"));
                    VentanaPrincipal.jLabel17.setIcon(imagen);
                }
                if (VentanaPrincipal.chin.isSelected() //16
                        && VentanaPrincipal.glasses.isSelected()
                        && !VentanaPrincipal.hair.isSelected()
                        && VentanaPrincipal.teeth.isSelected()) {
                    imagen = new ImageIcon(Bll.class.getResource("/imagenes/geek-cg-t.gif"));
                    VentanaPrincipal.jLabel17.setIcon(imagen);
                }

            }
        });

        VentanaPrincipal.glasses.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) { //3
                if (VentanaPrincipal.glasses.isSelected()
                        && VentanaPrincipal.chin.isSelected()
                        && !VentanaPrincipal.hair.isSelected()
                        && !VentanaPrincipal.teeth.isSelected()) {
                    imagen = new ImageIcon(Bll.class.getResource("/imagenes/geek-cg--.gif"));
                    VentanaPrincipal.jLabel17.setIcon(imagen);
                }
                if (VentanaPrincipal.glasses.isSelected() //4
                        && VentanaPrincipal.chin.isSelected()
                        && VentanaPrincipal.hair.isSelected()
                        && !VentanaPrincipal.teeth.isSelected()) {
                    imagen = new ImageIcon(Bll.class.getResource("/imagenes/geek-cgh-.gif"));
                    VentanaPrincipal.jLabel17.setIcon(imagen);
                }
                if (VentanaPrincipal.glasses.isSelected() //5
                        && VentanaPrincipal.chin.isSelected()
                        && VentanaPrincipal.hair.isSelected()
                        && VentanaPrincipal.teeth.isSelected()) {
                    imagen = new ImageIcon(Bll.class.getResource("/imagenes/geek-cght.gif"));
                    VentanaPrincipal.jLabel17.setIcon(imagen);
                }
                if (VentanaPrincipal.glasses.isSelected() //6
                        && !VentanaPrincipal.chin.isSelected()
                        && !VentanaPrincipal.hair.isSelected()
                        && !VentanaPrincipal.teeth.isSelected()) {
                    imagen = new ImageIcon(Bll.class.getResource("/imagenes/geek--g--.gif"));
                    VentanaPrincipal.jLabel17.setIcon(imagen);
                }
                if (VentanaPrincipal.glasses.isSelected()//7
                        && !VentanaPrincipal.chin.isSelected()
                        && VentanaPrincipal.hair.isSelected()
                        && !VentanaPrincipal.teeth.isSelected()) {
                    imagen = new ImageIcon(Bll.class.getResource("/imagenes/geek--gh-.gif"));
                    VentanaPrincipal.jLabel17.setIcon(imagen);
                }
                if (VentanaPrincipal.glasses.isSelected() //8
                        && !VentanaPrincipal.chin.isSelected()
                        && VentanaPrincipal.hair.isSelected()
                        && VentanaPrincipal.teeth.isSelected()) {
                    imagen = new ImageIcon(Bll.class.getResource("/imagenes/geek--ght.gif"));
                    VentanaPrincipal.jLabel17.setIcon(imagen);
                }
                if (VentanaPrincipal.glasses.isSelected() //14
                        && !VentanaPrincipal.chin.isSelected()
                        && !VentanaPrincipal.hair.isSelected()
                        && VentanaPrincipal.teeth.isSelected()) {
                    imagen = new ImageIcon(Bll.class.getResource("/imagenes/geek--g-t.gif"));
                    VentanaPrincipal.jLabel17.setIcon(imagen);
                }
                if (VentanaPrincipal.glasses.isSelected() //16
                        && VentanaPrincipal.chin.isSelected()
                        && !VentanaPrincipal.hair.isSelected()
                        && VentanaPrincipal.teeth.isSelected()) {
                    imagen = new ImageIcon(Bll.class.getResource("/imagenes/geek-cg-t.gif"));
                    VentanaPrincipal.jLabel17.setIcon(imagen);
                }
            }
        });

        VentanaPrincipal.hair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) { //4
                if (VentanaPrincipal.hair.isSelected()
                        && VentanaPrincipal.chin.isSelected()
                        && VentanaPrincipal.glasses.isSelected()
                        && !VentanaPrincipal.teeth.isSelected()) {
                    imagen = new ImageIcon(Bll.class.getResource("/imagenes/geek-cgh-.gif"));
                    VentanaPrincipal.jLabel17.setIcon(imagen);
                }
                if (VentanaPrincipal.hair.isSelected() //5
                        && VentanaPrincipal.chin.isSelected()
                        && VentanaPrincipal.glasses.isSelected()
                        && VentanaPrincipal.teeth.isSelected()) {
                    imagen = new ImageIcon(Bll.class.getResource("/imagenes/geek-cght.gif"));
                    VentanaPrincipal.jLabel17.setIcon(imagen);
                }
                if (VentanaPrincipal.hair.isSelected()//7
                        && !VentanaPrincipal.chin.isSelected()
                        && VentanaPrincipal.glasses.isSelected()
                        && !VentanaPrincipal.teeth.isSelected()) {
                    imagen = new ImageIcon(Bll.class.getResource("/imagenes/geek--gh-.gif"));
                    VentanaPrincipal.jLabel17.setIcon(imagen);
                }
                if (VentanaPrincipal.hair.isSelected() //8
                        && !VentanaPrincipal.chin.isSelected()
                        && VentanaPrincipal.glasses.isSelected()
                        && VentanaPrincipal.teeth.isSelected()) {
                    imagen = new ImageIcon(Bll.class.getResource("/imagenes/geek--ght.gif"));
                    VentanaPrincipal.jLabel17.setIcon(imagen);
                }
                if (VentanaPrincipal.hair.isSelected() //9
                        && !VentanaPrincipal.chin.isSelected()
                        && !VentanaPrincipal.glasses.isSelected()
                        && !VentanaPrincipal.teeth.isSelected()) {
                    imagen = new ImageIcon(Bll.class.getResource("/imagenes/geek---h-.gif"));
                    VentanaPrincipal.jLabel17.setIcon(imagen);
                }
                if (VentanaPrincipal.hair.isSelected() //10
                        && !VentanaPrincipal.chin.isSelected()
                        && !VentanaPrincipal.glasses.isSelected()
                        && VentanaPrincipal.teeth.isSelected()) {
                    imagen = new ImageIcon(Bll.class.getResource("/imagenes/geek---ht.gif"));
                    VentanaPrincipal.jLabel17.setIcon(imagen);
                }
                if (VentanaPrincipal.hair.isSelected() //13
                        && VentanaPrincipal.chin.isSelected()
                        && !VentanaPrincipal.glasses.isSelected()
                        && !VentanaPrincipal.teeth.isSelected()) {
                    imagen = new ImageIcon(Bll.class.getResource("/imagenes/geek-c-h-.gif"));
                    VentanaPrincipal.jLabel17.setIcon(imagen);
                }
                if (VentanaPrincipal.hair.isSelected() //15
                        && VentanaPrincipal.chin.isSelected()
                        && !VentanaPrincipal.glasses.isSelected()
                        && VentanaPrincipal.teeth.isSelected()) {
                    imagen = new ImageIcon(Bll.class.getResource("/imagenes/geek-c-ht.gif"));
                    VentanaPrincipal.jLabel17.setIcon(imagen);
                }

            }
        });

        VentanaPrincipal.teeth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) { //5
                if (VentanaPrincipal.teeth.isSelected()
                        && VentanaPrincipal.chin.isSelected()
                        && VentanaPrincipal.glasses.isSelected()
                        && VentanaPrincipal.hair.isSelected()) {
                    imagen = new ImageIcon(Bll.class.getResource("/imagenes/geek-cght.gif"));
                    VentanaPrincipal.jLabel17.setIcon(imagen);
                }
                if (VentanaPrincipal.teeth.isSelected() //8
                        && !VentanaPrincipal.chin.isSelected()
                        && VentanaPrincipal.glasses.isSelected()
                        && VentanaPrincipal.hair.isSelected()) {
                    imagen = new ImageIcon(Bll.class.getResource("/imagenes/geek--ght.gif"));
                    VentanaPrincipal.jLabel17.setIcon(imagen);
                }
                if (VentanaPrincipal.teeth.isSelected() //10
                        && !VentanaPrincipal.chin.isSelected()
                        && !VentanaPrincipal.glasses.isSelected()
                        && VentanaPrincipal.hair.isSelected()) {
                    imagen = new ImageIcon(Bll.class.getResource("/imagenes/geek---ht.gif"));
                    VentanaPrincipal.jLabel17.setIcon(imagen);
                }
                if (VentanaPrincipal.teeth.isSelected() //11
                        && !VentanaPrincipal.chin.isSelected()
                        && !VentanaPrincipal.glasses.isSelected()
                        && !VentanaPrincipal.hair.isSelected()) {
                    imagen = new ImageIcon(Bll.class.getResource("/imagenes/geek----t.gif"));
                    VentanaPrincipal.jLabel17.setIcon(imagen);
                }
                if (VentanaPrincipal.teeth.isSelected() //12
                        && VentanaPrincipal.chin.isSelected()
                        && !VentanaPrincipal.glasses.isSelected()
                        && !VentanaPrincipal.hair.isSelected()) {
                    imagen = new ImageIcon(Bll.class.getResource("/imagenes/geek-c--t.gif"));
                    VentanaPrincipal.jLabel17.setIcon(imagen);
                }
                if (VentanaPrincipal.teeth.isSelected() //14
                        && !VentanaPrincipal.chin.isSelected()
                        && VentanaPrincipal.glasses.isSelected()
                        && !VentanaPrincipal.hair.isSelected()) {
                    imagen = new ImageIcon(Bll.class.getResource("/imagenes/geek--g-t.gif"));
                    VentanaPrincipal.jLabel17.setIcon(imagen);
                }
                if (VentanaPrincipal.teeth.isSelected() //15
                        && VentanaPrincipal.chin.isSelected()
                        && !VentanaPrincipal.glasses.isSelected()
                        && VentanaPrincipal.hair.isSelected()) {
                    imagen = new ImageIcon(Bll.class.getResource("/imagenes/geek-c-ht.gif"));
                    VentanaPrincipal.jLabel17.setIcon(imagen);
                }
                if (VentanaPrincipal.teeth.isSelected() //16
                        && VentanaPrincipal.chin.isSelected()
                        && VentanaPrincipal.glasses.isSelected()
                        && !VentanaPrincipal.hair.isSelected()) {
                    imagen = new ImageIcon(Bll.class.getResource("/imagenes/geek-cg-t.gif"));
                    VentanaPrincipal.jLabel17.setIcon(imagen);
                }

            }
        });

    }

    public static void pintar(Graphics g, ArrayList<Nodo> puntosEje) {
        sd.pintarEncuacion(g, puntosEje);
    }

    public static int obtenerCampoA() {
        return Integer.parseInt(VentanaPrincipal.campoA.getText());
    }

    public static int obtenerCampoB() {
        return Integer.parseInt(VentanaPrincipal.campoB.getText());
    }

    public static int obtenerCampoC() {
        return Integer.parseInt(VentanaPrincipal.campoC.getText());
    }
}
