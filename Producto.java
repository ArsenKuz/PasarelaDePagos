import java.util.ArrayList;

public class Producto {

    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {

        this.nombre = nombre;
        this.precio = precio;
    }

    
    /** 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    /** 
     * @param precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    
    /** 
     * @return String
     */
    String getNombre() {
        return this.nombre;
    }

    
    /** 
     * @return double
     */
    double getPrecio() {
        return this.precio;
    }
    
    /** 
     * @return ArrayList<Producto>
     */
    public static ArrayList<Producto> crearInventario() {
        Producto producto_1 = new Producto("Veggie Buerger", 15.95);
        Producto producto_2 = new Producto("Meat Lovers Burger", 4.50);
        Producto producto_3 = new Producto("Fish thing", 4.50);
        Producto producto_4 = new Producto("Watah", 1.10);
        Producto producto_5 = new Producto("Cola", 1.50);
        Producto producto_6 = new Producto("Beer", 2.00);
        ArrayList<Producto> catalogoProductos = new ArrayList<Producto>();
        catalogoProductos.add(producto_1);
        catalogoProductos.add(producto_2);
        catalogoProductos.add(producto_3);
        catalogoProductos.add(producto_4);
        catalogoProductos.add(producto_5);
        catalogoProductos.add(producto_6);
        return catalogoProductos;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        String producto = "Producto : " + this.nombre + " Precio : " + this.precio;
        return producto;
    }

}
