/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 *
 * @author govergara
 */
public class MiembroFamilia {
    
    private String nombre;
    private String rut;
    private String clave;
    
    public MiembroFamilia(String n, String r, String c){
        this.nombre = n;
        this.rut = r;
        this.clave = c;
    }
    
    public String getNombre(){ return this.nombre; }
    public String getRut(){ return this.rut; }
    public String getClave(){ return this.clave; }
    
    public void setNombre(String n){
        this.nombre = n;
    }
    
    public void setRut(String r){
        this.rut = r;
    }
    
    public void setClave(String c){
        this.clave = c;
    }
}
