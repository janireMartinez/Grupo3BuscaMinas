package Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.ZonaMina;

import static org.junit.jupiter.api.Assertions.*;

class TestZonaMina {
    private ZonaMina zonaMina;

    @BeforeEach
    void setUp() {
        zonaMina = new ZonaMina();
    }

    @Test
    void testRevelar() {
        zonaMina.revelar();
        assertTrue(zonaMina.estaRevelada(), "La casilla debe estar revelada");
        assertNotNull(zonaMina.getBoton().getIcon(), "El ícono de mina debe estar asignado");
    }

    @Test
    void testSetNumeroMinasAlrededor() {
        zonaMina.setNumeroMinasAlrededor(5);
        assertEquals(0, zonaMina.getNumeroMinasAlrededor(), "El número de minas alrededor debe ser 0 para una mina");
    }

    @Test
    void testEsZonaVacia() {
        assertFalse(zonaMina.esZonaVacia(), "No debe ser una zona vacía");
    }
}
