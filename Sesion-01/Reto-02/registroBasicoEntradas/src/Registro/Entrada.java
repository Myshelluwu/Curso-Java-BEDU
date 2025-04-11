package Registro;

public class Entrada {
    String nombreEvento;
    double precioEntrada;

    public Entrada (String nombre, double precio){
        nombreEvento = nombre;
        precioEntrada = precio;
    }

    public void mostrarInformacion(String nombre, double precio){
        System.out.print("Evento: ");
        System.out.print(nombre);
        System.out.print(" | ");
        System.out.print("Precio: ");
        System.out.print(precio);
    }
}
