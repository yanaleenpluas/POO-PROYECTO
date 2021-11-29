package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USUARIO
 */
public class Concurso {
    //Atributos
    private String idConcurso;
    private String nombre;
    private LocalDate fechaEvento;
    private LocalTime horaEvento;
    private LocalDate fechaInicioI;
    private LocalDate fechaCierreI;
    private Ciudad ciudad;
    private String lugar;
    private ArrayList<Premio> premios;
    private ArrayList<Auspiciante> auspiciantes;
    private TipoMascota dirigido;
    private ArrayList<Mascota> mascotasInscritas;
    private static String codigoC;
    private ArrayList<Mascota> mascotasGanadoras;
    private String estado;

  // Constructor

    public Concurso(String nombre, String fechaEvento, String idConcurso,String horaEvento, String fechaInicioI, String fechaCierreI,
            Ciudad ciudad, String lugar, ArrayList<Premio> premios, ArrayList<Auspiciante> auspiciantes, TipoMascota dirigido,
            ArrayList<Mascota> mascotasInscritas, ArrayList<Mascota> mascotasGanadoras) {
        this.nombre = nombre;
        this.fechaEvento = LocalDate.parse(fechaEvento);
      //  this.horaEvento = LocalTime.parse(horaEvento);
        this.fechaInicioI =LocalDate.parse(fechaInicioI);
        this.fechaCierreI = LocalDate.parse(fechaCierreI);
        this.ciudad = ciudad;
        this.lugar = lugar;
        this.premios = premios;
        this.auspiciantes = auspiciantes;
        this.dirigido = dirigido;
        this.mascotasInscritas = mascotasInscritas;
        this.mascotasGanadoras = mascotasGanadoras;  
        this.idConcurso=idConcurso;
        elegirEstado();
        codigoConcurso(idConcurso);
    }
    public void elegirEstado(){
        LocalDate ld1= LocalDate.now();
        if(fechaCierreI.isBefore(ld1)){
            this.estado="FINALIZADO";
        }
        else if(fechaCierreI.isAfter(ld1)){
            this.estado="VIGENTE";
        }

    } 

    public void setMascotasInscritas(ArrayList<Mascota> mascotasInscritas) {
        this.mascotasInscritas = mascotasInscritas;
    }

    public ArrayList<Mascota> getMascotasInscritas() {
        return mascotasInscritas;
    }

    public String getIdConcurso() {
        return idConcurso;
    }

    public String getEstado() {
        return estado;
    }

    public static String getCodigoC() {
        return codigoC;
    }
    
    public void mostrarPremios(ArrayList<Premio> premios){
        for(Premio p:premios){
          System.out.println(p.toString());
        }
      }

  // Metodo mostrar mascotas inscritas 
    public static void mostrarMascotas(ArrayList<Mascota> mascotas){
        System.out.println("\nLas mascotas Ganadoras son:");
        for(Mascota m: mascotas){
          System.out.print( m.getNombreM());
        }
    }
    
    public void codigoConcurso(String idConcurso){
        this.codigoC=idConcurso;
        
    }
    

   
    @Override
        public String toString() {
        return  ") Nombre=" + nombre + ", dirigido=" +dirigido+ ", codigo:" +idConcurso+ ", estado=" + estado ;
    }
     public void mostrarInformacion() {
        System.out.print(  ")ID Concurso=" + idConcurso + "\n-Nombre=" + nombre + "\n-Fecha Evento=" + fechaEvento
                + "\n-Hora Evento=" + horaEvento + "\n- Fecha Inicio Inscripcion=" + fechaInicioI + "\n-Fecha Cierre Inscripcion=" + fechaCierreI + "\n-Ciudad=" + ciudad + "\n-Lugar=" + lugar + "\n-Premios=" 
                );
        for (Premio p: premios){
            System.out.print("\n"+p.getPuesto()+"="+p.getDescripcion());
        
        }
        mostrarMascotas(mascotasGanadoras);
        System.out.print("\n-Auspiciantes=" + auspiciantes + "\n-Dirigido=" + dirigido+ "\n-Estado=" + estado+"\n");
    }
 
}