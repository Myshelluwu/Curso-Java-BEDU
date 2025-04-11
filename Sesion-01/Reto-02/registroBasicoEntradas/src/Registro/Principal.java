package Registro;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Entrada e1 = NuevaEntrada();
        e1.mostrarInformacion();

        Entrada e2 = NuevaEntrada();
        e2.mostrarInformacion();

    }

    public static Entrada NuevaEntrada(){
        String name;
        double precio;
        Scanner input = new Scanner(System.in);

        System.out.println("Ingrese el nombre del evento");
        name = input.next();

        System.out.println("Ingrese el precio del evento");
        precio = input.nextInt();
        input.nextLine();

        return new Entrada(name, precio);
    }


}
