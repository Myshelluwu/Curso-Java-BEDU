package hospital;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Paciente p1 = new Paciente();

        System.out.print("Ingresa el nombre del paciente: ");
        p1.nombre = entrada.nextLine();

        System.out.print("Ingrese la edad del paciente: ");
        p1.edad = entrada.nextInt();
        entrada.nextLine();

        System.out.print("Ingrese el numero del expediente: ");
        p1.numeroExpediente = entrada.nextLine();

        entrada.close();

        p1.mostrarInformacion();
    }
}
