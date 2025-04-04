package modelo;

public abstract class Casilla {
	/* ATRIBUTOS MINIMOS: int filas y int columnas, el constructor solo tendra los parametros int filas y int columnas es decir public Casilla(int filas, int columnas){}
	 * dentro del constructor aparte de this.filas = filas y this.columnas = columnas, habra mas atributos como por ejemplo this.tieneMina = false, los cuales
	 * se tendran que inicializar.
	 * Metodos minimos:
	 * para validar si esta vacia o no, para randomizar 
	 * metodo revelar que te lleve a su respectiva clase
	 * boolean esMina(): Devuelve true si la casilla tiene una mina.

void setMina(boolean tieneMina): Asigna si la casilla contiene una mina.

void revelar(): Cambia el estado de la casilla a revelado.

boolean estaRevelada(): Retorna si la casilla ya está descubierta.

void setNumeroMinasAlrededor(int n): Almacena el número de minas cercanas.

int getNumeroMinasAlrededor(): Devuelve el número de minas cercanas.


	 */
	
	private boolean tieneMina;
	
	
	
	

}
