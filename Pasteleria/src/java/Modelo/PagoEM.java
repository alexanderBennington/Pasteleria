package Modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class PagoEM extends ConexionDB{
    private static final String INSERT_PEDIDO_QUERY = "INSERT INTO pedidos (id_pedido, id_usuario, direccion_envio, total) VALUES (?, ?, ?, ?)";
    private static final String INSERT_PRODUCTOS_QUERY = "INSERT INTO compras (id_pedido, id_producto, cantidad) VALUES (?, ?, ?)";
    private static final String INSERT_CONFRIMACION_QUERY = "INSERT INTO confirmaciones (id_pedido, estado, pagado) VALUES (?, 'PENDIENTE', 'NO')";
    
    public String realizarpedido(int id_usuario, String direccion, float total){
        String id_pedido = UUID.randomUUID().toString();
        try (PreparedStatement ps = getConnection().prepareStatement(INSERT_PEDIDO_QUERY)) {
            ps.setString(1, id_pedido);
            ps.setInt(2, id_usuario);
            ps.setString(3, direccion);
            ps.setFloat(4, total);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al ingresar pedido: " + e.getMessage());
        }
        return id_pedido;
    }
    
    public void confirmarpedido(String id_pedido){
        try (PreparedStatement ps = getConnection().prepareStatement(INSERT_CONFRIMACION_QUERY)) {
            ps.setString(1, id_pedido);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al ingresar pedido: " + e.getMessage());
        }
    }
    
    public void insertarproductos(String id_pedido, Producto producto, Articulo articulo){
        try (PreparedStatement ps = getConnection().prepareStatement(INSERT_PRODUCTOS_QUERY)) {
            ps.setString(1, id_pedido);
            ps.setString(2, producto.getId_producto());
            ps.setInt(3, articulo.getCantidad());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al ingresar pedido: " + e.getMessage());
        }
    }
    
    public void cerrarconexion(){
        closeConnection();
    }
}
