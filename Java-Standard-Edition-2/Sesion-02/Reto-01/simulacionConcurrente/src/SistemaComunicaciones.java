import java.util.concurrent.Callable;

public class SistemaComunicaciones implements Callable<String> {
    @Override
    public String call() throws Exception {
        // Simular tiempo de procesamiento aleatorio entre 0.7-2.7 segundos
        Thread.sleep((long)(Math.random() * 2000) + 700);
        return "📡 Comunicaciones: Enlace con estación terrestre establecido.";
    }
}