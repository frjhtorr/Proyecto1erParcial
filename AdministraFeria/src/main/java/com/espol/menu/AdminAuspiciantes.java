/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.menu;

import com.espol.feria.Feria;
import com.espol.personas.*;
import com.espol.personas.Persona;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author Josh
 */
public class AdminAuspiciantes {
    public static void menuAuspiciantes(){
        System.out.println("Administración de auspiciante");
        System.out.println("1. Registrar auspiciate");
        System.out.println("2. Editar ausipiciante");
        System.out.println("3. Asignar auspiciante a feria");
        System.out.println("4. Regresar");
    }
    public static void opcionRegistrarAuspiciante(Scanner sc, ArrayList<Auspiciante> auspiciantesGenerales){
        System.out.println("-> Registrar Auspiciante");
        System.out.println("Ingreso los datos del Auspiciante");
        String c;
        boolean cedulaValida;
        Auspiciante aus =  new Auspiciante();
        do{
            System.out.println("Ingrese el número de cédula o RUC: ");
            c=sc.nextLine();
            cedulaValida=Persona.validarCedula(c,auspiciantesGenerales);
            if(!cedulaValida){
                System.out.println("Ya existe un emprendedor con ese número de cédula o RUC.");
                System.out.println("Intente de nuevo.");
            }else{
                System.out.println("Cedula válida");
            }
        }while(!cedulaValida);
        Persona p = Persona.crearPersona(sc);
        System.out.println("Ingrese los Sectores Cubiertos:");
        String sectoresC = sc.nextLine();
        System.out.println("Ingrese el numero de redes que tiene: ");
        int valor = sc.nextInt();
        p.setLstRedes(valor,sc);
        if (p instanceof Auspiciante nuevoAuspiciante ) {
            nuevoAuspiciante.setSectorCubierto(sectoresC);
            aus = nuevoAuspiciante;
        }
        auspiciantesGenerales.add(aus);
    }
    
    public static void opcionEditarAuspiciante(Scanner sc,ArrayList<Auspiciante> auspiciantesGenerales){
        System.out.println("-> Editar auspiciante");
        System.out.println("Ingrese Cedula o RUC del Auspiciante");
        String ced = sc.nextLine();
        System.out.println("-> "+ ced);
        
        sc.nextLine();
        for(Auspiciante a: auspiciantesGenerales){
            System.out.println("Buscando Auspiciante...");
            if(a.getCedula().equals(ced)){
                a.editarAuspiciante(sc);
                System.out.println("Cambios guardados con éxito");
            }else{
                System.out.println("Este no es, siguiente iteración");
            }
        }

    }
    public static void opcionAsignarAuspiciante(Scanner sc, ArrayList<Auspiciante> auspiciantesGenerales, ArrayList<Feria> ferias){
        System.out.println("-> Asignar a Auspiciante a Feria");
        System.out.println("Selecciona una Feria: ");
        String codFeria = sc.nextLine();
        System.out.println("Inserte la Cedula o RUC del Auspiciante ");
        String ced = sc.nextLine();
        Feria f= AdminFerias.buscarFeria(codFeria, ferias);
        for(Auspiciante a: auspiciantesGenerales){
            if(a.getCedula().equals(ced)){
                if(f.getLstAuspiciantes().contains(a)){
                    System.out.println("El auspiciante esta registrado en la Feria"+f.getNombre());
                }else{
                    if(a instanceof AuspicianteEnFeria){
                        AuspicianteEnFeria aef = (AuspicianteEnFeria) a;
                        String auspicio = sc.nextLine();
                        aef.setAuspicio(auspicio);
                    
                        f.getLstAuspiciantes().add(aef);
                    }
                }
            }
        }
    }
    
    
}
