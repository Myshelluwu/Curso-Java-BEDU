package narrativa;

import java.util.Scanner;

public class DecisionBinaria implements LogicaDecision {
    private final Scanner sc = new Scanner(System.in);

    @Override
    public boolean elegir(String prompt, String opcion1, String opcion2) {
        System.out.printf("%s%n1) %s%n2) %s%n> ", prompt, opcion1, opcion2);
        String entrada = sc.nextLine();
        return entrada.trim().equals("1");
    }
}
