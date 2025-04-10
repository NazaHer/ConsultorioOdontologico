<%@page import="com.consultorio.logica.Paciente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Components/header.jsp" %>
<%@include file="Components/body.jsp" %>
<%
    String permisos = usuarioActual.getRol();
    List<Paciente> listaPacientes = (List)request.getSession().getAttribute("listaPacientes");
%>
<h1>Ver Pacientes</h1>
<%if(permisos.equalsIgnoreCase("admin")){%>
<div class="container-fluid">
    <div class="card shadow mb-4">
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>DNI</th>
                            <th>Nombre</th>
                            <th>Telefono</th>
                            <th>Direccion</th>
                            <th>Nacimiento</th>
                            <th>Obra social</th>
                            <th>Sangre</th>
                            <th style="width: 210px">Acción</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for(Paciente p : listaPacientes){
                        %>
                        <tr>
                            <td><%=p.getDni()%></td>
                            <td><%=p.getNombre() + " " +p.getApellido()%></td>
                            <td><%=p.getTelefono()%></td>
                            <td><%=p.getDireccion()%></td>
                            <td><%=p.getFechaNacimientoFormateada()%></td>
                            <td>
                                <%=
                                   p.isPoseeObraSocial() ? "SI" : "NO"
                                %>
                            </td>
                            <td><%=p.getTipoSangre()%></td>
                            <td style="display: flex; width: 230px">
                                <form name="eliminar" action="SvEliminarPaciente" method="POST">
                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color: red; margin-right: 5px;">
                                        <i class="fas fa-trash-alt"></i> Eliminar
                                    </button>
                                    <input type="hidden" name="id" value="<%=p.getId()%>">
                                </form>
                                <form name="editar" action="SvEditarPaciente" method="GET">
                                    <button type="submit" class="btn btn-primary btn-user btn-block"; style="margin-left: 5px;">
                                        <i class="fas fa-pencil-alt"></i> Editar
                                    </button>
                                        <input type="hidden" name="id" value="<%=p.getId()%>"> <!--para mandar el codigo al servlet-->
                                </form>
                            </td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<%} else { %>
    <p style="color: red; font-weight: bold;">No tienes permisos para realizar estas acciones.</p>
<%} %>
<%@include file="Components/final.jsp" %>