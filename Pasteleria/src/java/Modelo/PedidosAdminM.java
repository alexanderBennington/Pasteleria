package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PedidosAdminM {
    private static final String SELECT_PEDIDOSPENDIENTES_QUERY = "SELECT p.id_pedido, u.id_usuario, u.nombre, p.fecha_hora_compra FROM pedidos p "
            + "JOIN usuarios u ON p.id_usuario = u.id_usuario JOIN confirmaciones c ON p.id_pedido = c.id_pedido WHERE estado = 'PENDIENTE' ORDER BY p.fecha_hora_compra ASC";
    
    private static final String CONFIRMAR_PEDIDOPENDIENTE_QUERY = "UPDATE confirmaciones SET estado = 'PREPARADO' WHERE id_pedido = ?";
    
    private static final String SELECT_PRODUCTOSPEDIDOPENDIENTE_QUERY = "SELECT c.id_pedido, c.id_producto, p.nombre, c.cantidad FROM compras c "
            + "JOIN pasteles p ON c.id_producto = p.id_producto WHERE c.id_pedido = ?";
    
    public ArrayList<Pendientes>getAllPedidosPendientes(){
        ConexionDB conexion = new ConexionDB();
        ArrayList<Pendientes> pendiente = new ArrayList<>();
        try(PreparedStatement ps = conexion.getConnection().prepareStatement(SELECT_PEDIDOSPENDIENTES_QUERY)){
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    pendiente.add(new Pendientes(
                        rs.getString("id_pedido"), rs.getInt("id_usuario"), rs.getString("nombre"),
                        rs.getString("fecha_hora_compra")));
                }
            }
        } catch(SQLException e) {
            System.out.println("ERROR AL OBTENER PEDIDOS" + e.getMessage());
        }finally{
            conexion.closeConnection();
        }   
        return pendiente;  
    } 
    
    public void confirmarPedidopendiente(String id_pedido){
        ConexionDB conexion = new ConexionDB();
        try(PreparedStatement ps = conexion.getConnection().prepareStatement(CONFIRMAR_PEDIDOPENDIENTE_QUERY)){
            ps.setString(1, id_pedido);
            System.out.println(id_pedido);
            ps.executeUpdate();
        } catch(SQLException e) {
            System.out.println("ERROR AL CONFIRMAR PEDIDOS" + e.getMessage());
        }finally{
            conexion.closeConnection();
        }
    }
    
    public ArrayList<DetallesPedido>getAllProductosPedidosPendientes(String id_pedido){
        ConexionDB conexion = new ConexionDB();
        ArrayList<DetallesPedido> dpedido = new ArrayList<>();
        try(PreparedStatement ps = conexion.getConnection().prepareStatement(SELECT_PRODUCTOSPEDIDOPENDIENTE_QUERY)){
            ps.setString(1, id_pedido);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    dpedido.add(new DetallesPedido(
                        rs.getString("id_pedido"), rs.getString("id_producto"), rs.getString("nombre"),
                        rs.getInt("cantidad")));
                }
            }
        } catch(SQLException e) {
            System.out.println("ERROR AL OBTENER PRODUCTOS" + e.getMessage());
        }finally{
            conexion.closeConnection();
        }   
        return dpedido;  
    } 
}
