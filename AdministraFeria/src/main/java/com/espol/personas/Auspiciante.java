/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.personas;

/**
 *
 * @author joshf
 */
public class Auspiciante extends Persona{
    //VARIABLES DE INSTANCIA
    private SectorCubierto sector;
    
    public SectorCubierto getSectorCubierto(){
        return sector;
    }
    public void setSectorCubierto(String sector){
        this.sector = SectorCubierto.valueOf(sector);
    }
    
}
