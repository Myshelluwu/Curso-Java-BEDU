package Farmacia;

public class SimuladorFarmacia {
    String nombreMedicamento;
    double precioUnitario;
    int cantidadPiezas;
    double total;
    boolean aplicaDescuento;
    double descuento;
    double totalFinal;

    public SimuladorFarmacia(String nombreMedicamento, double precioUnitario, int cantidadPiezas) {
        this.nombreMedicamento = nombreMedicamento;
        this.precioUnitario = precioUnitario;
        this.cantidadPiezas = cantidadPiezas;
    }

    public void mostrarDescuento (){
        total = (precioUnitario * cantidadPiezas);
        aplicaDescuento = total > 500;
        descuento = aplicaDescuento ? total * 0.15 : 0;
        totalFinal = total - descuento;
        System.out.println("Medicamento: " + this.nombreMedicamento);
        System.out.println("Cantidad: " + this.cantidadPiezas);
        System.out.println("Precio unitario: " + this.precioUnitario);
        System.out.println("Total sin descuento: " + this.total);
        System.out.println("¿Aplica descuento?: " + this.aplicaDescuento);
        System.out.println("Descuento: " + this.descuento);
        System.out.println("Total a pagar: "+ this.totalFinal);
    }

}
