<%@page import="com.consultorio.logica.Odontologo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Components/header.jsp" %>
<%@include file="Components/body.jsp" %>
<h1>Edición de Odontólogo</h1>
<p>Por favor complete los datos.</p>

<%
    Odontologo o = (Odontologo)request.getSession().getAttribute("odontologoEditar");
%>
<% if (request.getAttribute("errorMensaje") != null) { %>
        <div style="color:red; font-weight: bold;">
            <%= request.getAttribute("errorMensaje") %>
        </div>
        <% } %>
<form class="user" action="SvEditarOdontologo" method="POST">
                                <div class="form-group col">
                                    <div class="col-sm-6 mb-3">
                                        <input required type="text" class="form-control form-control-user" id="dniOdontologo"
                                               placeholder="DNI" name="dniOdontologo" value="<%=o.getDni()%>">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input required type="text" class="form-control form-control-user" id="nombreOdontologo"
                                            placeholder="Nombre" name="nombreOdontologo" value="<%=o.getNombre()%>">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input required type="text" class="form-control form-control-user" id="apellidoOdontologo"
                                            placeholder="Apellido" name="apellidoOdontologo" value="<%=o.getApellido()%>">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input required type="text" class="form-control form-control-user" id="telefonoOdontologo"
                                            placeholder="Telefono" name="telefonoOdontologo" value="<%=o.getTelefono()%>">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input required type="text" class="form-control form-control-user" id="direccionOdontologo"
                                            placeholder="Dirección" name="direccionOdontologo" value="<%=o.getDireccion()%>">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input required type="date" class="form-control form-control-user" id="fechanacOdontologo"
                                            placeholder="Fecha de nacimiento" name="fechanacOdontologo">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input required type="text" class="form-control form-control-user" id="especialidadOdontologo"
                                            placeholder="Especialidad" name="especialidadOdontologo" value="<%=o.getEspecialidad()%>">
                                    </div>
                                    
                                </div>
                                
                                <button class="btn btn-primary btn-user btn-block" type="submit">
                                    Confirmar datos
                                </button>
                                
                            </form>

<%@include file="Components/final.jsp" %>
