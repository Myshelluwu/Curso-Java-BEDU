import java.nio.file.*;
import java.io.IOException;

public class RegistroSimulacion {
    // Ruta del archivo de configuración
    private static final Path CONFIG_PATH = Paths.get("config/parametros.txt");

    public static void main(String[] args) {
        // Contenido de configuración
        String parametros = """
            Tiempo de ciclo: 55.8 segundos
            Velocidad de línea: 1.2 m/s
            Número de estaciones: 8
            Modo de operación: Automático
            Tolerancia de error: 0.5%
            Fecha de simulación: """ + java.time.LocalDate.now();

        // Guardar parámetros
        guardarParametros(parametros);

        // Leer y mostrar parámetros
        String contenido = leerParametros();
        System.out.println("=== PARÁMETROS DE SIMULACIÓN ===");
        System.out.println(contenido);
    }

    /**
     * Guarda los parámetros en el archivo de configuración
     * @param contenido Los parámetros a guardar
     */
    private static void guardarParametros(String contenido) {
        try {
            // Crear directorio si no existe
            if (!Files.exists(CONFIG_PATH.getParent())) {
                Files.createDirectories(CONFIG_PATH.getParent());
                System.out.println("Directorio config creado exitosamente.");
            }

            // Escribir archivo (sobrescribe si existe)
            Files.writeString(CONFIG_PATH, contenido, StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Archivo de parámetros guardado en: " + CONFIG_PATH.toAbsolutePath());

        } catch (IOException e) {
            System.err.println("Error al guardar parámetros: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Lee los parámetros del archivo de configuración
     * @return El contenido del archivo
     */
    private static String leerParametros() {
        try {
            // Verificar si el archivo existe
            if (!Files.exists(CONFIG_PATH)) {
                throw new IOException("El archivo de configuración no existe.");
            }

            // Leer todo el contenido
            return Files.readString(CONFIG_PATH);

        } catch (IOException e) {
            System.err.println("Error al leer parámetros: " + e.getMessage());
            return "No se pudieron leer los parámetros.";
        }
    }
}