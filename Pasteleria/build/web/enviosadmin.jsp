<%-- 
    Document   : enviosadmin
    Created on : 29 dic 2023, 21:12:04
    Author     : keval
--%>

<%@page import="Controlador.EnviosC"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    EnviosC envios = new EnviosC();
%>
<%@ include file="menuadmin.jsp" %>
<section class="container">
    <h2 class="centrado-simple">Envios</h2>
    <div class="tabla-con-scroll">
        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th scope="col">No. Pedido</th>
                    <th scope="col">Usuario</th>
                    <th scope="col">Dirección</th>
                    <th scope="col">Pagado</th>
                    <th scope="col">Total</th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                </tr>
            </thead>
            <tbody>
                <%= envios.getPedidosListos() %>
            </tbody>
        </table>
    </div> 
</section>
<%@ include file="footeradmin.jsp" %>
<script>
    document.addEventListener("DOMContentLoaded", function() {
        var botonesConfirmarEntrega = document.getElementsByClassName("confirmarentrega");
        var botonesCancelarEntrega = document.getElementsByClassName("cancelarentrega");

        Array.from(botonesConfirmarEntrega).forEach(function(boton) {
            boton.addEventListener("click", function(event) {
                if (!confirm("¿Estás seguro de querer confirmar la entrega?")) {
                    event.preventDefault();
                }
            });
        });
        
        Array.from(botonesCancelarEntrega).forEach(function(boton) {
            boton.addEventListener("click", function(event) {
                if (!confirm("¿Estás seguro de querer cancelar la entrega?")) {
                    event.preventDefault();
                }
            });
        });
    });
</script>
<%
    String entrega = request.getParameter("entrega");
    if ("true".equals(entrega)) {
%>
        <script>
            alert("EXITO: Se ha confirmado la entrega del pedido");
        </script>
<%
    entrega = "false";
    }

    String cancelar = request.getParameter("cancelar");
        if ("true".equals(entrega)) {
%>
        <script>
            alert("EXITO: Se ha cancelado la entrega del pedido");
        </script>
<%
    cancelar = "false";
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