package vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public final class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;

	public static final int ANCHO = 700;
	public static final int ALTO = 700;

	public SuperficieDibujo sd;

	public Ventana() {
		setLayout(new BorderLayout());

		sd = new SuperficieDibujo();
		add(sd, BorderLayout.CENTER);

		setSize(ANCHO, ALTO);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

	}
}
