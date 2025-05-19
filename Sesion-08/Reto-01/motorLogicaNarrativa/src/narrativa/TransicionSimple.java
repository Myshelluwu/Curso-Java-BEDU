package narrativa;

public class TransicionSimple implements TransicionHistoria {
    @Override
    public void avanzarA(String idEscena) {
        System.out.println("[Transición] → Escena: " + idEscena);
    }
}
