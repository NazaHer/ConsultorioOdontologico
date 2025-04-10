package com.consultorio.servlets;

import com.consultorio.logica.Controladora;
import com.consultorio.logica.Paciente;
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

@WebServlet(name = "SvPaciente", urlPatterns = {"/SvPaciente"})
public class SvPaciente extends HttpServlet {
    
    Controladora controladora = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Paciente> listaPacientes = new ArrayList<Paciente>();
        
        listaPacientes = controladora.getPacientes();
        
        HttpSession sesionActual = request.getSession();
        sesionActual.setAttribute("listaPacientes", listaPacientes);
        
        response.sendRedirect("verPacientes.jsp");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            String dni = request.getParameter("dniPaciente");
            String nombre = request.getParameter("nombrePaciente");
            String apellido = request.getParameter("apellidoPaciente");
            String telefono = request.getParameter("telefonoPaciente");
            String direccion = request.getParameter("direccionPaciente");
            String fechaString = request.getParameter("fechanacPaciente");
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaNac = null;
            boolean obraSocial = true;
            try {
                fechaNac = formato.parse(fechaString);
            } catch (ParseException ex) {
                Logger.getLogger(SvOdontologo.class.getName()).log(Level.SEVERE, null, ex);
            }
            String texto = request.getParameter("obraSocialPaciente");
            if(texto == null){
                obraSocial = false;
            }
            String sangre = request.getParameter("sangrePaciente");
        
            controladora.crearPaciente(dni, nombre, apellido, telefono, direccion, fechaNac, obraSocial, sangre);
        
            response.sendRedirect("index.jsp");
        }catch(IllegalArgumentException e){//Si fallo obtengo el mensaje
            request.setAttribute("errorMensaje", "Error: " + e.getMessage());
            request.getRequestDispatcher("altaPaciente.jsp").forward(request, response);
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
