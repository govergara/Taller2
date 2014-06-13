/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Modelo.Familia;
import Modelo.Fotografia;
import Modelo.Modelo;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author govergara
 */
@WebServlet(urlPatterns = {"/upload"})
@MultipartConfig
public class upload extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("content", "upload");
        HttpSession sesion = request.getSession();
        request.setAttribute("familia", sesion.getAttribute("familia"));
        
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
        HttpSession sesion = request.getSession(false);
        if(sesion.getAttribute("familia") == null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("SistemFamilia");
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
        HttpSession sesion = request.getSession(false);
        if(sesion.getAttribute("familia") != null){
            try{
                Part foto = request.getPart("foto");
                String filename = this.getServletContext().getRealPath("images/"+ getFileName(foto));
                InputStream input = foto.getInputStream();
                FileOutputStream output;
                output = new FileOutputStream(filename);
                int leido = 0;
                leido = input.read();
                while (leido != -1) {
                    output.write(leido);
                    leido = input.read();
                }
                Fotografia photo = new Fotografia(getFileName(foto), request.getParameter("comentario"));
                System.out.println(sesion.getAttribute("familia"));
                Familia f = Modelo.getInstance().buscarFamilia(sesion.getAttribute("familia").toString());
                System.out.println(f);
                f.addFoto(photo);
                request.setAttribute("mensaje", "Guardado exitosamente");
            }catch(Exception e){
                request.setAttribute("mensaje", "Ups! "+e.getMessage());
            }
            
        }
        processRequest(request, response);
    }
    
     private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
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
