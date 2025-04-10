<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Components/header.jsp" %>
<%@include file="Components/body.jsp" %>
<%
    String permisos = usuarioActual.getRol();
%>
<h1>Registro de Usuarios</h1>
<p>Por favor complete sus datos.</p>
<%if(permisos.equalsIgnoreCase("admin")){%>
        <% if (request.getAttribute("errorMensaje") != null) { %>
        <div style="color:red; font-weight: bold;">
            <%= request.getAttribute("errorMensaje") %>
        </div>
        <% } %>
                            <form class="user" action="SvUsuarios" method="POST">
                                <div class="form-group col">
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" required class="form-control form-control-user" name="nombreUsuario"
                                            placeholder="Nombre Usuario" >
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="password" required class="form-control form-control-user" name="contrasenaUsuario"
                                            placeholder="Contraseña">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" required class="form-control form-control-user" name="rol"
                                            placeholder="Rol">
                                    </div>
                                </div>
                                <button class="btn btn-primary btn-user btn-block" type="submit">
                                    Crear Usuario
                                </button>
                            </form>
                            <%} else { %>
                            <p style="color: red; font-weight: bold;">No tienes permisos para realizar estas acciones.</p>
                            <%} %>

<%@include file="Components/final.jsp" %>
