package modelo;

public enum Dificultad {
	FACIL(8, 8, 10),
	MEDIA(16, 16, 40),
	DIFICIL(16, 30, 99);
	
	private final int filas;
	private final int columnas;
	private final int bombas;
	
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
	
	public int coeficientePuntuacion() {
		switch (this) {
		case FACIL: 
			return 1;
			
		case MEDIA:
			return 2;
			
		case DIFICIL:
			return 3;
			
		default:
			return 1;
		}
	}
	
	public static Dificultad obtenerDificultad(String nombre) {
		return valueOf(nombre.toUpperCase());
	}
	
	
}
