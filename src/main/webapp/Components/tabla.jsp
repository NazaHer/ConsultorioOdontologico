<%@page import="com.consultorio.logica.Usuario"%>
<%@page import="java.util.List"%>

<%
    String permisos = (String)session.getAttribute("rol");
%>

<div class="container-fluid">

                    <!-- Page Heading -->
                    <p class="mb-4">Usuario ya registrados en sistema. Si desea solicitar un usuario haga click <a target="_blank"
                            href="altaUsuario.jsp">acá</a>.</p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Nombre de usuario</th>
                                            <th>Rol</th>
                                            <th style="width: 210px">Acción</th>
                                        </tr>
                                    </thead>
                                    <%
                                        List<Usuario> listaUsuarios = (List)request.getSession().getAttribute("listaUsuarios");
                                    %>
                                    <tbody>
                                        <% for(Usuario u : listaUsuarios) {%>
                                        <tr>
                                            <td><%=u.getIdUsuario()%></td>
                                            <td><%=u.getNombreUsuario()%></td>
                                            <td><%=u.getRol()%></td>
                                            <td style="display: flex; width: 230px">
                                                <%if (permisos.equalsIgnoreCase("admin")) {%>
                                                <form name="eliminar" action="SvEliminarUsuarios" method="POST">
                                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color: red; margin-right: 5px;">
                                                        <i class="fas fa-trash-alt"></i> Eliminar
                                                    </button>
                                                    <input type="hidden" name="id" value="<%=u.getIdUsuario()%>"> <!--para mandar el codigo al servlet-->
                                                </form>
                                                <form name="editar" action="SvEditarUsuarios" method="GET">
                                                    <button type="submit" class="btn btn-primary btn-user btn-block"; style="margin-left: 5px;">
                                                        <i class="fas fa-pencil-alt"></i> Editar
                                                    </button>
                                                    <input type="hidden" name="id" value="<%=u.getIdUsuario()%>"> <!--para mandar el codigo al servlet-->
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
                <!-- /.container-fluid -->
