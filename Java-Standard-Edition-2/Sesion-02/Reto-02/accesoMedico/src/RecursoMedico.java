import java.util.concurrent.locks.ReentrantLock;

public class RecursoMedico {
    private final String nombre;
    private final ReentrantLock lock = new ReentrantLock(true); // Lock con fairnes

    public RecursoMedico(String nombre) {
        this.nombre = nombre;
    }

    public void usar(String profesional) {
        lock.lock(); // Adquirir el lock
        try {
            System.out.println("👩‍⚕️ " + profesional + " ha ingresado a " + nombre);
            // Simular tiempo de uso del recurso (1-3 segundos)
            Thread.sleep((long)(Math.random() * 2000) + 1000);
            System.out.println("✅ " + profesional + " ha salido de " + nombre);
        } catch (InterruptedException e) {
            System.out.println("⚠️ " + profesional + " fue interrumpido durante el procedimiento");
        } finally {
            lock.unlock(); // Liberar el lock siempre
        }
    }
}