package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SugerenciasM {
    private static final String VALIDATION_CATEGORIAS_QUERY = "SELECT p.categoria FROM pasteles p JOIN compras c ON p.id_producto = c.id_producto "
            + "JOIN pedidos pe ON pe.id_pedido = c.id_pedido WHERE pe.id_usuario = ? ORDER BY id_compra DESC LIMIT 1;";
    
    private static final String VALIDATION_PRODUCTOS_QUERY = "SELECT * FROM PASTELES WHERE stock > 0";
    
    public List<String> obtenerCategorias(int id_usuario){
        List<String> listaCategorias = new ArrayList<>();
        ConexionDB conexion = new ConexionDB();
        try(PreparedStatement ps = conexion.getConnection().prepareStatement(VALIDATION_CATEGORIAS_QUERY)){
            ps.setInt(1, id_usuario);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String categoria = rs.getString("categoria");
                    String[] palabras = categoria.split(",\\s*");
                    listaCategorias.addAll(List.of(palabras));
                }
            }
        } catch(SQLException e) {
            System.out.println("ERROR AL OBTENER CATEGORIAS" + e.getMessage());
        } finally{
            conexion.closeConnection();
        }
        return listaCategorias;
    }
    
    public ArrayList<Sugerencias> mostrarSugerencias(List<String> listaCategorias){
        List<String> listaCategoriasproducto = new ArrayList<>();
        ArrayList<Sugerencias> sugerencia = new ArrayList<>();
        ConexionDB conexion = new ConexionDB();
        try(PreparedStatement ps = conexion.getConnection().prepareStatement(VALIDATION_PRODUCTOS_QUERY)){
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String categoria = rs.getString("categoria");
                    String[] palabraspastel = categoria.split(",\\s*");
                    listaCategoriasproducto.addAll(List.of(palabraspastel));
                    for (String elemento : listaCategorias) {
                        if (listaCategoriasproducto.contains(elemento)) {
                            sugerencia.add(new Sugerencias(rs.getString("img_producto"), rs.getString("id_producto")));
                            break;
                        }
                    }
                    listaCategoriasproducto.clear();
                }
            }
        } catch(SQLException e) {
            System.out.println("ERROR AL OBTENER PRODUCTOS" + e.getMessage());
        } finally{
            conexion.closeConnection();
        }
        return sugerencia;
    }
}
