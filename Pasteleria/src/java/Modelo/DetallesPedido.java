package Modelo;

public class DetallesPedido {
    private String id_pedido;
    private String id_producto;
    private String nombre;
    private int cantidad;

    public DetallesPedido(String id_pedido, String id_producto, String nombre, int cantidad) {
        this.id_pedido = id_pedido;
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(String id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
