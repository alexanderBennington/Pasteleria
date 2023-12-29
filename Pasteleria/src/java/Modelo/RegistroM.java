package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistroM {
    private static final String INSERT_REGISTRO_QUERY = "INSERT INTO usuarios (nombre, apellido_paterno, apellido_materno, telefono, correo, clave) "
            + "VALUES (?, ?, ?, ?, ?, ?)";
    
    private static final String BUSCAR_ID_QUERY = "SELECT id_usuario FROM usuarios WHERE nombre = ? AND apellido_paterno = ? AND apellido_materno = ?";
    
    public void registrarUsuario(String nombre, String apellido_paterno, String apellido_materno, String telefono, String correo, String clave){
        ConexionDB conexion = new ConexionDB();
        try (PreparedStatement ps = conexion.getConnection().prepareStatement(INSERT_REGISTRO_QUERY)) {
            ps.setString(1, nombre);
            ps.setString(2, apellido_paterno);
            ps.setString(3, apellido_materno);
            ps.setString(4, telefono);
            ps.setString(5, correo);
            ps.setString(6, clave);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
        }
    }
    
    public int obtenerId_usuario(String nombre, String apellido_paterno, String apellido_materno){
        ConexionDB conexion = new ConexionDB();
        int id_usuario = 0;
        try (PreparedStatement ps = conexion.getConnection().prepareStatement(BUSCAR_ID_QUERY)) {
            ps.setString(1, nombre);
            ps.setString(2, apellido_paterno);
            ps.setString(3, apellido_materno);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    id_usuario = rs.getInt("id_usuario");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
        }
        return id_usuario;
    }
}
