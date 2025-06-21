import java.util.concurrent.*;
import java.util.Random;

public class MovilidadApp {
    private static final Random random = new Random();

    public CompletableFuture<String> calcularRuta() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("🚦 Calculando ruta...");
            try {
                // Simular latencia de 2-3 segundos
                Thread.sleep(2000 + random.nextInt(1000));

                // Simular posibilidad de fallo (20% de probabilidad)
                if (random.nextDouble() < 0.2) {
                    throw new RuntimeException("Error al calcular la ruta: Servicio de mapas no disponible");
                }

                return "Ruta: Centro -> Norte";
            } catch (InterruptedException e) {
                throw new RuntimeException("Cálculo de ruta interrumpido");
            }
        });
    }

    public CompletableFuture<Double> estimarTarifa() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("💰 Estimando tarifa...");
            try {
                // Simular latencia de 1-2 segundos
                Thread.sleep(1000 + random.nextInt(1000));

                // Simular posibilidad de fallo (20% de probabilidad)
                if (random.nextDouble() < 0.2) {
                    throw new RuntimeException("Error al estimar tarifa: No se pudo obtener datos de tráfico");
                }

                // Retornar tarifa base + variación aleatoria
                return 75.50 + random.nextDouble() * 30;
            } catch (InterruptedException e) {
                throw new RuntimeException("Estimación de tarifa interrumpida");
            }
        });
    }

    public void procesarSolicitudViaje() {
        CompletableFuture<String> rutaFuture = calcularRuta();
        CompletableFuture<Double> tarifaFuture = estimarTarifa();

        // Combinar resultados cuando ambos completen
        rutaFuture.thenCombine(tarifaFuture, (ruta, tarifa) -> {
                    String rutaFormateada = ruta.replace("Ruta: ", "");
                    return String.format("✅ 🚗 Ruta calculada: %s | Tarifa estimada: $%.2f",
                            rutaFormateada, tarifa);
                })
                .exceptionally(ex -> {
                    // Manejar cualquier error en la cadena
                    System.err.println("⚠️ Error en el proceso: " + ex.getMessage());
                    return "❌ No se pudo completar la solicitud. Por favor intente nuevamente.";
                })
                .thenAccept(System.out::println);
    }

    public static void main(String[] args) {
        MovilidadApp app = new MovilidadApp();

        System.out.println("📱 Usuario solicita un viaje...");
        app.procesarSolicitudViaje();

        // Mantener la aplicación corriendo para ver resultados
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\n🔹 La app sigue respondiendo a otras operaciones...");
    }
}