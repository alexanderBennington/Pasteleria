package Modelo;

public class EnvioPedidos {
    private String id_pedido;
    private String nombre;
    private String direccion_envio;
    private String pagado;
    private float total;
    private String telefono;
    private String id_producto;
    private String pastel;
    private int cantidad;
    private float precio;

    public EnvioPedidos(String id_producto, String pastel, int cantidad, float precio) {
        this.id_producto = id_producto;
        this.pastel = pastel;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    
    public EnvioPedidos(String id_pedido, String nombre, String direccion_envio, String pagado, float total, String telefono) {
        this.id_pedido = id_pedido;
        this.nombre = nombre;
        this.direccion_envio = direccion_envio;
        this.pagado = pagado;
        this.total = total;
        this.telefono = telefono;
    }

    public String getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(String id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion_envio() {
        return direccion_envio;
    }

    public void setDireccion_envio(String direccion_envio) {
        this.direccion_envio = direccion_envio;
    }

    public String getPagado() {
        return pagado;
    }

    public void setPagado(String pagado) {
        this.pagado = pagado;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getPastel() {
        return pastel;
    }

    public void setPastel(String pastel) {
        this.pastel = pastel;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    
}
