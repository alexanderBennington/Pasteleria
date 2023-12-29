package Modelo;

public class Sugerencias {
    private String img_producto;
    private String id_producto;

    public Sugerencias(String img_producto, String id_producto) {
        this.img_producto = img_producto;
        this.id_producto = id_producto;
    }

    public String getImg_producto() {
        return img_producto;
    }

    public void setImg_producto(String img_producto) {
        this.img_producto = img_producto;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }
    
    
}
