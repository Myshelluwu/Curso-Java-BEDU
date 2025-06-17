package hospital;

public class Paciente {
    String nombre;
    int edad;
    String numeroExpediente;

    public void mostrarInformacion(){
        System.out.println("Información del paciente:");
        System.out.println("Paciente: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Numero de expediente: " + numeroExpediente);
    }
}
