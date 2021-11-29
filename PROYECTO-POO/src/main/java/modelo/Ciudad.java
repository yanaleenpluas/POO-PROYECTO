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
public class Ciudad {
    private String nombre;
    private String provincia;
    private String id;
    private static String codigo;

    public Ciudad(String nombre, String provincia, String id) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getId() {
        return id;
    }
    
     public void codigoCiudad(String id){
        this.codigo=id;
        
    }

    public static String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return ") Nombre=" + nombre + ", Provincia=" + provincia ;
    }

    
    
}
