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
    
    public static int menu(ArrayList<Mascota> mascotas){
        System.out.print("----Administrar Mascotas ----");

        System.out.print("\n>>>Mascotas Existentes:\n");
        int i=1;
        for(Mascota m:mascotas){
            System.out.print(i+ m.toString()+"\n");
            i++;
        }
        System.out.print("\nCodigo de Mascota: " + Mascota.getCodigo()+"\n");
        System.out.print("\n 1. Crear mascota.\n 2. Eliminar mascota.\n 3. Regresar al menu principal\n");
        System.out.print("Ingrese una opcion:\n");
        Scanner sc= new Scanner(System.in);
        int opcion=sc.nextInt();
        return opcion;
    }
    
    
    
    
    public static ArrayList crearMascota(ArrayList<Mascota> mascotas){
        System.out.print("\n-----Crear Mascota-----\n");
        Scanner sc= new Scanner(System.in);
        System.out.print("Ingresar Tipo(PERRO/GATO):\n");
        String tip= sc.nextLine();
        
        TipoMascota tipo;
        tipo= TipoMascota.TODOS;
        if(tip.toUpperCase().equals("GATO")){
            tipo= TipoMascota.GATO;
        }else if(tip.toUpperCase().equals("PERRO")){
            tipo=TipoMascota.PERRO;
        }else{
            System.out.print("!ERROR!\nIngresar Tipo(PERRO/GATO):\n");
            String tip2= sc.nextLine();
            tip2=tip;    
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
        Mascota m= new Mascota(nombre,raza,fecha,foto, iD, tipo );
        m.codigoMascota(iD);
        mascotas.add(m);
        System.out.print("¡Se ha ingresado una nueva mascota con Exito!\n");
        
        return mascotas;
        }
    
    public static ArrayList eliminarMascota(ArrayList<Mascota> mascotas){
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
            
        
        }return mascotas;
    }
}