package com.consultorio.servlets;

import com.consultorio.logica.Controladora;
import com.consultorio.logica.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvUsuarios", urlPatterns = {"/SvUsuarios"})
public class SvUsuarios extends HttpServlet {
    
    Controladora controladora = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        
        listaUsuarios = controladora.getUsuarios();
        
        HttpSession sesionActual = request.getSession();
        sesionActual.setAttribute("listaUsuarios", listaUsuarios);

        response.sendRedirect("verUsuarios.jsp");
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            //Obtención de datos
            String nombreUsuario = request.getParameter("nombreUsuario");
            String contrasenaUsuario = request.getParameter("contrasenaUsuario");
            String rol = request.getParameter("rol");
            //Creo con esos datos el usuario
            controladora.crearUsuario(nombreUsuario, contrasenaUsuario, rol);
            //Regreso al index si todo fue correcto
            response.sendRedirect("index.jsp");
        }catch(IllegalArgumentException e){//Si fallo obtengo el mensaje
            request.setAttribute("errorMensaje", "Error: " + e.getMessage());
            request.getRequestDispatcher("altaUsuario.jsp").forward(request, response);
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
