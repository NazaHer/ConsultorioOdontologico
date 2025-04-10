package com.consultorio.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario implements Serializable {
    
    //Atributos
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idUsuario;
    private String nombreUsuario;
    private String contrasena;
    private String rol;
    
    //Constructor
    public Usuario(){
    }
    
    //Constructor parametrizado
    public Usuario(int idUsuario, String nombreUsuario, String contrasena, String rol) {
        setIdUsuario(idUsuario);
        setNombreUsuario(nombreUsuario);
        setContrasena(contrasena);
        setRol(rol);
    }
    
    public Usuario(String nombreUsuario, String contrasena, String rol) {
        setNombreUsuario(nombreUsuario);
        setContrasena(contrasena);
        setRol(rol);
    }

    //Getters
    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getRol() {
        return rol;
    }
    
    //Setters
    private void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    private void setNombreUsuario(String nombreUsuario) {
        if(nombreUsuario == null || nombreUsuario.isBlank()){
            throw new IllegalArgumentException("Nombre de usuario no puede estar vacio.");
        }
        this.nombreUsuario = nombreUsuario;
    }

    private void setContrasena(String contrasena) {
        if(contrasena == null || contrasena.isBlank()){
            throw new IllegalArgumentException("Contraseña no puede estar vacio.");
        }
        this.contrasena = contrasena;
    }

    private void setRol(String rol) {
        if(rol == null || rol.isBlank()){
            throw new IllegalArgumentException("El ROL no puede estar vacio.");
        }
        this.rol = rol;
    }
    
    //Metodo para actulizar sus valores al editar.
    public void actualizarValores(String nombreUsuario, String contrasena, String rol){
        setNombreUsuario(nombreUsuario);
        setContrasena(contrasena);
        setRol(rol);
    }
    
}
