package com.consultorio.logica;

import java.io.Serializable;
import java.security.Identity;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//Se mapa como entidad la clase madre
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//Superclase
public class Persona implements Serializable {
    
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String dni;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    
    //Constructor
    public Persona(){
    }

    //Constructor parametrizado
    public Persona(int id, String dni, String nombre, String apellido, String telefono, String direccion, Date fechaNacimiento) {
        setId(id);
        setDni(dni);
        setNombre(nombre);
        setApellido(apellido);
        setTelefono(telefono);
        setDireccion(direccion);
        setFechaNacimiento(fechaNacimiento);
    }
    
    public Persona(String dni, String nombre, String apellido, String telefono, String direccion, Date fechaNacimiento) {
        setDni(dni);
        setNombre(nombre);
        setApellido(apellido);
        setTelefono(telefono);
        setDireccion(direccion);
        setFechaNacimiento(fechaNacimiento);
    }

    //Getters
    public int getId() {
        return id;
    }
    
    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    //Setters
    private void setId(int id) {
        this.id = id;
    }
    
    private void setDni(String dni) {
        if(dni == null || dni.isBlank()){
            throw new IllegalArgumentException("El DNI no puede estar vacío.");
        }
        this.dni = dni;
    }

    private void setNombre(String nombre) {
        if(nombre == null || nombre.isBlank()){
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    private void setApellido(String apellido) {
        if(apellido == null || apellido.isBlank()){
            throw new IllegalArgumentException("El apellido no puede estar vacío.");
        }
        this.apellido = apellido;
    }

    private void setTelefono(String telefono) {
        if(telefono == null || telefono.isBlank()){
            throw new IllegalArgumentException("El telefono no puede estar vacío.");
        }
        this.telefono = telefono;
    }

    private void setDireccion(String direccion) {
        if(direccion == null || direccion.isBlank()){
            throw new IllegalArgumentException("La dirección no puede estar vacía.");
        }
        this.direccion = direccion;
    }

    private void setFechaNacimiento(Date fechaNacimiento) {
        if(fechaNacimiento == null){
            throw new IllegalArgumentException("La fecha de nacimiento no puede estar vacía.");
        }
        this.fechaNacimiento = fechaNacimiento;
    }
    
    //Metodos
    //Podria reverlo como metodo abstracto para las clases hijas.
    public void actualizarValores(String dni, String nombre, String apellido, String telefono, String direccion, Date fechaNacimiento){
        setDni(dni);
        setNombre(nombre);
        setApellido(apellido);
        setTelefono(telefono);
        setDireccion(direccion);
        setFechaNacimiento(fechaNacimiento);
    }
    
}
