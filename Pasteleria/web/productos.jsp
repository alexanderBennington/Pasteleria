<%-- 
    Document   : productos
    Created on : 26 dic 2023, 15:38:06
    Author     : keval
--%>

<%@page import="Controlador.ProductoC"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  ProductoC producto = new ProductoC();  
%>
<jsp:include page="menu.jsp" />
<h2 class="centrado-simple">Pasteles</h2>
<div class="grid">
    <%= producto.getProductos() %>
</div>
<jsp:include page="footer.jsp" />
