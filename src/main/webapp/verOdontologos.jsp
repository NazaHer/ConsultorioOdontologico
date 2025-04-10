<%@page import="java.util.List"%>
<%@page import="com.consultorio.logica.Odontologo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Components/header.jsp" %>
<%@include file="Components/body.jsp" %>
<%
    String permisos = usuarioActual.getRol();
%>
    <h1>Ver Odontólogos</h1>
    <div class="container-fluid">

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>DNI</th>
                                            <th>Nombre</th>
                                            <th>Apellido</th>
                                            <th>Telefono</th>
                                            <th>Direccion</th>
                                            <th>Fecha nacimiento</th>
                                            <th>Especialidad</th>
                                            <th style="width: 210px">Acción</th>
                                        </tr>
                                    </thead>
                                    <%
                                        List<Odontologo> listaOdontologos = (List)request.getSession().getAttribute("listaOdontologos");
                                    %>
                                    <tbody>
                                        <% for(Odontologo o : listaOdontologos) {%>
                                        <tr>
                                            <td><%=o.getDni()%></td>
                                            <td><%=o.getNombre()%></td>
                                            <td><%=o.getApellido()%></td>
                                            <td><%=o.getTelefono()%></td>
                                            <td><%=o.getDireccion()%></td>
                                            <td><%=o.getFechaNacimientoFormateada()%></td>
                                            <td><%=o.getEspecialidad()%></td>
                                            <td style="display: flex; width: 230px">
                                                <%if(permisos.equalsIgnoreCase("admin")){%>
                                                <form name="eliminar" action="SvEliminarOdontologo" method="POST">
                                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color: red; margin-right: 5px;">
                                                        <i class="fas fa-trash-alt"></i> Eliminar
                                                    </button>
                                                    <input type="hidden" name="id" value="<%=o.getId()%>"> <!--para mandar el codigo al servlet-->
                                                </form>
                                                <form name="editar" action="SvEditarOdontologo" method="GET">
                                                    <button type="submit" class="btn btn-primary btn-user btn-block"; style="margin-left: 5px;">
                                                        <i class="fas fa-pencil-alt"></i> Editar
                                                    </button>
                                                    <input type="hidden" name="id" value="<%=o.getId()%>"> <!--para mandar el codigo al servlet-->
                                                </form>
                                                <%} else { %>
                                                <p style="color: red; font-weight: bold;">No tienes permisos para realizar estas acciones.</p>
                                                <%} %>
                                            </td>
                                        </tr>
                                        <%}%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
<%@include file="Components/final.jsp" %>