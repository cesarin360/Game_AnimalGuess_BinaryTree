/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adivina;

import java.io.Serializable;
/**
 *
 * @author cesar
 */
public class Nodo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    //Nodos 
    public Object dato; 
    public Nodo izquierda; 
    public Nodo derecha; 
    
    public Nodo (){
        this (null, null, null);
    }
    
    public Nodo(Object valor){
        this.dato = valor;
        this.izquierda = null;
        this.derecha = null;
    }
    
    public Nodo (Nodo z, Object nv, Nodo rigth){
        dato = nv;
        izquierda = z;
        derecha = rigth;
    }  
}