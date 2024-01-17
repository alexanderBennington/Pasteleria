<%-- 
    Document   : producto
    Created on : 27 dic 2023, 2:43:13
    Author     : keval
--%>

<%@page import="Modelo.Articulo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Controlador.ProductoC"%>
<%@page import="Modelo.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    String id_producto = request.getParameter("id_producto");
    Producto producto= new ProductoC().getProducto(id_producto);
    ArrayList<Articulo> articulos = session.getAttribute("carrito") == null ? null : (ArrayList) session.getAttribute("carrito");
%>
<jsp:include page="menu.jsp" />
<h2 class="centrado-simple">Pastel</h2>
<section class="container">
    <div class="row">
        <div class="col-4 centrado-simple">
            <img src="img/productos/<%= producto.getImg_producto() %>" alt="logo" width="400" height="400">
        </div>
        <div class="col-8">
            <div class="cajacantidad">
                <div><h4><%= producto.getNombre() %></h4></div>
                <div><h5>Diametro: <%= producto.getTamaño() %></h5></div>
                <div><h5>Precio C/U: $<%= producto.getPrecio() %></h5></div>
                <%
                    boolean flag = false;
                    if (articulos != null && !articulos.isEmpty()) {
                        for(Articulo a : articulos){
                            if(id_producto.equals(a.getId_producto())){ 
                %>
                <div><h5>Disponibles: <%= producto.getStock()- a.getCantidad()%></h5></div>
                <%                  
                                flag = true;
                                break;
                            }
                        }
                    }
                    if(!flag){
                %>
                <div><h5>Disponibles: <%= producto.getStock() %></h5></div>
                <%
                    }
                %>
                <form action="addCart" method="post">
                    <input type="hidden" value="<%= producto.getId_producto() %>" name="id_producto">
                    <div class="row g-3 align-items-center">
                        <div class="col-auto">
                            <label for="cantidad" class="col-form-label">Cantidad &nbsp;</label>
                        </div>
                        <div class="col-auto">
                            <%
                                boolean flag2 = false;
                                if (articulos != null && !articulos.isEmpty()) {
                                    for(Articulo a : articulos){
                                        if(id_producto.equals(a.getId_producto())){ 
                            %>
                            <input type="number" value="<%= producto.getStock()- a.getCantidad() >= 1 ? 1 : 0 %>" min="0" max="<%= producto.getStock()- a.getCantidad() %>" id="cantidad" name="cantidad" class="form-control tamaño-cantidad">
                                <%          flag2 = true;                  
                                            break;
                                        }
                                    }
                                }
                                if(!flag2){
                            %>
                            <input type="number" value="1" min="0" max="<%= producto.getStock() %>" id="cantidad" name="cantidad" class="form-control tamaño-cantidad">
                            <%
                                }
                            %>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-outline-dark">Agregar al carrito</button>
                </form>
            </div>
        </div>
    </div>
</section>
<script src="js/cantidad.js"></script>
<jsp:include page="footer.jsp" />
