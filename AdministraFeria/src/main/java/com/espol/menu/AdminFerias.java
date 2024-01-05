/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.menu;

import java.util.ArrayList;
import com.espol.feria.*;
import java.util.Scanner;
/**
 *
 * @author joshf
 */
public class AdminFerias {
    //BUSCAR FERIA
    public static void menuFeria(){
        System.out.println("Administración de Ferias");
        System.out.println("1. Ver información de feria");
        System.out.println("2. Registrar feria");
        System.out.println("3. Editar feria");
        System.out.println("4. Consultar emprendedores en feria");
        System.out.println("5. Regresar");
    }
    
    public static Feria buscarFeria(String codFeria,ArrayList<Feria> ferias){
    Feria feriaBuscada = new Feria(codFeria);
      for(Feria f: ferias){
       if(f.getCodFeria().equals(codFeria)){
        feriaBuscada=f;
        } 
    }
    return feriaBuscada;
    }
    //POR INDICE
    public static void verFeria(int i, ArrayList<Feria> ferias){
        System.out.println(ferias.get(i).toString());
    }
    //POR CODIGO DE FERIA
    public static void verFeria(String cod, ArrayList<Feria> ferias){
      Feria feriaBuscada = buscarFeria(cod,ferias);
      int i = ferias.indexOf(feriaBuscada);
      verFeria(i,ferias);
    }
    
    public static void opcionVerFeria(Scanner sc, ArrayList<Feria> ferias){
        System.out.println("-> Ver información de feria");
        System.out.println("Selecciona el codigo de una feria: ");
        String codFeria = sc.nextLine();
        AdminFerias.verFeria(codFeria,ferias);
    }
    
    public static String generarCod(ArrayList<Feria> ferias){
        int n = ferias.size();
        return "FE00"+(n+1);
    } 
    
    public static void opcionRegistrarFeria(Scanner sc, ArrayList<Feria> ferias){
        System.out.println("-> Registrar nueva feria");
        System.out.print("Ingrese el nombre de la feria: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese la descripción de la feria: ");
        String descripcion = sc.nextLine();

        System.out.print("Ingrese la fecha de inicio de la feria: ");
        String fechaIni = sc.nextLine();

        System.out.print("Ingrese la fecha de fin de la feria: ");
        String fechaFin = sc.nextLine();

        System.out.print("Ingrese el lugar de la feria: ");
        String lugar = sc.nextLine();

        System.out.print("Ingrese el horario de la feria: ");
        String horario = sc.nextLine();

        String cod = generarCod(ferias);
        Feria feriaNueva = new Feria(cod, nombre, descripcion, lugar, fechaIni, fechaFin, horario);
        feriaNueva.fijarStandsFeria(sc);
        ferias.add(feriaNueva);
    }
    
    public static void opcionEditarFeria(Scanner sc, ArrayList<Feria> ferias){
        System.out.println("-> Editar feria");
        System.out.println("Selecciona una Feria: ");
        String codFeria = sc.nextLine();
        Feria f = buscarFeria(codFeria,ferias);
        f.editarFeria(sc);
    }
    
    public static void opcionConsultarEmprendedores(Scanner sc,ArrayList<Feria> ferias){
        System.out.println("-> Consultar emprendedores en feria");
        System.out.println("Selecciona una Feria: ");
        String codFeria = sc.nextLine();
        Feria feria = buscarFeria(codFeria,ferias);
        feria.consultarEmprendedores();
    }
    
    
    
}
