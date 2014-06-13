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
public class Fotografia {
    
    private String path;
    
    private String comentario;
    
    
    public Fotografia(String path, String comentario){
        this.path = path;
        if(comentario.length() > 100)
            this.comentario = comentario.substring(0, 99);
        else
            this.comentario = comentario;
    }
    
    public String getPath(){
        return this.path;
    }
    
    public String getComentario(){
        return this.comentario;
    }
    
    public void setPath(String path){
        this.path = path;
    }
    
    public boolean setComentario(String comentario){
        if(comentario.length() > 100)
            this.comentario = comentario.substring(0, 99);
        else
            this.comentario = comentario;
        return true;
    }
    
}
