import java.util.Comparator;

public class Tema implements Comparable<Tema> {
    private String titulo;
    private int prioridad;

    public Tema(String titulo, int prioridad) {
        this.titulo = titulo;
        this.prioridad = prioridad;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public int compareTo(Tema otro) {
        return this.titulo.compareTo(otro.titulo);
    }

    @Override
    public String toString() {
        return "Tema: " + titulo + " (Prioridad: " + prioridad + ")";
    }

    // Comparator para ordenar por prioridad ascendente
    public static Comparator<Tema> comparadorPorPrioridad = new Comparator<Tema>() {
        @Override
        public int compare(Tema t1, Tema t2) {
            return Integer.compare(t1.getPrioridad(), t2.getPrioridad());
        }
    };
}