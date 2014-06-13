package Modelo;


import java.util.ArrayList;
import Modelo.Familia;
import Modelo.Fotografia;
import Modelo.FileRead;
import java.io.File;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author govergara
 */
public class Modelo {
    
    private static Modelo instance;
    private ArrayList<Familia> familias;
    
    private Modelo(){
        this.familias = new ArrayList<>();
    }
    
    public static Modelo getInstance(){
        if(instance == null){
            instance = new Modelo();
        }
        return instance;
    }
    
    public Familia buscarFamilia(String nombre){
        for(Familia tmp : this.familias){
            System.out.println(tmp + " - "+ nombre);
            if(tmp.getNombre().equals(nombre))
                return tmp;
        }
        return null;
    }
    
    public ArrayList<Familia> getFamilias(){
        return this.familias;
    }
    
    public void addFamilia(Familia f){
        this.familias.add(f);
    }
    
    public void readData(String path){
        FileRead datos;
        datos = new FileRead(path);
        datos.leer();
        System.out.println(datos.getFamilias());
        this.familias = datos.getFamilias();
    }
    
    public void writeData(String path){
        FileRead datos;
        datos = new FileRead(path);
        datos.setFamilias(familias);
        datos.escribir();
    }
    
    
    
}
