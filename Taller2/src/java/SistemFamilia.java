/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Modelo.Modelo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.Familia;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author govergara
 */
@WebServlet(urlPatterns = {"/SistemFamilia"})
public class SistemFamilia extends HttpServlet {

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
        request.setAttribute("content", "login");
        
        request.setAttribute("familias", Modelo.getInstance().getFamilias());
        
        
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
        Modelo.getInstance().readData(this.getServletContext().getRealPath("datos.xml"));
        HttpSession sesion = request.getSession(true);
        if(sesion.getAttribute("familia") != null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("Inicio");
            dispatcher.forward(request, response);
        }else{
            processRequest(request, response);
        }
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
        HttpSession sesion = request.getSession();
        String rut = request.getParameter("rut").toString();
        String clave = request.getParameter("clave").toString();
        String familia = request.getParameter("familia").toString();
        Modelo m = Modelo.getInstance();
        Familia f = m.buscarFamilia(familia);
        if(f == null)
            request.setAttribute("error", "Familia no existe");
        else{
            //f.perteneceFamilia(rut, clave)
            if(f.perteneceFamilia(rut, clave)){
                sesion.setAttribute("familia", familia);
                sesion.setAttribute("rut", rut);
                RequestDispatcher dispatcher = request.getRequestDispatcher("Inicio");
                dispatcher.forward(request, response);
                return ;
            }else{
                request.setAttribute("error", "Datos no válidos");
            }
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
        return "Login en el sistema";
    }// </editor-fold>

}
