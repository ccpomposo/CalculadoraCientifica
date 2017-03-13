/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Usuario
 */
public class Cola<T extends Comparable<T>> {
    private ListaDoble<T> lista;
    
    public Cola() {
        this.lista = new ListaDoble();
    }
    
    public void insertar (T e) {
        this.lista.insertarFinal(e);
    }
    
    public T quitar() {
        return (T)lista.obtenerInicio();
    }
    
    public boolean isVacia(){
        return this.lista.getInicio()==null;
    }
}
