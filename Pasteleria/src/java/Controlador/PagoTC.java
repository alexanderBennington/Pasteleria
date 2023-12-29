package Controlador;

import Modelo.Articulo;
import Modelo.PagoEM;
import Modelo.PagoTM;
import Modelo.Producto;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PagoTC extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
        float total = Float.parseFloat(request.getParameter("total"));
        String direccion = request.getParameter("direccion");
        String id_pedido = "";
        
        HttpSession session = request.getSession(true);
        ArrayList<Articulo> articulos = session.getAttribute("carrito")== null ? new ArrayList<>() : (ArrayList) session.getAttribute("carrito");
        ProductoC pc = new ProductoC();
        PagoEM pem = new PagoEM();
        PagoTM ptm = new PagoTM();
        if(articulos!=null){
            id_pedido = pem.realizarpedido(id_usuario, direccion, total);
            ptm.confirmarpedido(id_pedido);
            
            for(Articulo a: articulos){
                Producto producto = pc.getProducto(a.getId_producto());
                pem.insertarproductos(id_pedido, producto, a);
            }
            
            pem.cerrarconexion();
        }
        response.sendRedirect("inicio.jsp?pedido=true");
        articulos.clear();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
