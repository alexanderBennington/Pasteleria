<%-- 
    Document   : pedidosadmin
    Created on : 29 dic 2023, 18:02:06
    Author     : keval
--%>

<%@page import="Controlador.PedidosAdminC"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    PedidosAdminC pedidos = new PedidosAdminC();
%>
<%@ include file="menuadmin.jsp" %>
<section class="container">
    <h2 class="centrado-simple">Pedidos</h2>
    <div class="tabla-con-scroll">
        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th scope="col">No. Pedido</th>
                    <th scope="col">Id. Usuario</th>
                    <th scope="col">Usuario</th>
                    <th scope="col">Fecha y Hora de Pedido</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%= pedidos.getPendientes() %>
            </tbody>
        </table>
    </div>
</section>
<%@ include file="footeradmin.jsp" %>
<script>
    document.addEventListener("DOMContentLoaded", function() {
        var botonesConfirmarPedido = document.getElementsByClassName("confirmarpedido");

        Array.from(botonesConfirmarPedido).forEach(function(boton) {
            boton.addEventListener("click", function(event) {
                if (!confirm("¿Estás seguro de querer confirmar el pedido?")) {
                    event.preventDefault();
                }
            });
        });
    });
</script>
<%
    String pedido = request.getParameter("pedido");
    if ("true".equals(pedido)) {
    %>
        <script>
            alert("EXITO: Se ha confirmado pedido para ennvio");
        </script>
<%
    pedido = "false";
    }
%>