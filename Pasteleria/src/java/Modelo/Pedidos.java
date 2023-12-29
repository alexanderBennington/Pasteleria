package Modelo;

public class Pedidos {
    private String id_pedido;
    private String direccion_envio;
    private String estado;
    private String pagado;
    private float total;
    private String fecha_hora_estado;

    public Pedidos(String id_pedido, String direccion_envio, String estado, String pagado, float total, String fecha_hora_estado) {
        this.id_pedido = id_pedido;
        this.direccion_envio = direccion_envio;
        this.estado = estado;
        this.pagado = pagado;
        this.total = total;
        this.fecha_hora_estado = fecha_hora_estado;
    }

    public String getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(String id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getDireccion_envio() {
        return direccion_envio;
    }

    public void setDireccion_envio(String direccion_envio) {
        this.direccion_envio = direccion_envio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public String getFecha_hora_estado() {
        return fecha_hora_estado;
    }

    public void setFecha_hora_estado(String fecha_hora_estado) {
        this.fecha_hora_estado = fecha_hora_estado;
    }
    
    
}
