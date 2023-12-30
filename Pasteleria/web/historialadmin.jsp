<%-- 
    Document   : historialadmin
    Created on : 30 dic 2023, 14:52:22
    Author     : keval
--%>

<%@page import="Controlador.HistorialC"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HistorialC historial = new HistorialC();
%>
<%@ include file="menuadmin.jsp" %>
<section class="container">
    <h2 class="centrado-simple">Historial del Día</h2>
    <%= historial.getGananciasDia()%>
    <div class="tabla-con-scroll">
        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th scope="col">ID Pedido</th>
                    <th scope="col">ID Usuario</th>
                    <th scope="col">Total</th>
                    <th scope="col">Fecha y Hora</th>
                </tr>
            </thead>
            <tbody>
                <%= historial.getHistorialEntregas() %>
            </tbody>
        </table>
    </div>
</section>
<%@ include file="footeradmin.jsp" %>