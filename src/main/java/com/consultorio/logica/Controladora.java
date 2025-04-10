package com.consultorio.logica;

import com.consultorio.persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Controladora {
    
    ControladoraPersistencia cp = new ControladoraPersistencia();
    
    //Metodos para Usuario
    public void crearUsuario(String nombreUsuario, String contrasena, String rol){
        cp.crearUsuario(new Usuario(nombreUsuario, contrasena, rol));
    }

    public List<Usuario> getUsuarios() {
        return cp.getUsuarios();
    }

    public void borrarUsuario(int id) {
        cp.borrarUsuario(id);
    }

    public Usuario conseguirUsuario(int id) {
        return cp.conseguirUsuario(id);
    }

    public void editarUsuario(Usuario u) {
        cp.editarUsuario(u);
    }
    
    public Usuario buscarUsuario(String usuario, String contrasena) {
        Usuario buscado = null;
        int i = 0;
        List<Usuario> usuarios = cp.obtenerUsuarios();
        while(i < usuarios.size() && buscado == null){
            if(usuarios.get(i).getNombreUsuario().equalsIgnoreCase(usuario)){//Estoy usando el ignoreCase para hacer mas practica la prueba
                if(usuarios.get(i).getContrasena().equalsIgnoreCase(contrasena)){
                    buscado = cp.obtenerUsuarios().get(i);
                }
            }
            i++;
        }
        return buscado;
    }

    //Metodos para Odontologo
    public void crearOdontologo(String dni, String nombre, String apellido, String telefono, String direccion, Date fechaNac, String especialidad) {
        cp.crearOdontologo(new Odontologo(especialidad, dni, nombre, apellido, telefono, direccion, fechaNac));
    }

    public List<Odontologo> getOdontologos() {
        return cp.getOdontologos();
    }

    public void borrarOdontologo(int id) {
        cp.borrarOdontologo(id);
    }

    public Odontologo conseguirOdontologo(int id) {
        return cp.conseguirOdontologo(id);
    }

    public void editarOdontologo(Odontologo o) {
        cp.editarOdontologo(o);
    }

    //Metodos para Paciente
    public void crearPaciente(String dni, String nombre, String apellido, String telefono, String direccion, Date fechaNac, boolean obraSocial, String sangre) {
        cp.crearPaciente(new Paciente(obraSocial, sangre, dni, nombre, apellido, telefono, direccion, fechaNac));
    }

    public List<Paciente> getPacientes() {
        return cp.getPacientes();
    }

    public void borrarPaciente(int id) {
        cp.borrarPaciente(id);
    }

    public Paciente conseguirPaciente(int id) {
        return cp.conseguirPaciente(id);
    }

    public void editarPaciente(Paciente p) {
        cp.editarPaciente(p);
    }

}
