package modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ranking { 

	private static final String RANKING_FICHERO = "ranking.txt";
	private static final int USUARIOS_MAX = 5;
	private List<Puntuacion> puntuacionLista;
	
	public Ranking() {
		this.puntuacionLista = new ArrayList<>();
		cargarPuntuacion();
	}
	
	public void calcularPuntuacion(String nombre, int c, int m, int d, int tiempo) {
		double puntuacion = 0.0;
		
		if (tiempo > 0) {
			puntuacion = (double)(c - m) + d / tiempo;
		}
		
		
		puntuacionLista.add(new Puntuacion(nombre, puntuacion, tiempo));
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
			String linea = leer.readLine();
			while (linea != null) {
				Puntuacion p = Puntuacion.convertirObjeto(linea);
				if (p != null) {
					puntuacionLista.add(p);
				}
				linea = leer.readLine();
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
				escribir.write(p.toString());
				escribir.newLine();
			}
			
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
