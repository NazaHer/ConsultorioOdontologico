package com.consultorio.persistencia;

import com.consultorio.logica.Odontologo;
import com.consultorio.logica.Paciente;
import com.consultorio.logica.Usuario;
import com.consultorio.persistencia.exceptions.NonexistentEntityException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.internal.org.jline.terminal.TerminalBuilder;

public class ControladoraPersistencia {
    
    OdontologoJpaController odoJpa = new OdontologoJpaController();
    UsuarioJpaController usJpa = new UsuarioJpaController();
    PacienteJpaController pacJpa = new PacienteJpaController();

    //Metodos de Usuario
    public void crearUsuario(Usuario u) {
        usJpa.create(u);
    }

    public List<Usuario> getUsuarios() {
        return usJpa.findUsuarioEntities();
    }

    public void borrarUsuario(int id) {
        try {
            usJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario conseguirUsuario(int id) {
        return usJpa.findUsuario(id);
    }

    public void editarUsuario(Usuario u) {
        try {
            usJpa.edit(u);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Usuario> obtenerUsuarios() {
        return usJpa.findUsuarioEntities();
    }

    //Metodos de Odontologo
    public void crearOdontologo(Odontologo o) {
        odoJpa.create(o);
        System.out.println(o.toString());
    }

    public List<Odontologo> getOdontologos() {
        return odoJpa.findOdontologoEntities();
    }

    public void borrarOdontologo(int id) {
        try {
            odoJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Odontologo conseguirOdontologo(int id) {
        return odoJpa.findOdontologo(id);
    }

    public void editarOdontologo(Odontologo o) {
        try {
            odoJpa.edit(o);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Metodos para Paciente
    public void crearPaciente(Paciente p) {
        pacJpa.create(p);
    }

    public List<Paciente> getPacientes() {
        return pacJpa.findPacienteEntities();
    }

    public void borrarPaciente(int id) {
        try {
            pacJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Paciente conseguirPaciente(int id) {
        return pacJpa.findPaciente(id);
    }

    public void editarPaciente(Paciente p) {
        try {
            pacJpa.edit(p);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
