<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Components/header.jsp" %>
<%@include file="Components/body.jsp" %>
<%
    String permisos = usuarioActual.getRol();
%>
<h1>Registro de Odontólogo</h1>
<p>Por favor complete sus datos.</p>

<%if(permisos.equalsIgnoreCase("admin")){%>
<% if (request.getAttribute("errorMensaje") != null) { %>
        <div style="color:red; font-weight: bold;">
            <%= request.getAttribute("errorMensaje") %>
        </div>
        <% } %>
<form class="user" action="SvOdontologo" method="POST">
                                <div class="form-group col">
                                    <div class="col-sm-6 mb-3">
                                        <input required type="text" class="form-control form-control-user" id="dniOdontologo"
                                               placeholder="DNI" name="dniOdontologo">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input required type="text" class="form-control form-control-user" id="nombreOdontologo"
                                            placeholder="Nombre" name="nombreOdontologo">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input required type="text" class="form-control form-control-user" id="apellidoOdontologo"
                                            placeholder="Apellido" name="apellidoOdontologo">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input required type="text" class="form-control form-control-user" id="telefonoOdontologo"
                                            placeholder="Telefono" name="telefonoOdontologo">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input required type="text" class="form-control form-control-user" id="direccionOdontologo"
                                            placeholder="Dirección" name="direccionOdontologo">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input required type="date" class="form-control form-control-user" id="fechanacOdontologo"
                                            placeholder="Fecha de nacimiento" name="fechanacOdontologo">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input required type="text" class="form-control form-control-user" id="especialidadOdontologo"
                                            placeholder="Especialidad" name="especialidadOdontologo">
                                    </div>
                                    
                                    <!-- Aca va tod lo relacionado a horarios y usuarios -->
                                    
                                </div>
                                
                                <button class="btn btn-primary btn-user btn-block" type="submit">
                                    Crear Odontólogo
                                </button>
                                
                            </form>
                                <%} else { %>
                                                <p style="color: red; font-weight: bold;">No tienes permisos para realizar estas acciones.</p>
                                                <%} %>


<%@include file="Components/final.jsp" %>
