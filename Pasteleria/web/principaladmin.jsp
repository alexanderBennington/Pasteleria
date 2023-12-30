<%-- 
    Document   : principaladmin
    Created on : 29 dic 2023, 17:36:54
    Author     : keval
--%>

<%@page import="Modelo.ConexionDB"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="menuadmin.jsp" %>
<section id="img-prin">
    <div id="img-prin-tex">
        <h2>Cake Alchemy</h2>
        <h2>Pedidos Pendientes:</h2>
        <%
            String COUNT_PEDIDOS_QUERY = "SELECT COUNT(*) AS total_filas FROM pedidos p JOIN confirmaciones c ON p.id_pedido = c.id_pedido WHERE c.estado = 'PENDIENTE'";
            ConexionDB conexion = new ConexionDB();
            try(PreparedStatement ps = conexion.getConnection().prepareStatement(COUNT_PEDIDOS_QUERY)){
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
        %>
        <h2><%= rs.getInt("total_filas") %></h2>
        <%
                    }
                }
            } catch(SQLException e) {
                System.out.println("ERROR AL OBTENER CANTIDAD" + e.getMessage());
            }
        %>
        <h2>Pedidos en Envio:</h2>
        <%
            String COUNT_ENVIOS_QUERY = "SELECT COUNT(*) AS total_filas FROM pedidos p JOIN confirmaciones c ON p.id_pedido = c.id_pedido WHERE c.estado = 'PREPARADO'";
            try(PreparedStatement ps = conexion.getConnection().prepareStatement(COUNT_ENVIOS_QUERY)){
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
        %>
        <h2><%= rs.getInt("total_filas") %></h2>
        <%
                    }
                }
            } catch(SQLException e) {
                System.out.println("ERROR AL OBTENER CANTIDAD ENVIOS" + e.getMessage());
            } finally{
                conexion.closeConnection();
            }
        %>
    </div>
</section>
<%@ include file="footeradmin.jsp" %>