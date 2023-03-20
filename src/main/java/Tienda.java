import java.util.Random;
import java.util.Scanner;

public class Tienda {
    public static void main (String [] args){
        principal();
    }

    public static void principal(){
        Bodega bodega = new Bodega();
        Scanner leer = new Scanner(System.in);
        int opc = -1;
        do{
            menu();
            opc = leer.nextInt();
            seleccion(opc, bodega);
        }while (opc !=0);
        System.out.println("Ha Salido.");
        System.exit(0);
    }

    public static void menu(){
        System.out.println(
                "0. Salir." + "\n" +
                        "1. Mostrar stock de productos." + "\n" +
                        "2. Buscar producto por nombre." + "\n" +
                        "3. Buscar producto por categoria." + "\n" +
                        "4. Agregar producto." + "\n" +
                        "5. Modificar producto." + "\n" +
                        "6. Eliminar producto." + "\n" +
                        "7. Realizar venta."
        );
    }

    public static void seleccion(int opc, Bodega bodega){
        Scanner leer = new Scanner(System.in);
        switch (opc) {
            case 0:
                break;
            case 1:
                if(bodega.getProductosEnVenta() == null){
                    System.out.println("No hay productos");
                } else{
                    bodega.mostrarProductos();
                }
                break;
            case 2:
                String nombreProducto;
                System.out.println("Escriba el nombre del producto");
                nombreProducto = leer.nextLine();
                if (bodega.buscarProductoPorNombre(nombreProducto) == null) {
                    System.out.println("No se ha encontrado el producto.");
                } else {
                    bodega.getProductosEnVenta().remove(bodega.buscarProductoPorNombre(nombreProducto));
                }
                break;
            case 3:
                String categoria = generarCategoriaAleatoria(generarNumerosAleatorios(3));
                String categoriaProducto;
                System.out.println("Escriba el categoria del producto");
                categoriaProducto = leer.nextLine();
                if (bodega.encontrarProductosDeUnaCategoria(categoria, bodega.getProductosEnVenta()) != null) {
                    System.out.println(
                            "Se ha encontrado a la(s) persona(s): " +
                                    bodega.encontrarProductosDeUnaCategoria(categoria, bodega.getProductosEnVenta())
                    );
                } else {
                    System.out.println("No se ha encontrado a la(s) persona(s).");
                }
                break;
            case 4:
                bodega.agragarProducto(new Producto("Producto",
                        "Descripcion Generica",
                        generarNumerosAleatorios(1),
                        generarNumerosAleatorios(2),
                        generarCategoriaAleatoria(generarNumerosAleatorios(3))
                ));
                break;
            case 5:
                String nombreDelProducto;
                int segmentoModificar;
                String nuevoSegmento;
                Producto productoModificar;
                do {
                    System.out.println("Escriba el nombre del producto que desea modificar.");
                    nombreDelProducto = leer.nextLine();
                    if (bodega.buscarProductoPorNombre(nombreDelProducto) == null) {
                        System.out.println("No se ha encontrado el producto.");
                    }
                } while (bodega.buscarProductoPorNombre(nombreDelProducto) == null);
                System.out.println("Escriba que desea modificar");
                System.out.println("1.Nombre");
                System.out.println("2.Descripcion");
                System.out.println("3.Precio");
                System.out.println("4.Stock");
                System.out.println("5.Categoria");
                segmentoModificar = leer.nextInt();
                System.out.println("Escriba el nuevo nombre o valor");
                nuevoSegmento = leer.nextLine();
                productoModificar = bodega.buscarProductoPorNombre(nombreDelProducto);
                switch (segmentoModificar){
                    case 1:
                        productoModificar.modificarNombre(nuevoSegmento);
                        break;
                    case 2:
                        productoModificar.modificarDescripcion(nuevoSegmento);
                        break;
                    case 3:
                        productoModificar.modificarPrecio(nuevoSegmento);
                        break;
                    case 4:
                        productoModificar.modificarStock(nuevoSegmento);
                        break;
                    case 5:
                        productoModificar.modificarCategoria(nuevoSegmento);
                        break;
                }
                System.out.println("Se ha modificado el Produto");
                break;
            case 6:
                String nombre;
                System.out.println("Escriba el nombre del producto que desea eliminar.");
                nombre = leer.nextLine();
                if(bodega.buscarProductoPorNombre(nombre) == null){
                    System.out.println("No se ha encontrado el producto.");
                }else{
                    bodega.getProductosEnVenta().remove(bodega.buscarProductoPorNombre(nombre));
                }
                break;
            case 7:
                String nombreProductoVenta;
                System.out.println("Escriba el nombre del producto que desea eliminar.");
                nombreProductoVenta = leer.nextLine();
                if(bodega.buscarProductoPorNombre(nombreProductoVenta) == null){
                    System.out.println("No se ha encontrado el producto.");
                }else{
                    System.out.println("Se ha completado la venta");
                    System.out.println("Detalle: " + bodega.buscarProductoPorNombre(nombreProductoVenta));
                    bodega.getProductosEnVenta().remove(bodega.buscarProductoPorNombre(nombreProductoVenta));
                }
                break;
            default:
                System.out.println("Agregue una opción valida");
        }

    }

    public static String generarNumerosAleatorios(int opcion){
        //opcion 1 es para generar un precio
        if(opcion == 1){
            Random numero = new Random();
            String numeroAleatorio = "";
            for(int i = 0; i < 5; i++){
                numeroAleatorio = numeroAleatorio + Integer.toString(numero.nextInt(10));
            }
            return numeroAleatorio;
        }
        //opcion 2 es para generar una cantidad para stock
        if(opcion == 2){
            Random numero = new Random();
            String numeroAleatorio = "";
            for(int i = 0; i < 3; i++){
                numeroAleatorio = numeroAleatorio + Integer.toString(numero.nextInt(10));
            }
            return numeroAleatorio;
        }
        //la opcion 3 es para generar un numero aleatorio del 0 al 2
        if(opcion == 3){
            Random numero = new Random();
            String numeroAleatorio = "";
            for(int i = 0; i < 1; i++){
                numeroAleatorio = numeroAleatorio + Integer.toString(numero.nextInt(3));
            }
            return numeroAleatorio;
        }
        return null;
    }
    public static String generarCategoriaAleatoria(String numero){
        if(numero.equals(0)){
            return "Nootbook";
        }
        if(numero.equals(1)){
            return "Escritorio";
        }
        if(numero.equals(2)){
            return "Radio";
        }
        return null;
    }

}
