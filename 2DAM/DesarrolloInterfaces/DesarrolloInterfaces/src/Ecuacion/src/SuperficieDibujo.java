import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class SuperficieDibujo extends JPanel {

	private static final long serialVersionUID = 1L;

	public static ArrayList<Nodo> puntosEje = new ArrayList<Nodo>();

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		setBackground(Color.GRAY.brighter());

		int ancho = getWidth();
		int alto = getHeight();

		int mitadX = ancho / 2;
		int mitadY = alto / 2;

		// Horizontal
		g.setColor(Color.red);
		g.drawLine(0, mitadY, ancho, mitadY);

		// Vertical
		g.drawLine(mitadX, 0, mitadX, alto);

	}

	public ArrayList<Nodo> calcularPuntos(int a, int b, int c) {

		double min, max, x, y;
		int dentroRaiz = b * b - 4 * a * c;

		if (dentroRaiz < 0) {
			System.out.println("No se puede calcular");
		} else {
			int divisor = 2 * a;
			if (divisor == 0) {
				System.out.println("No se puede calcular");
			} else {
				double sol1 = ((-1) * b + Math.sqrt(dentroRaiz)) / divisor;
				double sol2 = ((-1) * b - Math.sqrt(dentroRaiz)) / divisor;

				if (sol1 < sol2) {
					max = sol2;
					min = sol1;
				} else {
					max = sol1;
					min = sol2;
				}

				for (x = min - 10; x < max + 10; x += 0.1) {

					y = a * x * x + b * x + c;

					Nodo nodo = new Nodo(x, y);

					puntosEje.add(nodo);
				}
			}
		}

		return puntosEje;
	}

	public void pintarEncuacion(Graphics g, ArrayList<Nodo> puntosEje) {

		int ancho = getWidth();
		int alto = getHeight();

		int mitadX = ancho / 2;
		int mitadY = alto / 2;

		int zoom = 5;

		double x1 = 0, y1 = 0;

		boolean primera = true;

		for (int i = 0; i < puntosEje.size(); i++) {
			double x = puntosEje.get(i).obtenerPosicionX();
			double y = puntosEje.get(i).obtenerPosicionY();

			g.setColor(Color.blue);
			g.fillOval((int) (x * zoom + mitadX), (int) ((-1) * y * zoom + mitadY), 1, 1);

			if (primera) {
				primera = false;
			} else {
				g.drawLine((int) (x * zoom + mitadX), (int) ((-1) * y * zoom + mitadY), (int) (x1 * zoom + mitadX),
						(int) ((-1) * y1 * zoom + mitadY));
			}
			x1 = x;
			y1 = y;
		}

	}
}
