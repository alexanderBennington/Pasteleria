package Modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TarjetaM {
    private static final String REGISTRAR_TARJETA_QUERY = "INSERT INTO datos_tarjeta(id_usuario, direccion, ciudad, codigo_postal, numero_tarjeta, fecha_vencimiento, cvv) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?);";
    
    public void registrarTarjeta(int id_usuario, String direccion, String ciudad, String codigo_postal, String numero_tarjeta, String fecha_vencimiento, String cvv){
        ConexionDB conexion = new ConexionDB();
        try (PreparedStatement ps = conexion.getConnection().prepareStatement(REGISTRAR_TARJETA_QUERY)) {
            ps.setInt(1, id_usuario);
            ps.setString(2, direccion);
            ps.setString(3, ciudad);
            ps.setString(4, codigo_postal);
            ps.setString(5, numero_tarjeta);
            ps.setString(6, fecha_vencimiento);
            ps.setString(7, cvv);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
        }
    }
}
