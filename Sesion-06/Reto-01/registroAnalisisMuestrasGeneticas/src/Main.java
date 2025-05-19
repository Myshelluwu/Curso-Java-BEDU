public class Main {
    public static void main(String[] args) {
        // Crear instancia para manejar el registro de muestras
        RegistroMuestras registro = new RegistroMuestras();

        // Agregar muestras al registro
        registro.agregarMuestra("Homo sapiens");
        registro.agregarMuestra("Mus musculus");
        registro.agregarMuestra("Arabidopsis thaliana");
        registro.agregarMuestra("Homo sapiens"); // Muestra repetida
        registro.agregarMuestra("Drosophila melanogaster");
        registro.agregarMuestra("Mus musculus"); // Muestra repetida

        // Crear instancia para manejar las asociaciones con investigadores
        AsociacionMuestras asociaciones = new AsociacionMuestras();

        // Agregar asociaciones muestra-investigador
        asociaciones.agregarAsociacion("M-001", "Dra. López");
        asociaciones.agregarAsociacion("M-002", "Dr. Hernández");
        asociaciones.agregarAsociacion("M-003", "Dra. García");
        asociaciones.agregarAsociacion("M-004", "Dr. Martínez");
        asociaciones.agregarAsociacion("M-005", "Dra. Rodríguez");

        // Mostrar resultados
        registro.mostrarRegistroCompleto();
        registro.mostrarEspeciesUnicas();
        asociaciones.mostrarAsociaciones();

        // Realizar búsqueda de muestra
        asociaciones.mostrarResultadoBusqueda("M-002");
    }
}