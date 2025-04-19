package modelo;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Clase abstracta que representa una casilla del juego Buscaminas.
 * Es la base para las subclases ZonaVacia (sin mina) y ZonaMina (con mina).
 * Contiene atributos de estado lógico y un JButton para su representación gráfica.
 * Incluye la lógica de marcar con bandera y métodos abstractos que serán implementados por las subclases.
 *
 * Atributos:
 * - tieneMina: indica si la casilla contiene una mina.
 * - estaRevelada: si el jugador ya la ha revelado.
 * - tieneBandera: si se ha marcado con una bandera.
 * - boton: el botón Swing que representa visualmente esta casilla.
 */

public abstract class Casilla {
	//Atributos definidos con el modificador protected para que sean visibles por las clases vecinas que interactuan entre si
	//Tenemos 3 atributos: Boolean tieneMina,Boolean estaRevelada y Boolean tiene Bandera ademas de un atributo de JButton que se encarga de vincular la lógica del modelo con la interfaz gráfica (GUI), en este caso usando Swing.
    //El atributo tieneMina indica si esta casilla contiene una mina.
	protected boolean tieneMina;
	//El atributo estaRevelada determina si el jugador ya ha hecho clic sobre esta casilla.
    protected boolean estaRevelada;
    //El atributo tieneBandera marca si el jugador ha puesto una bandera sobre ella (clic derecho).
    protected boolean tieneBandera;
    //El atributo boton  el componente gráfico (JButton) que representa esta casilla en la interfaz visual.
    protected JButton boton; // Botón gráfico
    
    //El constructor inicializa los valores lógicos por defecto y crea un nuevo botón (JButton) que será mostrado en el tablero gráfico.
    public Casilla() {
        this.tieneMina = false;
        this.estaRevelada = false;
        this.tieneBandera = false;
        this.boton = new JButton();
    }
    //Devuelve el botón asociado a esta casilla, útil para manipularlo desde otras clases (por ejemplo, para añadirle eventos).
    public JButton getBoton() {
        return boton;
    }
    //Métodos "getters" para consultar el estado actual de la casilla:
    public boolean tieneMina() {
        return tieneMina;
    }

    public boolean estaRevelada() {
        return estaRevelada;
    }

    public boolean estaMarcada() {
        return tieneBandera;
    }
    //Marca esta casilla como que contiene una mina. Se usa durante la generación del tablero.
    public void ponerMina() {
        this.tieneMina = true;
    }
    //Este método simula el clic derecho del jugador:
    //Si la casilla no está revelada, permite alternar entre:
    //Colocar una bandera (se muestra un ícono de bandera).
    //Quitarla si ya había una.
    //El uso de ImageIcon("images/bombflagged.gif") permite que la bandera se muestre visualmente en el botón.
    public void revelarConBandera() {
        if (!estaRevelada) {
            if (!tieneBandera) {
                boton.setIcon(new ImageIcon("images/bombflagged.gif"));
                tieneBandera = true;
            } else {
                boton.setIcon(null);
                tieneBandera = false;
            }
        }
    }
    //Se llamará cuando el jugador haga clic sobre una casilla (acción principal). La implementación será distinta según el tipo de casilla (mina, vacía...).
    public abstract void revelar();
    //Se usan para asociar y consultar cuántas minas rodean una casilla vacía. En ZonaVacia se implementarán, en ZonaMina pueden quedarse vacíos o retornar 0.
    public abstract void setNumeroMinasAlrededor(int n);
    
    public abstract int getNumeroMinasAlrededor();
    //Método útil para hacer comprobaciones sin usar instanceof. Por defecto retorna false, pero ZonaVacia lo sobreescribirá devolviendo true.
    public boolean esZonaVacia() {
        return false; // Sobreescrito en ZonaVacia
    }
}

/*
*casilla.getBoton().addMouseListener(new MouseAdapter() {
    @Override
    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {
            casilla.revelarConBandera();
        } else {
            casilla.revelar();
        }
    }
});
Este MouseListener se utiliza para detectar clics del ratón sobre una casilla (botón) en el Buscaminas, y según el botón del ratón que se presione:

Si haces clic izquierdo, llama a casilla.revelar(), revelando la casilla.

Si haces clic derecho, llama a casilla.revelarConBandera(), para poner o quitar una bandera en esa casilla.

 ¿Dónde debería ir este código?

Este código debe ir en la parte visual de tu aplicación, más concretamente en la clase VentanaJuego (que es la que gestiona la interfaz del juego).

 Específicamente, debe colocarse cuando estás creando el tablero visual, por ejemplo, en un for que recorra el TableroEntero y coloque los botones (getBoton()) en un panel.
for (int fila = 0; fila < tablero.getFilas(); fila++) {
    for (int columna = 0; columna < tablero.getColumnas(); columna++) {
        Casilla casilla = tablero.getCasilla()[fila][columna];
        JButton boton = casilla.getBoton();

        // Agregar el botón al panel
        panelTablero.add(boton);

        // Añadir el MouseListener
        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    casilla.revelarConBandera();
                } else {
                    tablero.revelarCasilla(fila, columna);
                }

                // Opcional: podrías comprobar si se ha ganado o perdido
            }
        });
    }
}

*/