package com.espol.aplication;

import com.espol.menu.*;
import com.espol.feria.*;
import com.espol.personas.*;
import com.espol.redes.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
/**
 *
 * @author joshf
 */


public class AdministraFeria {
    //VARIABLES ESTATICAS
    static ArrayList<Feria> ferias = new ArrayList<>();
    static ArrayList<Auspiciante> auspiciantesGenerales = new ArrayList<>();
    //METODOS ESTÁTICOS
    public static void mostrarFerias(){
        for(Feria f: ferias){
            System.out.println("---------------------");
            System.out.println(f.toString());
        }
    }
    public static void menuPrincipal(){
        System.out.println("Menú Principal");
        System.out.println("1. Administración de Ferias");
        System.out.println("2. Administración de emprendedores");
        System.out.println("3. Administración de auspiciantes");
        System.out.println("4. Adiministración de Stands");
        System.out.println("5. Salir");
    }    
    
    public static int pedirSolicitud(Scanner sc){
        System.out.println("Ingrese selección: ");
        int opcion = sc.nextInt();
        sc.nextLine();
        return opcion;
    }
    
    public static Feria crearFeria(){
        Feria feria = new Feria();
        feria.setCodFeria("FE001");
        feria.setNombre("Feria del Mueble 2024");
        feria.setDescripcion("Venta de muebles de emprendimientos de guayaquileños");
        feria.setLugar("Centro de convenciones");
        feria.setFechaIni("2024-06-15");
        feria.setFechaFin("2024-06-17");
        feria.setHorario("10h00-14h00");
        feria.setLugar("Centro de convenciones");
        ArrayList<AuspicianteEnFeria> lstAuspiciantes= new ArrayList<>();
        ArrayList<Emprendedor> lstEmprendedores= new ArrayList<>();
        feria.setLstAuspiciantes(lstAuspiciantes);
        feria.setLstEmprendedores(lstEmprendedores);
        
        Seccion[] seccionesFeria = new Seccion[4];
        String[] letras = {"A","B","C","D"};
        int j = 0;
        for(String letra : letras){
            Seccion seccion = new Seccion();
            ArrayList<Stand> stands = new ArrayList<Stand>();
            int cant = 4;
            seccion.setCantStands(cant);
            seccion.setId(letra);
            for (int i = 1; i <= (cant+1); i++) {
                Stand st = new Stand();
                st.setCod(letra+i);
                stands.add(st);
            }
            seccion.setArrayStands(stands);
            seccionesFeria[j]=seccion;
            j+=1;
        }
        feria.setSecciones(seccionesFeria);
        
        return feria;
    }
    public static void crearEmprendedores(Feria f){
        //Emprendedor 1
        Emprendedor emp1 = new Emprendedor();
        emp1.setCedula("0908070605");
        emp1.setNombre("Arturo Carrera");
        emp1.setOwner("Emprendimiento 1");
        emp1.setEmail("arcagarz@gmail.com");
        emp1.setWeb("www.emprendimiento1.com.ec");
        emp1.setTelefono("0952864928");
        emp1.setDireccion("Casa de Arturo");
        emp1.setServicios("Opiniones especializadas de la industria automotriz");
        ArrayList<CuentaRedSocial> lstRedes1 = new ArrayList<>();
        CuentaRedSocial crs1 = new CuentaRedSocial(RedSocial.INSTAGRAM,"@arcagarz");
        lstRedes1.add(crs1);
        emp1.setLstRedes(lstRedes1);
        //Emprendedor 2
        Emprendedor emp2 = new Emprendedor();
        emp2.setCedula("0203040506");
        emp2.setNombre("Christopher Lema");
        emp2.setOwner("Emprendimiento 2");
        emp2.setEmail("chle@gmail.com");
        emp2.setWeb("www.emprendimiento2.com.ec");
        emp2.setTelefono("0960858518");
        emp2.setDireccion("Casa de Christopher");
        emp2.setServicios("Opiniones especializadas de la industria robótica");
        ArrayList<CuentaRedSocial> lstRedes2 = new ArrayList<>();
        CuentaRedSocial crs2 = new CuentaRedSocial(RedSocial.FACEBOOK,"Christopher Lema");
        lstRedes2.add(crs2);
        emp2.setLstRedes(lstRedes2);
        //Emprendedor 3
        Emprendedor emp3 = new Emprendedor();
        emp3.setCedula("1902589436");
        emp3.setNombre("Freddy Torres");
        emp3.setOwner("Emprendimiento 3");
        emp3.setEmail("frjhtorr@gmail.com");
        emp3.setWeb("www.emprendimiento3.com.ec");
        emp3.setTelefono("0979522649");
        emp3.setDireccion("Casa de Freddy");
        emp3.setServicios("Opiniones especializadas de la industria ");
        ArrayList<CuentaRedSocial> lstRedes3 = new ArrayList<>();
        CuentaRedSocial crs3 = new CuentaRedSocial(RedSocial.FACEBOOK,"Christopher Lema");
        lstRedes3.add(crs3);
        emp2.setLstRedes(lstRedes3);
        
        //Agregar a la lista de emprendedores
        ArrayList<Emprendedor> lstEmprendedores = new ArrayList<>();
        lstEmprendedores.add(emp1);
        lstEmprendedores.add(emp2);
        lstEmprendedores.add(emp3);
        
        f.setLstEmprendedores(lstEmprendedores);
    }
    
