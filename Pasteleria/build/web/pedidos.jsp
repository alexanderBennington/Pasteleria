<%-- 
    Document   : pedidos
    Created on : 28 dic 2023, 11:56:04
    Author     : keval
--%>

<%@page import="Controlador.PedidosC"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    PedidosC pedidos = new PedidosC();
    
    int id_usuario = (int) session.getAttribute("id_usuario");
%>
<%@ include file="menu.jsp" %>
<section class="container">
    <table class="table">
        <thead>
            <tr>
                <th scope="col">Id Pedido</th>
                <th scope="col">Dirección de Envio</th>
                <th scope="col">Estado</th>
                <th scope="col">Pagado</th>
                <th scope="col">Total</th>
                <th scope="col">Fecha y Hora</th>
                <th scope="col"></th>
            </tr>
        </thead>
        <thead>
            <%= pedidos.getPedidos(id_usuario) %>
        </tbody>
    </table>
</section>
<%
    String cancelado = request.getParameter("cancelado");
    if ("true".equals(cancelado)) {
%>
    <script>
        alert("Su pedido se ha cancelado");
    </script>
<%
    cancelado= "false";
    }
%>
<script>
    var filasPrincipales = document.querySelectorAll('.filaPrincipal');
    filasPrincipales.forEach(function(fila) {
        fila.addEventListener('click', function() {
            mostrarSubfilas(this);
        });
    });

    function mostrarSubfilas(fila) {
        var subfilas = fila.nextElementSibling;

        while (subfilas && subfilas.classList.contains("subfila")) {
            if (subfilas.style.display === "table-row") {
                subfilas.style.display = "none";
            } else {
                subfilas.style.display = "table-row";
            }
                subfilas = subfilas.nextElementSibling;
        }
    }
</script>
<%@ include file="footer.jsp" %>