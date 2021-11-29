/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import com.sun.tools.javac.Main;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class AdministrarMascota {
    //menu de la clase administrar mascota
    public static int menu(ArrayList<Mascota> mascotas){
        System.out.print("----Administrar Mascotas ----");

        System.out.print("\n>>>Mascotas Existentes:\n");
        mostrarMascota(mascotas);
        System.out.print("\nCodigo de Mascota: " + Mascota.getCodigo()+"\n");
        System.out.print("\n 1. Crear mascota.\n 2. Eliminar mascota.\n 3. Regresar al menu principal\n");
        System.out.print("Ingrese una opcion:\n");
        Scanner sc= new Scanner(System.in);
        int opcion=sc.nextInt();
        return opcion;
    }
    //muestra las mascotas
    public static void mostrarMascota(ArrayList<Mascota> mascotas){
                int i=1;
        for(Mascota m:mascotas){
            System.out.print(i+ m.toString()+"\n");
            i++;
        }
    }
    
    
    //crea una nueva mascota
    public static void crearMascota(ArrayList<Mascota> mascotas, ArrayList<Duenio> duenios){
        System.out.print("\n-----Crear Mascota-----\n");
        Scanner sc= new Scanner(System.in);        
        TipoMascota tipo;
        tipo= TipoMascota.TODOS;
        int i=0;
        while(i==0){
            System.out.print("Ingresar Tipo(PERRO/GATO):\n");
            String tip= sc.nextLine();
            if(tip.toUpperCase().equals("GATO")){
                i++;
                tipo= TipoMascota.GATO;
                
            }else if(tip.toUpperCase().equals("PERRO")){
                i++;
                tipo=TipoMascota.PERRO;
                
            }else{
                System.out.print("!ERROR!\n");
            }
        }

        System.out.print("Ingresar ID:\n");
        String iD= sc.nextLine();

        System.out.print("Ingresar Nombre:\n");
        String nombre= sc.nextLine();

        System.out.print("Ingresar Raza:\n");
        String raza= sc.nextLine();

        System.out.print("Ingresar Fecha de Nacimiento(YYYY-MM-DD):\n");
        String fecha= sc.nextLine();

        System.out.print("Ingresar Foto(String):\n");
        String foto= sc.nextLine();
         System.out.print("Seleccionar Dueño):\n");
        Duenio.mostrarAuspiciante(duenios);
        int op1=sc.nextInt();
        Duenio d1= duenios.get(op1-1);
        Mascota m= new Mascota(nombre,raza,fecha,foto, iD, tipo,d1 );
        m.codigoMascota(iD);
        mascotas.add(m);
        System.out.print("¡Se ha ingresado una nueva mascota con Exito!\n");
        
        
        }
    //elimina una mascota
    public static void eliminarMascota(ArrayList<Mascota> mascotas){
        Scanner sc=new Scanner(System.in);
        System.out.print("\n-----Eliminar Mascota-----\n");
        int i=0;
        while(i==0){
            System.out.print("Ingrese ID Mascota: \n");      
            String idmascota=sc.nextLine();
            boolean b= mascotas.removeIf(m1-> m1.getId().equals(idmascota.toUpperCase()));
            if(b){
                i=1;
                System.out.print("¡SE HA ELIMINADO LA MASCOTA!\n");    
            }else{
                System.out.print("¡ID INCORRRECTO - MASCOTA NO ENCONTRADA!\n");    

            }
            
        
        }
    }
}