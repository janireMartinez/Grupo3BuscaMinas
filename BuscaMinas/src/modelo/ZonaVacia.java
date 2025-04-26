package modelo;

import javax.swing.ImageIcon;
import java.util.List;

/**
 * Clase que representa una casilla sin mina en el juego Buscaminas.
 * Extiende de Casilla y almacena el número de minas adyacentes.
 * Permite mostrar un número gráfico e implementar revelado recursivo si el número es 0.
 *
 * Atributos:
 * - numero: cantidad de minas vecinas (0 a 8).
 * - adyacentes: lista de casillas vecinas (para revelar recursivamente si numero == 0).
 *
 * Métodos principales:
 * - revelar(): Muestra el número correspondiente y revela casillas vecinas si no hay minas cerca.
 * - mostrarNumero(): Usa imágenes (.gif) para representar gráficamente el número.
 * - setNumeroMinasAlrededor() / getNumeroMinasAlrededor(): permite establecer o consultar el número de minas cercanas.
 * - esZonaVacia(): indica que esta casilla es del tipo "vacía".
 */

//ZonaVacia es una subclase de Casilla que representa una casilla sin mina. Puede tener un número del 0 al 8 indicando cuántas minas la rodean.
public class ZonaVacia extends Casilla {
	
    private int numero; 
    private List<Casilla> adyacentes;
    private static ImageIcon casillaAbierta;
    private static ImageIcon[] numeroCasilla;
    
    public ZonaVacia(int numero) {
        super();
        this.numero = numero;
        this.estaRevelada = false;
        this.tieneMina = false;
    }
    
    public static void imagenesNumeros() {
    	if (casillaAbierta == null || numeroCasilla == null) {
    		try {
    			casillaAbierta = new ImageIcon(ZonaVacia.class.getResource("/images/open0.gif"));
    			numeroCasilla = new ImageIcon[9];
    			numeroCasilla[0] = casillaAbierta;
    			
    			for (int i = 1; i <= 8; i++) {
    				numeroCasilla[i] = new ImageIcon(ZonaVacia.class.getResource("/images/open"+i+".gif"));
    			}
    			
    		} catch (Exception e) {
    			e.getMessage();
    		}
    	} 
    }
    //Asigna las casillas vecinas a esta casilla. Esto es útil para que luego pueda revelarlas automáticamente si numero == 0.
    public void setAdyacentes(List<Casilla> adyacentes) {
        this.adyacentes = adyacentes;
    }
    /*
     * 🔹Este método se llama cuando el jugador hace clic izquierdo sobre la casilla.
		Solo se revela si no estaba revelada y no tiene bandera.
		Marca la casilla como revelada y desactiva el botón.
		Muestra la imagen correspondiente (ver mostrarNumero()).
		Si el número es 0 (es decir, no hay minas alrededor), revela automáticamente las casillas vecinas de forma recursiva.
     * 
     */
    
    @Override
    public void revelar() {
        if (!estaRevelada && !tieneBandera) {
            estaRevelada = true;
            boton.setEnabled(false);
            mostrarNumero();
        }
    }
    /*
     * 🔹 Asigna un ícono según el número de minas cercanas:
		Se usan imágenes .gif ubicadas en la carpeta images (ej. 1.gif, 2.gif, ..., 8.gif, 0.gif).
		Mejora la interfaz visual en vez de usar texto.
     */
    private void mostrarNumero() {
    	imagenesNumeros();
    	boton.setText(""); // Limpiar texto
        boton.setIcon(null); // Limpiar cualquier icono anterior

        if (numero >= 0 && numero <= 8 && numeroCasilla[numero] != null) {
            boton.setIcon(numeroCasilla[numero]);
            boton.setDisabledIcon(numeroCasilla[numero]);
        } else {
            boton.setText(String.valueOf(numero));
        }
    }
    // Permiten asignar o consultar el número de minas cercanas a esta casilla.
    @Override
    public void setNumeroMinasAlrededor(int n) {
        this.numero = n;
    }

    public List<Casilla> getAdyacentes() {
		return adyacentes;
	}

	@Override
    public int getNumeroMinasAlrededor() {
        return this.numero;
    }
    //Retorna true, útil para identificar que esta casilla es una zona vacía sin necesidad de usar instanceof.
    @Override
    public boolean esZonaVacia() {
        return true;
    }
}
