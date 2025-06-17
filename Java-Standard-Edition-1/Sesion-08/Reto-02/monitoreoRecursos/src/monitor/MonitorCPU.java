package monitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal que orquesta el flujo de monitoreo de CPU.
 * Demuestra buenas prácticas de validación, manejo de errores y cierre de recursos.
 */
public class MonitorCPU {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ValidadorEntrada validador = new ValidadorEntrada();
        List<Integer> consumos = new ArrayList<>();

        System.out.println("Ingrese valores de consumo CPU en % (ENTER en blanco para terminar):");

        try {
            while (true) {
                System.out.print("> ");
                String linea = scanner.nextLine();

                if (linea.isBlank()) break;            // fin entrada

                try {
                    int valor = validador.validar(linea);
                    consumos.add(valor);
                    System.out.println("✓ Registrado: " + valor + "%");
                } catch (ConsumoCriticoException e) {
                    System.err.println(e.getMessage()); // crítico pero se registra igual
                    consumos.add(Integer.parseInt(linea.trim()));
                } catch (NumberFormatException e) {
                    System.err.println("Entrada no numérica. Intente de nuevo.");
                } catch (IllegalArgumentException e) {
                    System.err.println("Entrada inválida: " + e.getMessage());
                }
            }

            // Resumen
            System.out.println("\nRegistros finales (" + consumos.size() + "): " + consumos);

        } finally {
            scanner.close(); // cierre seguro del recurso (good practice)
            System.out.println("Recursos liberados. Fin del monitoreo.");
        }
    }
}
