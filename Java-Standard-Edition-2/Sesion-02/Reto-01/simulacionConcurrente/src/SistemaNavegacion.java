import java.util.concurrent.Callable;

public class SistemaNavegacion implements Callable<String> {
    @Override
    public String call() throws Exception {
        // Simular tiempo de procesamiento aleatorio entre 1-3 segundos
        Thread.sleep((long)(Math.random() * 2000) + 1000);
        return "🛰️ Navegación: Trayectoria corregida con éxito.";
    }
}