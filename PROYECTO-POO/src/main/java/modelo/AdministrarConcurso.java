/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.Auspiciante;
import modelo.Premio;


/**
 *
 * @author USUARIO
 */
//Clase administrar concurso
public class AdministrarConcurso {
    public static int menu(ArrayList<Concurso> concursos){
        System.out.print("----Administrar Concurso----");

        System.out.print("\n>>>Concursos Existentes:\n");
        mostrarConcursos(concursos);
        System.out.print("\nCodigo de Concurso: " + Concurso.getCodigoC() +"\n");
        System.out.print("\n 1. Crear Concurso.\n 2. Inscribir Participante.\n 3. Mostrar Informacion de concurso.\n 4. Regresar al menu principal\n");
        System.out.print("Ingrese una opcion:\n");
        Scanner sc= new Scanner(System.in);
        int opcion=sc.nextInt();
        return opcion;
    }
    //muestra los concursos existentes
    public static void mostrarConcursos(ArrayList<Concurso> concursos){
        int i=1;
        for(Concurso c:concursos){
            System.out.print(i+ c.toString()+"\n");
            i++;
        }
    }
    //muestra los concursos vigentes
    public static void mostrarConcursosVigentes(ArrayList<Concurso> concursos){
        int i=1;
        for(Concurso c:concursos){
            if(c.getEstado().equals("VIGENTE")){
                System.out.print(i+ c.toString()+"\n");
                i++; 
            }
        }
    }
    //cea un nuevo concurso
    public static void crearConcurso(ArrayList<Concurso> concursos, 
        ArrayList<Ciudad> ciudades, ArrayList<Auspiciante> auspiciantes){
        System.out.print("\n-----Crear Concurso-----\n");
        ArrayList<Auspiciante> auspiciantesC= new ArrayList<Auspiciante>();
        ArrayList<Mascota> mInscritas= new ArrayList<Mascota>();
        ArrayList<Mascota> mGanadoras= new ArrayList<Mascota>();
        ArrayList<Premio> premios= new ArrayList<Premio>();
        Scanner sc = new Scanner(System.in);

        TipoMascota dirigido;
        dirigido= TipoMascota.TODOS;
        int i=0;
        while(i==0){
            System.out.print("Ingresar Tipo(PERRO/GATO/TODOS):\n");
            String tip= sc.nextLine();
            if(tip.toUpperCase().equals("GATO")){
                i++;
                dirigido= TipoMascota.GATO;
                
            }else if(tip.toUpperCase().equals("PERRO")){
                i++;
                dirigido=TipoMascota.PERRO;
            }else if(tip.toUpperCase().equals("TODOS")){
                i++;
                dirigido=TipoMascota.TODOS;
                
            }else{
                System.out.print("!ERROR!\n");
            }
        }
        System.out.print("Ingresar ID Concurso:\n");
        String iD= sc.nextLine();
        
        System.out.print("Ingresar Nombre:\n");
        String nombre= sc.nextLine();   
        
        System.out.print("Ingresar Fecha de Evento(YYYY-MM-DD):\n");
        String fechaEvento= sc.nextLine();
        System.out.print("Ingresar Inicio de Inscripcion(YYYY-MM-DD):\n");
        String fechaInicioI= sc.nextLine();
        System.out.print("Ingresar Final de Inscripcion(YYYY-MM-DD):\n");
        String fechaFinalI= sc.nextLine();
        System.out.print("Ingresar Hora del evento(HH:MM:SS):\n");
        String hora= sc.nextLine();

        System.out.print("Selecionar Ciudad:\n");
        AdministrarCiudad.mostrarCiudades(ciudades);
        System.out.print((ciudades.size()+1)+" )Ingresar nueva ciudad:\n");
        int op=sc.nextInt();
        Ciudad c= new Ciudad("","","");
        if(op==ciudades.size()+1){
            Ciudad c1 = AdministrarCiudad.CrearCiudad();
            ciudades.add(c1);
            c=c1;
        }else{
            Ciudad c1= ciudades.get(op-1);
            c=c1;
        }
        sc.nextLine();
        System.out.print("Ingresar Lugar:\n");
        String lugar= sc.nextLine();
        
        
        int i2=0;
        while(i2<2){            
            i2++;
            System.out.print("--Ingresar Premios Concurso--\n");
            System.out.print("Selecionar Auspiciante:\n");
            Auspiciante.mostrarAuspiciante(auspiciantes);
            int op1=sc.nextInt();
            Auspiciante a1= auspiciantes.get(op1-1);
            auspiciantesC.add(a1);
            Premio p=Premio.CrearPremio(a1);
            premios.add(p);
        
        }
               
        Concurso c1 = new Concurso(nombre,fechaEvento,iD,hora,fechaInicioI,fechaFinalI,c,
               lugar,premios,auspiciantesC,dirigido,mInscritas,mGanadoras);
        
        concursos.add(c1);
        System.out.print("¡Se ha creado un nuevo concurso con Exito!\n");


    }
    //inscribe un nuevo participante
    public static void inscribirParticipante(ArrayList<Concurso> concursos,ArrayList<Mascota> mascotas){
        System.out.print("\n-----Inscribir Participante-----\n");
        System.out.print("\n>>>Concursos Vigentes:\n");
        mostrarConcursosVigentes(concursos);
        System.out.print("Ingresar Codigo Concurso:\n");
        Scanner sc= new Scanner(System.in);
        String codigo= sc.nextLine();
        for (Concurso c: concursos){
            if(codigo.equals(c.getIdConcurso())){
                ArrayList<Mascota> mInscri= c.getMascotasInscritas();
                AdministrarMascota.mostrarMascota(mascotas);
                System.out.print("Ingresar Id Mascota:\n");
                String idMascota= sc.nextLine();
                for(Mascota m: mascotas){
                    if(idMascota.equals(m.getId())){
                        mInscri.add(m);                        
                    }
                }
                c.setMascotasInscritas(mInscri);
                
            }
            
        }
        System.out.print("Se ha inscrito un nuevo participante con exito\n");

    }
    //muestra la informacion del concurso
    public static void mostrarInformacionConcurso(ArrayList<Concurso>concursos){
        int i=0;
        for(Concurso c:concursos){
            i++;
            System.out.print(i);
            c.mostrarInformacion();
            System.out.print("\n");
            
        }
        
    }
    
        
}
