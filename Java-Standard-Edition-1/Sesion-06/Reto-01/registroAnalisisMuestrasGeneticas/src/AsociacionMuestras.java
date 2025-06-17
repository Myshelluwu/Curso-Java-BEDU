import java.util.HashMap;

public class AsociacionMuestras {
    private HashMap<String, String> muestrasInvestigadores;

    public AsociacionMuestras() {
        this.muestrasInvestigadores = new HashMap<>();
    }

    // Método para asociar una muestra con un investigador
    public void agregarAsociacion(String idMuestra, String investigador) {
        muestrasInvestigadores.put(idMuestra, investigador);
    }

    // Método para buscar una muestra por ID
    public String buscarMuestra(String idMuestra) {
        return muestrasInvestigadores.get(idMuestra);
    }

    // Método para mostrar todas las asociaciones
    public void mostrarAsociaciones() {
        System.out.println("\n=== Relación de muestras e investigadores ===");
        for (String id : muestrasInvestigadores.keySet()) {
            System.out.println(id + " → " + muestrasInvestigadores.get(id));
        }
    }

    // Método para mostrar resultados de búsqueda
    public void mostrarResultadoBusqueda(String idBusqueda) {
        System.out.println("\n=== Búsqueda de muestra " + idBusqueda + " ===");
        String investigador = buscarMuestra(idBusqueda);
        if (investigador != null) {
            System.out.println("Muestra encontrada: " + idBusqueda +
                    " - Investigador: " + investigador);
        } else {
            System.out.println("Muestra " + idBusqueda + " no encontrada en los registros.");
        }
    }
}