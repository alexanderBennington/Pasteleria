package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PedidosM extends ConexionDB{
    private static final String VALIDATION_PEDIDOS_QUERY = "SELECT p.id_pedido, p.direccion_envio, c.estado, c.pagado, p.total, c.fecha_hora_estado FROM pedidos p JOIN "
            + "confirmaciones c ON p.id_pedido = c.id_pedido WHERE id_usuario = ? ORDER BY p.fecha_hora_compra DESC";
    
    private static final String VALIDATION_PASTELES_QUERY = "SELECT p.nombre, c.cantidad FROM pasteles p JOIN compras c ON p.id_producto = c.id_producto "
            + "WHERE id_pedido = ? ORDER BY nombre ASC";
    
    public ArrayList<Pedidos>getAllPedidos(int id_usuario){
        ArrayList<Pedidos> pedidos = new ArrayList<>();
        try(PreparedStatement ps = getConnection().prepareStatement(VALIDATION_PEDIDOS_QUERY)){
            ps.setInt(1, id_usuario);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    pedidos.add(new Pedidos(
                        rs.getString("id_pedido"), rs.getString("direccion_envio"), rs.getString("estado"),
                        rs.getString("pagado"), rs.getFloat("total"), rs.getString("fecha_hora_estado")));
                }
            }
        } catch(SQLException e) {
            System.out.println("ERROR AL OBTENER PEDIDOS" + e.getMessage());
        }   
        return pedidos;  
    }
    
    public ArrayList<PedidoPasteles>getAllPedidosPasteles(String id_pedido){
        ArrayList<PedidoPasteles> pedidosp = new ArrayList<>();
        try(PreparedStatement ps = getConnection().prepareStatement(VALIDATION_PASTELES_QUERY)){
            ps.setString(1, id_pedido);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    pedidosp.add(new PedidoPasteles(
                        rs.getString("nombre"), rs.getInt("cantidad")));
                }
            }
        } catch(SQLException e) {
            System.out.println("ERROR AL OBTENER PASTELES" + e.getMessage());
        }   
        return pedidosp;  
    }
}
