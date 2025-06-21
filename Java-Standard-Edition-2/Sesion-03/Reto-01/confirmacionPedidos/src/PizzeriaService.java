import java.util.List;
import java.util.Optional;

public class PizzeriaService {
    public static void main(String[] args) {
        // Crear lista de pedidos de ejemplo
        List<Pedido> pedidos = List.of(
                new Pedido("Juan Pérez", "domicilio", "555-1234"),
                new Pedido("María García", "local", null),
                new Pedido("Carlos López", "domicilio", "555-5678"),
                new Pedido("Ana Martínez", "domicilio", null),
                new Pedido("Luisa Fernández", "domicilio", "555-9012")
        );

        System.out.println("📞 Procesando confirmaciones de pedidos a domicilio...\n");

        // Procesar los pedidos con Stream API y Optional
        pedidos.stream()
                // Filtrar solo pedidos a domicilio
                .filter(p -> "domicilio".equalsIgnoreCase(p.getTipoEntrega()))
                // Obtener los teléfonos como Optional y filtrar los presentes
                .map(Pedido::getTelefono)
                .flatMap(Optional::stream)
                // Transformar cada teléfono en mensaje de confirmación
                .forEach(telefono ->
                        System.out.println("📞 Confirmación enviada al número: " + telefono));

        System.out.println("\n✅ Proceso de confirmación completado");
    }
}