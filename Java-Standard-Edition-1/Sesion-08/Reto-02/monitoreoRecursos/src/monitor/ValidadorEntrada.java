package monitor;

import java.util.HashSet;
import java.util.Set;

/** Encapsula la validación y deduplicación de registros. */
public class ValidadorEntrada {
    private final Set<Integer> registros = new HashSet<>();

    /**
     * Valida un valor de CPU.
     * @param valorStr entrada en texto proveniente del usuario
     * @return el valor entero validado
     * @throws NumberFormatException si no es numérico
     * @throws IllegalArgumentException si está fuera de rango o duplicado
     * @throws ConsumoCriticoException si supera el umbral crítico (95 %)
     */
    public int validar(String valorStr)
            throws NumberFormatException, IllegalArgumentException, ConsumoCriticoException {

        int valor = Integer.parseInt(valorStr.trim());

        if (valor < 0 || valor > 100) {
            throw new IllegalArgumentException("El valor debe estar entre 0 y 100 %");
        }
        if (!registros.add(valor)) {
            throw new IllegalArgumentException("Valor duplicado: " + valor + "%");
        }
        if (valor > 95) {
            throw new ConsumoCriticoException("⚠ Consumo crítico detectado: " + valor + "%");
        }
        return valor;
    }
}
