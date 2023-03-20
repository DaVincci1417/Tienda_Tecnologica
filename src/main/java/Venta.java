import java.util.ArrayList;

public class Venta {
    private ArrayList<Producto> productos;
    private int cliente;

    public Venta(ArrayList<Producto> productos, int cliente){
        setProductos(productos);
        setCliente(cliente);
    }

    //Getters
    public ArrayList<Producto> getProductos() {
        return productos;
    }
    public int getCliente() {
        return cliente;
    }

    //Setters
    private void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
    private void setCliente(int cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "Productos" + productos + "\n" +
                "Cliente: " + cliente +
                '}';
    }
}
