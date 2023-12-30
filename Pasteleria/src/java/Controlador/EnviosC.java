package Controlador;

import Modelo.EnvioPedidos;
import Modelo.EnviosM;

public class EnviosC {
    
    public String getPedidosListos(){
        EnviosM em = new EnviosM();
        String htmlcode = "";
        for(EnvioPedidos enviopedido : em.getAllEnvioPedidos()){
            htmlcode += "<tr class=\"filaPrincipal\">\n" +
"                <td>"+enviopedido.getId_pedido()+"</td>\n" +
"                <td>"+enviopedido.getNombre()+"</td>\n" +
"                <td>"+enviopedido.getDireccion_envio()+"</td>\n" +
"                <td>"+enviopedido.getPagado()+"</td>\n" +
"                <td>$"+enviopedido.getTotal()+"</td>\n" +
"                <td><a href=\"https://api.whatsapp.com/send?phone=52"+enviopedido.getTelefono()+"&text=Hola,%20Tu%20Pedido%20Va%20En%20Camino\" target=\"_blank\" rel=\"noopener noreferrer\"><button type=\"button\" class=\"btn btn-info\">Enviar Mensaje</button></a></td>\n" +
"                <td>\n" +
"                    <form action=\"ConfirmarEntregaC\" method=\"post\">\n" +
"                        <input type=\"text\" style=\"display: none;\" value=\""+enviopedido.getId_pedido()+"\" name=\"id_pedido\">\n" +
"                        <button type=\"submit\" class=\"btn btn-success confirmarentrega\">Confirmar Entrega</button>\n" +
"                    </form>\n" +
"                </td>\n" +
"                <td>\n" +
"                    <form action=\"CancelarEntregaC\" method=\"post\">\n" +
"                        <input type=\"text\" style=\"display: none;\" value=\""+enviopedido.getId_pedido()+"\" name=\"id_pedido\">\n" +
"                        <button type=\"submit\" class=\"btn btn-danger cancelarentrega\">Cancelar Entrega</button>\n" +
"                    </form>\n" +
"                </td>\n" +                    
"           </tr>\n";
            for(EnvioPedidos envioproducto : em.getAllEnvioProductosPedido(enviopedido.getId_pedido())){
                htmlcode += "<tr class=\"subfila\">\n" +
"                <td>Id Producto: "+envioproducto.getId_producto()+"</td>\n" +                 
"                <td colspan=\"4\">Pastel: "+envioproducto.getPastel()+"</td>\n" +
"                <td>Cantidad: "+envioproducto.getCantidad()+"</td>\n" +
"                <td>Precio C/U: $"+envioproducto.getPrecio()+"</td>\n" +               
"                <td>Precio Total: $"+envioproducto.getPrecio() * envioproducto.getCantidad()+"</td>\n" +                         
"            </tr>";
            }
        }
        return htmlcode;
    }
}