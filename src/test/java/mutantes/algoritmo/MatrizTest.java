package mutantes.algoritmo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MatrizTest {

    private Matriz matriz;

    @BeforeEach
    void setUp() {
        matriz = new Matriz();
    }

    // TESTS RELACIONADOS CON MATRICES INVÁLIDAS
    @Test
    void testVerificarADNNull() {
        String[] adn = null;
        assertThrows(NullPointerException.class, () -> matriz.verificarADN(adn), "Debería lanzar NullPointerException si el array es null.");
    }

    @Test
    void testVerificarADNEmpytArray() {
        String[] adn = {};
        assertFalse(matriz.verificarADN(adn), "Debería retornar false para un array vacío.");
    }

    @Test
    void testVerificarADNNxMArray() {
        String[] adn = {"ATGC", "CAGT", "TTGT"}; // Un array 3x4
        assertFalse(matriz.verificarADN(adn), "Debería retornar false para un array NxM.");
    }

    @Test
    void testVerificarADNNumeros() {
        String[] adn = {"1234", "5678", "9123", "4567"};
        assertFalse(matriz.verificarADN(adn), "Debería retornar false para un array que contiene números en vez de letras.");
    }

    @Test
    void testVerificarADNNulos() {
        String[] adn = {null, null, null, null};
        assertFalse(matriz.verificarADN(adn), "Debería retornar false si el array contiene solo nulls.");
    }

    @Test
    void testVerificarADNLetrasDistintas() {
        String[] adn = {"BHJB", "HBHJ", "BHJB", "JBHJ"};
        assertFalse(matriz.verificarADN(adn), "Debería retornar false si el array contiene letras distintas a A, C, G, T.");
    }

    @Test
    void testVerificarADNCorrecto() {
        String[] adn = {"ATGC", "CAGT", "TTGT", "AGCA"};
        assertTrue(matriz.verificarADN(adn), "Debería retornar true para un array válido de ADN.");
    }

    // Tests para analizarADN
    @Test
    void testAnalizarADNMutante() {
        String[] adn = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        assertTrue(matriz.analizarADN(adn), "Debería retornar true para un ADN mutante.");
    }
}

