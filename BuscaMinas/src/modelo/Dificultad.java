package modelo;

public enum Dificultad {
	// facil, media, dificil (ATRIBUTOS: filas, columnas, bombas)  y para llamar y tal, static Dificultad obtenerDificultad(String nombre)
	FACIL(8, 8, 10),
	
	MEDIA(16, 16, 40),
	
	DIFICIL(16, 30, 99);
	
	private int filas;
	private int columnas;
	private int bombas;
	
	Dificultad(int filas, int columnas, int bombas) {
		this.filas=filas;
		this.columnas=columnas;
		this.bombas=bombas;
	}

	public int getFilas() {
		return filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public int getBombas() {
		return bombas;
	}
	
	
}
