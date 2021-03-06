/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Modelo.Familia;
import Modelo.MiembroFamilia;
import Modelo.Modelo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author govergara
 */
@WebServlet(urlPatterns = {"/Crear"})
public class Crear extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         request.setAttribute("content", "crear");
        
        getServletContext().getRequestDispatcher("/WEB-INF/pages/layout.jsp").forward(request, response);
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
        try{
            String nombre = request.getParameter("nombre");
            String rut = request.getParameter("rut");
            String clave = request.getParameter("clave");
            Familia f = Modelo.getInstance().buscarFamilia(request.getParameter("familia"));
            MiembroFamilia miembro = new MiembroFamilia(nombre, rut, clave);
            f.addMiembro(miembro);
            request.setAttribute("mensaje", "Guardado exitosamente");
            Modelo.getInstance().writeData(this.getServletContext().getRealPath("datos.xml"));
        }catch(Exception e){
            request.setAttribute("mensaje", "Ups! error mientras creabamos el miembro de la familia");
        }
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Crear nuevo mienbro de la familia";
    }// </editor-fold>

}
