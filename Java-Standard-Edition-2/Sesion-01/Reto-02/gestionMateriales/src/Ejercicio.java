public class Ejercicio extends MaterialCurso {
    private boolean revisado;

    public Ejercicio(String titulo, String autor) {
        super(titulo, autor);
        this.revisado = false;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("📝 Ejercicio: " + titulo + " - Autor: " + autor + " - Revisado: " + revisado);
    }

    public void marcarRevisado() {
        this.revisado = true;
        System.out.println("✅ Ejercicio '" + titulo + "' marcado como revisado.");
    }
}