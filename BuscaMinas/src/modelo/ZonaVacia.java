package modelo;

import javax.swing.ImageIcon;
import java.util.List;

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

    public void setAdyacentes(List<Casilla> adyacentes) {
        this.adyacentes = adyacentes;
    }
    
    @Override
    public void revelar() {
        if (!estaRevelada && !tieneBandera) {
            estaRevelada = true;
            boton.setEnabled(false);
            mostrarNumero();
        }
    }
 
    private void mostrarNumero() {
    	imagenesNumeros();
    	boton.setText(""); 
        boton.setIcon(null); 

        if (numero >= 0 && numero <= 8 && numeroCasilla[numero] != null) {
            boton.setIcon(numeroCasilla[numero]);
            boton.setDisabledIcon(numeroCasilla[numero]);
        } else {
            boton.setText(String.valueOf(numero));
        }
    }

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

    @Override
    public boolean esZonaVacia() {
        return true;
    }
}
