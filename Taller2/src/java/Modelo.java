
import java.util.ArrayList;
import Modelo.Familia;

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
        
    }
    
    public static Modelo getInstance(){
        if(instance == null){
            instance = new Modelo();
        }
        return instance;
    }
    
    
    
}
