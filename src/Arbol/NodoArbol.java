/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol;

/**
 *
 * @author Usuario
 */
public class NodoArbol {
    private int[][] estado;
    private NodoArbol siguiente;
    private NodoArbol anterior;

    public NodoArbol(int[][] estado, NodoArbol siguiente, NodoArbol anterior) {
        this.estado = estado;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }
    

    public void setSiguiente(NodoArbol siguiente) {
        this.siguiente = siguiente;
    }

    public void setAnterior(NodoArbol anterior) {
        this.anterior = anterior;
    }


    public NodoArbol getSiguiente() {
        return siguiente;
    }

    public NodoArbol getAnterior() {
        return anterior;
    }

    public int[][] getEstado() {
        return estado;
    }

    public void setEstado(int[][] estado) {
        this.estado = estado;
    }
       
}
