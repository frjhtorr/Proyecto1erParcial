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
    }
    public Feria(String codFeria){
        this.codFeria=codFeria;
    }
    
    public Feria(String nombre, String descripcion, String fechaIni, String fechaFin, String lugar, String horario){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.lugar = lugar;
        this.horario = horario;
    }
    
    public String getCodFeria() {
        return codFeria;  
    }
    public void setCodFeria(String cod){
        this.codFeria = cod;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public String getFechaIni() {
        return fechaIni;
    }
    public void setFechaIni(String fechaIni){
        this.fechaIni=fechaIni;
    }
    
    public String getFechaFin(){
        return fechaFin;
    }
    public void setFechaFin(String fechaFin){
        this.fechaFin = fechaFin;
    }

    public String getLugar() {
        return lugar;
    }
    public void setLugar(String lugar){
        this.lugar=lugar;
    }
    
    public String getHorario(){
        return horario;
    }
    public void setHorario(String horario){
        this.horario = horario;
    }
    
    public ArrayList<Emprendedor> getLstEmprendedores(){
        return lstEmprendedores;
    }
    public void setLstEmprendedores(ArrayList<Emprendedor> lstEmprendedores){
        this.lstEmprendedores = lstEmprendedores;
    }
    
    public ArrayList<AuspicianteEnFeria> getLstAuspiciantes(){
        return lstAuspiciantes;
    }
    public void setLstAuspiciantes(ArrayList<AuspicianteEnFeria> lstAuspiciantes){
        this.lstAuspiciantes = lstAuspiciantes;
    }
    
    public Seccion[] getSecciones() {
        return secciones;
    }
    public void setSecciones(Seccion[] seccionesFeria) {
        this.secciones = seccionesFeria;
    }
    
    public String toString(){
        return "Feria{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaIni='" + fechaIni + '\'' +
                ", fechaFin='" + fechaFin + '\'' +
                ", lugar='" + lugar + '\'' +
                ", horario='" + horario + '\'' +
                '}';
    }
    
    public void editarFeria(Scanner sc){
        String fechaIni = this.getFechaIni();
        String[] fecha = fechaIni.split("-");
        int a = Integer.parseInt(fecha[0]);
        int m = Integer.parseInt(fecha[1]);
        int d = Integer.parseInt(fecha[2]);
        System.out.println("Datos actuales de la feria");
        System.out.println(this.toString());
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaInicio = LocalDate.of(a,m,d);
        if(!fechaInicio.isBefore(fechaActual)){
            System.out.println("-------------------------");
            System.out.println("¿Qué campo desea editar?");
            System.out.println("1. Nombre");
            System.out.println("2. Descripción");
            System.out.println("3. Lugar");
            System.out.println("4. Fecha de Inicio");
            System.out.println("5. Fecha de Fin");
            System.out.println("6. Horario");
            int opcion = sc.nextInt();
            switch(opcion){
                case 1 ->{
                    System.out.println("Ingrese el nuevo nombre: ");
                    String nom= sc.nextLine();
                    this.setNombre(nom);
                    break;
                }
                case 2 ->{
                    System.out.println("Ingrese la nueva descripción: ");
                    String des= sc.nextLine();
                    this.setDescripcion(des);
                    break;
                }
                case 3 ->{
                    System.out.println("Ingrese la nueva fecha de Inicio YYYY-MM-DD: ");
                    String fi= sc.nextLine();
                    this.setFechaIni(fi);
                    break;
                }
                case 4 ->{
                    System.out.println("Ingrese la nueva fecha de Fin YYYY-MM-DD: ");
                    String ff= sc.nextLine();
                    this.setFechaFin(ff);
                    break;
                }
                case 5 ->{
                    System.out.println("Ingrese el nuevo lugar: ");
                    String lugar = sc.nextLine();
                    this.setLugar(lugar);
                    break;
                }
                case 6 ->{
                    System.out.println("Ingrese el nuevo horario: ");
                    String horario = sc.nextLine();
                    this.setHorario(horario);
                    break;
                }
        }
        }else{
            System.out.println("Lo sentimos, la feria ya está en curso. No se puede editar");
        }
    }
    
    public void consultarEmprendedores(){
        for (Emprendedor e : this.lstEmprendedores){
            System.out.println(e.toString());
        }
    }
    
    public void editarEmprendedor(Scanner sc,String cedula, ArrayList<Emprendedor> lstEmprendedores){
        Emprendedor emp = new Emprendedor();
        for(Emprendedor e: lstEmprendedores){
           if(e.getCedula().equals(cedula)){
               emp = e;
           }
       }
        emp.editarEmprendedor(sc);
        
    }
    
    public void fijarStandsFeria(Scanner sc){
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
        }


    
}
