
import java.util.ArrayList;
import java.util.Scanner;
import modelo.AdministrarMascota;
import modelo.Mascota;
import modelo.TipoMascota;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USUARIO
 */
public class Main {
    public static ArrayList<Mascota> mascotas;
    public static int oprincipal=0;
    
    public static void main(String[] args) {
       datosMascotas();
       simulacionPrograma();
    }
    
    
    
    
    
    public static void simulacionPrograma(){
        while(oprincipal!=4){
            
           int opcionMenu=menuPrincipal();

           while(opcionMenu==3){
                int opMascotas= AdministrarMascota.menu(mascotas);
                if(opMascotas==1){
                    ArrayList lm=AdministrarMascota.crearMascota(mascotas);
                    mascotas=lm;
                    System.out.print("1. Volver al menu principal \n2. Volver al Menu Administrar Mascotas\n3.Salir\n");
                    int op = Main.volverMenu(opcionMenu);
                    opcionMenu=op;
                            
 
                }
                if(opMascotas==3){
                    opcionMenu=0;
                     
                }
           
            }
           while(opcionMenu==4){
               salir();
               opcionMenu=0;
               oprincipal=4;
           }
        }
           
    }
    public static int menuPrincipal(){
        System.out.print("----BIENVENIDOS A LA FUNDACION AMIGOS PELUDOS EC?----\n");
        System.out.print("-----Menu Principal----- \n ");
        System.out.print("1. Administrar Concursos.\n 2. Administrar Dueños.\n 3 .Administrar Mascotas.\n 4. Salir\n" );
        System.out.print("Ingrese una opcion:\n");
        Scanner sc = new Scanner(System.in);
        int opcion=sc.nextInt();
        return opcion;
    }
    
    public static void salir(){
        System.out.print("!Muchas gracias por su atencion!");
        
    }
    public static int volverMenu( int opcionMenu){
        Scanner sc=new Scanner(System.in);
        int opcion2 = sc.nextInt();
        if(opcion2==1){
            opcionMenu=0;
            oprincipal=0;
            
        }
        else if(opcion2==2){
            opcionMenu=opcionMenu;
        }
        else if(opcion2==3){
            salir();
            opcionMenu=0;
            oprincipal=4;
        }
        return opcionMenu;
    }

    


    
    public static void datosMascotas(){
        //Se crean los datos iniciales para que el programa tenga un mejor funcionamiento
        //Se crean los 10 objetos de tipo Mascota 
        mascotas= new ArrayList<>();
        TipoMascota PERRO;
        PERRO=TipoMascota.PERRO;
        TipoMascota GATO;
        GATO=TipoMascota.GATO;
        Mascota m1 = new Mascota("Zeus","Pastor Aleman","2011-10-12","1.png","2001ZEUSPA",PERRO);
        Mascota m2 = new Mascota("Kira","Snaucher","2017-08-01","2.png","2017KIRASN",PERRO);        
        Mascota m3 = new Mascota("Jacko","San Bernardo","2015-02-05","3.png","2015JACKSB",PERRO);
        Mascota m4 = new Mascota("Chiqui","Golden","2016-06-08","4.png","2016CHIQGD",PERRO);
        Mascota m5 = new Mascota("Oso","Labrador","2020-12-09","5.png","2020OSOLABR",PERRO);
        Mascota m6 = new Mascota("Bolita","Persa ","2018-07-22","6.png","2018BOLIPS",GATO);
        Mascota m7 = new Mascota("Max","Siames","2019-01-18","7.png","2019MAXSIA",GATO);
        Mascota m8 = new Mascota("Lana","Burmes","2017-03-03","8.png","2017LANABM",GATO);
        Mascota m9 = new Mascota("Garfiel","Skookum","2019-12-01","9.png","2019GARFSK",GATO);
        Mascota m10 = new Mascota("Luke","Toyger","2016-04-05","10.png","2016LUKETG",GATO);
       
        mascotas.add(m1);
        mascotas.add(m2);
        mascotas.add(m3);
        mascotas.add(m4);
        mascotas.add(m5);
        mascotas.add(m6);
        mascotas.add(m7);
        mascotas.add(m8);
        mascotas.add(m9);
        mascotas.add(m10);
        m10.codigoMascota("2016LUKETG");
        
    }
   
   /* public static void menuPrincipal(){
        System.out.print("----BIENVENIDOS A LA FUNDACION AMIGOS PELUDOS EC?----\n");
        System.out.print("-----Menu Principal----- \n ");
        System.out.print("1. Administrar Concursos.\n 2. Administrar Dueños.\n 3.Administrar Mascotas\n");
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese una opcion:\n");
        int opcion = sc.nextInt();
        if(opcion==3){
            ArrayList lm=AdministrarMascota.menu(mascotas);
            mascotas=lm;
            
            //Main.menuAdministrarMascota();           
        }
    }*/
    
    /*public static void menuAdministrarMascota(){
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
        sc.nextLine();
        if (opcion==1){
            Main.crearMascota();
        }
        else if(opcion==3){
            Main.menuPrincipal();
        }
        
        
    }
    public static void crearMascota(){
        System.out.print("\n-----Crear Mascota-----\n");
        Scanner sc= new Scanner(System.in);
        System.out.print("Ingresar Tipo(PERRO/GATO):\n");
        String tip= sc.nextLine();
        
        TipoMascota tipo;
        tipo= TipoMascota.TODOS;
        if(tip.toUpperCase().equals("GATO")){
            tipo= TipoMascota.GATO;
        }
        else if(tip.toUpperCase().equals("PERRO")){
            tipo=TipoMascota.PERRO;
        }
        else{
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
        System.out.print("1. Volver al menu principal \n2. Volver al Menu Administrar Mascotas\n3.Salir\n");
        int opcion2 = sc.nextInt();
        if(opcion2==1){
            menuPrincipal();
        }
        else if(opcion2==2){
            Main.menuAdministrarMascota();
        }
        else if(opcion2==3){
            salir();
        }

      
        
    }
    
    public static void salir(){
        System.out.print("!Muchas gracias por su atencion!");
    }*/
}
