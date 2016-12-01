package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;

import bll.SopaBll;

public final class SuperficieDibujo extends JPanel implements ActionListener {

	private JButton[] casillasLetras;
	private JList<String> listaPalabrasValidas;
	private JList<String> listaPalabrasEncontradas;
	private JButton calcular;
	private DefaultListModel<String> model;
	private DefaultListModel<String> model2;

	private String[] palabrasValidas;
	private ArrayList<String> palabrasEncontradas;
	private String[][] letras;

	private JButton siguiente;
	private JButton retroceder;

	public static int numeroArchivo = 1;

	public SuperficieDibujo() {
		setLayout(new BorderLayout());

		// TABLA SOPALETRAS
		JPanel panelCasillas = new JPanel(
				new GridLayout(SopaBll.obtenerLadoMatrizLetras(), SopaBll.obtenerLadoMatrizLetras()));

		letras = SopaBll.leerLetras();

		casillasLetras = new JButton[SopaBll.obtenerLadoMatrizLetras() * SopaBll.obtenerLadoMatrizLetras()];
		for (int y = 0; y < SopaBll.obtenerLadoMatrizLetras(); y++) {
			for (int x = 0; x < SopaBll.obtenerLadoMatrizLetras(); x++) {
				panelCasillas
						.add(casillasLetras[x + y * SopaBll.obtenerLadoMatrizLetras()] = new JButton(letras[y][x]));
			}
		}

		add(panelCasillas, BorderLayout.NORTH);

		// LISTA PALABRAS VALIDAS
		palabrasValidas = SopaBll.leerPalabrasValidas();
		model = new DefaultListModel<>();

		for (int i = 0; i < palabrasValidas.length; i++) {
			model.addElement(palabrasValidas[i]);
		}
		listaPalabrasValidas = new JList<>(model);
		add(listaPalabrasValidas, BorderLayout.WEST);

		model2 = new DefaultListModel<>();
		palabrasEncontradas = new ArrayList<>();

		listaPalabrasEncontradas = new JList<>(model2);
		add(listaPalabrasEncontradas, BorderLayout.EAST);

		// BOTON
		calcular = new JButton("Calcular");
		add(calcular, BorderLayout.SOUTH);

		calcular.addActionListener(this);

		// BOTONES RETROCEDER Y SIGUIENTE
		siguiente = new JButton(">>");
		siguiente.addActionListener(this);

		retroceder = new JButton("<<");
		retroceder.addActionListener(this);

		JPanel botonesActividades = new JPanel(new GridLayout(1, 2));
		botonesActividades.add(retroceder);
		botonesActividades.add(siguiente);

		add(botonesActividades, BorderLayout.CENTER);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object fuente = e.getSource();

		if (fuente == calcular) {
			palabrasEncontradas = SopaBll.calcularPalabrasEncontradas(letras, palabrasValidas);
			for (int i = 0; i < palabrasEncontradas.size(); i++) {
				model2.addElement(palabrasEncontradas.get(i));
			}
		}

		if (fuente == siguiente) {
			numeroArchivo++;
		}

		if (fuente == retroceder) {
			numeroArchivo--;
		}

	}
}
