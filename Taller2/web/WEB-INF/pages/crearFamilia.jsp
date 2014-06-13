<%-- 
    Document   : crearFamilia
    Created on : 12-jun-2014, 17:45:26
    Author     : govergara
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Familia"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class='container'>
    <% 
        String mensaje = (request.getAttribute("mensaje") == null) ? "" : request.getAttribute("mensaje").toString();
        if(!mensaje.isEmpty() ){
            out.println("Guardado exitosamente");
        }
    %>
    <div class='col-sm-12'>
        <form class="form-horizontal" role="form" method='post'>
            <div class="form-group">
                <label class="col-sm-2 control-label">Nombre</label>
                <div class="col-sm-10">
                  <input type="text" class="form-control" name="nombre" required>
                </div>
            </div>
            <div class="form-group">
              <div class="col-sm-offset-2 col-sm-10">
                  <button type="submit" class="btn btn-success"> <span class='glyphicon glyphicon-save'></span> Guardar</button>
              </div>
            </div>
        </form>

    </div>
    
</div>


