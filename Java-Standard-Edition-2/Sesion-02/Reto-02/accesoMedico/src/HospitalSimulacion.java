import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HospitalSimulacion {
    public static void main(String[] args) {
        System.out.println("🏥 Iniciando acceso a recursos médicos críticos...\n");

        // Crear el recurso médico compartido
        RecursoMedico salaCirugia = new RecursoMedico("Sala de cirugía");

        // Crear profesionales médicos
        ProfesionalMedico[] profesionales = {
                new ProfesionalMedico(salaCirugia, "Dra. Sánchez"),
                new ProfesionalMedico(salaCirugia, "Dr. Gómez"),
                new ProfesionalMedico(salaCirugia, "Enf. Martínez"),
                new ProfesionalMedico(salaCirugia, "Dr. Rodríguez"),
                new ProfesionalMedico(salaCirugia, "Dra. Fernández")
        };

        // Crear pool de hilos (4 quirófanos disponibles)
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Enviar todas las tareas al executor
        for (ProfesionalMedico profesional : profesionales) {
            executor.execute(profesional);
        }

        // Cerrar el executor
        executor.shutdown();

        // Esperar a que terminen todas las tareas
        while (!executor.isTerminated()) {
            // Esperar activamente
        }

        System.out.println("\n🏥 Todos los procedimientos han finalizado");
    }
}