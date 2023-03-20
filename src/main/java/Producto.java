public class Producto {
    private String nombre;
    private String descripcion;
    private String precio;
    private String stock;
    private String categoria;

    public Producto(String nombre, String descripcion, String precio,
                    String stock, String categoria){
        setNombre(nombre);
        setDescripcion(descripcion);
        setPrecio(precio);
        setStock(stock);
        setCategoria(categoria);
    }

    //Getters
    public String getNombre(){
        return nombre;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public String getPrecio(){
        return precio;
    }
    public String getStock(){
        return stock;
    }
    public String getCategoria(){
        return categoria;
    }

    //Setters
    private void setNombre(String nombre){
        this.nombre = nombre;
    }
    private void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    private void setPrecio(String precio){
        validacion(precio, "Ingrese un precio valido");
        this.precio = precio;
    }
    private void setStock(String stock){
        validacion(stock, "Ingrese un número valido");
        this.stock = stock;
    }
    private void setCategoria(String categoria){
        this.categoria = categoria;
    }

    //Para modificar productos
    public void modificarNombre(String nombreNuevo){
        setNombre(nombreNuevo);
    }
    public void modificarDescripcion(String descripcionNuevo){
        setNombre(descripcionNuevo);
    }
    public void modificarPrecio(String precioNuevo){
        validacion(precio, "Ingrese un precio valido");
        setNombre(precioNuevo);
    }
    public void modificarStock(String stockNuevo){
        validacion(stock, "Ingrese un número valido");
        setNombre(stockNuevo);
    }
    public void modificarCategoria(String categoriaNuevo){
        setNombre(categoriaNuevo);
    }
    //Validacion Número
    private void validacion(String numero, String mensaje){
        try {
            Integer.parseInt(numero);
        }catch (Exception e){
            System.out.println(mensaje);
        }
    }

    @Override
    public String toString() {
        return "Producto{" +
                "Nombre: " + nombre + '\n' +
                "Descripcion: " + descripcion + '\n' +
                "Precio: " + precio + '\n' +
                "Stock: " + stock + '\n' +
                "Categoria: " + categoria+
                '}';
    }
}
