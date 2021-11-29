/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
//Clase administrar cuidad
public class AdministrarCiudad {
    //crea una ciudad nueva
    public static Ciudad CrearCiudad(){
        Scanner sc =  new Scanner(System.in);
        System.out.print("Ingresar Nombre de Ciudad:\n");
        String nombre = sc.nextLine();
        System.out.print("Ingresar Porvincia:\n");
        String provincia = sc.nextLine();
        System.out.print("Ingresar ID :\n");
        String iD = sc.nextLine();
        Ciudad c= new Ciudad(nombre,provincia, iD);
        return c;
        
    }
    //muestra las ciudades existentes
    public static void mostrarCiudades(ArrayList<Ciudad> ciudades){
        int i=0;
        for(Ciudad c: ciudades){
            i++;
            System.out.print(i+ c.toString()+"\n");
        }
    }
    
}
