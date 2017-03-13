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
public class Pila<T extends Comparable<T>> {
    private ListaDoble<T> lista;
    
    public Pila(){
        this.lista = new ListaDoble<>();
    }
    
    public void insertar(T e) {
        lista.insertarFinal(e);
    }
    
    public T quitar() {
        return (T)lista.obtenerFinal();
    }
    
    public boolean isVacia() {
        return this.lista.getFin() == null;
    }
    
    public T getValorActual() {
        return this.lista.getFin().getDato();
    }
}
