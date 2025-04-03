package modelo;

public class Usuario {   // Meter la puntuacion, el tiempo, el nombre, dificultad
						/* Metodos minimos:
						 * calcular puntuacion, get y set, y un comparable par el ranking
						 * String getNombre(): Devuelve el nombre del usuario.

void setNombre(String nombre): Asigna el nombre del usuario.

int getPuntuacion(): Obtiene la puntuación.

void setPuntuacion(int puntuacion): Modifica la puntuación del usuario.
						 */
	
	private String nombre;

	public Usuario(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
