package com.consultorio.logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.OneToOne;


@Entity
//Extiende de Persona
public class Secretario extends Persona implements Serializable{
    
    //Atributos
    private String sector;
    @OneToOne
    private Usuario usuario;
    
    //Constructor
    public Secretario(){
    }
    
    //Constructor parametrizado desde la superclase

    public Secretario(String sector, Usuario usuario, int id, String dni, String nombre, String apellido, String telefono, String direccion, Date fechaNacimiento) {
        super(id, dni, nombre, apellido, telefono, direccion, fechaNacimiento);
        setSector(sector);
        setUsuario(usuario);
    }
    
    
    //Getters
    public String getSector() {
        return sector;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    //Setters
    public void setSector(String sector) {
        if(sector == null || sector.isBlank()){
            throw new IllegalArgumentException("El sector no puede estar vacío.");
        }
        this.sector = sector;
    }

    public void setUsuario(Usuario usuario) {
        if(usuario == null){
            throw new IllegalArgumentException("No puede no tener usuario.");
        }
        this.usuario = usuario;
    }
    
}
