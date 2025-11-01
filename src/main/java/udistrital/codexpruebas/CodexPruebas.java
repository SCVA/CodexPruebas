/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package udistrital.codexpruebas;

import java.util.Locale;
import java.util.Scanner;

/**
 * Aplicación de consola que implementa una calculadora básica.
 * Permite realizar operaciones de suma, resta, multiplicación y división
 * con números decimales introducidos por el usuario.
 */
public class CodexPruebas {

    private static final String MENU = """
            ================================
            Calculadora básica
            ================================
            1. Sumar
            2. Restar
            3. Multiplicar
            4. Dividir
            5. Salir
            """;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            scanner.useLocale(Locale.US);
            boolean continuar = true;

            while (continuar) {
                mostrarMenu();
                String opcion = scanner.nextLine().trim();

                switch (opcion) {
                    case "1" -> realizarOperacion(scanner, "Sumar", Calculadora::sumar);
                    case "2" -> realizarOperacion(scanner, "Restar", Calculadora::restar);
                    case "3" -> realizarOperacion(scanner, "Multiplicar", Calculadora::multiplicar);
                    case "4" -> realizarDivision(scanner);
                    case "5" -> {
                        System.out.println("¡Hasta pronto!");
                        continuar = false;
                    }
                    default -> System.out.println("Opción no válida. Intente nuevamente.\n");
                }
            }
        }
    }

    private static void realizarDivision(Scanner scanner) {
        double dividendo = solicitarNumero(scanner, "Ingrese el dividendo: ");
        double divisor;
        while (true) {
            divisor = solicitarNumero(scanner, "Ingrese el divisor: ");
            if (divisor != 0) {
                break;
            }
            System.out.println("El divisor no puede ser cero. Por favor, ingrese otro valor.");
        }

        double resultado = Calculadora.dividir(dividendo, divisor);
        System.out.printf(Locale.US, "Resultado de la división: %.4f%n%n", resultado);
    }

    private static void realizarOperacion(Scanner scanner, String nombreOperacion, Operacion operacion) {
        double primerNumero = solicitarNumero(scanner, "Ingrese el primer número: ");
        double segundoNumero = solicitarNumero(scanner, "Ingrese el segundo número: ");

        double resultado = operacion.aplicar(primerNumero, segundoNumero);
        System.out.printf(Locale.US, "Resultado de %s: %.4f%n%n", nombreOperacion.toLowerCase(Locale.ROOT), resultado);
    }

    private static double solicitarNumero(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();

            if (entrada.isEmpty()) {
                System.out.println("Entrada vacía. Por favor, ingrese un número.");
                continue;
            }

            try {
                // Permite separar decimales con coma o punto
                entrada = entrada.replace(',', '.');
                return Double.parseDouble(entrada);
            } catch (NumberFormatException ex) {
                System.out.println("Valor inválido. Intente nuevamente utilizando números válidos.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println(MENU);
        System.out.print("Seleccione una opción: ");
    }

    @FunctionalInterface
    private interface Operacion {
        double aplicar(double a, double b);
    }
}
