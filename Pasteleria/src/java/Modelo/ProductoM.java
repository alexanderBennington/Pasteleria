package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductoM extends ConexionDB{
    private static final String VALIDATION_QUERY = "SELECT * FROM pasteles";
    private static final String VALIDATION_QUERY_2 = "SELECT * FROM pasteles WHERE id_producto = ?";
    
    public ArrayList<Producto>getAllProductos(){
        ArrayList<Producto> productos = new ArrayList<>();
        try(PreparedStatement ps = getConnection().prepareStatement(VALIDATION_QUERY)){
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    productos.add(new Producto(
                        rs.getString("id_producto"), rs.getString("nombre"), rs.getString("img_producto"),
                        rs.getString("categoria"), rs.getFloat("precio"), rs.getString("tamaño")));
                }
            }
        } catch(SQLException e) {
            System.out.println("ERROR AL OBTENER DATOS DE LISTA" + e.getMessage());
        } finally{
            closeConnection();
        }    
        return productos;  
    }
    
    public Producto getProducto(String id_producto){
        Producto producto = null;
        try(PreparedStatement ps = getConnection().prepareStatement(VALIDATION_QUERY_2)){
            ps.setString(1, id_producto);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    producto = new Producto(
                        rs.getString("id_producto"), rs.getString("nombre"), rs.getString("img_producto"),
                        rs.getString("categoria"), rs.getFloat("precio"), rs.getString("tamaño"));
                }
            }
        } catch(SQLException e) {
            System.out.println("ERROR AL OBTENER DATOS DE LISTA" + e.getMessage());
        } finally{
            closeConnection();
        }
        return producto;
    }
}
