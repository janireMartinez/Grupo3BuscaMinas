package Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Puntuacion;
import modelo.Ranking;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TestRanking {
    private Ranking ranking;

    @BeforeEach
    void setUp() {
        ranking = Ranking.getInstance();
    }

    @Test
    void testCalcularPuntuacion() {
        ranking.calcularPuntuacion("Jugador1", 20, 5, 10, 300);
        List<Puntuacion> lista = ranking.getPuntuacionLista();
        assertEquals(1, lista.size(), "Debe haber al menos 1 puntuación");
        assertEquals(0.05, lista.get(0).getPuntuacion(), 0.01, "La puntuación debe ser mayor a 0");
    }

    @Test
    void testGuardarCargarPuntuacion() {
        ranking.calcularPuntuacion("Jugador2", 15, 3, 8, 250);
        ranking.guardarPuntuacion();
        ranking.cargarPuntuacion();
        List<Puntuacion> lista = ranking.getPuntuacionLista();
        assertTrue(lista.size() > 0, "Debe haber puntuaciones guardadas");
    }
}
