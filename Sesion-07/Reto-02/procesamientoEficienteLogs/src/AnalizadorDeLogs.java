import java.io.*;
import java.nio.file.*;
import java.text.DecimalFormat;

public class AnalizadorDeLogs {
    // Ruta del archivo de logs
    private static final Path LOG_PATH = Paths.get("errores.log");
    private static final Path FAIL_LOG_PATH = Paths.get("registro_fallos.txt");

    public static void main(String[] args) {
        int totalLineas = 0;
        int errores = 0;
        int warnings = 0;

        try {
            // Análisis del archivo de logs
            AnalisisResultado resultado = analizarArchivoLog();

            // Mostrar resumen
            mostrarResumen(resultado);

        } catch (Exception e) {
            registrarFallo("Error en el análisis: " + e.getMessage());
        }
    }

    /**
     * Analiza el archivo de logs y devuelve los resultados
     */
    private static AnalisisResultado analizarArchivoLog() throws IOException {
        int totalLineas = 0;
        int errores = 0;
        int warnings = 0;

        // Try-with-resources para manejo automático del cierre
        try (BufferedReader reader = Files.newBufferedReader(LOG_PATH)) {
            String linea;

            while ((linea = reader.readLine()) != null) {
                totalLineas++;

                if (linea.contains("ERROR")) {
                    errores++;
                } else if (linea.contains("WARNING")) {
                    warnings++;
                }
            }
        } catch (IOException e) {
            registrarFallo("Error al leer el archivo de logs: " + e.getMessage());
            throw e;
        }

        return new AnalisisResultado(totalLineas, errores, warnings);
    }

    /**
     * Muestra el resumen del análisis en consola
     */
    private static void mostrarResumen(AnalisisResultado resultado) {
        DecimalFormat df = new DecimalFormat("0.00%");

        System.out.println("\n=== RESUMEN DE ANÁLISIS DE LOGS ===");
        System.out.println("Total de líneas leídas: " + resultado.totalLineas());
        System.out.println("Errores detectados: " + resultado.errores());
        System.out.println("Advertencias detectadas: " + resultado.warnings());

        if (resultado.totalLineas() > 0) {
            double porcentajeErrores = (double) resultado.errores() / resultado.totalLineas();
            double porcentajeWarnings = (double) resultado.warnings() / resultado.totalLineas();

            System.out.println("\nPorcentaje de líneas con errores: " + df.format(porcentajeErrores));
            System.out.println("Porcentaje de líneas con advertencias: " + df.format(porcentajeWarnings));
            System.out.println("Porcentaje de líneas correctas: " +
                    df.format(1 - (porcentajeErrores + porcentajeWarnings)));
        }
    }

    /**
     * Registra fallos en el archivo de registro
     */
    private static void registrarFallo(String mensaje) {
        try {
            // Añadir al archivo (crea si no existe)
            Files.writeString(FAIL_LOG_PATH,
                    java.time.LocalDateTime.now() + " - " + mensaje + "\n",
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);

            System.err.println("Fallo registrado en: " + FAIL_LOG_PATH.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error crítico al registrar fallo: " + e.getMessage());
        }
    }

    /**
     * Clase de registro para los resultados del análisis
     */
    private record AnalisisResultado(int totalLineas, int errores, int warnings) {}
}