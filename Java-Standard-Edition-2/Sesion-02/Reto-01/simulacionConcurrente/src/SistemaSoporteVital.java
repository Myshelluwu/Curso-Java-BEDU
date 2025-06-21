import java.util.concurrent.Callable;

public class SistemaSoporteVital implements Callable<String> {
    @Override
    public String call() throws Exception {
        // Simular tiempo de procesamiento aleatorio entre 0.8-2.8 segundos
        Thread.sleep((long)(Math.random() * 2000) + 800);
        return "🧪 Soporte vital: Presión y oxígeno dentro de parámetros normales.";
    }
}