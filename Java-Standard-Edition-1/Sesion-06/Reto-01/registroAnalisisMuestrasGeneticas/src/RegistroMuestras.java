import java.util.ArrayList;
import java.util.HashSet;

public class RegistroMuestras {
    private ArrayList<String> ordenMuestras;
    private HashSet<String> especiesUnicas;

    public RegistroMuestras() {
        this.ordenMuestras = new ArrayList<>();
        this.especiesUnicas = new HashSet<>();
    }

    // Método para añadir una nueva muestra
    public void agregarMuestra(String especie) {
        ordenMuestras.add(especie);
        especiesUnicas.add(especie);
    }

    // Método para obtener la lista completa de muestras
    public ArrayList<String> getOrdenMuestras() {
        return ordenMuestras;
    }

    // Método para obtener las especies únicas
    public HashSet<String> getEspeciesUnicas() {
        return especiesUnicas;
    }

    // Método para mostrar el registro completo
    public void mostrarRegistroCompleto() {
        System.out.println("=== Lista completa de muestras en orden de llegada ===");
        for (int i = 0; i < ordenMuestras.size(); i++) {
            System.out.println((i+1) + ". " + ordenMuestras.get(i));
        }
    }

    // Método para mostrar especies únicas
    public void mostrarEspeciesUnicas() {
        System.out.println("\n=== Especies únicas procesadas ===");
        for (String especie : especiesUnicas) {
            System.out.println("- " + especie);
        }
    }
}