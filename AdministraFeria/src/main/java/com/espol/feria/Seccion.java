/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.feria;

import java.util.ArrayList;

/**
 *
 * @author joshf
 */
public class Seccion {
    //ATRIBUTOS -----------------------------------------------
    private int cantStands;
    private String id;
    private ArrayList<Stand> ArrayStands;

    public void setId(String letra) {
        this.id= letra;
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setCantStands(int cant) {
        this.cantStands = cant;
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getCantStands() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void setArrayStands(ArrayList<Stand> ArrayStands){
        this.ArrayStands = ArrayStands;
    }
    
}
