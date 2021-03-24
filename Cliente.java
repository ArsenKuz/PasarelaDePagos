import java.util.ArrayList;
import java.util.Date;

public class Cliente {

    private String nombre;
    private String apellidos;
    private Date fechaAlta;
    private String telefono;
    private String direccion;
    private ArrayList<Pedido> historial;

    public Cliente(String nombre, String apellidos, String direccion, String telefono, ArrayList<Pedido> historial, Date fechaAlta) 
    {   

        this.nombre = nombre.toLowerCase();
        this.apellidos = apellidos.toUpperCase();
        this.direccion = direccion;
        this.telefono = telefono;
        this.historial = historial;
        this.fechaAlta = fechaAlta;
    }
   
    public Cliente(String nombre, String apellidos, String direccion, String telefono) 
    {
        this.nombre = nombre.toLowerCase();
        this.apellidos = apellidos.toUpperCase();
        this.direccion = direccion;
        this.telefono = telefono;
        this.historial= new ArrayList<Pedido>();
        this.fechaAlta = new Date();
    }
 
    
    /** 
     * @return Date
     */
    public Date getFechaAlta() {
        return this.fechaAlta;
    }

    
    /** 
     * @param fechaAlta
     */
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
   
    
    /** 
     * @param pedido
     */
    public void agregarPedido(Pedido pedido){
        this.historial.add(pedido);
    }

    
    /** 
     * @return ArrayList<Pedido>
     */
    public ArrayList<Pedido> getHistorial() {
        return this.historial;
    }

    
    /** 
     * @param historial
     */
    public void setHistorial(ArrayList<Pedido> historial) {
        this.historial = historial;
    }

    
    /** 
     * @return String
     */
    public String getNombre() {
        return this.nombre;
    }

    
    /** 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre.toLowerCase();
    }

    
    /** 
     * @return String
     */
    public String getApellidos() {
        return this.apellidos;
    }

    
    /** 
     * @param apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos.toUpperCase();
    }

    
    /** 
     * @return String
     */
    public String getDireccion() {
        return this.direccion;
    }

    
    /** 
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    /** 
     * @return String
     */
    public String getTelefono() {
        return this.telefono;
    }

    
    /** 
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    /** 
     * @param catalogoClientes
     */
    public static void agregadorClientesManual(ArrayList<Cliente> catalogoClientes) {
        Cliente cliente_1 = new Cliente("arsen", "kor", "calle", "1234");
        catalogoClientes.add(cliente_1);
    }

    
    /** 
     * @return String
     */
    //TODO validacion de campos
    @Override
    public String toString() {
        String cliente = "Nombre : " + nombre + "" + ", Apellidos : " + apellidos + "" + ", direccion : "
                + getDireccion() + "" + ", telefono : " + getTelefono() + "" + ", pedidos en el historial : " + getHistorial().size() + "";
        return cliente;

    }
}