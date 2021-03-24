import java.util.Date;
import java.util.Scanner;

public class PasarelaDePago {
    private double importe;
    private String codigoPago;

    public PasarelaDePago(double importe) {
        // importe Tendrá como máximo dos decimales
        this.importe = Double.parseDouble(String.format("%.2f", importe));
        // Es un código que se genera cuando se realiza el pago
        this.codigoPago = null;
    }

    
    /** 
     * @return double
     */
    public double getImporte() {
        return this.importe;
    }

    
    /** 
     * @param importe
     */
    public void setImporte(double importe) {
        this.importe = Double.parseDouble(String.format("%.2f", importe));

    }

    
    /** 
     * @return String
     */
    public String getCodigoPago() {
        return this.codigoPago;
    }

    
    /** 
     * @param codigoPago
     */
    public void setCodigoPago(String codigoPago) {
        this.codigoPago = codigoPago;
    }

    
    /** 
     * @param efectivo
     */
    private void Efectivo(String efectivo) {
        this.importe = 0;
        this.codigoPago = String.valueOf(new Date().getTime());
    }

    
    /** 
     * @param numeroTarjeta
     */
    private void Tarjeta(String numeroTarjeta) {
        // If Check regex numero tarjeta
        this.importe = 0;
        this.codigoPago = String.valueOf(new Date().getTime());
    }

    
    /** 
     * @param cuenta
     */
    private void Cuenta(String cuenta) {
        // If Check regex IBAN
        this.importe = 0;
        this.codigoPago = String.valueOf(new Date().getTime());
    }

    
    /** 
     * @param TipoPago
     */
    public void Pagar(TipoPago TipoPago) {
        Scanner metodoPago = new Scanner(System.in);
        String opcion;

        switch (TipoPago) {

        case EFECTIVO:
            System.out.print("Introduce el efectivo: ");
            opcion = metodoPago.nextLine();
            this.Efectivo(opcion);
            break;
        case CUENTA:
            System.out.print("Introduce el número de cuenta: ");
            opcion = metodoPago.nextLine();
            this.Cuenta(opcion);
            break;
        case TARJETA:
            System.out.print("Introduce el nuúmero tarjeta: ");
            opcion = metodoPago.nextLine();
            this.Tarjeta(opcion);
            break;
        default:
            break;
        }
    }

}
