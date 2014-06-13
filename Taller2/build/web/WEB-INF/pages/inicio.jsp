<%-- 
    Document   : inicio
    Created on : 12-jun-2014, 16:35:04
    Author     : govergara
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Fotografia"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.Familia"%>
<%@page import="Modelo.Modelo"%>


<div class="jumbotron">
   <h1>Fotografias de tu familia</h1>
   <p class="lead">Si quieres subir una nueva fotografia haz click acá!</p>
   <p><a class="btn btn-lg btn-success" href="/Taller2/upload" role="button"> <span class="glyphicon glyphicon-picture"></span> Subir Foto</a></p>
</div>

<div class="container">
    <%
        Familia f = Modelo.getInstance().buscarFamilia(request.getAttribute("familia").toString());
        if(f != null){
            ArrayList<Fotografia> fotos = f.getFotos();
            int rows = (fotos.size() / 3)+1;
            int i,j,cont =0;
            Fotografia tmpFoto;
            for(i=0; i< rows; ++i){
                out.println("<div class='row'>");
                for(j=0; j<3 && cont < fotos.size(); ++j, ++cont){
                    tmpFoto = fotos.get(cont);
                    out.println("<div class='col-sm-4'>");
                        out.println(" <div class='thumbnail'>");
                               out.println("<img src='"+request.getContextPath()+"/images/"+tmpFoto.getPath()+"'>");
                               out.println("<div class='caption'>");
                                    out.println(" <h3>Comentario</h3>");
                                    out.println("<p>"+tmpFoto.getComentario()+"</p>");
                               out.println("</div>");
                    
                         out.println("</div>");
                     out.println("</div>");
                }
                out.println("</div>");
            }
        }
    %>
</div>