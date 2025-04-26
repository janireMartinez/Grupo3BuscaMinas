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
        	boton.setText(""); // Limpiar texto por si acaso
            boton.setIcon(null); // Asegúrate de que no haya iconos previos
            ImageIcon minaIcono = new ImageIcon(ZonaMina.class.getResource("/images/bombdeath.gif"));
            boton.setIcon(minaIcono);
            boton.setDisabledIcon(minaIcono);
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
