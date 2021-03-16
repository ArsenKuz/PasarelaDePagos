
import java.util.Date;
import java.util.HashMap;
// import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.ArrayList;
// import java.util.Collections;

public class Main {

   
   
    
   
   
    public static Cliente crearCliente() {
        // Creamos metodo para agregar instancias cliente
        Scanner creadorClientesScanner = new Scanner(System.in);
        System.out.print("Introduce el nombre: ");
        String nombre = creadorClientesScanner.nextLine();
        System.out.print("Introduce apellidos: ");
        String apellidos = creadorClientesScanner.nextLine();
        System.out.print("Introduce la dirección: ");
        String direccion = creadorClientesScanner.nextLine();
        // TODO -Hay que tener en cuenta que puede que el usuario introduzca espacios, es decir: 766 28 56 33 sería un teléfono válido 
        String regExTotal = "\\b[6-7]{1}[0-9]{8}\\b";
        Boolean coincide = false;
        String telefono = "";
        while (true) {
            System.out.print("Introduce el telefono: ");
            telefono = creadorClientesScanner.nextLine();
            coincide = Pattern.matches(regExTotal, telefono);
            if (coincide) {
                Cliente cliente = new Cliente(nombre, apellidos, direccion, telefono);
                return cliente;
            } else {
                System.out.println("Número de teléfono no válido.");
            }
        }
    }

    

    public static void menuAgregarProductosAlPedido(ArrayList<Producto> catalogoProductos, Pedido nuevoPedido) {
        Scanner administrarProductosScanner = new Scanner(System.in);
        String opcion;
        int product_index = 0;
        while (true) {
            System.out.println("\n*** Elige producto a añadir (0 para finalizar pedido) ***");
            Interfaces.imprimirProductos(catalogoProductos);
            opcion = administrarProductosScanner.nextLine();
            if (opcion.equals("0")) {
                return; // volver al menu anterior
            }
            try {
                // 1º comprobamos que opcion es un entero & indice -1 (xk empezamos en 0)
                product_index = Integer.parseInt(opcion) - 1;
                try {
                    // 2º comprobamos que existe un producto en el catalogo de productos con ese
                    Producto producto_seleccionado = catalogoProductos.get(product_index);
                    nuevoPedido.agregarProducto(producto_seleccionado);
                    nuevoPedido.imprimirProductosDelPedido();
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(
                            "\n*** Producto: " + (product_index) + " no encontrado en el catalogo de productos ***");
                }
            } catch (NumberFormatException e) {
                System.out.println("\n*** Opcion: '" + opcion + "' no válida. ***");
            }
            // System.out.println(nuevoPedido.getImporte(0));
        }
    }

    public static void menuEliminarProductosDelPedido(Pedido nuevoPedido) {
        Scanner administrarProductosScanner = new Scanner(System.in);
        String opcion;
        int product_index = 0;
        while (true) {
            System.out.println("\n*** Elige producto a eliminar (0 para finalizar pedido) ***");
            Interfaces.imprimirProductos(nuevoPedido.getListaProductos());
            opcion = administrarProductosScanner.nextLine();
            if (opcion.equals("0")) {
                return;
            }
            try {
                // 1º comprobamos que opcion es un entero & indice -1 (xk empezamos en 0)
                product_index = Integer.parseInt(opcion) - 1;
                try {
                    nuevoPedido.eliminarProducto(product_index);
                    nuevoPedido.imprimirProductosDelPedido();
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(
                            "\n*** Producto: " + (product_index) + " no encontrado en la lista de productos ***");
                }
            } catch (NumberFormatException e) {
                System.out.println("\n*** Opcion: '" + opcion + "' no válida. ***");
            }
        }
    }