    public static void crearAuspiciantes(){
        //Auspiciante 1
        Auspiciante aus1 = new Auspiciante();
        aus1.setCedula("9517538642");
        aus1.setNombre("Nombre Auspiciante");
        aus1.setOwner("Auspicio 1");
        aus1.setEmail("correo@gmail.com");
        aus1.setWeb("www.ausp1.com.ec");
        aus1.setTelefono("0952864928");
        aus1.setDireccion("Local 1");
        aus1.setSectorCubierto("ALIMENTACION");
        ArrayList<CuentaRedSocial> lstRedes1 = new ArrayList<>();
        CuentaRedSocial crs1 = new CuentaRedSocial(RedSocial.FACEBOOK,"Christopher Lema");
        lstRedes1.add(crs1);
        aus1.setLstRedes(lstRedes1);
       auspiciantesGenerales.add(aus1);
    }
        
    public static void main(String[] args) {
      System.out.println("GESTION DE FERIAS");
        try (Scanner sc = new Scanner(System.in)) {
            int opcion;
            Feria feria = crearFeria();
            ferias.add(feria);
            crearEmprendedores(feria);
            crearAuspiciantes();
            String codFeria;
            
            do{ 
                menuPrincipal();
                opcion = pedirSolicitud(sc);
                switch(opcion){
                    case 1 -> {
                        //Administración de Ferias
                        mostrarFerias();
                        AdminFerias.menuFeria();
                        int opcionF = pedirSolicitud(sc);
                        while(opcionF != 5){
                            switch(opcionF){
                                case 1 -> AdminFerias.opcionVerFeria(sc,ferias);
                                case 2 -> AdminFerias.opcionRegistrarFeria(sc,ferias);
                                case 3 -> AdminFerias.opcionEditarFeria(sc, ferias);
                                case 4 -> AdminFerias.opcionConsultarEmprendedores(sc, ferias);
}
                            opcionF=5;
                        } }
                    case 2 -> {
                        //Administracion de emprendedores
                        AdminEmprendedores.menuEmprendedores();
                        int opcionE = pedirSolicitud(sc);
                        while(opcionE!=3){
                            switch(opcionE){
                                case 1 -> //registrar emprendedor
                                    AdminEmprendedores.opcionRegistrarEmprendedor(sc,ferias);
                                case 2 -> //editar emprendedor
                                    AdminEmprendedores.opcionEditarEmprendedores(sc,ferias);
                            }
                            opcionE =3;
                        } }
                    case 3 -> {
                        //Administración de auspiciantes
                        AdminAuspiciantes.menuAuspiciantes();
                        int opcionA = sc.nextInt();
                        while(opcionA!=4){
                            sc.nextLine();
                            switch(opcionA){
                                case 1 -> {
                                    //registrar aupsiciante
                                    AdminAuspiciantes.opcionRegistrarAuspiciante(sc,auspiciantesGenerales);
                                }
                                case 2 -> {
                                    //editar auspiciante
                                    AdminAuspiciantes.opcionEditarAuspiciante(sc,auspiciantesGenerales);
                                }
                                case 3 -> {
                                    //asignar auspiciante
                                    AdminAuspiciantes.opcionAsignarAuspiciante(sc, auspiciantesGenerales, ferias);
                                }
                            }
                            opcionA = 4;
                        } }
                    case 4 -> {
                        //Administración de Stands
                        System.out.println("Selecciona una Feria: ");
                        codFeria = sc.nextLine();
                        Feria f = new Feria();
                        f = AdminFerias.buscarFeria(codFeria, ferias);
                        String nombre = f.getNombre();
                        System.out.println("-> " +nombre);
                        f.mostrarDistribucion();
                        AdminStands.menuStands();
                        int opcionS = sc.nextInt();
                        while(opcionS!=3){
                            switch(opcionS){
                                case 1 -> {
                                    //Reservar stand
                                    AdminStands.opcionReservarStand(f,sc,ferias);
                                }
                                
                                case 2 -> {
                                    //Mostrar informacion del stand
                                    AdminStands.opcionMostrarInfoStand(f, sc);
                                    
                                }
                            }
                            opcionS = 3;
                        } }
                    case 5 ->{
                        
                    }
                    default -> {
                        System.out.println("Ingrese una opción válida");
                    }
                }
                System.out.println("");
                
            } while(opcion != 5);
        sc.close();
        }
    
    }
}
