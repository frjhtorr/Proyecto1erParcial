
import com.espol.menu.*;
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
    
    public static void main(String[] args) {
      System.out.println("GESTION DE FERIAS");
      Scanner sc = new Scanner(System.in);
      int opcion; 
      Feria f = new Feria();
      String ln;
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
                      case 1:
                          AdminFerias.opcionVerFeria(sc,ferias);
                          break;
                      case 2:
                          AdminFerias.opcionRegistrarFeria(sc,ferias);
                          break;
                      case 3:
                          AdminFerias.opcionEditarFeria(sc, ferias);
                          break;
                      case 4:
                          AdminFerias.opcionConsultarEmprendedores(sc, ferias);
                          break;}
                  opcionF=5;
              } }
          case 2 -> {
              //Administracion de emprendedores
              AdminEmprendedores.menuEmprendedores();
              int opcionE = pedirSolicitud(sc);
              while(opcionE!=3){
                  sc.nextLine();
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
              adminAuspiciantes();
              int opcionA = sc.nextInt();
              while(opcionA!=4){
                  sc.nextLine();
                  switch(opcionA){
                      case 1://registrar aupsiciante
                          System.out.println("-> Registrar auspiciante");
                          registrarAuspiciante();
                          break;
                      case 2: //editar auspiciante
                          System.out.println("-> Editar auspiciante");
                          editarAuspiciante();
                          break;
                      case 3: //asignar auspiciante
                          System.out.println("-> Asignar auspiciante");
                          System.out.println("Selecciona una Feria: ");
                          codFeria = sc.nextLine();
                          System.out.println("Escriba la cédula del auspiciante: ");
                          String ci = sc.nextLine();
                          asignarAuspiciante(codFeria, ci);
                          break;}
                  opcionA = 4;
              } }
          case 4 -> {
              //Administración de Stands
              System.out.println("Selecciona una Feria: ");
              codFeria = sc.nextLine();
              f = buscarFeria(codFeria);
              String nombre = f.getNombre();
              System.out.println("-> " +nombre);
              f.mostrarDistribucion();
              adminStands();
              int opcionS = sc.nextInt();
              while(opcionS!=3){
                  switch(opcionS){
                      case 1://Reservar stand
                          //System.out.println("Selecciona una Feria: ");
                          sc.nextLine();
                          //codFeria = sc.nextLine();
                          //Feria fe = buscarFeria(codFeria);
                          System.out.println("Selecciona un Stand: ");
                          ln = sc.nextLine();
                          f.reservarStand(ln);
                          break;
                          
                      case 2://Mostrar informacion del stand
                          //System.out.println("Selecciona una Feria: ");
                          //codFeria = sc.nextLine();
                          sc.nextLine();
                          //Feria fd = buscarFeria(codFeria);
                          System.out.println("Selecciona un Stand: ");
                          ln = sc.nextLine();
                          Stand std = f.buscarStand(ln);
                          System.out.println("Se encontró stand");
                          f.infoStand(std);
                          break;
                  }
                  opcionS = 3;
              } }
            default -> {
                System.out.println("Ingrese una opción válida");
                opcion = sc.nextInt();
              }
        }
        System.out.println("");
        
      } while(opcion != 5); 

       sc.close();
    }
}
