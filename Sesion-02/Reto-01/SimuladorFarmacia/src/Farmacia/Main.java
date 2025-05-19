package Farmacia;

public class Main {
    public static void main(String[] args) {
        SimuladorFarmacia medicamento = new SimuladorFarmacia("Amoxicilina", 99.34, 6);

        medicamento.mostrarDescuento();
    }
}