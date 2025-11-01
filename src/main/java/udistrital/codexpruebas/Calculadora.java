package udistrital.codexpruebas;

/**
 * Proporciona operaciones aritméticas básicas para la calculadora.
 */
public final class Calculadora {

    private Calculadora() {
        // Evita la instanciación.
    }

    /**
     * Suma dos números.
     *
     * @param a primer sumando
     * @param b segundo sumando
     * @return la suma de {@code a} y {@code b}
     */
    public static double sumar(double a, double b) {
        return a + b;
    }

    /**
     * Resta dos números.
     *
     * @param a minuendo
     * @param b sustraendo
     * @return la resta de {@code a} y {@code b}
     */
    public static double restar(double a, double b) {
        return a - b;
    }

    /**
     * Multiplica dos números.
     *
     * @param a primer factor
     * @param b segundo factor
     * @return el producto de {@code a} y {@code b}
     */
    public static double multiplicar(double a, double b) {
        return a * b;
    }

    /**
     * Divide dos números.
     *
     * @param dividendo el valor a dividir
     * @param divisor el valor por el que se divide
     * @return el cociente resultante
     * @throws IllegalArgumentException si el divisor es cero
     */
    public static double dividir(double dividendo, double divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("El divisor no puede ser cero");
        }
        return dividendo / divisor;
    }
}
