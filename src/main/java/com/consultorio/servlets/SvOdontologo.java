package com.consultorio.servlets;

import com.consultorio.logica.Controladora;
import com.consultorio.logica.Odontologo;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvOdontologo", urlPatterns = {"/SvOdontologo"})
public class SvOdontologo extends HttpServlet {
    
    Controladora controladora = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Odontologo> listaOdontologos = new ArrayList<Odontologo>();
        
        listaOdontologos = controladora.getOdontologos();
        
        HttpSession sesionActual = request.getSession();
        sesionActual.setAttribute("listaOdontologos", listaOdontologos);

        response.sendRedirect("verOdontologos.jsp");
        
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

            controladora.crearOdontologo(dni, nombre, apellido, telefono, direccion, fechaNac, especialidad);
        
            response.sendRedirect("index.jsp");
        }catch(IllegalArgumentException e){//Si fallo obtengo el mensaje
            request.setAttribute("errorMensaje", "Error: " + e.getMessage());
            request.getRequestDispatcher("altaOdontologo.jsp").forward(request, response);
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
