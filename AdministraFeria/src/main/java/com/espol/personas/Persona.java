/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.personas;

import com.espol.feria.*;
import com.espol.redes.*;
import java.util.ArrayList;

/**
 *
 * @author joshf
 */
public class Persona {
   //VARIABLES DE INSTANCIA
    protected String cedula;
    protected String nombre;
    protected String telefono;
    protected String email;
    protected String direccion;
    protected String web;
    protected String owner;
    protected ArrayList<CuentaRedSocial> lstRedes;
    protected ArrayList<Stand> lstStands; 
}
