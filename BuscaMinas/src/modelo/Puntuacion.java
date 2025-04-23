package modelo;

public class Puntuacion implements Comparable<Puntuacion>{

	private String nombre;
	private double puntuacion;
	private int tiempo;
	
	public Puntuacion(String nombre, double puntuacion, int tiempo) {
		this.nombre = nombre;
		this.puntuacion = Math.round(puntuacion * 100.0) / 100.0;
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
		String[] divisor = linea.split("//|"); 
		if (divisor.length == 3) {
			String nombre = divisor[0];
			double puntuacion = Double.parseDouble(divisor[1]);
			int tiempo = Integer.parseInt(divisor[2]);
			return new Puntuacion(nombre, puntuacion, tiempo);
		}
		return null;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPuntuacion() {
		return puntuacion;
	}

	public int getTiempo() {
		return tiempo;
	}
	
	
	
}
