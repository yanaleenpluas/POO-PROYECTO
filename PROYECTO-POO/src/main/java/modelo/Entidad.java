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
//Utilizaremos entidad como una clase padre de duenio y auspiciante
public abstract class Entidad {
  //Atributos de Entidad
    protected String nombre;
    protected String direccion;
    protected String email;
    protected String telefono;
    protected Ciudad ciudad;

    //Constructor de entidad
    public Entidad(String nombre, String direccion, Ciudad ciudad, String email, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.email = email;
        this.telefono = telefono;
    }

    //getters y setters
    public Ciudad getCiudad() {
        return ciudad;
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

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //Metodo toStrin
    @Override
    public String toString() {
        return ", Nombre=" + nombre+", Ciudad: "+ ciudad.getNombre();
    }
    
}

