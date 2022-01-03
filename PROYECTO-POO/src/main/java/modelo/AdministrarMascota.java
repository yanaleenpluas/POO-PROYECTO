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
        int opcion=sc.nextInt();//Pedimos una opcion al usuario
        return opcion;
    }
    //Metodo mostrar mascotas
    public static void mostrarMascota(ArrayList<Mascota> mascotas){
                int i=1;
        for(Mascota m:mascotas){
            System.out.print(i+ m.toString()+"\n");
            i++;
        }
    }
    
    
    //Metodo para crear una nueva mascota
    public static void crearMascota(ArrayList<Mascota> mascotas, ArrayList<Duenio> duenios){
        System.out.print("\n-----Crear Mascota-----\n");
        //Pedimos informacion de la mascota
        Scanner sc= new Scanner(System.in);        
        TipoMascota tipo;
        tipo= TipoMascota.TODOS;
        int i=0;
        while(i==0){
          //Verificamos el tipo de mascota
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
        //Pedimos info de la mascota al usuario
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
        Duenio.mostrarAuspiciante(duenios);//Mostramos los duenios
        int op1=sc.nextInt();
        Duenio d1= duenios.get(op1-1);//Creamos la mascota con la informacion recolectada
        Mascota m= new Mascota(nombre,raza,fecha,foto, iD, tipo,d1 );
        m.codigoMascota(iD);//Generamos el codigo de la mascota
        mascotas.add(m); //Agregamos la mascota a la lista
        System.out.print("¡Se ha ingresado una nueva mascota con Exito!\n");
        }
    
    //Metodo para eliminar una mascota
    public static void eliminarMascota(ArrayList<Mascota> mascotas){
        Scanner sc=new Scanner(System.in);
        System.out.print("\n-----Eliminar Mascota-----\n");
        int i=0;
        while(i==0){
          //Pedimos el id de la mascota
            System.out.print("Ingrese ID Mascota: \n");      
            String idmascota=sc.nextLine();
            //Eliminamos la mascota si esta en la lista
            boolean b= mascotas.removeIf(m1-> m1.getId().equals(idmascota.toUpperCase()));
            if(b){
                i=1;
                System.out.print("¡SE HA ELIMINADO LA MASCOTA!\n");    
            }else{ //Si no esta la mascota imprimimos ID incorrecto
                System.out.print("¡ID INCORRRECTO - MASCOTA NO ENCONTRADA!\n");    

            }
        }
    }
}