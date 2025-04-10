package com.consultorio.servlets;

import com.consultorio.logica.Controladora;
import com.consultorio.logica.Paciente;
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

@WebServlet(name = "SvEditarPaciente", urlPatterns = {"/SvEditarPaciente"})
public class SvEditarPaciente extends HttpServlet {

    Controladora controladora = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        Paciente p = controladora.conseguirPaciente(id);
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("pacienteEditar", p);
        
        response.sendRedirect("editarPaciente.jsp");
        
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
            try {
                fechaNac = formato.parse(fechaString);
            } catch (ParseException ex) {
                Logger.getLogger(SvOdontologo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            boolean obraSocial = true;    
            String texto = request.getParameter("obraSocialPaciente");
            if(texto == null){
                obraSocial = false;
            }
            
            String sangre = request.getParameter("sangrePaciente");
        
            Paciente p = (Paciente)request.getSession().getAttribute("pacienteEditar");
            p.actualizarValores(dni, nombre, apellido, telefono, direccion, fechaNac, obraSocial, sangre);
        
            controladora.editarPaciente(p);
        
            response.sendRedirect("SvPaciente");
        }catch(IllegalArgumentException e){//Si fallo obtengo el mensaje
            request.setAttribute("errorMensaje", "Error: " + e.getMessage());
            request.getRequestDispatcher("editarPaciente.jsp").forward(request, response);
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
