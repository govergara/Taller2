/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.util.ArrayList;

/**
 *
 * @author govergara
 */
public class Familia {
    
    private String nombre;
    
    private ArrayList<MiembroFamilia> miembros;
    
    public Familia(String n){
        this.nombre = n;
        this.miembros = new ArrayList<>();
    }
    
    public void addMiembro(MiembroFamilia miembro){
        this.miembros.add(miembro);
    }
    
    public ArrayList<MiembroFamilia> getMiembros(){
        return this.miembros;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String n){
        this.nombre = n;
    }
    
    public boolean perteneceFamilia(String rut, String clave){
        int i;
        MiembroFamilia tmp;
        for(i=0; i< this.miembros.size(); ++i){
           tmp = this.miembros.get(i);
           if(tmp.getRut().equals(rut) && tmp.getClave().equals(clave))
               return true;
        }
        return false;
    }
    
}
