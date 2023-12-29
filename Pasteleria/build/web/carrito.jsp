<%-- 
    Document   : carrito
    Created on : 27 dic 2023, 14:50:42
    Author     : keval
--%>

<%@page import="Modelo.Producto"%>
<%@page import="Controlador.ProductoC"%>
<%@page import="Modelo.Articulo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Articulo> articulos = session.getAttribute("carrito") == null ? null : (ArrayList) session.getAttribute("carrito");
%>
<%@ include file="menu.jsp" %>
<h2 class="centrado-simple">Carrito</h2>
<section class="container" id="cart-container">
    <table class="table" id="shop-table">
        <thead>
            <tr>
                <th scope="col">Pastel</th>
                <th scope="col">Precio</th>
                <th scope="col">Cantidad</th>
                <th scope="col">Total</th>
                <th scope="col"></th>
            </tr>
        </thead>
        <tbody>
            <%
                ProductoC pc = new ProductoC();
                float total = 0;

                if(articulos!=null){
                for(Articulo a: articulos){
                    Producto producto = pc.getProducto(a.getId_producto());
                    total += a.getCantidad() * producto.getPrecio();

            %> 
            <tr>
                <th scope="row" class="centrado-tabla"><img src="img/productos/<%= producto.getImg_producto() %>" alt="" width="150" height="150"><p><%= producto.getNombre() %></p></th>
                <td>$<%= producto.getPrecio() %></td>
                <td>
                    <div class="col-auto">
                        <input type="text" value="<%= a.getCantidad() %>" id="cantidad" class="form-control tamaño-cantidad" readonly>
                    </div>
                </td>
                <td><%= producto.getPrecio() * a.getCantidad() %></td>
                <td>
                    <span id="idarticulo" style="display: none;"><%= producto.getId_producto() %></span>
                    <a href="" id="eliminarcarrito">x</a>
                </td>
            </tr>
            <% } } %>
        </tbody>
    </table>
    <div class="row g-3 align-items-center">
        <div class="col-auto">
            <label for="total" class="col-form-label label-total">Total &nbsp;$</label>
        </div>
        <div class="col-auto">
            <input type="text" value="<%= total %>" id="total" name="total" class="form-control tamano-total" readonly>
        </div>
    </div>
    <div>
        <label for="direccionenvio">Dirección de envio:</label>
        <input type="text" id="direccionenvio" placeholder="Favor de indicar No. de casa, ciudad, C.P." class="form-control direccion">
    </div>
    <div id="botones-pago" class="row g-3 align-items-center">
        <form action="PagoEC" method="post" class="pago-boton">
            <input value="${id_usuario}" Style="display:none;" name="id_usuario">
            <input value="<%= total %>" name="total" style="display:none;">
            <input name="direccion" id="direccion1" style="display:none;">
            <button type="submit" id="pagoEfectivo" class="btn btn-outline-secondary btn-lg">Pagar en Efectivo</button>
        </form>&nbsp;&nbsp;&nbsp;
        <form action="PagoTC" method="post" class="pago-boton">
            <input value="${id_usuario}" Style="display:none;" name="id_usuario">
            <input value="<%= total %>" name="total" style="display:none;">
            <input name="direccion" id="direccion2" style="display:none;">
            <button type="submit" id="pagoTarjeta" class="btn btn-outline-dark btn-lg">Pagar con Tarjeta</button>
        </form>
    </div>
    <div class="direccion"><a href="productos.jsp"><h3>Ver más productos</h3></a></div>            
</section>
<section class="container"><h3 id="mensajeNoProductos" style="display: none;">No hay productos</h3></section>
<%@ include file="footer.jsp" %>
<script src="js/carrito.js"></script>
<script>
    var botonPagoEfectivo = document.getElementById("pagoEfectivo");
    var botonPagoTarjeta = document.getElementById("pagoTarjeta");

    botonPagoEfectivo.addEventListener("click", function(event) {
        if (!confirm("¿Estás seguro de querer pagar en efectivo?")) {
            event.preventDefault();
        }
    });

    botonPagoTarjeta.addEventListener("click", function(event) {
        if (!confirm("¿Estás seguro de querer pagar con tarjeta?")) {
            event.preventDefault();
        }
    });
</script>
