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
        tablero = new TableroEntero(Dificultad.FACIL); // Usamos dificultad fácil como ejemplo
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
        // Aquí deberíamos verificar si las minas han sido colocadas correctamente,
        // pero el código necesita mayor lógica para hacer este tipo de pruebas.
        tablero.colocarMinas(); 
        // Este test es un poco más complicado porque depende de la aleatoriedad, 
        // pero podrías realizar pruebas para verificar la cantidad de minas.
    }

    @Test
    void testContarMinas() {
        // Aquí se asume que hay minas colocadas en las casillas adecuadas
        int minas = tablero.contarMinas(0, 0); // Llamada ejemplo, debes verificar la posición
        assertTrue(minas >= 0 && minas <= 8, "Debe haber un número de minas alrededor");
    }

    @Test
    void testRevelarCasilla() {
        tablero.revelarCasilla(0, 0); 
        assertTrue(tablero.getCasilla()[0][0].estaRevelada(), "La casilla debe estar revelada");
    }

    @Test
    void testGanar() {
        // Aquí deberías realizar una prueba para verificar si el juego se ha ganado
        assertTrue(tablero.ganar(), "Debe devolver true si se ha ganado");
    }

    @Test
    void testPerder() {
        // Verifica si el juego se pierde correctamente al hacer clic en una mina
        assertTrue(tablero.perder(0, 0), "Debe devolver true si se ha perdido");
    }
}
