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
 
    public Date getFechaAlta() {
        return this.fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
   
    public void agregarPedido(Pedido pedido){
        this.historial.add(pedido);
    }

    public ArrayList<Pedido> getHistorial() {
        return this.historial;
    }

    public void setHistorial(ArrayList<Pedido> historial) {
        this.historial = historial;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.toLowerCase();
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos.toUpperCase();
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public static void agregadorClientesManual(ArrayList<Cliente> catalogoClientes) {
        Cliente cliente_1 = new Cliente("arsen", "kor", "calle", "1234");
        catalogoClientes.add(cliente_1);
    }

    //TODO validacion de campos
    @Override
    public String toString() {
        String cliente = "Nombre : " + nombre + "" + ", Apellidos : " + apellidos + "" + ", direccion : "
                + getDireccion() + "" + ", telefono : " + getTelefono() + "" + ", pedidos en el historial : " + getHistorial().size() + "";
        return cliente;

    }
}