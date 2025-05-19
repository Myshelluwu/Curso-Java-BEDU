public class Main {
    public static void main(String[] args) {
        Pasajero ana = new Pasajero("Ana Martínez", "AB123456");
        Vuelo vueloParis = new Vuelo("UX123", "París", "14:30");

        if (vueloParis.reservarAsiento(ana)) {
            System.out.println("Reserva realizada con éxito.\n");
        }
        System.out.println(vueloParis.obtenerItinerario());

        System.out.println("\nCancelando reserva...\n");
        vueloParis.cancelarReserva();
        System.out.println(vueloParis.obtenerItinerario());

        if (vueloParis.reservarAsiento("Mario Gonzalez", "CD789012")) {
            System.out.println("\nNueva reserva realizada con éxito.\n");
        }
        System.out.println(vueloParis.obtenerItinerario());
    }
}