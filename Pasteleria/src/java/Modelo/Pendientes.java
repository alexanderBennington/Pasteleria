package Modelo;

public class Pendientes {
    private String id_pedido;
    private int id_usuario;
    private String nombre;
    private String fecha_hora_compra;

    public Pendientes(String id_pedido, int id_usuario, String nombre, String fecha_hora_compra) {
        this.id_pedido = id_pedido;
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.fecha_hora_compra = fecha_hora_compra;
    }

    public String getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(String id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_hora_compra() {
        return fecha_hora_compra;
    }

    public void setFecha_hora_compra(String fecha_hora_compra) {
        this.fecha_hora_compra = fecha_hora_compra;
    }
    
    
}
