package modelo;

import java.util.List;

/**
	* Clase que representa una casilla con mina 
	* Extiende la clase abstracta Casilla
	* Contiene metodos y atributos que determinan las condiciones qye llevan al fin del juego
	*
	* Atributo:
	* 	- cadBombas : Lista de las casillas con las que cuenta el tablero
	*
	* Metodos:
	* 	- gameOverAdvice : Devuelve un mensaje de fin del juego
	* 	- setCadBombas : Asigna las casillas a una lista para poder recorrerla luego
	* 	- revelar : Revela, y representa las casillas que contengan una mina 
	*/

public class ZonaMina extends Casilla{
	private List<Casilla> cadBombas;
	
	public ZonaMina() {
		super();
		this.estaRevelada=false;
		this.tieneMina=true;
	}

	//Metodo que devuelve el mensaje de fin del juego
	public String gameOverAdvice() { 
		return "Fin del juego";
	}
	
	//Metodo que asigna las casillas a una lista
	public void setCadBombas(List<Casilla> cadBombas) {
		this.cadBombas=cadBombas;
	}
	
	/*Este metodo revela una casilla con mina cuando el jugador hace click izquierdo sobre una casilla que la contenga,
		lo que forma una reaccion en cadena que desvela el resto de las bombas pero sin llegar a detonarlas y que lleva
		al fin del juego
	*/

	@Override
	public void revelar() {
		if(tieneMina) {
			estaRevelada=true;
			boton.setEnabled(false);
			boton.setIcon(bombDeath);
			for(Casilla bomba : cadBombas) {
				if(tieneMina) {
					boton.setEnabled(false);
					bomba.boton.setIcon(bombRevealed);
				}
				
			}
		}
	}

	@Override
	public void setNumeroMinasAlrededor(int n) {
		
	}

	@Override
	public int getNumeroMinasAlrededor() {
		return 0;
	}
	
	/*
	 * ZonaMina
@Override void revelar(): Si se revela, el juego termina.
	 */
	//Atributos:

	//boolean tieneMina: Indica si la casilla contiene una mina. 
	//Este atributo se inicializa en true para las instancias de ZonaMinada.
	
	//Método revelar():

		//Este método es una implementación de la función heredada de la clase Casilla.
		//Al ser llamado, se verifica si tieneMina es true.
		//Si es true, se debe ejecutar la lógica para terminar el juego (por ejemplo, mostrar un mensaje de "Game Over" y deshabilitar el tablero).
		//Si es false, se puede revelar la casilla como vacía (aunque en este caso, no debería haber una instancia de ZonaMinada sin mina, por lo que este caso no debería ocurrir).

	//Lógica de finalización del juego:

	//Al revelar una casilla con mina, se debe notificar al jugador y posiblemente realizar otras acciones 
	//como mostrar la ubicación de todas las minas en el tablero.
}
