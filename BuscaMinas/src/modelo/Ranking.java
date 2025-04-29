package modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ranking {

	private static final String RANKING_FICHERO = "src/modelo/ranking.txt";
	private static final int USUARIOS_MAX = 5;
	private static Ranking instance = null;
	private List<Puntuacion> puntuacionLista;

	public Ranking() {
		this.puntuacionLista = new ArrayList<>();
		cargarPuntuacion();
	}

	public static Ranking getInstance() {
		if (instance == null) {
			instance = new Ranking();
		}
		return instance;
	}

	public void calcularPuntuacion(String nombre, int c, int m, int d, int tiempo) {
		int puntuacion = 0;

		if (tiempo > 0) {
			int base = (c - m) * 10;
			int tiempoCalculo = tiempo / 2;
			puntuacion = (base - tiempoCalculo) * d;
		}

		Puntuacion p = new Puntuacion(nombre, puntuacion, tiempo);
		puntuacionLista.add(p);
		Collections.sort(puntuacionLista);

		if (puntuacionLista.size() > USUARIOS_MAX) {
			puntuacionLista.subList(USUARIOS_MAX, puntuacionLista.size()).clear();
		}
		guardarPuntuacion();
	}

	public void cargarPuntuacion() {
		BufferedReader leer = null;

		try {
			leer = new BufferedReader(new FileReader(RANKING_FICHERO));
			String linea;
			while ((linea = leer.readLine()) != null) {
				if (!linea.trim().isEmpty()) {
					Puntuacion p = Puntuacion.convertirObjeto(linea);

					if (p != null) {
						puntuacionLista.add(p);
					}
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void guardarPuntuacion() {
		BufferedWriter escribir = null;

		try {
			escribir = new BufferedWriter(new FileWriter(RANKING_FICHERO));
			for (Puntuacion p : puntuacionLista) {
				String linea = p.toString();
				escribir.write(linea);
				escribir.newLine();
			}
			escribir.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getRankingFichero() {
		return RANKING_FICHERO;
	}

	public static int getUsuariosMax() {
		return USUARIOS_MAX;
	}

	public List<Puntuacion> getPuntuacionLista() {
		return puntuacionLista;
	}
}
