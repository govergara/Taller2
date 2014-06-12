<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Familia"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="jumbotron">
                    <h1>Inicio de sesión</h1>
                    <p class="lead">Ingrese sus datos para iniciar sesión</p>
                    <form class="form-horizontal" role="form" method="post">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Familia</label>
                            <div class="col-sm-10">
                                <select class='form-control'>
                                    <%
                                        int i;
                                        Familia tmp;
                                        ArrayList<Familia> familias = (ArrayList)request.getAttribute("familias");
                                        for(i=0; i<familias.size(); ++i){
                                            tmp = familias.get(i);
                                            out.println("<option value='"+tmp.getNombre()+"'>"+tmp.getNombre()+"</option>");
                                        }
                                    %>
                                </select>   
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">RUT</label>
                            <div class="col-sm-10">
                                <input type="text" name="rut" class="form-control" id="rut" placeholder="Ejemplo: 11.111.111-1">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" placeholder="Password">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                              <button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-user"></span>  Login</button>
                            </div>
                        </div>
                    </form>
                </div>