package Registro;

public record Entrada_record ( String evento, double precio) {
    public void mostrarInformacion(){
        System.out.println("Evento: " + evento + " | Precio: " + precio);

    }
}
