package modelo;


import modelo.Dueño;
import java.time.LocalDate;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USUARIO
 */
public class Mascota {
    private static String codigo;
    private String nombreM;
    private String raza;
    private LocalDate fechaNacimiento;
    private String foto;
    private Dueño dueño;
    private String id;
    private TipoMascota tipo;

    public Mascota(String nombreM, String raza, String fecha, String foto, String id, TipoMascota tipo) {
        this.nombreM = nombreM;
        this.raza = raza;
        LocalDate fechaNacimiento = LocalDate.parse(fecha);
        this.fechaNacimiento = fechaNacimiento;
        this.foto = foto;
        this.id = id;
        this.tipo = tipo;        
    }
    
    public void codigoMascota(String id){
        this.codigo=id;
        
    }

    public static String getCodigo() {
        return codigo;
    }

    public String getNombreM() {
        return nombreM;
    }

    public String getRaza() {
        return raza;
    }

    public Dueño getDueño() {
        return dueño;
    }

    public String getId() {
        return id;
    }

    public TipoMascota getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return  ") Nombre=" + nombreM + ", ID=" + id +  ", Raza=" + raza + ", Fecha Nacimiento=" + fechaNacimiento  +", Tipo=" + tipo ;
    }
    
}
