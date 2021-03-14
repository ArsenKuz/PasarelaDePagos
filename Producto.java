public class Producto {

    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {

        this.nombre = nombre;
        this.precio = precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    String getNombre() {
        return this.nombre;
    }

    double getPrecio() {
        return this.precio;
    }

    @Override
    public String toString() {
        String producto = "Producto : " + this.nombre + " Precio : " + this.precio;
        return producto;
    }

}
