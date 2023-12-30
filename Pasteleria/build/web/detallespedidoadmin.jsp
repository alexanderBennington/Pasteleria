<%-- 
    Document   : detallespedidoadmin
    Created on : 29 dic 2023, 18:50:17
    Author     : keval
--%>

<%@page import="Controlador.PedidosAdminC"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    PedidosAdminC pac = new PedidosAdminC();
    String id_pedido = request.getParameter("id_pedido");
%>
<%@ include file="menuadmin.jsp" %>
<section class="container">
    <h2 class="centrado-simple">Detalles del Pedido</h2>
    <div class="tabla-con-scroll">
        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th scope="col">No. Pedido</th>
                    <th scope="col">Id. Producto</th>
                    <th scope="col">Nombre Producto</th>
                    <th scope="col">Cantidad</th>
                    <th scope="col">Listo</th>
                </tr>
            </thead>
            <tbody>
                <%= pac.getdetallesPendientes(id_pedido) %>
            </tbody>
        </table>
    </div>
</section>
<%@ include file="footeradmin.jsp" %>

