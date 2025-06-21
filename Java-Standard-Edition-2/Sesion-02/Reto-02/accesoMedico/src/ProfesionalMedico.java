public class ProfesionalMedico implements Runnable {
    private final RecursoMedico recurso;
    private final String nombre;

    public ProfesionalMedico(RecursoMedico recurso, String nombre) {
        this.recurso = recurso;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            System.out.println("⏳ " + nombre + " solicitando acceso...");
            recurso.usar(nombre);
        } catch (Exception e) {
            System.out.println("❌ Error con " + nombre + ": " + e.getMessage());
        }
    }
}