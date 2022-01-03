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
//Auspiciante es clase hija de entidad
public class Auspiciante extends Entidad{
  //Atributos de Auspiciante
    private String webPage;
    private String id;
    private static String codigo;

    //Constructor de Auspiciante
    public Auspiciante(String id, String nombre, String direccion, Ciudad ciudad, String email, String telefono,String webPage ) {
      //Utilizamos super para llamar al constructor de la clase padre
        super(nombre, direccion, ciudad, email, telefono);
        this.webPage = webPage;
        this.id = id;
    }
    
    //Metodo de codigo de Auspiciante
    public void codigoAuspiciante(String id){
        this.codigo=id;
        
    }

    //Gettes y Setters
    public String getWebPage() {
        return webPage;
    }

    public String getId() {
        return id;
    }

    public static String getCodigo() {
        return codigo;
    }

    //Metodo toString
    @Override
    public String toString() {
        return ") "+nombre;
    }
    
    
    
    public static void mostrarAuspiciante(ArrayList<Auspiciante> auspiciantes){
        int i=0;
        for(Auspiciante a: auspiciantes){
            i++;
            System.out.print(i+ a.toString()+"\n");
        }
    }
}
