import java.util.Date;

public class PasarelaDePago {
    private double importe;
    private String codigoPago;

    public PasarelaDePago(double importe) {
        // importe Tendrá como máximo dos decimales
        this.importe = Double.parseDouble(String.format("%.2f", importe));
        // Es un código que se genera cuando se realiza el pago
        this.codigoPago = null;
    }

    public double getImporte() {
        return this.importe;
    }

    public void setImporte(double importe) {
        this.importe = Double.parseDouble(String.format("%.2f", importe));

    }

    public String getCodigoPago() {
        return this.codigoPago;
    }

    public void setCodigoPago(String codigoPago) {
        this.codigoPago = codigoPago;
    }

    private void Efectivo() {
        this.importe = 0;
        this.codigoPago = String.valueOf(new Date().getTime());
    }

    private void Tarjeta(String numeroTarjeta) {
        // If Check regex numero tarjeta
        this.importe = 0;
        this.codigoPago = String.valueOf(new Date().getTime());
    }

    private void Cuenta(String cuenta) {
        // If Check regex IBAN
        this.importe = 0;
        this.codigoPago = String.valueOf(new Date().getTime());
    }

    public void Pagar(TipoPago TipoPago) {

        switch (TipoPago) {
            case EFECTIVO:
                this.Efectivo();
                break;
            case CUENTA:
                // leer una Cuenta desde Scanner(System.in) nextline
                this.Cuenta("TEST");
                break;
            case TARJETA:
                // leer una tarjeta desde Scanner(System.in) nextline
                this.Tarjeta("TEST");
                break;
            default:
                break;
        }
    }

}
