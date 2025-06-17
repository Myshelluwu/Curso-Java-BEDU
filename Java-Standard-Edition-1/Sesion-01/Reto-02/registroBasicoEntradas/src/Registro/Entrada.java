package Registro;

public class Entrada {
    String nombreEvento;
    double precioEntrada;

    public Entrada (String nombre, double precio) {
        nombreEvento = nombre;
        precioEntrada = precio;
    }

    public void mostrarInformacion(){
        System.out.print("Evento: ");
        System.out.print(this.nombreEvento);
        System.out.print(" | ");
        System.out.print("Precio: ");
        System.out.println(this.precioEntrada);
    }
}
