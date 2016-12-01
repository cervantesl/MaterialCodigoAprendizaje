import java.awt.Point;

public class Nodo {

	public Point posicion;

	public double puntoX;
	public double puntoY;

	public Nodo(final Point posicion) {
		this.posicion = posicion;
	}

	public Nodo(final double puntoX, final double puntoY) {
		this.puntoX = puntoX;
		this.puntoY = puntoY;
	}

	public Point obtenerPosicion() {
		return posicion;
	}

	public double obtenerPosicionX() {
		return puntoX;
	}

	public double obtenerPosicionY() {
		return puntoY;
	}
}
