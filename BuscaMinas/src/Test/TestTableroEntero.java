package Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Dificultad;
import modelo.TableroEntero;

import static org.junit.jupiter.api.Assertions.*;

class TestTableroEntero {
    private TableroEntero tablero;

    @BeforeEach
    void setUp() {
        tablero = new TableroEntero(Dificultad.FACIL); 
    }

    @Test
    void testIniciarTablero() {
        assertNotNull(tablero.getCasilla(), "El tablero debe estar inicializado");
        assertEquals(8, tablero.getFilas(), "El número de filas debe ser 8");
        assertEquals(8, tablero.getColumnas(), "El número de columnas debe ser 8");
        assertEquals(10, tablero.getBombas(), "El número de bombas debe ser 10");
    }

    @Test
    void testColocarMinas() {
        tablero.colocarMinas(); 
    }

    @Test
    void testContarMinas() {
        int minas = tablero.contarMinas(0, 0); 
        assertTrue(minas >= 0 && minas <= 8, "Debe haber un número de minas alrededor");
    }

    @Test
    void testRevelarCasilla() {
        tablero.revelarCasilla(0, 0); 
        assertTrue(tablero.getCasilla()[0][0].estaRevelada(), "La casilla debe estar revelada");
    }

    @Test
    void testGanar() {
        assertTrue(tablero.ganar(), "Debe devolver true si se ha ganado");
    }

    @Test
    void testPerder() {
        assertTrue(tablero.perder(0, 0), "Debe devolver true si se ha perdido");
    }
}
