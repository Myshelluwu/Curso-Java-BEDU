package monitor;

/** Excepción comprobada (checked) que indica consumo crítico de CPU. */
public class ConsumoCriticoException extends Exception {
    public ConsumoCriticoException(String mensaje) {
        super(mensaje);
    }
}
