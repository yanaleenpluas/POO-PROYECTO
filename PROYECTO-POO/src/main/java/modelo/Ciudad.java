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
      //Atributos de ciudad
    private String nombre;
    private String provincia;
    private String id;
    private static String codigo;
    
    //Constructor de ciudad
    public Ciudad(String nombre, String provincia, String id) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.id = id;
    }

    //Gettes y Setters
    public String getNombre() {
        return nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getId() {
        return id;
    }
    
    //Metodo de codigo de ciudad
    public void codigoCiudad(String id){
        this.codigo=id;
        
    }
    //Gettes y Setters
    public static String getCodigo() {
        return codigo;
    }

    //Metodo toString
    @Override
    public String toString() {
        return ") Nombre=" + nombre + ", Provincia=" + provincia ;
    }

    
    
}
