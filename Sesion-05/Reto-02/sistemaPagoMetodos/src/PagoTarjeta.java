public class PagoTarjeta extends MetodoPago implements Autenticable {
    private double limiteTarjeta;

    public PagoTarjeta(double monto, double limiteTarjeta) {
        super(monto);
        this.limiteTarjeta = limiteTarjeta;
    }

    @Override
    public boolean autenticar() {
        return monto <= limiteTarjeta;
    }

    @Override
    public void procesarPago() {
        System.out.println("Procesando pago con tarjeta por $" + monto);
    }
}