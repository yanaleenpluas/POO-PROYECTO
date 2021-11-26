
import java.util.ArrayList;
import java.util.Scanner;
import modelo.AdministrarDuenio;
import modelo.AdministrarMascota;
import modelo.Cuidad;
import modelo.Mascota;
import modelo.Duenio;
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
    public static ArrayList<Duenio> duenios;
    public static ArrayList<Mascota> mascotas;
    public static int oprincipal=0;
    
    public static void main(String[] args) {
       datosMascotas();
       datosDuenios();
       simulacionPrograma();
    }
    
    
    public static void simulacionPrograma(){
        while(oprincipal!=4){
            int opcionMenu=menuPrincipal();
            
            while(opcionMenu==2){
                int opDuenios=AdministrarDuenio.menu(duenios);
                if(opDuenios==1){
                    ArrayList ld= AdministrarDuenio.crearDuenio(duenios);
                    duenios=ld;
                    System.out.print("1. Volver al menu principal \n2. Volver al Menu Administrar Dueños\n3.Salir\n");
                    int op = Main.volverMenu(opcionMenu);
                    opcionMenu=op;
                }else if (opDuenios==2){
                    ArrayList ld = AdministrarDuenio.editarDuenio(duenios);
                    duenios=ld;
                    System.out.print("1. Volver al menu principal \n2. Volver al Menu Administrar Dueños\n3.Salir\n");
                    int op = Main.volverMenu(opcionMenu);
                    opcionMenu=op;
                    
                }else if(opDuenios==3){
                    opcionMenu=0;
                }

            }

            while(opcionMenu==3){
                int opMascotas= AdministrarMascota.menu(mascotas);
                if(opMascotas==1){
                    ArrayList lm=AdministrarMascota.crearMascota(mascotas);
                    mascotas=lm;
                    System.out.print("1. Volver al menu principal \n2. Volver al Menu Administrar Mascotas\n3.Salir\n");
                    int op = Main.volverMenu(opcionMenu);
                    opcionMenu=op;

                }else if(opMascotas==2){
                    ArrayList lm=AdministrarMascota.eliminarMascota(mascotas);
                    mascotas=lm;
                    System.out.print("1. Volver al menu principal \n2. Volver al Menu Administrar Mascotas\n3.Salir\n");
                    int op=Main.volverMenu(opcionMenu);
                    opcionMenu=op;                   
                }else if(opMascotas==3){
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
            
        }else if(opcion2==2){
            opcionMenu=opcionMenu;
        }else if(opcion2==3){
            salir();
            opcionMenu=0;
            oprincipal=4;
        }
        return opcionMenu;
    }
    
    public static void datosDuenios(){
        duenios= new ArrayList<>();
        //String id, String apellido, String nombre, String direccion,  String email, int telefono
        
        Duenio d1 = new Duenio("0953519745","Pluas","Britney","Mapasingue Este", "pbritney@gmail.com","0961586881");
        Duenio d2 = new Duenio("0964136181","Macias","Sebastian","Guasmo Norte", "sebastiaM@gmail.com","0751584625");
        Duenio d3 = new Duenio("3574161765","Kathia","Jimenez","15 y Argentina", "ninivek21_@hotmail.com","9823455552");
        Duenio d4 = new Duenio("4554164766", "Edwin",  "Rodriguez", "35 y Portete",  "edwin55@gmail.com","7899342123");
        Duenio d5 = new Duenio("0415681516","Suarez","Angela","Samanes3", "asuearez@gmail.com","0923541877");
        Duenio d6 = new Duenio("7916581631","Vera","Leonardo","Metropolis", "lvera@gmail.com","0974454116");
        Duenio d7 = new Duenio("0971465410","Quirimbay","Samantha","Samanes 2", "saman123@gmail.com","0935418484");
        Duenio d8 = new Duenio("0745251851","Ponce","Erick","Urdesa", "eponces@gmail.com","0964516548");
        Duenio d9 = new Duenio("0546116169", "Alejandro", "Tepan", "21 y Portete", "alebernal@gmail.com","9487395465");
        Duenio d10 = new Duenio("2347215842", "Jorge", "Sanchez", "30 y Cuenca",  "penaa_@hotmail.com","8598766095");
    
        duenios.add(d1);
        duenios.add(d2);
        duenios.add(d3);
        duenios.add(d4);
        duenios.add(d5);
        duenios.add(d6);
        duenios.add(d7);
        duenios.add(d8);
        duenios.add(d9);
        duenios.add(d10);
        d10.codigoDuenio(d10.getId());

        
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
        m10.codigoMascota(m10.getId());
        
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
