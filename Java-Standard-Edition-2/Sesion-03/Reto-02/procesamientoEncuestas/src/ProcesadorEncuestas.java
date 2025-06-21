import java.util.List;

public class ProcesadorEncuestas {
    public static void main(String[] args) {
        // Crear datos de ejemplo
        List<Sucursal> sucursales = List.of(
                new Sucursal("Centro", List.of(
                        new Encuesta("Juan Pérez", "El tiempo de espera fue largo", 3),
                        new Encuesta("María García", null, 2),
                        new Encuesta("Carlos López", "Excelente atención", 5)
                )),
                new Sucursal("Norte", List.of(
                        new Encuesta("Ana Martínez", "La atención fue buena, pero la limpieza puede mejorar", 3),
                        new Encuesta("Luisa Fernández", null, 1),
                        new Encuesta("Pedro Sánchez", "Muy satisfecho con el servicio", 4)
                )),
                new Sucursal("Sur", List.of(
                        new Encuesta("Laura Gómez", "El médico fue muy profesional", 5),
                        new Encuesta("Miguel Ruiz", "Demasiado tiempo en espera", 2),
                        new Encuesta("Sofía Díaz", null, 3)
                ))
        );

        System.out.println("📋 Procesando encuestas de pacientes insatisfechos...\n");

        // Procesamiento con Stream API
        sucursales.stream()
                // Aplanar la estructura para trabajar con todas las encuestas
                .flatMap(sucursal -> sucursal.getEncuestas().stream()
                        // Filtrar encuestas con calificación <=3 y comentario presente
                        .filter(encuesta -> encuesta.getCalificacion() <= 3)
                        .flatMap(encuesta -> encuesta.getComentario()
                                // Transformar cada comentario en mensaje de seguimiento
                                .map(comentario -> String.format(
                                        "Sucursal %s: Seguimiento a paciente con comentario: \"%s\"",
                                        sucursal.getNombre(),
                                        comentario))
                                .stream()))
                // Mostrar cada mensaje
                .forEach(System.out::println);

        System.out.println("\n✅ Proceso de análisis de calidad completado");
    }
}