package Controlador;

import Modelo.PedidoPasteles;
import Modelo.Pedidos;
import Modelo.PedidosM;

public class PedidosC {
    public String getPedidos(int id_usuario){
        PedidosM pm = new PedidosM();
        String htmlcode = "";
        for(Pedidos pedido : pm.getAllPedidos(id_usuario)){
            htmlcode += "<tr class=\"filaPrincipal\">\n" +
"                <td>"+pedido.getId_pedido()+"</td>\n" +
"                <td>"+pedido.getDireccion_envio()+"</td>\n" +
"                <td>"+pedido.getEstado()+"</td>\n" +
"                <td>"+pedido.getPagado()+"</td>\n" +
"                <td>"+pedido.getTotal()+"</td>\n" +
"                <td>"+pedido.getFecha_hora_estado()+"</td>\n";
            if(!pedido.getEstado().equals("CANCELADO") && !pedido.getEstado().equals("ENTREGADO")){
                htmlcode += "<td><a href=\"cancelarPedidoC?id_pedido="+pedido.getId_pedido()+"\"><button type=\"submit\" class=\"btn btn-outline-danger\">Cancelar<br>Pedido</button></a></td>\n"; 
            }else{
                 htmlcode += "<td></td>\n";
            }
            htmlcode += "</tr>\n";
            for(PedidoPasteles pedidop : pm.getAllPedidosPasteles(pedido.getId_pedido())){
                htmlcode += "<tr class=\"subfila\">\n" +
"                <td></td>\n" +                 
"                <td colspan=\"4\">Pastel: "+pedidop.getNombre()+"</td>                \n" +
"                <td>Cantidad: "+pedidop.getCantidad()+"</td>\n" +
"                <td></td>\n" +                        
"            </tr>";
            }
        }
        return htmlcode;
    }
}
