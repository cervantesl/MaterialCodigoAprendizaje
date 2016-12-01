package bll;

import java.util.ArrayList;

import dao.SopaDao;
import vista.SuperficieDibujo;

public class SopaBll {

	public static String leerArchivo() {
		String ruta = obtenerRutaSiguienteArchivo();

		String contenido = SopaDao.leerArchivoTexto(ruta);

		return contenido;
	}

	public static String obtenerRutaSiguienteArchivo() {
		int numeroArchivo = SuperficieDibujo.numeroArchivo;

		String ruta = "/sopaLetras" + numeroArchivo + ".txt";
		System.out.println(ruta);

		return ruta;
	}

	public static String[][] leerLetras() {
		String contenido = leerArchivo();
		String[] letrasSeparadas = SopaDao.leerLetras(contenido);

		int lado = obtenerLadoMatrizLetras();

		String[][] cuadriculaLetras = new String[lado][lado];

		for (int y = 0; y < cuadriculaLetras.length; y++) {
			for (int x = 0; x < cuadriculaLetras[0].length; x++) {
				cuadriculaLetras[y][x] = letrasSeparadas[x + y * lado];
			}
		}

		return cuadriculaLetras;
	}

	public static String[] leerPalabrasValidas() {
		String contenido = leerArchivo();
		String palabrasSeparadas[] = SopaDao.leerPalabrasValidas(contenido);

		return palabrasSeparadas;
	}

	public static ArrayList<String> calcularPalabrasEncontradas(String[][] sopaLetras, String[] palabrasValidas) {
		ArrayList<String> palabrasPosibles = new ArrayList<>();
		ArrayList<String> palabrasEcontradas = new ArrayList<>();

		String palabrasHorizontales = "";
		String palabrasVerticales = "";
		String palabrasHorizontalesAlReves = "";
		String palabrasVerticalesAlReves = "";

		for (int y = 0; y < obtenerLadoMatrizLetras(); y++) {
			for (int x = 0; x < obtenerLadoMatrizLetras(); x++) {
				palabrasHorizontales += sopaLetras[y][x];
				palabrasVerticales += sopaLetras[x][y];

				palabrasHorizontalesAlReves = sopaLetras[y][x] + palabrasHorizontalesAlReves;
				palabrasVerticalesAlReves = sopaLetras[x][y] + palabrasVerticalesAlReves;
			}

			palabrasPosibles.add(palabrasHorizontales);
			palabrasPosibles.add(palabrasVerticales);
			palabrasPosibles.add(palabrasHorizontalesAlReves);
			palabrasPosibles.add(palabrasVerticalesAlReves);

			palabrasHorizontales = "";
			palabrasVerticales = "";
			palabrasHorizontalesAlReves = "";
			palabrasVerticalesAlReves = "";
		}

		// Diagonal (0,0) - (3,3)
		String palabrasDiagonalesIzquierdaArriba = "";
		String palabrasDiagonalesIzquierdaArribaInverso = "";
		String palabrasDiagonalesDerechaAbajo = "";
		String palabrasDiagonalesDerechaAbajoInverso = "";

		// Diagonal (3,0) - (0,3)
		String palabrasDiagonalesIzquierdaAbajo = "";
		String palabrasDiagonalesIzquierdaAbajoInverso = "";
		String palabrasDiagonalesDerechaArriba = "";
		String palabrasDiagonalesDerechaArribaInverso = "";

		int lado = obtenerLadoMatrizLetras();

		for (int n = 1; n < lado; n++) {
			int y = lado - n;
			for (int x = 0; x <= lado - n; x++) {
				palabrasDiagonalesIzquierdaArriba += sopaLetras[y][x];
				palabrasDiagonalesIzquierdaArribaInverso += sopaLetras[x][y];
				palabrasDiagonalesDerechaAbajo += sopaLetras[(lado - 1) - y][(lado - 1) - x];
				palabrasDiagonalesDerechaAbajoInverso += sopaLetras[(lado - 1) - x][(lado - 1) - y];

				palabrasDiagonalesIzquierdaAbajo += sopaLetras[(lado - 1) - y][x];
				palabrasDiagonalesIzquierdaAbajoInverso += sopaLetras[(lado - 1) - x][y];
				palabrasDiagonalesDerechaArriba += sopaLetras[y][(lado - 1) - x];
				palabrasDiagonalesDerechaArribaInverso += sopaLetras[x][(lado - 1) - y];

				y--;
			}
			palabrasPosibles.add(palabrasDiagonalesIzquierdaArriba);
			palabrasPosibles.add(palabrasDiagonalesIzquierdaArribaInverso);
			palabrasPosibles.add(palabrasDiagonalesDerechaAbajo);
			palabrasPosibles.add(palabrasDiagonalesDerechaAbajoInverso);

			palabrasPosibles.add(palabrasDiagonalesIzquierdaAbajo);
			palabrasPosibles.add(palabrasDiagonalesIzquierdaAbajoInverso);
			palabrasPosibles.add(palabrasDiagonalesDerechaArriba);
			palabrasPosibles.add(palabrasDiagonalesDerechaArribaInverso);

			palabrasDiagonalesIzquierdaArriba = "";
			palabrasDiagonalesIzquierdaArribaInverso = "";
			palabrasDiagonalesDerechaAbajo = "";
			palabrasDiagonalesDerechaAbajoInverso = "";

			palabrasDiagonalesIzquierdaAbajo = "";
			palabrasDiagonalesIzquierdaAbajoInverso = "";
			palabrasDiagonalesDerechaArriba = "";
			palabrasDiagonalesDerechaArribaInverso = "";
		}

		// COMPROBAR SI ESTAN LAS PALABRAS EN LA LISTA VALIDA
		String[] palabrasValidasLista = leerPalabrasValidas();

		for (int i = 0; i < palabrasPosibles.size(); i++) {
			for (int j = 0; j < palabrasValidasLista.length; j++) {
				// O SI NO ESTA EN LA LISTA YA
				if (palabrasPosibles.get(i).indexOf(palabrasValidasLista[j]) != -1) {
					String palabra = palabrasPosibles.get(i).substring(
							palabrasPosibles.get(i).indexOf(palabrasValidasLista[j]),
							palabrasPosibles.get(i).lastIndexOf(palabrasValidasLista[j])
									+ palabrasValidasLista[j].length());
					palabrasEcontradas.add(palabra);
				}
			}
		}

		return palabrasEcontradas;
	}

	public static int obtenerLadoMatrizLetras() {
		String contenido = leerArchivo();
		String[] letrasSeparadas = SopaDao.leerLetras(contenido);

		int lado = (int) Math.sqrt(letrasSeparadas.length);

		return lado;
	}

}
