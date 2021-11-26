/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class Duenio extends Entidad {
  private String id;
  private String apellido;
  private static String codigo;
  //ArrayList<Mascota> mascotas;

    public Duenio(String id, String apellido, String nombre, String direccion, String email, String telefono) {
        super(nombre, direccion, email, telefono);
        this.id = id;
        this.apellido = apellido;
    }

    public String getId() {
        return id;
    }

    public String getApellido() {
        return apellido;
    }
    public void codigoDuenio(String id){
        codigo=id;
        
    }

    public static String getCodigo() {
        return codigo;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public static void setCodigo(String codigo) {
        Duenio.codigo = codigo;
    }

    public void setId(String id) {
        this.id = id;
    }
    

    @Override
    public String toString() {
        return  ") ID=" + id +super.toString()+ ", Apellido=" + apellido ;
    }
    



}
