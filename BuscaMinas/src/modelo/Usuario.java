package modelo;

public class Usuario {   // Meter la puntuacion, el tiempo, el nombre, dificultad
						/* Metodos minimos:
						 * calcular puntuacion, get y set, 
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
