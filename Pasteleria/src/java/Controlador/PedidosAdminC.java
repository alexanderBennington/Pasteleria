package Controlador;

import Modelo.DetallesPedido;
import Modelo.Pendientes;
import Modelo.PedidosAdminM;

public class PedidosAdminC {
    
    public String getPendientes(){
        PedidosAdminM pac = new PedidosAdminM();
        String htmlcode = "";
        for(Pendientes pendiente : pac.getAllPedidosPendientes()){
            htmlcode +="<tr>\n" +
"                    <th scope=\"row\">"+pendiente.getId_pedido()+"</th>\n" +
"                    <td>"+pendiente.getId_usuario()+"</td>\n" +
"                    <td>"+pendiente.getNombre()+"</td>\n" +
"                    <td>"+pendiente.getFecha_hora_compra()+"</td>\n" +
"                    <td><a href=\"detallespedidoadmin.jsp?id_pedido="+pendiente.getId_pedido()+"\"><button type=\"button\" class=\"btn btn-success\">Ver Pedido</button></a></td>\n" +
"                    <td>\n" +
"                        <form action=\"ConfirmarPedidoC\" method=\"post\">\n" +
"                           <input type=\"text\" value=\""+pendiente.getId_pedido()+"\" style=\"display: none;\" name=\"id_pedido\">\n" +
"                           <button type=\"submit\" class=\"btn btn-danger confirmarpedido\">Confirmar Envio</button>\n" +
"                        </form>\n" + 
"                    <td>\n" +
"                </tr>";
        }
        return htmlcode;
    }
    
    public String getdetallesPendientes(String id_pedido){
        PedidosAdminM pam = new PedidosAdminM();
        String htmlcode = "";
        for(DetallesPedido dpedido : pam.getAllProductosPedidosPendientes(id_pedido)){
            htmlcode +="<tr>\n" +
"                    <th scope=\"row\">"+dpedido.getId_pedido()+"</th>\n" +
"                    <td>"+dpedido.getId_producto()+"</td>\n" +
"                    <td>"+dpedido.getNombre()+"</td>\n" +
"                    <td>"+dpedido.getCantidad()+"</td>\n" +
"                    <td>\n" +
"                        <input class=\"form-check-input\" type=\"checkbox\" value=\"\">\n" +
"                    </td>\n" +
"                </tr>";
        }
        return htmlcode;
    }
}
