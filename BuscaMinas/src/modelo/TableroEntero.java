package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TableroEntero {
	
	private int filas;
	private int columnas;
	private int bombas;
	private Casilla[][] casilla;
	private boolean juegoAcabado;
	private int casillasReveladas;
	private int bombasRestantes;
	private int minasMarcadas;
	
	public TableroEntero(Dificultad dificultad) {
		ZonaVacia.imagenesNumeros();
		
		this.filas = dificultad.getFilas(); 
		this.columnas = dificultad.getColumnas(); 
		this.bombas = dificultad.getBombas();
		this.casilla = new Casilla[filas][columnas];
		this.juegoAcabado = false;
		this.casillasReveladas = 0;
		this.bombasRestantes = bombas;
		this.minasMarcadas = 0;
		
		mostrarTablero();
		colocarMinas();
		calcularMinas();
		casillasAdyacentes();
	}
	
	public void mostrarTablero() {
		for(int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				casilla[i][j] = new ZonaVacia(0); 
;			}
		}
	}
	
	public void colocarMinas() {
		Random random = new Random();
		
		int bombasColocadas = 0;
		while (bombasColocadas < bombas) {
			int fila = random.nextInt(filas);
			int columna = random.nextInt(columnas);
			if (!casilla[fila][columna].tieneMina()) { 
				casilla[fila][columna] = new ZonaMina(); 
				bombasColocadas++;
			}
		}
	}
	
	public void casillasAdyacentes() {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if (casilla[i][j].esZonaVacia()) {
					List<Casilla>adyacentes = new ArrayList<>();
					for (int k = -1; k <= 1; k++) {
						for (int l = -1; l <= 1; l++) {
							int filaNueva = i + k;
							int columnaNueva = j + l;
							if (validar(filaNueva, columnaNueva) && !(k == 0 && l == 0)) {
								adyacentes.add(casilla[filaNueva][columnaNueva]);
							}
						}
					}
					((ZonaVacia)casilla[i][j]).setAdyacentes(adyacentes);
				}
			}
		}
	}
	
	public int contarMinas(int fila, int columna) {
		int cont = 0;
		for (int i = -1; i <= 1; i++) { 
			for (int j = -1; j <= 1; j++) {
				int filaNueva = fila + i; 
				int columnaNueva = columna + j;
				if (validar(filaNueva, columnaNueva) && casilla[filaNueva][columnaNueva].tieneMina()) { 
					cont++;
				}
			}
		}
		return cont;
	}
	
	public boolean validar(int fila, int columna) {
		return fila >= 0 && fila < filas && columna >= 0 && columna < columnas;
	}
	
	public void calcularMinas() {
		for(int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if (casilla[i][j].esZonaVacia()) { 
					int bombas = contarMinas(i, j);
					casilla[i][j].setNumeroMinasAlrededor(bombas); 
				}
			} 
		}
	}
	
	public void revelarCasilla(int fila, int columna) {
		if (!juegoAcabado && validar(fila, columna) && !casilla[fila][columna].estaRevelada() && !casilla[fila][columna].estaMarcada()) { 
			casilla[fila][columna].revelar();
			if (casilla[fila][columna].tieneMina()) {
				juegoAcabado = true;
			} else {
				casillasReveladas++;
				if (casilla[fila][columna].esZonaVacia() && casilla[fila][columna].getNumeroMinasAlrededor() == 0) {
                    List<Casilla> adyacentes = ((ZonaVacia) casilla[fila][columna]).getAdyacentes();
                    if (adyacentes != null) {
                        for (Casilla c : adyacentes) {
                            for (int i = 0; i < filas; i++) {
                                for (int j = 0; j < columnas; j++) {
                                    if (casilla[i][j] == c && !c.estaRevelada() && !c.estaMarcada() && !c.tieneMina()) {
                                        revelarCasilla(i, j);
                                    }
                                }
                            }
                        }
                    }}
			}
		}
	}

	public void marcarCasilla (int fila, int columna) {
		if (!juegoAcabado && validar(fila, columna) && !casilla[fila][columna].estaRevelada()) {
			casilla[fila][columna].revelarConBandera();
			if (casilla[fila][columna].estaMarcada()) {
				bombasRestantes -= 1;
				minasMarcadas += 1;
			} else {
				bombasRestantes += 1;
				minasMarcadas -= 1;
			}
		}
	}
	
	public boolean perder(int fila, int columna) {
		return casilla[fila][columna].tieneMina() && casilla[fila][columna].estaRevelada();
	}
	
	public boolean ganar() {
		boolean ganar = casillasReveladas == (filas * columnas - bombas);
		return ganar;
	}
	
	public int getBombas() {
		return bombas;
	}

	public boolean isJuegoAcabado() {
		return juegoAcabado;
	}

	public int getCasillasReveladas() {
		return casillasReveladas;
	}

	public void setFilas(int filas) {
		this.filas = filas;
	}

	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}

	public void setBombas(int bombas) {
		this.bombas = bombas;
	}

	public void setCasilla(Casilla[][] casilla) {
		this.casilla = casilla;
	}

	public void setJuegoAcabado(boolean juegoAcabado) {
		this.juegoAcabado = juegoAcabado;
	}

	public void setCasillasReveladas(int casillasReveladas) {
		this.casillasReveladas = casillasReveladas;
	}
	
	public int getFilas() {
		return filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public Casilla[][] getCasilla() {
		return casilla;
	}

	public int getBombasRestantes() {
		return bombasRestantes;
	}

	public void setBombasRestantes(int bombasRestantes) {
		this.bombasRestantes = bombasRestantes;
	}

	public int getMinasMarcadas() {
		return minasMarcadas;
	}
	
}
