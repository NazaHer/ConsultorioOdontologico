package com.consultorio.servlets;

import com.consultorio.logica.Controladora;
import com.consultorio.logica.Odontologo;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvEditarOdontologo", urlPatterns = {"/SvEditarOdontologo"})
public class SvEditarOdontologo extends HttpServlet {
    
    Controladora controladora = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        Odontologo o = controladora.conseguirOdontologo(id);
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("odontologoEditar", o);
        
        response.sendRedirect("editarOdontologo.jsp");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            String dni = request.getParameter("dniOdontologo");
            String nombre = request.getParameter("nombreOdontologo");
            String apellido = request.getParameter("apellidoOdontologo");
            String telefono = request.getParameter("telefonoOdontologo");
            String direccion = request.getParameter("direccionOdontologo");
            String fechaString = request.getParameter("fechanacOdontologo");
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaNac = null;
            try {
                fechaNac = formato.parse(fechaString);
            } catch (ParseException ex) {
                Logger.getLogger(SvOdontologo.class.getName()).log(Level.SEVERE, null, ex);
            }
            String especialidad = request.getParameter("especialidadOdontologo");
            
            Odontologo o = (Odontologo)request.getSession().getAttribute("odontologoEditar");
            
            o.actualizarValores(dni, nombre, apellido, telefono, direccion, fechaNac, especialidad);
            
            controladora.editarOdontologo(o);
        
            response.sendRedirect("SvOdontologo");
        }catch(IllegalArgumentException e){//Si fallo obtengo el mensaje
            request.setAttribute("errorMensaje", "Error: " + e.getMessage());
            request.getRequestDispatcher("editarOdontologo.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
