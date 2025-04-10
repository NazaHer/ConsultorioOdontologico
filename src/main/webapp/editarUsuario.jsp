<%@page import="com.consultorio.logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Components/header.jsp" %>
<%@include file="Components/body.jsp" %>
<h1>Edición de Usuario</h1>
<p>Por favor complete sus datos.</p>

<% if (request.getAttribute("errorMensaje") != null) { %>
<div style="color:red; font-weight: bold;">
    <%= request.getAttribute("errorMensaje") %>
</div>
<% } %>

<% Usuario u = (Usuario)request.getSession().getAttribute("usuarioEditar"); //Castearlo para que no rompa al ser otro objeto %>



<form class="user" action="SvEditarUsuarios" method="POST">
    
                                <div class="form-group col">
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" name="nombreUsuario"
                                               placeholder="Nombre Usuario" value="<%=u.getNombreUsuario()%>" required>
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="password" class="form-control form-control-user" name="contrasenaUsuario"
                                            placeholder="Contraseña" value="<%=u.getContrasena()%>" required>
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user" name="rol"
                                            placeholder="Rol" value="<%=u.getRol()%>" required>
                                    </div>
                                    
                                    
                                    <!-- Aca va tod lo relacionado a horarios y usuarios -->
                                    
                                </div>
                                
                                <button class="btn btn-primary btn-user btn-block" type="submit">
                                    Confirmar datos
                                </button>
                                
                            </form>

<%@include file="Components/final.jsp" %>
