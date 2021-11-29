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
public class Premio {    
    private String puesto;
    private Auspiciante auspiciante;
    private String descripcion;

    public Premio(String puesto, Auspiciante auspiciante, String descripcion) {
        this.puesto = puesto;
        this.auspiciante = auspiciante;
        this.descripcion = descripcion;
    }

    public String getPuesto() {
        return puesto;
    }

    public Auspiciante getAuspiciante() {
        return auspiciante;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return puesto + ": " + descripcion+ ", Auspiciante=" + auspiciante  ;
    }
    
    public static Premio CrearPremio(Auspiciante auspiciante){
        Scanner sc =  new Scanner(System.in);
        System.out.print("Ingresar Puesto:\n");
        String puesto = sc.nextLine();
        System.out.print("Ingresar Descripcion:\n");;
        String descripcion = sc.nextLine();
        Premio p= new Premio(puesto,auspiciante, descripcion);
        return p;        
    }
    


}
