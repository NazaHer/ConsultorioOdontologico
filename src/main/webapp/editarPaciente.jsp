<%@page import="com.consultorio.logica.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Components/header.jsp" %>
<%@include file="Components/body.jsp" %>
<%
    String permisos = usuarioActual.getRol();
    Paciente p = (Paciente)request.getSession().getAttribute("pacienteEditar");
%>
<h1>Edición de Pacientes</h1>
<p>Por favor complete sus datos.</p>
<% if (request.getAttribute("errorMensaje") != null) { %>
        <div style="color:red; font-weight: bold;">
            <%= request.getAttribute("errorMensaje") %>
        </div>
        <% } %>

<form class="user" action="SvEditarPaciente" method="POST">
                                <div class="form-group col">
                                    <div class="col-sm-6 mb-3">
                                        <input required type="text" class="form-control form-control-user" id="dniPaciente"
                                               placeholder="DNI" name="dniPaciente" value="<%=p.getDni()%>">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input required type="text" class="form-control form-control-user" id="nombrePaciente"
                                            placeholder="Nombre" name="nombrePaciente" value="<%=p.getNombre()%>">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input required type="text" class="form-control form-control-user" id="apellidoPaciente"
                                            placeholder="Apellido" name="apellidoPaciente" value="<%=p.getApellido()%>">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input required type="text" class="form-control form-control-user" id="telefonoPaciente"
                                            placeholder="Telefono" name="telefonoPaciente" value="<%=p.getTelefono()%>">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input required type="text" class="form-control form-control-user" id="direccionPaciente"
                                            placeholder="Dirección" name="direccionPaciente" value="<%=p.getDireccion()%>">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input required type="date" class="form-control form-control-user" id="fechanacPaciente"
                                            placeholder="Fecha de nacimiento" name="fechanacPaciente">
                                    </div>
                                    <div class="col-sm-6 mb-3 form-check">
                                        <input type="checkbox" class="form-check-input" id="obraSocialPaciente" name="obraSocialPaciente" value="true">
                                        <label class="form-check-label" for="obraSocialPaciente">¿Tiene obra social?</label>
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input required type="text" class="form-control form-control-user" id="sangrePaciente"
                                               placeholder="Tipo de sangre" name="sangrePaciente" value="<%=p.getTipoSangre()%>">
                                    </div>
                                </div>
                                <button class="btn btn-primary btn-user btn-block" type="submit">
                                    Confirmar datos
                                </button>
                            </form>
<%@include file="Components/final.jsp" %>
