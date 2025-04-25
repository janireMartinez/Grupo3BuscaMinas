package Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.ZonaVacia;

import static org.junit.jupiter.api.Assertions.*;

class TestZonaVacia {
    private ZonaVacia zonaVacia;

    @BeforeEach
    void setUp() {
        zonaVacia = new ZonaVacia(0);
    }

    @Test
    void testRevelarZonaVacia() {
        // Revela la zona vacía
        zonaVacia.revelar();
        
        // Verifica que la zona esté revelada
        assertTrue(zonaVacia.estaRevelada(), "La zona vacía debe estar revelada");

        // Verifica que el ícono del botón sea null después de revelar (si se espera que sea así)
        assertNull(zonaVacia.getBoton().getIcon(), "El ícono del botón debe ser null para una zona vacía");
    }



    @Test
    void testSetNumeroMinasAlrededor() {
        zonaVacia.setNumeroMinasAlrededor(3);
        assertEquals(3, zonaVacia.getNumeroMinasAlrededor(), "El número de minas alrededor debe ser 3");
    }

    @Test
    void testEsZonaVacia() {
        assertTrue(zonaVacia.esZonaVacia(), "Debe ser una zona vacía");
    }
}
