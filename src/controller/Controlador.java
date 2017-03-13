/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Cola;
import model.Pila;

/**
 *
 * @author Usuario
 */
public class Controlador {
    private Cola<Character> colaResultado;
    private Pila<Character> pilaOperadores;
    
    public Controlador() {
        this.colaResultado = new Cola();
        this.pilaOperadores = new Pila();
    }
    
    public String obtenerPolaca(String expresion) {
        char aux = 'x';
        for (int i = 0; i < expresion.length(); i++) {
            aux = expresion.charAt(i);
            if(aux != '+' || aux != '-' || aux != '*' || aux != '/' || aux != '^' || aux != '(' || aux != ')') {
                this.colaResultado.insertar(aux);
            } else {
                if (aux == '(') {
                    this.pilaOperadores.insertar(aux);
                } else {
                    if(aux == ')') {
                        char aux2 = 'x';
                        while (aux2 != '(') {
                            aux2 = pilaOperadores.quitar();
                            this.colaResultado.insertar(aux2);
                        }
                        this.pilaOperadores.quitar();
                    } else {
                        if (aux == '*' || aux == '/' || aux == '^') {
                            pilaOperadores.insertar(aux);
                        } else {
                            boolean flag = true;
                            while (flag) {
                                if(this.pilaOperadores.isVacia() || this.pilaOperadores.getValorActual() == '(' || aux == '+' || aux == '-'){
                                    this.pilaOperadores.insertar(aux);
                                    flag = false;
                                } else {
                                    this.colaResultado.insertar(this.pilaOperadores.quitar());
                                }
                            }
                        }
                    }
                }
            }
            
        }
        while(!this.pilaOperadores.isVacia()) {
            this.colaResultado.insertar(this.pilaOperadores.quitar());
        }
        String resultado = "";
        while (!this.colaResultado.isVacia()) {
            resultado += this.colaResultado.quitar();
        }
        return resultado;
    }
}

class Test {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        System.out.println(controlador.obtenerPolaca("A+B*C"));
    }
}
