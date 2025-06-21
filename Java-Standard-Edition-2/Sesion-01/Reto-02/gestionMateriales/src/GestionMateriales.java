import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;

public class GestionMateriales {

    // Método para mostrar cualquier tipo de material
    public static void mostrarMateriales(List<? extends MaterialCurso> lista) {
        System.out.println("\n📚 Materiales del curso:");
        for (MaterialCurso material : lista) {
            material.mostrarDetalle();
        }
    }

    // Método para contar duración total de videos
    public static void contarDuracionVideos(List<? extends Video> lista) {
        int total = 0;
        for (Video video : lista) {
            total += video.getDuracion();
        }
        System.out.println("\n🎥 Duración total de videos: " + total + " minutos");
    }

    // Método para marcar ejercicios como revisados
    public static void marcarEjerciciosRevisados(List<? super Ejercicio> lista) {
        for (Object obj : lista) {
            if (obj instanceof Ejercicio) {
                Ejercicio ejercicio = (Ejercicio) obj;
                ejercicio.marcarRevisado();
            }
        }
    }

    // Método opcional para filtrar por autor (usando Predicate)
    public static void filtrarPorAutor(List<? extends MaterialCurso> lista, Predicate<MaterialCurso> condicion) {
        System.out.println("\n🔍 Filtrando materiales por autor:");
        for (MaterialCurso material : lista) {
            if (condicion.test(material)) {
                material.mostrarDetalle();
            }
        }
    }

    public static void main(String[] args) {
        // Crear materiales del curso
        List<MaterialCurso> materiales = new ArrayList<>();
        materiales.add(new Video("Introducción a Java", "Mario", 15));
        materiales.add(new Video("POO en Java", "Carlos", 20));
        materiales.add(new Articulo("Historia de Java", "Ana", 1200));
        materiales.add(new Articulo("Tipos de datos", "Luis", 800));
        materiales.add(new Ejercicio("Variables y tipos", "Luis"));
        materiales.add(new Ejercicio("Condicionales", "Mario"));

        // Mostrar todos los materiales
        mostrarMateriales(materiales);

        // Crear lista específica de videos para contar duración
        List<Video> videos = new ArrayList<>();
        for (MaterialCurso m : materiales) {
            if (m instanceof Video) {
                videos.add((Video) m);
            }
        }
        contarDuracionVideos(videos);

        // Marcar ejercicios como revisados
        marcarEjerciciosRevisados(materiales);

        // Filtrar por autor (desafío adicional)
        Predicate<MaterialCurso> filtroMario = m -> "Mario".equals(m.autor);
        filtrarPorAutor(materiales, filtroMario);
    }
}