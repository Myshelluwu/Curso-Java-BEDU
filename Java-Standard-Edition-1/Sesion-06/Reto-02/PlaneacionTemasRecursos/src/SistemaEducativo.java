import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class SistemaEducativo {
    public static void main(String[] args) {
        // 1. Crear lista concurrente de temas activos
        CopyOnWriteArrayList<Tema> temasActivos = new CopyOnWriteArrayList<>();

        // Añadir algunos temas de ejemplo
        temasActivos.add(new Tema("Lectura comprensiva", 2));
        temasActivos.add(new Tema("Matemáticas básicas", 1));
        temasActivos.add(new Tema("Cuidado del medio ambiente", 3));
        temasActivos.add(new Tema("Historia del arte", 2));
        temasActivos.add(new Tema("Introducción a la programación", 1));

        // 2. Mostrar lista ordenada alfabéticamente (orden natural)
        System.out.println("=== Temas ordenados alfabéticamente ===");
        List<Tema> ordenadosAlfabeticamente = new CopyOnWriteArrayList<>(temasActivos);
        Collections.sort(ordenadosAlfabeticamente);
        ordenadosAlfabeticamente.forEach(System.out::println);

        // 3. Mostrar lista ordenada por prioridad ascendente
        System.out.println("\n=== Temas ordenados por prioridad ===");
        List<Tema> ordenadosPorPrioridad = new CopyOnWriteArrayList<>(temasActivos);
        Collections.sort(ordenadosPorPrioridad, Tema.comparadorPorPrioridad);
        ordenadosPorPrioridad.forEach(System.out::println);

        // 4. Crear repositorio concurrente de recursos
        ConcurrentHashMap<String, String> recursos = new ConcurrentHashMap<>();

        // Añadir algunos recursos de ejemplo
        recursos.put("Lectura comprensiva", "https://recursos.edu/lectura");
        recursos.put("Matemáticas básicas", "https://recursos.edu/mate");
        recursos.put("Cuidado del medio ambiente", "https://recursos.edu/medio-ambiente");
        recursos.put("Historia del arte", "Documentos PDF sobre movimientos artísticos");
        recursos.put("Introducción a la programación", "Ejercicios prácticos de Java");

        // 5. Mostrar los recursos disponibles
        System.out.println("\n=== Recursos por tema ===");
        recursos.forEach((tema, recurso) ->
                System.out.println(tema + ": " + recurso));

        // Ejemplo de cómo sería seguro acceder concurrentemente
        new Thread(() -> {
            temasActivos.add(new Tema("Educación física", 3));
            recursos.put("Educación física", "Guía de ejercicios básicos");
        }).start();

        new Thread(() -> {
            temasActivos.add(new Tema("Gramática avanzada", 2));
            recursos.put("Gramática avanzada", "Libro digital de gramática");
        }).start();
    }
}