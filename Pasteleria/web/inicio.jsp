<%-- 
    Document   : inicio
    Created on : 26 dic 2023, 14:31:15
    Author     : keval
--%>

<%@page import="Controlador.SugerenciasC"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    SugerenciasC sugerencia = new SugerenciasC();
    
    int id_usuario = (int) session.getAttribute("id_usuario");
%>
<%@ include file="menu.jsp" %>
<section id="img-prin">
    <div id="img-prin-tex">
        <h2>Cake Alchemy</h2>
        <h2>Transformamos ingredientes en obras maestras: <br>¡Bienvenido a Cake Alchemy, donde cada bocado es una experiencia mágica!</h2>
    </div>
</section>
<section id="anunciossec">
    <div class="home-demo">
        <div class="row">
            <h3 id="h3-pasteles">Pasteles</h3>
            <div class="large-12 columns">
                <div class="owl-carousel" align="center">
                    <%= sugerencia.getSugerencias(id_usuario) %>
                </div>
            </div>
        </div>
    </div>
    <script>
        var owl = $('.owl-carousel');
        owl.owlCarousel({
            margin: 10,
            loop: true,
            responsive: {
                0: {
                    items: 1
                },
                600: {
                    items: 2
                },
                1000: {
                    items: 4
                }
            }
        });
    </script>
</section>
<%
    // Verifica si hay un parámetro de error en la URL
    String pedido = request.getParameter("pedido");
    if ("true".equals(pedido)) {
%>
    <script>
        alert("Su pedido esta siendo procesado");
    </script>
<%
    pedido= "false";
    }
%>
<%@ include file="footer.jsp" %>
