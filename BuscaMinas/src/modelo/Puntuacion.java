package modelo;

public class Puntuacion implements Comparable<Puntuacion>{

	private String nombre;
	private int puntuacion;
	private int tiempo;
	
	public Puntuacion(String nombre, int puntuacion, int tiempo) {
		this.nombre = nombre;
		this.puntuacion = puntuacion;
		this.tiempo = tiempo;
	}

	@Override
	public int compareTo(Puntuacion o) {
		return Double.compare(o.puntuacion, this.puntuacion);
	}

	@Override
	public String toString() {
		return nombre + "|" + puntuacion + "|" + tiempo;
	}
	
	public static Puntuacion convertirObjeto(String linea) {
		String[] divisor = linea.split("\\|"); 
		if (divisor.length == 3) {
			String nombre = divisor[0];
			int puntuacion = Integer.parseInt(divisor[1]);
			int tiempo = Integer.parseInt(divisor[2]);
			return new Puntuacion(nombre, puntuacion, tiempo);
		}
		return null;
	}

	public String getNombre() {
		return nombre;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public int getTiempo() {
		return tiempo;
	}
	
	
	
}
