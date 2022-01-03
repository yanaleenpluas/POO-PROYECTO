
import java.util.ArrayList;
import java.util.Scanner;
import modelo.AdministrarConcurso;
import modelo.AdministrarDuenio;
import modelo.AdministrarMascota;
import modelo.Auspiciante;
import modelo.Ciudad;
import modelo.Concurso;
import modelo.Mascota;
import modelo.Duenio;
import modelo.Premio;
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
    //Se crean las listas estaticas de duenio, mascotas, ciudades, concursos,auspiciantes
    public static ArrayList<Duenio> duenios;
    public static ArrayList<Mascota> mascotas;
    public static ArrayList<Ciudad> ciudades;
    public static ArrayList<Concurso> concursos;
    public static ArrayList<Auspiciante> auspiciantes;
    public static int oprincipal=0;
    
    public static void main(String[] args) {
        //Se ejecutan los datos de cada lista
        datosCiudades();
        datosDuenios();
        datosMascotas();
        datosAuspiciantes();
        datosConcurso();
       simulacionPrograma();
    }
    
    //Se crea la clase simulacion de programa
    public static void simulacionPrograma(){
        while(oprincipal!=4){           
            //Se llama al metodo menu principal que imprime el menu y devuelve la opcion del menu
            int opcionMenu=menuPrincipal();
            
            //Si opcionMenu es igual a 1 se va al menu AdministrarConcursos
            while (opcionMenu==1){
                //Se inprime el menu AdministrarConcurso y se obtiene la opcion de dicho menu
                int opConcurso=AdministrarConcurso.menu(concursos);
                //Si opConcurso es igual a 1, se llama al metodo crearCOncurso de la clase administrarConcurso
                if(opConcurso==1){
                    AdministrarConcurso.crearConcurso(concursos, ciudades, auspiciantes);
                    System.out.print("1. Volver al menu principal \n2. Volver al Menu Administrar Concursos\n3.Salir\n");
                    int op = Main.volverMenu(opcionMenu);
                    opcionMenu=op;
                 
                //Si opConcurso es igual a 2, se llama al metodo InscribirConcurso de la clase administrarConcurso                    
                }else if(opConcurso==2){
                    AdministrarConcurso.inscribirParticipante(concursos, mascotas);
                    System.out.print("1. Volver al menu principal \n2. Volver al Menu Administrar Concursos\n3.Salir\n");
                    int op = Main.volverMenu(opcionMenu);
                    opcionMenu=op;

                //Si opConcurso es igual a 3, se llama al metodo mostratInformacionConcurso de la clase administrarConcurso
                }else if(opConcurso==3){
                    AdministrarConcurso.mostrarInformacionConcurso(concursos);
                    System.out.print("1. Volver al menu principal \n2. Volver al Menu Administrar Concursos\n3.Salir\n");
                    int op = Main.volverMenu(opcionMenu);
                    opcionMenu=op;
                //Si opConcurso es igual a 4, opcionMenu toma valor de 0 lo cual hace que se imprima de nuevo el menu principal
                }else if(opConcurso==4){
                    opcionMenu=0;
                }
                
            }
            
            //Si opcionMenu es igual a 2 se va al menu AdministrarDuenio
            while(opcionMenu==2){
                //Se llama al metodo menu de la clase administrarDuenio que imprime un menu
                //y retorna la opcion del menu
                int opDuenios=AdministrarDuenio.menu(duenios);
                //Si opDuenios==1 entonces se llama al metodo crearDuenio de la clase administrarDuenio
                if(opDuenios==1){
                    AdministrarDuenio.crearDuenio(duenios,ciudades);
                    System.out.print("1. Volver al menu principal \n2. Volver al Menu Administrar Dueños\n3.Salir\n");
                    int op = Main.volverMenu(opcionMenu);
                    opcionMenu=op;
                //Si opDuenios==2 entonces se llama al metodo editarDuenio de la clase administrarDuenio                
                }else if (opDuenios==2){
                    AdministrarDuenio.editarDuenio(duenios, ciudades);
                    System.out.print("1. Volver al menu principal \n2. Volver al Menu Administrar Dueños\n3.Salir\n");
                    int op = Main.volverMenu(opcionMenu);
                    opcionMenu=op;
                //Si opDuenios==3 se regresa al menu principal
                }else if(opDuenios==3){
                    opcionMenu=0;
                }

            }

            while(opcionMenu==3){
                int opMascotas= AdministrarMascota.menu(mascotas);
                if(opMascotas==1){
                    AdministrarMascota.crearMascota(mascotas, duenios);
                   // mascotas=lm;
                    System.out.print("1. Volver al menu principal \n2. Volver al Menu Administrar Mascotas\n3.Salir\n");
                    int op = Main.volverMenu(opcionMenu);
                    opcionMenu=op;

                }else if(opMascotas==2){
                    AdministrarMascota.eliminarMascota(mascotas);
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
    //Se crea la clase menuPrincipal que muestra el menu principal
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
    //Se crea la clase volverMenu que regresa al menuPrincipal
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
    
    //Se crea los dueños y se los agrega a la lista duenios
    public static void datosDuenios(){
        duenios= new ArrayList<>();
        //String id, String apellido, String nombre, String direccion,  String email, int telefono
        
        Duenio d1 = new Duenio("0953519745","Pluas","Britney","Mapasingue Este",ciudades.get(0), "pbritney@gmail.com","0961586881");
        Duenio d2 = new Duenio("0964136181","Macias","Sebastian","Guasmo Norte",ciudades.get(1), "sebastiaM@gmail.com","0751584625");
        Duenio d3 = new Duenio("3574161765","Kathia","Jimenez","15 y Argentina",ciudades.get(2) ,"ninivek21_@hotmail.com","9823455552");
        Duenio d4 = new Duenio("4554164766", "Edwin",  "Rodriguez", "35 y Portete",ciudades.get(2) ,  "edwin55@gmail.com","7899342123");
        Duenio d5 = new Duenio("0415681516","Suarez","Angela","Samanes3", ciudades.get(0) ,"asuearez@gmail.com","0923541877");
        Duenio d6 = new Duenio("7916581631","Vera","Leonardo","Metropolis", ciudades.get(1) ,"lvera@gmail.com","0974454116");
        Duenio d7 = new Duenio("0971465410","Quirimbay","Samantha","Samanes 2",ciudades.get(0) , "saman123@gmail.com","0935418484");
        Duenio d8 = new Duenio("0745251851","Ponce","Erick","Urdesa", ciudades.get(2) ,"eponces@gmail.com","0964516548");
        Duenio d9 = new Duenio("0546116169", "Alejandro", "Tepan", "21 y Portete",ciudades.get(1) , "alebernal@gmail.com","9487395465");
        Duenio d10 = new Duenio("2347215842", "Jorge", "Sanchez", "30 y Cuenca",ciudades.get(0) ,  "penaa_@hotmail.com","8598766095");
    
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

        
    }//Se crean los objetos ciudad y se los agrega a la lista ciudades
    public static void datosCiudades(){
        ciudades= new ArrayList<>();
        Ciudad c1 = new Ciudad("Quito","Pichincha","QUIT851");        
        Ciudad c2 = new Ciudad("Guayaquil","Guayas","GUAYA754");
        Ciudad c3 = new Ciudad("Cuenca","Azuay","CUENC45");
        ciudades.add(c1);        
        ciudades.add(c2);       
        ciudades.add(c3);
        c3.codigoCiudad(c3.getId());

        
    }
    
    //Se crea los objetos mascota y se los agrega a la clase mascota
    public static void datosMascotas(){
        //Se crean los datos iniciales para que el programa tenga un mejor funcionamiento
        //Se crean los 10 objetos de tipo Mascota 
        mascotas= new ArrayList<>();
        TipoMascota PERRO;
        PERRO=TipoMascota.PERRO;
        TipoMascota GATO;
        GATO=TipoMascota.GATO;
        Mascota m1 = new Mascota("Zeus","Pastor Aleman","2011-10-12","1.png","2001ZEUSPA",PERRO,duenios.get(0));
        Mascota m2 = new Mascota("Kira","Snaucher","2017-08-01","2.png","2017KIRASN",PERRO,duenios.get(5));        
        Mascota m3 = new Mascota("Jacko","San Bernardo","2015-02-05","3.png","2015JACKSB",PERRO,duenios.get(4));
        Mascota m4 = new Mascota("Chiqui","Golden","2016-06-08","4.png","2016CHIQGD",PERRO,duenios.get(7));
        Mascota m5 = new Mascota("Oso","Labrador","2020-12-09","5.png","2020OSOLABR",PERRO,duenios.get(3));
        Mascota m6 = new Mascota("Bolita","Persa ","2018-07-22","6.png","2018BOLIPS",GATO,duenios.get(2));
        Mascota m7 = new Mascota("Max","Siames","2019-01-18","7.png","2019MAXSIA",GATO,duenios.get(1));
        Mascota m8 = new Mascota("Lana","Burmes","2017-03-03","8.png","2017LANABM",GATO,duenios.get(4));
        Mascota m9 = new Mascota("Garfiel","Skookum","2019-12-01","9.png","2019GARFSK",GATO,duenios.get(9));
        Mascota m10 = new Mascota("Luke","Toyger","2016-04-05","10.png","2016LUKETG",GATO,duenios.get(8));
       
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
    //Se crea los objetos auspiciantes y se los añade a la lista Auspiciantes
    public static void datosAuspiciantes(){
        auspiciantes= new ArrayList<>();
        //String id, String nombre, String direccion, Ciudad ciudad, String email, String telefono,String webPage 
        Auspiciante a1 = new Auspiciante("C10985522","Dog Chow","El Mirador",ciudades.get(0),"doqChow@gmail.com","0995421127","dogChow.com");        
        Auspiciante a2 = new Auspiciante("C29856825","ProCan","El Jaboncillo",ciudades.get(1),"procan@gmail.com","0986116855","procan.com");
        Auspiciante a3 = new Auspiciante("C58154751","NutraPro","MarthadeRoldos",ciudades.get(2),"nutrapro@gmail.com","0985416154","nutraPro.com");
        
        auspiciantes.add(a1);
        auspiciantes.add(a2);
        auspiciantes.add(a3);
        
        a3.codigoAuspiciante(a3.getId());

    }
    //Se crea los objetos concursos y se los añade a la lista concurso
    public static void datosConcurso(){
        //Concurso pasado
        concursos= new ArrayList<>();
        ArrayList<Mascota> mInscritas= new ArrayList<Mascota>();
        ArrayList<Mascota> lGanadores= new ArrayList<Mascota>();
        mInscritas.add(mascotas.get(2));        
        mInscritas.add(mascotas.get(5));
        mInscritas.add(mascotas.get(8));
        mInscritas.add(mascotas.get(3));
        mInscritas.add(mascotas.get(1));
        
        lGanadores.add(mascotas.get(5));
        lGanadores.add(mascotas.get(3));
        lGanadores.add(mascotas.get(2));

        ArrayList<Premio> premios = new ArrayList<Premio>();
        Premio p1= new Premio("Primer Lugar",auspiciantes.get(0),"$300 Dolares y productos Dog Chow");
        Premio p2= new Premio("Segundo Lugar",auspiciantes.get(0),"$200 Dolares y productos Dog Chow");
        Premio p3= new Premio("Tercer Lugar",auspiciantes.get(0),"$100 Dolares y productos Dog Chow");
        premios.add(p1);
        premios.add(p2);
        premios.add(p3);
        
        ArrayList<Auspiciante> auspiciantesC1= new ArrayList<Auspiciante>();
        auspiciantesC1.add(auspiciantes.get(0));
        TipoMascota todos;
        todos=TipoMascota.TODOS;
        
        Concurso c1 =new Concurso("Animales Geniales","2021-11-15","AnGenia2021","12:00:00","2021-10-15","2021-11-15",ciudades.get(0),"El Panecillo mz A", premios,auspiciantesC1,todos,mInscritas,lGanadores);
        
        
        //Concurso vigente
        ArrayList<Mascota> mInscritas2= new ArrayList<Mascota>();
        ArrayList<Mascota> lGanadores2= new ArrayList<Mascota>();
        
        mInscritas2.add(mascotas.get(9 ));        
        mInscritas2.add(mascotas.get(6));
        mInscritas2.add(mascotas.get(7));
        mInscritas2.add(mascotas.get(4));
        mInscritas2.add(mascotas.get(0));
        

        ArrayList<Premio> premios2 = new ArrayList<Premio>();
        Premio p12= new Premio("Primer Lugar",auspiciantes.get(2),"$300 Dolares y productos NutraPro");
        Premio p22= new Premio("Segundo Lugar",auspiciantes.get(1),"$200 Dolares y productos ProCan");
        Premio p32= new Premio("Tercer Lugar",auspiciantes.get(2),"$100 Dolares y productos NutraPro");
        premios2.add(p12);
        premios2.add(p22);
        premios2.add(p32);
        
        ArrayList<Auspiciante> auspiciantesC2= new ArrayList<Auspiciante>();
        auspiciantesC2.add(auspiciantes.get(2));
        auspiciantesC2.add(auspiciantes.get(1));
        TipoMascota perro;
        perro=TipoMascota.PERRO;
        
       Concurso c2 =new Concurso("Mi Mascota y Yo","2021-12-20","MiMacYo2021","14:00:00","2021-11-20","2021-12-20",ciudades.get(2),"Cdla. Martha de Roldos", premios2,auspiciantesC2,perro,mInscritas2,lGanadores2);
       
       concursos.add(c1);
       concursos.add(c2);
    }
}