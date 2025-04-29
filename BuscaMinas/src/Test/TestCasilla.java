package Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Casilla;
import modelo.ZonaVacia;

import static org.junit.jupiter.api.Assertions.*;

class TestCasilla {
    private Casilla casilla;

    @BeforeEach
    void setUp() {
        casilla = new ZonaVacia(0);
    }

    @Test
    void testIniciarCasilla() {
        assertFalse(casilla.tieneMina(), "La casilla no tiene mina por defecto");
        assertFalse(casilla.estaRevelada(), "La casilla no está revelada por defecto");
        assertFalse(casilla.estaMarcada(), "La casilla no tiene bandera por defecto");
        assertNotNull(casilla.getBoton(), "El botón de la casilla no es nulo");
    }

    @Test
    void testPonerMina() {
        casilla.ponerMina();
        assertTrue(casilla.tieneMina(), "La casilla debe tener una mina después de ponerla");
    }

    @Test
    void testRevelarConBandera() {
        casilla.revelarConBandera();
        assertTrue(casilla.estaMarcada(), "La casilla debe estar marcada con una bandera");
    }

    @Test
    void testRevelar() {
        casilla.revelar();
        assertTrue(casilla.estaRevelada(), "La casilla debe estar revelada");
    }

    @Test
    void testRevelarConBanderaCuandoRevelada() {
        casilla.revelar();
        casilla.revelarConBandera();
        assertFalse(casilla.estaMarcada(), "No debe poder marcar con bandera después de revelar");
    }
}
