import java.util.Objects;

public class Factura {
    private String folio;
    private String cliente;
    private double total;

    public Factura(String folio, String cliente, double total){
        this.folio = folio;
        this.cliente = cliente;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura[" +
                "folio='" + folio + '\'' +
                ", cliente='" + cliente + '\'' +
                ", total=" + total +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Factura factura = (Factura) o;
        return folio.equals(factura.folio);
    }

    @Override
    public int hashCode() {
        return folio.hashCode();
    }
}
