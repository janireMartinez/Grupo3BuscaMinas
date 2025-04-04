package modelo;

public class TableroEntero {
	
	private int fila;
	private int columna;
	private Casilla[][] casilla;
	
	public TableroEntero(int fila, int columna) {
		this.fila = fila; // LLAMAR AL ENUMERADO DIFICULTAS Y COGER LAS FILA
		this.columna = columna; // LLAMAR AL ENUMERADO DIFICULTAS Y COGER LAS COLUMNAS
		this.casilla = new Casilla[fila][columna];
	}
	
	public void colocarMinas(int minas) {
		
	}
	
	public void calcularMinas() {
		
	}
	
	public void calcularNumeros() {
		
	}
	
	public void mostrarTablero() {
		
	}
	
	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}

	public Casilla[][] getCasilla() {
		return casilla;
	}
	
	/*
	 * Randomizar las bombas, Objeto dificultad, comprobar todo, numeros de casillas 
	 * void generarTablero(int filas, int columnas, int minas): Crea el tablero con las dimensiones y cantidad de minas dadas.

	Casilla getCasilla(int fila, int columna): Retorna una casilla en una posición específica.

	void colocarMinas(int minas): Distribuye aleatoriamente las minas en el tablero.

	void calcularNumeros(): Asigna los números de minas cercanas a cada casilla.

	void mostrarTablero(): (Solo para depuración) Imprime el tablero en consola.
	 */
}
