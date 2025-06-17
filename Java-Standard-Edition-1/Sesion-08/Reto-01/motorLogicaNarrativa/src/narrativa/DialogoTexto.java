package narrativa;

public class DialogoTexto implements GestorDialogo {
    @Override
    public void decir(String personaje, String texto) {
        System.out.println(personaje + ": \"" + texto + "\"");
    }
}
