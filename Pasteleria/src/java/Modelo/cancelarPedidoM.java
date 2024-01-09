package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class cancelarPedidoM {
    private static final String VALIDATION_CANCELAR_PEDIDO = "UPDATE confirmaciones SET estado = 'CANCELADO' WHERE id_pedido = ?";
    private static final String SELECT_PRODUCTOS_PEDIDO = "SELECT id_producto, cantidad FROM compras WHERE id_pedido = ?";
    private static final String UPDATE_STOCK_PEDIDO = "UPDATE pasteles SET stock = stock + ? WHERE id_producto = ?";
    
    public void cancelarPedido(String id_pedido){
        ConexionDB conexion = new ConexionDB();
        
        try(PreparedStatement ps = conexion.getConnection().prepareStatement(VALIDATION_CANCELAR_PEDIDO)){
            ps.setString(1, id_pedido);
            ps.executeUpdate();
        } catch(SQLException e) {
            System.out.println("ERROR AL CANCELAR PEDIDO" + e.getMessage());
        } finally{
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
