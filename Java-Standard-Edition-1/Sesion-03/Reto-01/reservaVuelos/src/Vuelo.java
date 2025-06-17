public class Vuelo {
    final String codigoVuelo;
    String destino;
    String horaSalida;
    private Pasajero asientoReservado;

    public Vuelo(String codigoVuelo, String destino, String horaSalida) {
        this.codigoVuelo = codigoVuelo;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.asientoReservado = null;
    }

    public boolean reservarAsiento(Pasajero p) {
        if (asientoReservado == null) {
            asientoReservado = p;
            return true;
        }
        return false;
    }

    public boolean reservarAsiento(String nombre, String pasaporte) {
        if (asientoReservado == null) {
            asientoReservado = new Pasajero(nombre, pasaporte);
            return true;
        }
        return false;
    }

    public void cancelarReserva() {
        asientoReservado = null;
    }

    public String obtenerItinerario() {
        String itinerario = "Itinerario del vuelo:\n";
        itinerario += "Código: " + codigoVuelo;
        itinerario += "\nDestino: " + destino;
        itinerario += "\nSalida: " + horaSalida;

        if (asientoReservado != null) {
            itinerario += "\nPasajero: " + asientoReservado.getNombre();
        } else {
            itinerario += "\nPasajero: [Sin reserva]";
        }

        return itinerario;
    }
}