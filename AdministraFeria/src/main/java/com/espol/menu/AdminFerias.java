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
    public static Feria buscarFeria(String codFeria,ArrayList<Feria> ferias){
    Feria feriaBuscada = new Feria(cod, nombre, descripcion, lugar, fechaIni, fechaFin, horario);
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
    public static String generarCod(ArrayList<Feria> ferias){
        int n = ferias.size();
        return "FE00"+(n+1);
    } 
    public static void registrarFeria(String nombre, String descripcion, String lugar, String fechaIni, String fechaFin, String horario, ArrayList<Feria> ferias){
        String cod = generarCod(ferias);
        Feria feriaNueva = new Feria(cod, nombre, descripcion, lugar, fechaIni, fechaFin, horario);
        feriaNueva.fijarStands();
        ferias.add(feriaNueva);
    }
    
    public static void editarFeria(){
    
    }
    
    public static void consultarEmprendedores(){
    
    }
    
    
    
}
