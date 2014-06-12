<%-- 
    Document   : layout
    Created on : 12-jun-2014, 14:00:17
    Author     : govergara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <title>TO 2014-1</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/extra.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/css/bootstrap/js/bootstrap.js"></script>
        
    </head>
    <body>
           <div class="container">
                <div class="header">
                    <ul class="nav nav-pills pull-right">
                        <li class="active"><a href="#">Inicio</a></li>
                        <li><a href="#">Fotografias</a></li>
                    </ul>
                    <h3 class="text-muted">Sistema Fotografias</h3>
                </div>

                <div>
                    <jsp:include page="/WEB-INF/pages/${content}.jsp"/>
                </div>

          <div class="footer">
            <p>&copy; UBB 2014</p>
          </div>

        </div> <!-- /container -->
    </body>
</html>
