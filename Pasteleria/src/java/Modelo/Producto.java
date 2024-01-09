package Modelo;

public class Producto {
    private String id_producto;
    private String nombre;
    private String img_producto;
    private String categoria;
    private float precio;
    private String tamaño;
    private int stock;

    public Producto(String id_producto, String nombre, String img_producto, String categoria, float precio, String tamaño, int stock) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.img_producto = img_producto;
        this.categoria = categoria;
        this.precio = precio;
        this.tamaño = tamaño;
        this.stock = stock;
    }
    
    public Producto(){
        
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

    public String getImg_producto() {
        return img_producto;
    }

    public void setImg_producto(String img_producto) {
        this.img_producto = img_producto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
}
