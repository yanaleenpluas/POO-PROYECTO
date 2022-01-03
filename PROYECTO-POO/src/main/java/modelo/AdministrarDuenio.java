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
public class AdministrarDuenio {
    //muestra el menu de la clase administrar duenio
    public static int menu(ArrayList<Duenio> duenios){
        System.out.print("----Administrar Dueños----");

        System.out.print("\n>>>Dueños Existentes:\n");
        mostrarDuenio(duenios);
        System.out.print("\nCodigo de Dueño: " + Duenio.getCodigo() +"\n");
        System.out.print("\n 1. Crear Dueño.\n 2. Editar Dueño.\n 3. Regresar al menu principal\n");
        System.out.print("Ingrese una opcion:\n");
        Scanner sc= new Scanner(System.in);
        int opcion=sc.nextInt();
        return opcion;
    }
    //muestra la informacion de los duenios
    public static void mostrarDuenio(ArrayList<Duenio> duenios){
        int i=1;
        for(Duenio d:duenios){
            System.out.print(i+ d.toString()+"\n");
            i++;
        }
    }
    
    //crea un nuevo dueño
    public static void crearDuenio(ArrayList<Duenio> duenios, ArrayList<Ciudad>ciudades){  
        System.out.print("\n-----Crear Dueño-----\n");

        Scanner sc= new Scanner(System.in);
        //Se pide al usuario la informacion del duenio  
        System.out.print("Ingresar Cedula:\n");
        String id= sc.nextLine();

        System.out.print("Ingresar Nombres:\n");
        String nombre1= sc.nextLine();

        System.out.print("Ingresar Apellidos:\n");
        String ape1= sc.nextLine();

        System.out.print("Ingresar Direccion:\n");
        String direc= sc.nextLine();

        System.out.print("Ingresar telefono:\n");
        String telefono= sc.nextLine();

        System.out.print("Ingresar email:\n");
        String email= sc.nextLine();
        
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
        //Creamos el nuevo duenio con la informacion         
        Duenio d= new Duenio(id, nombre1,  ape1, direc,c, email, telefono );
        duenios.add(d);
        d.codigoDuenio(id);//Agregamos el duenio a la lista
        System.out.print("¡Se ha ingresado un nuevo Dueño con Exito!\n");
    }
    //Metodo para editar un duenio ya existente
    public static void editarDuenio(ArrayList<Duenio> duenios, ArrayList<Ciudad> ciudades){
        Scanner sc=new Scanner(System.in);        
        System.out.print("\n-----Editar Dueño-----\n");
        System.out.print("Ingresar ID (cedula):\n");
        //Pedimos al usuario que ingrese el ID del duenio
        String id=sc.nextLine(); 
        int i=0;
        Duenio d= new Duenio("","","","",ciudades.get(i),"","");
        //Verificamos que el duenio exista
        for (int i2=0;i2<duenios.size();i2++) {
        //for(Duenio du:duenios){
            Duenio du= duenios.get(i2);
            if(id.toUpperCase().equals(du.getId())){
                i2=duenios.size();
                i=1;
                int q=0;
                while(q==0){
                    //Preguntamos que atributo desea cambiar
                    System.out.print("Ingrese los datos a cambiar:\n");
                    System.out.print("1. Cambiar Nombres\n");
                    System.out.print("2. Cambiar Apellidos\n");
                    System.out.print("3. Cambiar Direccion\n");
                    System.out.print("4. Cambiar Telefono\n");
                    System.out.print("5. Cambiar Ciudad\n");
                    System.out.print("6. Cambiar E-mail\n");
                    System.out.print("F. Finalizar\n");

                    String opcion=sc.nextLine();

                    //Dependiendo de la opcion se cambia el atributo
                    if(opcion.equals("1")){
                        System.out.print("Ingrese el nuevo Nombre:\n");
                        String dato=sc.nextLine();
                        du.setNombre(dato);

                    }else if(opcion.equals("2")){
                      System.out.print("Ingrese el nuevo Apellido:\n");
                      String dato=sc.nextLine();
                      du.setApellido(dato);

                    }else if(opcion.equals("3")){
                      System.out.print("Ingrese la nueva Direccion:\n");
                      String dato=sc.nextLine();
                      du.setDireccion(dato);

                    }else if(opcion.equals("4")){
                      System.out.print("Ingrese el nuevo Telefono:\n");
                      String dato=sc.nextLine();
                      du.setTelefono(dato);

                    }else if(opcion.equals("5")){
                        System.out.print("Ingrese la nueva Ciudad:\n");
                        
                        AdministrarCiudad.mostrarCiudades(ciudades);
                        
                        System.out.print((ciudades.size()+1)+")Ingresar nueva ciudad:\n");
                        int op= sc.nextInt();
                        Ciudad c = new Ciudad("","","");
                        if(op==ciudades.size()+1){
                            Ciudad c1 = AdministrarCiudad.CrearCiudad();
                            ciudades.add(c1);
                            c=c1;
                        }else{
                            Ciudad c1= ciudades.get(op-1);
                            c=c1;
                        du.setCiudad(c);

                    }}else if(opcion.equals("6")){
                      System.out.print("Ingrese el nuevo E-mail:\n");
                      String dato=sc.nextLine();
                      du.setEmail(dato);

                    }else if(opcion.toUpperCase().equals("F")){
                        System.out.print("\nCambios Realidos con exito.\n");
                        q=1;
                        
                    }
                    if(q!=1){
                        d=du;
                        System.out.print("Desea cambiar otro dato(SI/NO):\n");
                        String dato=sc.nextLine();

                        if(dato.toUpperCase().equals("NO")){
                            System.out.print("Cambios Realidos con exito.\n");
                            q=1;   
                        }
                    }
                }
            }
        }if(i==0){//Si no existe el duenio en la lista imprimimos error
            System.out.print("!ERROR!\n");
            System.out.print("No existe ningun dueño con ese ID\n");
            
        }
    }
    
}
