/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.feria;

import java.util.*;
import com.espol.personas.*;
import java.time.LocalDate;
import java.time.Month;
/**
 *
 * @author joshf
 */
public class Feria {

    public Feria(String cod, String nombre1, String descripcion1, String lugar1, String fechaIni1, String fechaFin1, String horario1) {
    }
  //VARIABLES DE INSTANCIA
    private String nombre;
    private String descripcion;
    private String fechaIni;
    private String fechaFin;
    private String lugar;
    private String horario;
    private String codFeria;
    private ArrayList<Emprendedor> lstEmprendedores;
    private ArrayList<AuspicianteEnFeria> lstAuspiciantes;
    private Seccion[] secciones;

    public Feria() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getCodFeria() {
        return codFeria;  
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaIni() {
        return fechaIni;
    }

    public String getLugar() {
        return lugar;
    }

    public int cantidadAus() {
        return secciones.length;
    }
    
    public void setSecciones(Seccion[] seccionesFeria) {
        this.secciones = seccionesFeria;
    }
    
    private Seccion[] getSecciones() {
        return secciones;
    }
    
    
    
    public void fijarStandsFeria(){
        Scanner sc = new Scanner(System.in);
        // Asigna valores a las secciones
        String[] letras = {"A","B","C","D"};
        Seccion[] seccionesFeria = new Seccion[4];
        for(int i=0;i<seccionesFeria.length;i++){
          seccionesFeria[i] = new Seccion();
          seccionesFeria[i].setId(letras[i]);
          int cant = sc.nextInt();
          seccionesFeria[i].setCantStands(cant);
        }
          // Asigna el arreglo de secciones a la feria
          this.setSecciones(seccionesFeria);

          // Crea los stands
          for(int j=0;j<seccionesFeria.length;j++){
            int cantidad = seccionesFeria[j].getCantStands();
            //lista de stands
            ArrayList<Stand> stands = new ArrayList<>();
              for(int k = 0; k<cantidad; k++){
            Stand stand1 = new Stand();
            stand1.setNum(k+1);
            stand1.setReservado(false);
            stands.add(stand1);
            this.getSecciones()[j].setArrayStands(stands);
              }
            
          }
          sc.close();
        }


    
}
