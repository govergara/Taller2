<%-- 
    Document   : upload
    Created on : 12-jun-2014, 17:45:26
    Author     : govergara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class='container'>
    <% out.println(request.getAttribute("url"));%>
    <div class='col-sm-12'>
        <form class="form-horizontal" role="form" method='post' enctype="multipart/form-data">
            <div class="form-group">
                <label class="col-sm-2 control-label">Foto:</label>
                <div class="col-sm-10">
                  <input type="file" class="form-control" name="foto">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Comentario</label>
                <div class="col-sm-10">
                    <textarea class='form-control' name='comentario'></textarea>
                </div>
            </div>

            <div class="form-group">
              <div class="col-sm-offset-2 col-sm-10">
                  <button type="submit" class="btn btn-success"> <span class='glyphicon glyphicon-upload'></span> Subir</button>
              </div>
            </div>
        </form>

    </div>
    
</div>

