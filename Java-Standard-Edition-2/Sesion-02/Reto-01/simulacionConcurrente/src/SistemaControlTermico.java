import java.util.concurrent.Callable;

public class SistemaControlTermico implements Callable<String> {
    @Override
    public String call() throws Exception {
        // Simular tiempo de procesamiento aleatorio entre 0.5-2.5 segundos
        Thread.sleep((long)(Math.random() * 2000) + 500);
        return "🔥 Control térmico: Temperatura estable (22°C).";
    }
}