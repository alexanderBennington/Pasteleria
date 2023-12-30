package DAO;

import Modelo.ConexionDB;
import Modelo.Persona;
import Modelo.ValidarAdmin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginAdminDAO implements ValidarAdmin {
    private static final String VALIDATION_ADMIN_QUERY = "SELECT * FROM administracion WHERE correo = ? AND clave = ?";
    
    @Override
    public boolean validarAdmin(Persona per){
        ConexionDB conexion = new ConexionDB();
        int r = 0;
        try (PreparedStatement ps = conexion.getConnection().prepareStatement(VALIDATION_ADMIN_QUERY)) {
            ps.setString(1, per.getCorreo());
            ps.setString(2, per.getClave());
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    r++;
                    per.setId_usuario(rs.getInt("id_administrador"));
                    per.setNombre(rs.getString("nombre"));
                    per.setApellido_paterno(rs.getString("apellido_paterno"));
                    per.setApellido_materno(rs.getString("apellido_materno"));
                    per.setTelefono(rs.getString("telefono"));
                    per.setCorreo(rs.getString("correo"));
                    per.setClave(rs.getString("clave"));
                }
            }
            if (r == 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al validar usuario: " + e.getMessage());
            return false;
        } finally{
            conexion.closeConnection();
        }
    }
}
