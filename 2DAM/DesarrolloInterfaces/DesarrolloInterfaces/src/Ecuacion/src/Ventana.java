
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ventana extends JFrame implements ActionListener {

	public SuperficieDibujo sd;

	JTextField campoA;
	JTextField campoB;
	JTextField campoC;

	ArrayList<Nodo> puntosEje = new ArrayList<Nodo>();

	public Ventana() {
		setLayout(new GridBagLayout());

		GridBagConstraints constrains = new GridBagConstraints();

		JLabel valorA = new JLabel("Valor A: ");

		constrains.gridx = 0;
		constrains.gridy = 0;

		constrains.gridwidth = 1;
		constrains.gridheight = 1;

		add(valorA, constrains);

		campoA = new JTextField(5);

		constrains.gridx = 1;
		constrains.gridy = 0;

		constrains.gridwidth = 1;
		constrains.gridheight = 1;

		constrains.weightx = 1.0;

		constrains.fill = GridBagConstraints.VERTICAL;

		add(campoA, constrains);

		JLabel valorB = new JLabel("Valor B: ");

		constrains.gridx = 2;
		constrains.gridy = 0;

		constrains.gridwidth = 1;
		constrains.gridheight = 1;

		add(valorB, constrains);

		campoB = new JTextField(5);

		constrains.gridx = 3;
		constrains.gridy = 0;

		constrains.gridwidth = 1;
		constrains.gridheight = 1;

		constrains.weightx = 1.0;

		constrains.fill = GridBagConstraints.VERTICAL;

		add(campoB, constrains);

		JLabel valorC = new JLabel("Valor C: ");

		constrains.gridx = 4;
		constrains.gridy = 0;

		constrains.gridwidth = 1;
		constrains.gridheight = 1;

		add(valorC, constrains);

		campoC = new JTextField(5);

		constrains.gridx = 5;
		constrains.gridy = 0;

		constrains.gridwidth = 1;
		constrains.gridheight = 1;

		constrains.weightx = 1.0;

		constrains.fill = GridBagConstraints.VERTICAL;

		add(campoC, constrains);

		sd = new SuperficieDibujo();

		constrains.gridx = 0;
		constrains.gridy = 1;

		constrains.gridwidth = 6;
		constrains.gridheight = 1;

		constrains.weighty = 1.0;

		constrains.fill = GridBagConstraints.BOTH;

		constrains.anchor = GridBagConstraints.SOUTH;

		add(sd, constrains);

		constrains.weighty = 0.0;

		JButton botonCalcular = new JButton("Calcular");

		constrains.gridx = 0;
		constrains.gridy = 2;

		constrains.gridwidth = 6;
		constrains.gridheight = 1;

		constrains.weightx = 1.0;

		constrains.fill = GridBagConstraints.HORIZONTAL;

		add(botonCalcular, constrains);

		botonCalcular.addActionListener(this);

		setVisible(true);
		setBounds(700, 200, 700, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		puntosEje = sd.calcularPuntos(obtenerCampoA(), obtenerCampoB(), obtenerCampoC());
		pintar(sd.getGraphics(), puntosEje);

	}

	public void pintar(Graphics g, ArrayList<Nodo> puntosEje) {
		sd.pintarEncuacion(g, puntosEje);
	}

	public int obtenerCampoA() {
		return Integer.parseInt(campoA.getText());
	}

	public int obtenerCampoB() {
		return Integer.parseInt(campoB.getText());
	}

	public int obtenerCampoC() {
		return Integer.parseInt(campoC.getText());
	}
}
