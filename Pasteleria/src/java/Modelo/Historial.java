package Modelo;

public class Historial {
        private String id_pedido;
    private int id_usuario;
    private float total;
    private String fecha_hora_estado;

    public Historial(String id_pedido, int id_usuario, float total, String fecha_hora_estado) {
        this.id_pedido = id_pedido;
        this.id_usuario = id_usuario;
        this.total = total;
        this.fecha_hora_estado = fecha_hora_estado;
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

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getFecha_hora_estado() {
        return fecha_hora_estado;
    }

    public void setFecha_hora_estado(String fecha_hora_estado) {
        this.fecha_hora_estado = fecha_hora_estado;
    }
    
}
