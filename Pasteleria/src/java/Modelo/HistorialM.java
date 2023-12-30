package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HistorialM {
    private static final String SELECT_HISTORIAL_ENTREGAS_QUERY = "SELECT p.id_pedido, p.id_usuario, p.total, c.fecha_hora_estado FROM pedidos p "
            + "JOIN confirmaciones c ON p.id_pedido = c.id_pedido WHERE c.estado = 'ENTREGADO' AND pagado = 'SI' ORDER BY C.fecha_hora_estado DESC";
    
    private static final String SELECT_GANANCIAS_QUERY = "SELECT SUM(p.total) AS total_del_dia FROM pedidos p "
            + "JOIN confirmaciones c ON p.id_pedido = c.id_pedido WHERE c.estado = 'ENTREGADO' AND DATE(c.fecha_hora_estado) = CURDATE()";

    public ArrayList<Historial>getHistorialEntregados(){
        ConexionDB conexion = new ConexionDB();
        ArrayList<Historial> historial = new ArrayList();
        try(PreparedStatement ps = conexion.getConnection().prepareStatement(SELECT_HISTORIAL_ENTREGAS_QUERY)){
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    historial.add(new Historial(
                        rs.getString("id_pedido"), rs.getInt("id_usuario"), rs.getFloat("total"),
                        rs.getString("fecha_hora_estado")));
                }
            }
        } catch(SQLException e) {
            System.out.println("ERROR AL OBTENER HISTTORIAL DE ENTREGAS" + e.getMessage());
        } finally{
            conexion.closeConnection();
        }
        return historial; 
    }
    
    public int getHistorialGanancias(){
        ConexionDB conexion = new ConexionDB();
        int ganancias = 0;
        try(PreparedStatement ps = conexion.getConnection().prepareStatement(SELECT_GANANCIAS_QUERY)){
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ganancias = rs.getInt("total_del_dia");
                }
            }
        } catch(SQLException e) {
            System.out.println("ERROR AL OBTENER GANANCIAS" + e.getMessage());
        } finally{
            conexion.closeConnection();
        }
        return ganancias;
    }
}
