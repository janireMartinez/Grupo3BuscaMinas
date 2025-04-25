package controlador;

import modelo.Dificultad;
import vista.VentanaInicio;
import vista.VentanaJuego;
import vista.VentanaPerder;
import vista.VentanaRanking;

public class Main {
	
	private static VentanaInicio ventanaInicio;
	private static VentanaJuego ventanaJuego;
	private static VentanaRanking ventanaRanking;
	private static VentanaPerder ventanaPerder;
	
	
	public static void main(String[] args) {
		
		ventanaInicio = new VentanaInicio();
		ventanaInicio.setVisible(true);
		
	}
	// pasar de la inicial a juego
	public static void cambioInicioJuego(String nombre, Dificultad dificultad) {
		ventanaJuego = new VentanaJuego(nombre, dificultad); // pasar por parametro todos las variables diferente que haya
		ventanaJuego.setVisible(true);
		ventanaInicio.setVisible(false);
	}
	
	// pasar de la venta juego a ranking
	public static void cambioJuegoRanking() {
		ventanaRanking = new VentanaRanking(); // pasar por parametro todos las variables diferente que haya
		ventanaRanking.setVisible(true);
	}
	
	// pasar de la venta ranking a inicio
	public static void cambioRankingInico() {
		ventanaInicio = new VentanaInicio(); // pasar por parametro todos las variables diferente que haya
		ventanaInicio.setVisible(true);
		ventanaRanking.setVisible(false);
	}
	
	// cerrar sesion de la ventana ranking
	public static void cerrarSesionRanking() {
		ventanaRanking.setVisible(false);
	}
	
	//ventana de perder
	public static void apareceVentanaPerder(String nombre, Dificultad dificultad, VentanaJuego ventanaJuego) {
		ventanaPerder = new VentanaPerder(nombre, dificultad, ventanaJuego);
		ventanaPerder.setVisible(true);
	}
	
	//cerrar sesion cuando pierdes
	public static void cerrarSesion(String nombre, Dificultad dificultad, VentanaJuego ventanaJuego) {
		if (ventanaPerder != null) {
			ventanaPerder.dispose();
		}
		
		if (ventanaJuego != null) {
			ventanaJuego.dispose();
		}
		
		ventanaInicio = new VentanaInicio();
		ventanaInicio.setVisible(true);
		
	}

}
