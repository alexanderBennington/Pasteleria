package Modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class cancelarPedidoM {
    private static final String VALIDATION_CANCELAR_PEDIDO = "UPDATE confirmaciones SET estado = 'CANCELADO' WHERE id_pedido = ?";
    
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
}
