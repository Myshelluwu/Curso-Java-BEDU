import java.util.List;
import java.util.ArrayList;

public class GestionOrdenes {
    
    // Método para mostrar cualquier tipo de orden
    public static void mostrarOrdenes(List<? extends OrdenProduccion> lista) {
        System.out.println("\n📋 Órdenes registradas:");
        for (OrdenProduccion orden : lista) {
            orden.mostrarResumen();
        }
    }
    
    // Método para procesar órdenes personalizadas
    public static void procesarPersonalizadas(List<? super OrdenPersonalizada> lista, int costoAdicional) {
        System.out.println("\n💰 Procesando órdenes personalizadas...");
        for (Object obj : lista) {
            if (obj instanceof OrdenPersonalizada) {
                OrdenPersonalizada orden = (OrdenPersonalizada) obj;
                orden.agregarCostoAdicional(costoAdicional);
            }
        }
    }
    
    // Método opcional para contar órdenes por tipo
    public static void contarOrdenes(List<? extends OrdenProduccion> lista) {
        int masa = 0, personalizada = 0, prototipo = 0;
        
        for (OrdenProduccion orden : lista) {
            if (orden instanceof OrdenMasa) masa++;
            else if (orden instanceof OrdenPersonalizada) personalizada++;
            else if (orden instanceof OrdenPrototipo) prototipo++;
        }
        
        System.out.println("\n📊 Resumen total de órdenes:");
        System.out.println("🔧 Producción en masa: " + masa);
        System.out.println("🛠️ Personalizadas: " + personalizada);
        System.out.println("🧪 Prototipos: " + prototipo);
    }

    public static void main(String[] args) {
        // Crear listas de órdenes
        List<OrdenMasa> ordenesMasa = new ArrayList<>();
        ordenesMasa.add(new OrdenMasa("A123", 500));
        ordenesMasa.add(new OrdenMasa("A124", 750));
        
        List<OrdenPersonalizada> ordenesPersonalizadas = new ArrayList<>();
        ordenesPersonalizadas.add(new OrdenPersonalizada("P456", 100, "ClienteX"));
        ordenesPersonalizadas.add(new OrdenPersonalizada("P789", 150, "ClienteY"));
        
        List<OrdenPrototipo> ordenesPrototipo = new ArrayList<>();
        ordenesPrototipo.add(new OrdenPrototipo("T789", 10, "Diseño"));
        ordenesPrototipo.add(new OrdenPrototipo("T790", 5, "Pruebas"));
        
        // Mostrar todas las órdenes
        mostrarOrdenes(ordenesMasa);
        mostrarOrdenes(ordenesPersonalizadas);
        mostrarOrdenes(ordenesPrototipo);
        
        // Procesar órdenes personalizadas
        List<OrdenProduccion> todasLasOrdenes = new ArrayList<>();
        todasLasOrdenes.addAll(ordenesPersonalizadas);
        procesarPersonalizadas(todasLasOrdenes, 200);
        
        // Contar órdenes (desafío adicional)
        todasLasOrdenes.addAll(ordenesMasa);
        todasLasOrdenes.addAll(ordenesPrototipo);
        contarOrdenes(todasLasOrdenes);
    }
}