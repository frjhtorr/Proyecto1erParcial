
import com.espol.feria.*;
import com.espol.personas.*;
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

   //METODOS ESTATICOS
    public static void menuPrincipal(){ 
        System.out.println("Menú Principal_______________________" + 
               "\n 1. Administración de Ferias " + 
               "\n 2. Administración de Emprendedores " + 
               "\n 3. Administración de Auspiciantes " + 
               "\n 4. Administración de Stands " + 
               "\n 5. Salir");
   
    }
  
   //GENERAR CODIGO FERIA
    public static String generarCod(){
        int n = ferias.size();
        return "FE00"+(n+1);
    }   
  
    //BUSCAR FERIA POR COD
    public static Feria buscarFeria(String codFeria){
    Feria feriaBuscada = new Feria(cod, nombre, descripcion, lugar, fechaIni, fechaFin, horario);
      for(Feria f: ferias){
       if(f.getCodFeria().equals(codFeria)){
        feriaBuscada=f;
        } 
    }
    return feriaBuscada;
  }
    
    //MOSTRAR FERIA - ITEM 0 EN EL SUB MENU AdminFerias
    public static void mostrarFerias(ArrayList<Feria> ferias){
    System.out.println("------LISTADO DE FERIAS QUE EXISTEN------ ");
    for(Feria f: ferias){
      System.out.println(f.getCodFeria()+" - "+f.getNombre()+" - "+f.getFechaIni()+" - "+f.getLugar()+" - "+f.cantidadAus());
       }
    }
    
    //VER FERIA POR INDICE
    public static void verFeria(int i){
        System.out.println(ferias.get(i).toString());
    }
  
    //VER FERIA POR CODIGO DE FERIA
    public static void verFeria(String cod){
      Feria feriaBuscada = buscarFeria(cod);
      int i = ferias.indexOf(feriaBuscada);
      verFeria(i);
    }
    
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
