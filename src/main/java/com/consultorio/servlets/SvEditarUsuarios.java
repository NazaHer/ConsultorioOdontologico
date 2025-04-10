package com.consultorio.servlets;

import com.consultorio.logica.Controladora;
import com.consultorio.logica.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvEditarUsuarios", urlPatterns = {"/SvEditarUsuarios"})
public class SvEditarUsuarios extends HttpServlet {
    
    Controladora controladora = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id")); //convierto el id que es un string a int
        Usuario u = controladora.conseguirUsuario(id);
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("usuarioEditar", u);
        
        response.sendRedirect("editarUsuario.jsp");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            String nombreUsuario = request.getParameter("nombreUsuario");
        String contrasenaUsuario = request.getParameter("contrasenaUsuario");
        String rol = request.getParameter("rol");
        
        Usuario u = (Usuario)request.getSession().getAttribute("usuarioEditar");
        
        u.actualizarValores(nombreUsuario, contrasenaUsuario, rol);
        
        controladora.editarUsuario(u);
        
        response.sendRedirect("SvUsuarios");
        }catch(IllegalArgumentException e){//Si fallo obtengo el mensaje
            request.setAttribute("errorMensaje", "Error: " + e.getMessage());
            request.getRequestDispatcher("editarUsuario.jsp").forward(request, response);
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