    public static void menuConfirmarPedido(Pedido nuevoPedido, Cliente cliente) {
        Scanner administrarProductosScanner = new Scanner(System.in);
        String opcion;
        int tipoPagoIndex = 0;
        while (true) {
            System.out.println(nuevoPedido);
            System.out.println("¿Como quieres pagarlo?");
            Interfaces.imprimirPosiblesPagos();
            opcion = administrarProductosScanner.nextLine();
            if (opcion.equals("0")) {
                return;
            } else {
                try {
                    // 1º comprobamos que opcion es un entero & indice -1 (xk empezamos en 0)
                    tipoPagoIndex = Integer.parseInt(opcion) - 1;
                    try {
                        // 2º comprobamos que existe un producto en el catalogo de productos con ese
                        TipoPago pagoSeleccionado = TipoPago.values()[tipoPagoIndex];
                        System.out.println("Vamos a pagar con: " + pagoSeleccionado);
                        // pagar pedido -> genero código pago
                        nuevoPedido.Pagar(pagoSeleccionado);
                        // añadimos el pedido al historial del cliente
                        cliente.agregarPedido(nuevoPedido);
                        return;
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("\n*** TipoPago: " + (tipoPagoIndex)
                                + " no encontrado en el catalogo de Pagos admisibles ***");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("\n*** Opcion: '" + opcion + "' no válida. ***");
                }
            }

        }
    }

    
    public static void gestionDePedidos(Cliente cliente, ArrayList<Pedido> catalogoPedidos,
            ArrayList<Producto> catalogoProductos) {
        // Cada vez que accedemos a una gestion de pedido, creamos un nuevo pedido
        Pedido nuevoPedido = new Pedido(cliente);
        Scanner administrarProductosScanner = new Scanner(System.in);
        String opcion;
        while (true) {
           
            Interfaces.imprimirMenuGestionPedidos();
            opcion = administrarProductosScanner.nextLine();
            if (opcion.equals("1")) {
                menuAgregarProductosAlPedido(catalogoProductos, nuevoPedido);
            } else if (opcion.equals("2")) {
                menuEliminarProductosDelPedido(nuevoPedido);
            } else if (opcion.equals("3")) {
                if (nuevoPedido.pedidoVacio()) {
                    System.out.println("Tienes que agregar un producto al pedido");
                } else {
                    menuConfirmarPedido(nuevoPedido, cliente);
                    return;
                }

            } else if (opcion.equals("0")) {
                return;
            } else {
                System.out.println("Parámetro " + opcion + " no reconocido.");
            }
            System.out.println(nuevoPedido);
        }
    }

    public static void gestionDeUsuarios(ArrayList<Cliente> catalogoClientes) {
        Scanner administrarClientesScanner = new Scanner(System.in);
        String opcion;

        while (true) {
            Interfaces.imprimirMenuCliente();

            opcion = administrarClientesScanner.nextLine();
            if (opcion.equals("1")) {
                Cliente nuevoCliente = crearCliente();
                catalogoClientes.add(nuevoCliente);
            } else if (opcion.equals("2")) {
                System.out.print("***********Lista de clientes********* ");
                System.out.println();

                // System.out.println(catalogoClientes);
                Iterator<Cliente> iterador = catalogoClientes.iterator();
                int index = 1;
                while (iterador.hasNext()) {

                    System.out.println(index + " - " + (Cliente) iterador.next());
                    index++;
                }
            } else if (opcion.equals("0")) {
                return;

            } else {
                System.out.println("Parámetro " + opcion + " no reconocido.");
            }

        }
    }

   
    public static Cliente seleccionarCliente(ArrayList<Cliente> catalogoClientes) {

        System.out.println("***** Listado de usuarios a seleccionar: *****");
        // para seleccionar un usuario, primero los imprimimos
        Iterator<Cliente> iterador = catalogoClientes.iterator();
        int index = 1;
        while (iterador.hasNext()) {
            System.out.println(index + " - " + (Cliente) iterador.next());
            index++;
        }
        System.out.println("Seleccione uno de los clientes listados anteriormente.");

        Scanner scanner = new Scanner(System.in);
        int usuario_index = scanner.nextInt();
        // To Do (try-catch java.lang.IndexOutOfBoundsException)
        Cliente clienteSeleccionado = catalogoClientes.get(usuario_index - 1);
        return clienteSeleccionado;
        
    }
    
    public static void main(String[] args)

    {
        // 
        ArrayList<Cliente> catalogoClientes = new ArrayList<Cliente>();
        // creamos el catálogo de pedidos - dinámicamente
        ArrayList<Pedido> catalogoPedidos = new ArrayList<Pedido>();
        // creamos un catalogo basado en el ARRAY
        ArrayList<Producto> catalogoProductos =Producto.crearInventario();
        // arrancamos la "base de datos de clientes"

        // arrancamos la función principal (menu)
        Interfaces.menuPrincipal(catalogoClientes, catalogoPedidos, catalogoProductos);


    }

}

// {
// String fechaHoy = "yyyy-MM-dd HH:mm:ssZ";
// SimpleDateFormat simpleDateFormat = new SimpleDateFormat(fechaHoy);

// String date = simpleDateFormat.format(new Date());
// System.out.println(date);

// ArrayList pedido = new ArrayList();

// pedido.add("Hamburguesa");
// pedido.add(20);
// pedido.add(true);



// System.out.println(pedido);

// }
