import reactor.core.publisher.Flux;
import java.time.Duration;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class UCIMonitoringSystem {

    private static final Random random = new Random();
    private static final AtomicInteger criticalCounter = new AtomicInteger(0);
    private static final AtomicInteger droppedEvents = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        // Configuración ajustable
        final int NUM_PACIENTES = 3;
        final int GENERATION_INTERVAL = 400; // ms
        final int PROCESSING_DELAY = 800; // ms
        final int BUFFER_SIZE = 50;
        final int RUNTIME_MINUTES = 2;

        // Crear flujos para cada paciente con backpressure controlado
        Flux<String>[] pacientes = new Flux[NUM_PACIENTES];
        for (int i = 0; i < NUM_PACIENTES; i++) {
            final int pacienteId = i + 1;
            pacientes[i] = Flux.interval(Duration.ofMillis(GENERATION_INTERVAL))
                    .onBackpressureBuffer(BUFFER_SIZE,
                            dropped -> System.out.println("💥 Eventos descartados: " + droppedEvents.incrementAndGet()))
                    .map(tick -> generarSignosVitales(pacienteId))
                    .filter(UCIMonitoringSystem::esCritico)
                    .delayElements(Duration.ofMillis(PROCESSING_DELAY))
                    .map(signos -> formatearAlerta(pacienteId, signos))
                    .doOnError(error -> System.err.println("❌ Error en paciente " + pacienteId + ": " + error.getMessage()));
        }

        // Fusionar todos los flujos con prioridad para FC
        Flux.merge(pacientes)
                .subscribe(
                        alerta -> {
                            System.out.println(alerta);
                            int count = criticalCounter.incrementAndGet();
                            if (count % 10 == 0) {
                                System.out.println("[Resumen] Total alertas: " + count + " | Descarte: " + droppedEvents.get());
                            }
                        },
                        error -> System.err.println("🔥 Error crítico: " + error.getMessage()),
                        () -> System.out.println("✅ Monitoreo completado")
                );

        // Mantener el programa en ejecución
        Thread.sleep(RUNTIME_MINUTES * 60 * 1000);
    }

    private static SignosVitales generarSignosVitales(int pacienteId) {
        return new SignosVitales(
                random.nextInt(80) + 40,   // FC: 40-120 bpm
                random.nextInt(70) + 85,   // PA sistólica: 85-155 mmHg
                random.nextInt(40) + 55,   // PA diastólica: 55-95 mmHg
                random.nextInt(15) + 85    // SpO2: 85-100%
        );
    }

    private static boolean esCritico(SignosVitales signos) {
        return signos.frecuenciaCardiaca < 55 || signos.frecuenciaCardiaca > 115 ||
                signos.paSistolica < 95 || signos.paSistolica > 135 ||
                signos.paDiastolica < 65 || signos.paDiastolica > 85 ||
                signos.spO2 < 92;
    }

    private static String formatearAlerta(int pacienteId, SignosVitales signos) {
        if (signos.frecuenciaCardiaca < 55) {
            return "⚠️ Paciente " + pacienteId + " - FC BAJA: " + signos.frecuenciaCardiaca + " bpm";
        } else if (signos.frecuenciaCardiaca > 115) {
            return "⚠️ Paciente " + pacienteId + " - FC ALTA: " + signos.frecuenciaCardiaca + " bpm";
        } else if (signos.paSistolica < 95 || signos.paDiastolica < 65) {
            return "⚠️ Paciente " + pacienteId + " - PA BAJA: " + signos.paSistolica + "/" + signos.paDiastolica + " mmHg";
        } else if (signos.paSistolica > 135 || signos.paDiastolica > 85) {
            return "⚠️ Paciente " + pacienteId + " - PA ALTA: " + signos.paSistolica + "/" + signos.paDiastolica + " mmHg";
        } else if (signos.spO2 < 92) {
            return "⚠️ Paciente " + pacienteId + " - SpO2 BAJO: " + signos.spO2 + "%";
        }
        return null;
    }

    static class SignosVitales {
        final int frecuenciaCardiaca; // bpm
        final int paSistolica;       // mmHg
        final int paDiastolica;      // mmHg
        final int spO2;             // %

        public SignosVitales(int fc, int paSis, int paDias, int spo2) {
            this.frecuenciaCardiaca = fc;
            this.paSistolica = paSis;
            this.paDiastolica = paDias;
            this.spO2 = spo2;
        }
    }
}