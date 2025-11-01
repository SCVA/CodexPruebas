package udistrital.codexpruebas;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import org.junit.jupiter.api.Test;

class CodexPruebasTest {

    @Test
    void deberiaSumarNumerosConEntradaValida() throws Exception {
        String salida = ejecutarProgramaConEntrada("1\n2\n3\n5\n");

        assertTrue(salida.contains("Resultado de sumar: 5.0000"),
                () -> "La salida fue: " + salida);
        assertTrue(salida.contains("¡Hasta pronto!"));
    }

    @Test
    void deberiaMostrarMensajeCuandoDivisorEsCero() throws Exception {
        String salida = ejecutarProgramaConEntrada("4\n10\n0\n2\n5\n");

        assertTrue(salida.contains("El divisor no puede ser cero"),
                () -> "La salida fue: " + salida);
        assertTrue(salida.contains("Resultado de la división: 5.0000"));
    }

    @Test
    void deberiaAceptarDecimalesConComaTrasEntradaInvalida() throws Exception {
        String salida = ejecutarProgramaConEntrada("1\nabc\n4,5\n2\n5\n");

        assertTrue(salida.contains("Valor inválido"),
                () -> "La salida fue: " + salida);
        assertTrue(salida.contains("Resultado de sumar: 6.5000"));
    }

    private String ejecutarProgramaConEntrada(String entrada) throws Exception {
        InputStream entradaOriginal = System.in;
        PrintStream salidaOriginal = System.out;
        Locale localeOriginal = Locale.getDefault();

        ByteArrayInputStream nuevaEntrada = new ByteArrayInputStream(entrada.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream nuevaSalida = new ByteArrayOutputStream();

        try (PrintStream printStream = new PrintStream(nuevaSalida, true, StandardCharsets.UTF_8)) {
            System.setIn(nuevaEntrada);
            System.setOut(printStream);
            Locale.setDefault(Locale.US);

            CodexPruebas.main(new String[0]);
        } finally {
            System.setIn(entradaOriginal);
            System.setOut(salidaOriginal);
            Locale.setDefault(localeOriginal);
        }

        return nuevaSalida.toString(StandardCharsets.UTF_8);
    }
}
