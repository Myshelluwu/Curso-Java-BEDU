import java.util.concurrent.*;
import java.util.Random;

public class AeropuertoControl {
    private static final Random random = new Random();

    // Probabilidades de éxito para cada verificación
    private static final double PROBABILIDAD_PISTA = 0.80;
    private static final double PROBABILIDAD_CLIMA = 0.85;
    private static final double PROBABILIDAD_TRAFICO = 0.90;
    private static final double PROBABILIDAD_PERSONAL = 0.95;

    public CompletableFuture<Boolean> verificarPista() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("🛣️ Verificando disponibilidad de pista...");
            try {
                Thread.sleep(2000 + random.nextInt(1000)); // Latencia 2-3 segundos

                // Simular fallo aleatorio (20% de fallo)
                if (random.nextDouble() > PROBABILIDAD_PISTA) {
                    System.out.println("⚠️ Pista en mantenimiento!");
                    return false;
                }
                return true;
            } catch (InterruptedException e) {
                throw new RuntimeException("Verificación de pista interrumpida");
            }
        });
    }

    public CompletableFuture<Boolean> verificarClima() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("🌦️ Verificando condiciones climáticas...");
            try {
                Thread.sleep(2000 + random.nextInt(1000)); // Latencia 2-3 segundos

                // Simular fallo aleatorio (15% de fallo)
                if (random.nextDouble() > PROBABILIDAD_CLIMA) {
                    System.out.println("⚠️ Tormenta detectada!");
                    return false;
                }
                return true;
            } catch (InterruptedException e) {
                throw new RuntimeException("Verificación de clima interrumpida");
            }
        });
    }

    public CompletableFuture<Boolean> verificarTraficoAereo() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("🚦 Verificando tráfico aéreo...");
            try {
                Thread.sleep(2000 + random.nextInt(1000)); // Latencia 2-3 segundos

                // Simular fallo aleatorio (10% de fallo)
                if (random.nextDouble() > PROBABILIDAD_TRAFICO) {
                    System.out.println("⚠️ Tráfico aéreo congestionado!");
                    return false;
                }
                return true;
            } catch (InterruptedException e) {
                throw new RuntimeException("Verificación de tráfico interrumpida");
            }
        });
    }

    public CompletableFuture<Boolean> verificarPersonalTierra() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("👷‍♂️ Verificando personal en tierra...");
            try {
                Thread.sleep(2000 + random.nextInt(1000)); // Latencia 2-3 segundos

                // Simular fallo aleatorio (5% de fallo)
                if (random.nextDouble() > PROBABILIDAD_PERSONAL) {
                    System.out.println("⚠️ Personal insuficiente!");
                    return false;
                }
                return true;
            } catch (InterruptedException e) {
                throw new RuntimeException("Verificación de personal interrumpida");
            }
        });
    }

    public void autorizarAterrizaje() {
        System.out.println("\n🛫 Verificando condiciones para aterrizaje...\n");

        CompletableFuture<Boolean> pista = verificarPista();
        CompletableFuture<Boolean> clima = verificarClima();
        CompletableFuture<Boolean> trafico = verificarTraficoAereo();
        CompletableFuture<Boolean> personal = verificarPersonalTierra();

        // Combinar todos los resultados
        CompletableFuture<Void> todasVerificaciones = CompletableFuture.allOf(
                pista, clima, trafico, personal
        );

        todasVerificaciones.thenRun(() -> {
            try {
                // Obtener resultados individuales
                boolean pistaOk = pista.get();
                boolean climaOk = clima.get();
                boolean traficoOk = trafico.get();
                boolean personalOk = personal.get();

                System.out.println("\n🛣️ Pista disponible: " + pistaOk);
                System.out.println("🌦️ Clima favorable: " + climaOk);
                System.out.println("🚦 Tráfico aéreo despejado: " + traficoOk);
                System.out.println("👷‍♂️ Personal disponible: " + personalOk);
                System.out.println();

                if (pistaOk && climaOk && traficoOk && personalOk) {
                    System.out.println("🛬 Aterrizaje autorizado: todas las condiciones óptimas.");
                } else {
                    System.out.println("🚫 Aterrizaje denegado: condiciones no óptimas.");
                }
            } catch (InterruptedException | ExecutionException e) {
                System.err.println("⚠️ Error en el proceso de autorización: " + e.getMessage());
                System.out.println("🚫 Aterrizaje denegado: error en las verificaciones.");
            }
        }).exceptionally(ex -> {
            System.err.println("⚠️ Error crítico: " + ex.getMessage());
            System.out.println("🚫 Aterrizaje denegado: sistema no disponible.");
            return null;
        });

        // Mantener la aplicación corriendo
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        AeropuertoControl control = new AeropuertoControl();
        control.autorizarAterrizaje();
    }
}