/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.menu;

import com.espol.feria.Feria;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Josh
 */
public class AdminStands {
    public static void menuStands(){
        System.out.println("Administración de Stands");
        System.out.println("1. Reservar un Stand");
        System.out.println("2. Mostrar informacion Stand");
        System.out.println("3. Regresar");
    }
    
    public static void opcionReservarStand(Scanner sc,ArrayList<Feria> ferias){
        System.out.println("-> Reservar Stand");
        System.out.println("Ingrese el codigo de una feria");
        String codFeria = sc.nextLine();
        AdminFerias.buscarFeria(codFeria, ferias);
        
    }
}
