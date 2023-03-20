import java.util.ArrayList;
import java.util.Objects;

public class Bodega {
    private ArrayList<Producto> productosEnVenta = new ArrayList<>();
    public Bodega(){

    }

    //Agraga un nuevo producto
    public void agragarProducto(Producto producto){
        productosEnVenta.add(producto);
    }

    //Elimina un producto
    public void eliminarProducto(Producto producto){
        productosEnVenta.remove(producto);
    }

    //Muestra los productos que hay en stock
    public void mostrarProductos(){
        for(int i = 0; i < productosEnVenta.size(); i++){
            System.out.println(productosEnVenta.get(i));
        }
    }

    //Busca un producto por su nombre o categoria
    public Producto buscarProductoPorNombre(String nombre){
        int posicion = -1;
        for (int i = 0; i < productosEnVenta.size(); i++) {
            if (productosEnVenta.get(i).getNombre() == nombre){
                posicion = i;
            }
        }
        if (posicion != -1) {
            return productosEnVenta.get(posicion);
        } else {
            return null;
        }
    }


    //Modificar un producto existente
    public void modificarProducto(Producto producto){

    }
    public ArrayList<Producto> getProductosEnVenta() {
        return productosEnVenta;
    }

    public ArrayList<Producto> encontrarProductosDeUnaCategoria(String categoria, ArrayList<Producto> productosEnVenta) {
        ArrayList<Producto> productosDeLaCategoria = new ArrayList<>();
        if (productosEnVenta == null) {
            return null;
        } else {
            int posicion = -1;
            for (int i = 0; i < productosEnVenta.size(); i++) {
                if (productosEnVenta.get(i).getCategoria().equalsIgnoreCase(categoria)) {
                    productosDeLaCategoria.add(productosEnVenta.get(posicion));
                }
            }
            if (posicion != -1) {
                return productosDeLaCategoria;
            } else {
                return null;
            }
        }
    }

}
