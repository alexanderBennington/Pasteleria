package Controlador;

import DAO.PersonaDAO;
import Modelo.Persona;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginC extends HttpServlet {
    PersonaDAO dao = new PersonaDAO();
    Persona p = new Persona();
    int r;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String correo=request.getParameter("correo");
        String clave=request.getParameter("clave");
        p.setCorreo(correo);
        p.setClave(clave);
        r=dao.validar(p);
        if(r==1){
            HttpSession session = request.getSession();
            session.setAttribute("sesion", true);
            session.setAttribute("id_usuario", p.getId_usuario());
            session.setAttribute("nombre", p.getNombre());
            session.setAttribute("apellido_paterno", p.getApellido_paterno());
            session.setAttribute("apellido_materno", p.getApellido_materno());
            session.setAttribute("telefono", p.getTelefono());
            session.setAttribute("correo", correo);
            session.setAttribute("clave", clave);
            request.getRequestDispatcher("inicio.jsp").forward(request, response);
        } 
        if(r == 0){
            request.getRequestDispatcher("index.jsp?error=true").forward(request, response);
        }
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
