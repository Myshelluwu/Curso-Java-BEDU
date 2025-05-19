package narrativa;

/**
 * Clase orquestadora que depende SOLO de interfaces
 * (Inversión de Dependencias – DIP).
 */
public class MainNarrativa {
    private final TransicionHistoria transicion;
    private final GestorDialogo dialogo;
    private final LogicaDecision decision;

    public MainNarrativa(TransicionHistoria t, GestorDialogo d, LogicaDecision l) {
        this.transicion = t;
        this.dialogo = d;
        this.decision = l;
    }

    public void ejecutar() {
        transicion.avanzarA("Bosque");
        dialogo.decir("Narrador", "Llegas a un cruce entre dos caminos.");
        boolean izquierda = decision.elegir(
                "¿Qué camino tomas?",
                "Ir a la izquierda (hacia la luz)",
                "Ir a la derecha (hacia la sombra)"
        );

        if (izquierda) {
            transicion.avanzarA("Claro luminoso");
            dialogo.decir("Guardián", "¡Bienvenido, viajero de corazón valiente!");
        } else {
            transicion.avanzarA("Caverna oscura");
            dialogo.decir("Eco", "Los temerarios siempre pagan un precio...");
        }
        dialogo.decir("Narrador", "Fin de la demostración.");
    }

    public static void main(String[] args) {
        MainNarrativa juego = new MainNarrativa(
                new TransicionSimple(),
                new DialogoTexto(),
                new DecisionBinaria()
        );
        juego.ejecutar();
    }
}
