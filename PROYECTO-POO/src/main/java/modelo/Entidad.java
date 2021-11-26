/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author USUARIO
 */
public abstract class Entidad {
    private String nombre;
    private String direccion;
    //private Cuidad cuidad;
    private String email;
    private String telefono;

    public Entidad(String nombre, String direccion,  String email, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        //this.cuidad = cuidad;
        this.email = email;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }


    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return ", Nombre=" + nombre;
    }
    
}

