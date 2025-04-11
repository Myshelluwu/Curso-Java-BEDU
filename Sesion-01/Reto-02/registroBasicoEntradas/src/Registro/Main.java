package Registro;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name;
        double precio;
        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese el nombre del evento");
        name = entrada.next();

        System.out.println("Ingrese el precio del evento");
        precio = entrada.nextInt();
        entrada.nextLine();

        Entrada e1 = new Entrada(name, precio);

        e1.mostrarInformacion(name, precio);
    }
}
