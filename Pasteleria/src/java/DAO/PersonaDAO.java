package DAO;

import Modelo.ConexionDB;
import Modelo.Persona;
import Modelo.Validar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PersonaDAO extends ConexionDB implements Validar {
    private static final String VALIDATION_QUERY = "SELECT * FROM usuarios WHERE correo=? AND clave=?";
    
    @Override
    public int validar(Persona per) {
        int r = 0;
        try (PreparedStatement ps = getConnection().prepareStatement(VALIDATION_QUERY)) {
            ps.setString(1, per.getCorreo());
            ps.setString(2, per.getClave());
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    r++;
                    per.setId_usuario(rs.getInt("id_usuario"));
                    per.setNombre(rs.getString("nombre"));
                    per.setApellido_paterno(rs.getString("apellido_paterno"));
                    per.setApellido_materno(rs.getString("apellido_materno"));
                    per.setTelefono(rs.getString("telefono"));
                    per.setCorreo(rs.getString("correo"));
                    per.setClave(rs.getString("clave"));
                }
            }
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (SQLException e) {
            System.out.println("Error al validar usuario: " + e.getMessage());
            return 0;
        }
    }
}
