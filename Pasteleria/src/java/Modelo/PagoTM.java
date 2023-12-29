package Modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PagoTM extends ConexionDB {
    private static final String INSERT_CONFRIMACION_QUERY = "INSERT INTO confirmaciones (id_pedido, estado, pagado) VALUES (?, 'PENDIENTE', 'SI')";

    public void confirmarpedido(String id_pedido){
        try (PreparedStatement ps = getConnection().prepareStatement(INSERT_CONFRIMACION_QUERY)) {
            ps.setString(1, id_pedido);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al confirmar pedido: " + e.getMessage());
        }
    }
}
