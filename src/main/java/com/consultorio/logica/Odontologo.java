package com.consultorio.logica;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import java.util.Date;
import javax.persistence.Entity;


@Entity
//Extiende de Persona
public class Odontologo extends Persona implements Serializable{
    
    //Atributos
    private String especialidad;
    
    //Constructor
    public Odontologo(){
    }

    //Constructor parametrizado desde la superclase
    public Odontologo(String especialidad, int id, String dni, String nombre, String apellido, String telefono, String direccion, Date fechaNacimiento) {
        super(id, dni, nombre, apellido, telefono, direccion, fechaNacimiento);
        setEspecialidad(especialidad);
    }

    public Odontologo(String especialidad, String dni, String nombre, String apellido, String telefono, String direccion, Date fechaNacimiento) {
        super(dni, nombre, apellido, telefono, direccion, fechaNacimiento);
        setEspecialidad(especialidad);
    }
    
    //Getters
   public String getEspecialidad() {
        return especialidad;
    }

    //Setters
    private void setEspecialidad(String especialidad) {
        if(especialidad == null || especialidad.isBlank()){
            throw new IllegalArgumentException("La especialidad no puede estar vacío.");
        }
        this.especialidad = especialidad;
    }

    public void actualizarValores(String dni, String nombre, String apellido, String telefono, String direccion, Date fechaNac, String especialidad) {
        super.actualizarValores(dni, nombre, apellido, telefono, direccion, fechaNac);
        setEspecialidad(especialidad);
    }
    
    
    //Metodos
    public String getFechaNacimientoFormateada() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(super.getFechaNacimiento());
    }

    
}
