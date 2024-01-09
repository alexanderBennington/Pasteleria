package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EnviosM {
    private static final String PEDIDOS_LISTOS_QUERY = "SELECT p.id_pedido, u.nombre, p.direccion_envio, c.pagado, p.total, u.telefono FROM usuarios u JOIN pedidos p ON u.id_usuario = p.id_usuario "
            + "JOIN confirmaciones c ON p.id_pedido = c.id_pedido WHERE c.estado = 'PREPARADO' ORDER BY p.fecha_hora_compra ASC";
    
    private static final String PRODUCTOS_ENVIO_QUERY = "SELECT c.id_pedido, c.id_producto, p.nombre AS pastel, c.cantidad, p.precio FROM compras c "
            + "JOIN pasteles p ON c.id_producto = p.id_producto WHERE c.id_pedido = ?";
    
    private static final String CONFIRMAR_ENTREGA_QUERY = "UPDATE confirmaciones SET estado = 'ENTREGADO', pagado = 'SI' WHERE id_pedido = ?";
    
    private static final String CANCELAR_ENTREGA_QUERY = "UPDATE confirmaciones SET estado = 'CANCELADO' WHERE id_pedido = ?";
    
    private static final String SELECT_PRODUCTOS_PEDIDO = "SELECT id_producto, cantidad FROM compras WHERE id_pedido = ?";
    
    private static final String UPDATE_STOCK_PEDIDO = "UPDATE pasteles SET stock = stock + ? WHERE id_producto = ?";
    
    public ArrayList<EnvioPedidos>getAllEnvioPedidos(){
        ConexionDB conexion = new ConexionDB();
        ArrayList<EnvioPedidos> enviopedidos = new ArrayList<>();
        try(PreparedStatement ps = conexion.getConnection().prepareStatement(PEDIDOS_LISTOS_QUERY)){
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    enviopedidos.add(new EnvioPedidos(
                        rs.getString("id_pedido"), rs.getString("nombre"), rs.getString("direccion_envio"),
                        rs.getString("pagado"), rs.getFloat("total"), rs.getString("telefono")));
                }
            }
        } catch(SQLException e) {
            System.out.println("ERROR AL OBTENER PEDIDOS" + e.getMessage());
        }finally{
            conexion.closeConnection();
        }
        return enviopedidos;  
    }
    
    public ArrayList<EnvioPedidos>getAllEnvioProductosPedido(String id_pedido){
        ConexionDB conexion = new ConexionDB();
        ArrayList<EnvioPedidos> enviopedidos = new ArrayList<>();
        try(PreparedStatement ps = conexion.getConnection().prepareStatement(PRODUCTOS_ENVIO_QUERY)){
            ps.setString(1, id_pedido);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    enviopedidos.add(new EnvioPedidos(
                        rs.getString("id_producto"), rs.getString("pastel"), rs.getInt("cantidad"),
                        rs.getFloat("precio")));
                }
            }
        } catch(SQLException e) {
            System.out.println("ERROR AL OBTENER PRODUCTOS" + e.getMessage());
        }finally{
            conexion.closeConnection();
        }
        return enviopedidos;  
    }
    
    public void ConfirmarEnvio(String id_pedido){
        ConexionDB conexion = new ConexionDB();
        try(PreparedStatement ps = conexion.getConnection().prepareStatement(CONFIRMAR_ENTREGA_QUERY)){
            ps.setString(1, id_pedido);
            ps.executeUpdate();
        }catch(SQLException e) {
            System.out.println("ERROR AL CONFIRMAR ENTREGA" + e.getMessage());
        }finally{
            conexion.closeConnection();
        }
    }
    
    public void cancelarEnvio(String id_pedido){
        ConexionDB conexion = new ConexionDB();
        try(PreparedStatement ps = conexion.getConnection().prepareStatement(CANCELAR_ENTREGA_QUERY)){
            ps.setString(1, id_pedido);
            ps.executeUpdate();
        }catch(SQLException e) {
            System.out.println("ERROR AL CANCELAR ENTREGA" + e.getMessage());
        }finally{
            conexion.closeConnection();
        }
    }
    
    public void actualizarStock(String id_pedido){
        ConexionDB conexion = new ConexionDB();
        
        try(PreparedStatement ps = conexion.getConnection().prepareStatement(SELECT_PRODUCTOS_PEDIDO)){
            ps.setString(1, id_pedido);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    try(PreparedStatement ps1 = conexion.getConnection().prepareStatement(UPDATE_STOCK_PEDIDO)){
                        ps1.setInt(1, rs.getInt("cantidad"));
                        ps1.setString(2, rs.getString("id_producto"));
                        ps1.executeUpdate();
                    } catch(SQLException e) {
                        System.out.println("ERROR AL ACTUALIZAR STOCK" + e.getMessage());
                    }
                }
            }
        } catch(SQLException e) {
            System.out.println("ERROR AL OBTENER PRODUCTOS" + e.getMessage());
        } finally{
            conexion.closeConnection();
        }
    }
}
