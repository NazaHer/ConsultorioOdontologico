package com.consultorio.logica;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Entity;

@Entity
//Extiende de Persona
public class Paciente extends Persona implements Serializable{
    
    //Atributos
    private boolean poseeObraSocial;
    private String tipoSangre;
    
    //Constructor
    public Paciente(){
    }

    //Constructor parametrizado desde la superclase
    public Paciente(boolean poseeObraSocial, String tipoSangre, int id, String dni, String nombre, String apellido, String telefono, String direccion, Date fechaNacimiento) {
        super(id, dni, nombre, apellido, telefono, direccion, fechaNacimiento);
        setPoseeObraSocial(poseeObraSocial);
        setTipoSangre(tipoSangre);
    }

    public Paciente(boolean poseeObraSocial, String tipoSangre, String dni, String nombre, String apellido, String telefono, String direccion, Date fechaNacimiento) {
        super(dni, nombre, apellido, telefono, direccion, fechaNacimiento);
        setPoseeObraSocial(poseeObraSocial);
        setTipoSangre(tipoSangre);
    }
    
    //Getters
    public boolean isPoseeObraSocial() {
        return poseeObraSocial;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }
    
    //Setters
    private void setPoseeObraSocial(boolean poseeObraSocial) {
        this.poseeObraSocial = poseeObraSocial;
    }

    private void setTipoSangre(String tipoSangre) {
        if(tipoSangre == null || tipoSangre.isBlank()){
            throw new IllegalArgumentException("El tipo de sangre no puede estar vacío.");
        }
        this.tipoSangre = tipoSangre;
    }

    //Metodos
    public void actualizarValores(String dni, String nombre, String apellido, String telefono, String direccion, Date fechaNac, boolean obraSocial, String sangre) {
        super.actualizarValores(dni, nombre, apellido, telefono, direccion, fechaNac);
        setPoseeObraSocial(obraSocial);
        setTipoSangre(sangre);
    }
    
    public String getFechaNacimientoFormateada() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(super.getFechaNacimiento());
    }
}
