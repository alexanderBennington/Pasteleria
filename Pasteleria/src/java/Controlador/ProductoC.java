package Controlador;

import Modelo.Producto;
import Modelo.ProductoM;

public class ProductoC {
    public String getProductos(){
        ProductoM pm = new ProductoM();
        String htmlcode = "";
        for(Producto producto : pm.getAllProductos()){
            htmlcode += "<div class=\"productos\">\n" +
"            <div class=\"tarjeta\">\n" +
"                <div>\n" +
"                    <img src=\"img/productos/"+producto.getImg_producto()+"\" alt=\"pasteles\" width=\"300\" height=\"300\">\n" +
"                </div>\n" +
"                <div class=\"centrado-simple tarjeta-abajo\">\n" +
"                    <h3>"+producto.getNombre()+"</h3>\n" +
"                    <div>\n" +
"                        <button type=\"button\" class=\"btn btn-outline-dark\" data-bs-toggle=\"modal\" data-bs-target=\"#pastel"+producto.getId_producto()+"\">\n" +
"                            Detalles\n" +
"                        </button>\n" +
"                    </div>\n" +
"                    <div>\n" +
"                        <a href=\"producto.jsp?id_producto="+producto.getId_producto()+"\"><button class=\"btn btn-outline-dark\">Ver Pastel</button></a>\n" +
"                    </div>\n" +
"                </div>\n" +
"            </div>\n" +
"        </div>\n" +
    "    <div class=\"modal fade\" id=\"pastel"+producto.getId_producto()+"\" tabindex=\"-1\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n" +
    "        <div class=\"modal-dialog\">\n" +
    "            <div class=\"modal-content\">\n" +
    "                <div class=\"modal-header\">\n" +
    "                    <h3 class=\"modal-title\" id=\"exampleModalLabel\">"+producto.getNombre()+"</h3>\n" +
    "                    <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\n" +
    "                </div>\n" +
    "                <div class=\"modal-body\">\n" +
    "                    <h4>Detalles:</h4>\n" +
    "                    <p>\n" +
    "                        Precio: $"+producto.getPrecio()+"\n" +
    "                        <br><br>\n" +
    "                        Diametro: "+producto.getTamaño()+"\n" +
    "                        <br><br>\n" +
    "                        Categorias: "+producto.getCategoria()+"\n" +
    "                        <br><br>" +
    "                    </p>\n" +
    "                    <div class=\"centrado-simple\">\n" +
    "                        <img src=\"img/productos/"+producto.getImg_producto()+"\" alt=\"Pastel\" width=\"300\">\n" +
    "                    </div>\n" +
    "                </div>\n" +
    "                <div class=\"modal-footer\">\n" +
    "                    <button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\">Cerrar</button>\n" +
    "                </div>\n" +
    "            </div>\n" +
    "        </div>\n" +
    "    </div>";
        }
        return htmlcode;
    }
    
    public Producto getProducto(String id_producto){
        return new ProductoM().getProducto(id_producto);
    }
}
