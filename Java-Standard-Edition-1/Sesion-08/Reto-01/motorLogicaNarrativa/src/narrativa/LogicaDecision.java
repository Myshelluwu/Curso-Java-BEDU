package narrativa;

/** Abstracción (Interface) responsable de tomar la decisión del jugador */
public interface LogicaDecision {
    /** Devuelve true si elige la primera opción, false en otro caso */
    boolean elegir(String prompt, String opcion1, String opcion2);
}
