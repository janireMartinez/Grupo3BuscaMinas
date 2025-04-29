package modelo;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public abstract class Casilla {
	protected boolean tieneMina;
    protected boolean estaRevelada;
    protected boolean tieneBandera;
    protected JButton boton;
    
    public Casilla() {
        this.tieneMina = false;
        this.estaRevelada = false;
        this.tieneBandera = false;
        this.boton = new JButton();
        
        boton.setIcon(new ImageIcon(Casilla.class.getResource("/images/blank.gif")));
    }
    public JButton getBoton() {
        return boton;
    }

    public boolean tieneMina() {
        return tieneMina;
    }

    public boolean estaRevelada() {
        return estaRevelada;
    }

    public boolean estaMarcada() {
        return tieneBandera;
    }
 
    public void ponerMina() {
        this.tieneMina = true;
    }

    public void revelarConBandera() {
        if (!estaRevelada) {
            if (!tieneBandera) {
            	boton.setIcon(new ImageIcon(Casilla.class.getResource("/images/bombflagged.gif")));
                tieneBandera = true;
            } else {
            	boton.setIcon(new ImageIcon(Casilla.class.getResource("/images/blank.gif")));
                tieneBandera = false;
            }
        }
    }
    
    public abstract void revelar();

    public abstract void setNumeroMinasAlrededor(int n);
    
    public abstract int getNumeroMinasAlrededor();
    
    public boolean esZonaVacia() {
        return false; 
    }
}