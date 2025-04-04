package modelo;

public class ZonaVacia extends Casilla{
	private int numero;
	private boolean esRevelada;
	
	public ZonaVacia(int numero, boolean esRevelada) {
		this.numero = numero;
		this.esRevelada = false;
	}
	
	//@Override
	public void revelar() {
		if(!esRevelada) {
			esRevelada = true;
		}else {
			esRevelada = false;
		}
		
	}
	
	/*
	 * ZonaVacia

@Override void revelar(): Si se revela, descubre casillas vacías adyacentes.
	 */
	
	//Atributos:

	//int numero: Este atributo puede representar el número de minas adyacentes a esta casilla. Puede ser inicializado en el constructor.
	//boolean esRevelada: Indica si la casilla ha sido revelada o no.
	
	//Método revelar():

		//Este método también es una implementación de la función heredada de la clase Casilla.
		//Al ser llamado, se verifica si la casilla ya ha sido revelada.
		//Si ya está revelada, no se realiza ninguna acción adicional.
		//Si no está revelada, se cambia el estado de esRevelada a true.
		//Dependiendo del valor de numero, se puede:
		//Mostrar una imagen que represente un número (si numero es mayor que 0).
		//Mostrar una imagen que represente una casilla vacía (si numero es 0).
		//Si numero es 0, se puede implementar una lógica adicional para revelar automáticamente las casillas adyacentes, lo que es típico en el juego de Buscaminas.
}
