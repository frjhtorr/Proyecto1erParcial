/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.menu;

import com.espol.feria.Feria;
import com.espol.personas.Emprendedor;
import com.espol.personas.Persona;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Josh
 */
public class AdminEmprendedores {
    public static void menuEmprendedores(){
        System.out.println("Administración de emprendedores");
        System.out.println("1. Registrar emprendedor");
        System.out.println("2. Editar emprendedor");
        System.out.println("3. Regresar");
    }
    
    public static Emprendedor crearEmprendedor(Scanner sc, ArrayList<Emprendedor> listaEmprendedores){
        System.out.println("Ingreso los datos del emprendimiento");
        String c;
        boolean cedulaValida;
        Emprendedor emp =  new Emprendedor();
        do{
            System.out.println("Ingrese el número de cédula o RUC: ");
            c=sc.nextLine();
            cedulaValida=Persona.validarCedula(c,listaEmprendedores);
            if(!cedulaValida){
                System.out.println("Ya existe un emprendedor con ese número de cédula o RUC.");
                System.out.println("Intente de nuevo.");
            }else{
                System.out.println("Cedula válida");
            }
        }while(!cedulaValida);
        Persona p = Persona.crearPersona(sc);
        System.out.println("Ingrese la descripción de los servicios que ofrece:");
        String descripcion = sc.nextLine();
        System.out.println("Ingrese el numero de redes que tiene: ");
        int valor = sc.nextInt();
        p.setLstRedes(valor,sc);
        if (p instanceof Emprendedor ) {
            Emprendedor nuevoEmprendedor = (Emprendedor) p;
            nuevoEmprendedor.setServicios(descripcion);
            emp = nuevoEmprendedor;
        }
        return emp;
    }
    
    public static void opcionRegistrarEmprendedor(Scanner sc, ArrayList<Feria> ferias){
        System.out.println("-> Registrar emprendedor");
        System.out.println("Selecciona una Feria: ");
        String codFeria = sc.nextLine();
        Feria f= AdminFerias.buscarFeria(codFeria, ferias);
        Emprendedor emp = crearEmprendedor(sc,f.getLstEmprendedores());
        f.getLstEmprendedores().add(emp);
    }
    
    public static void opcionEditarEmprendedores(Scanner sc, ArrayList<Feria> ferias){
        System.out.println("-> Editar emprendedor");
        System.out.println("Selecciona una Feria: ");
        String codFeria = sc.nextLine();
        Feria f = AdminFerias.buscarFeria(codFeria,ferias);
        System.out.println("Ingrese la cédula de un emprendedor: ");
        String ced = sc.nextLine();
        f.editarEmprendedor(sc,ced,f.getLstEmprendedores()); 
    }
}
