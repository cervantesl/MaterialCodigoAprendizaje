package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SopaDao {

	public static String leerArchivoTexto(final String ruta) {
		String contenido = "";

		InputStream entradaBytes = ClassLoader.class.getResourceAsStream(ruta);
		BufferedReader lector = new BufferedReader(new InputStreamReader(entradaBytes));

		String linea;

		try {
			while ((linea = lector.readLine()) != null) {
				contenido += linea;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (entradaBytes != null) {
					entradaBytes.close();
				}
				if (lector != null) {
					lector.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		return contenido;
	}

	public static String[] leerLetras(String contenido) {

		String partes[] = contenido.split("\\*");

		String letras = partes[0];

		String[] letrasSeparadas = letras.split("");

		return letrasSeparadas;
	}

	public static String[] leerPalabrasValidas(String contenido) {

		String partes[] = contenido.split("\\*");

		String palabras = partes[1];

		String[] palabrasSeparadas = palabras.split(",");

		return palabrasSeparadas;
	}
}
