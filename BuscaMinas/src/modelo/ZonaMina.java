package modelo;

import java.util.List;

import javax.swing.ImageIcon;

public class ZonaMina extends Casilla{	
	public ZonaMina() {
		super();
		this.tieneMina=true;
	}

	@Override
    public void revelar() {
        if (!estaRevelada && !tieneBandera) {
            estaRevelada = true;
            boton.setIcon(new ImageIcon("images/bombdeath.gif"));
            boton.setEnabled(false);
        }
    }

	@Override
	public void setNumeroMinasAlrededor(int n) {
		
	}

	@Override
	public int getNumeroMinasAlrededor() {
		return 0;
	}
	
}
