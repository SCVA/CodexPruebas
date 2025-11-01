package udistrital.codexpruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculadoraTest {

    @Test
    @DisplayName("Suma números positivos y negativos")
    void sumar() {
        assertEquals(7.5, Calculadora.sumar(3.0, 4.5), 1e-9);
        assertEquals(-1.0, Calculadora.sumar(-2.5, 1.5), 1e-9);
    }

    @Test
    @DisplayName("Resta números incluyendo resultados negativos")
    void restar() {
        assertEquals(-1.5, Calculadora.restar(3.0, 4.5), 1e-9);
        assertEquals(-4.0, Calculadora.restar(-2.5, 1.5), 1e-9);
    }

    @Test
    @DisplayName("Multiplica números con decimales")
    void multiplicar() {
        assertEquals(13.5, Calculadora.multiplicar(3.0, 4.5), 1e-9);
        assertEquals(-3.75, Calculadora.multiplicar(-2.5, 1.5), 1e-9);
    }

    @Test
    @DisplayName("Divide números positivos y negativos")
    void dividir() {
        assertEquals(2.0, Calculadora.dividir(9.0, 4.5), 1e-9);
        assertEquals(-1.6666666667, Calculadora.dividir(-2.5, 1.5), 1e-9);
    }

    @Test
    @DisplayName("Lanza excepción cuando se divide por cero")
    void dividirPorCeroLanzaExcepcion() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Calculadora.dividir(10.0, 0.0));
        assertEquals("El divisor no puede ser cero", exception.getMessage());
    }
}
