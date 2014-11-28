
import Arbol.Arbol;
import Arbol.NodoArbol;
import java.util.ArrayList;

public class Sudoku{
    public int[][] valores;
    public Arbol arbol;

    public Sudoku() {
        this.valores = new int[9][9];
    }
    
    public int[][] aplicador(){
        arbol=new Arbol(new NodoArbol(valores,0,0,null));
        
        NodoArbol actual=arbol.getRaiz();
        
        int [][] valoresActual=valores.clone();
                for (int k = 0; k < valores.length; k++) {
                    valoresActual[k]=valores[k].clone();
        }
        
        //while(terminado(valoresActual)){
        
        //for (int k = 0; k < 200; k++) {
            
        
        
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (valores[i][j]==0) {
                        if (actual!=arbol.getRaiz()&&sePuedeAplicarRegla(valoresActual, i, j)==false) {
                            valoresActual[i][j]=0;
                            int [][] valoresClon=valoresActual.clone();
                            for (int k = 0; k < valoresActual.length; k++) {
                                valoresClon[k]=valoresActual[k].clone();
                            }
                            actual=actual.getAnterior();
                            actual.setEstado(valoresClon);
                                i=actual.iCambio;
                                j=actual.jCambio;
                        }
                        else{
                        valoresActual=aplicarRegla(valoresActual, i, j);
                        int [][] valoresClon=valoresActual.clone();
                            for (int k = 0; k < valoresActual.length; k++) {
                                valoresClon[k]=valoresActual[k].clone();
                            }
                        actual.setSiguiente(new NodoArbol(valoresClon,i,j,actual));
                        actual=actual.getSiguiente();
                        }
                    }  
                }
            }
            
            
        //}
        //}
        
        return actual.getEstado();
    }

    public boolean terminado(int[][] estado) {
        
        return true;       
    }
    public boolean estadoValido(int [][] estado){
        ArrayList numeros=new ArrayList();
        for (int i = 0; i < estado.length; i++) {
            for (int j = 0; j < estado.length; j++) {
                if (estado[i][j]!=0) {
                    if(numeros.indexOf(estado[i][j])==-1){
                    numeros.add(estado[i][j]);
                }
                else{
                    return false;
                }
                }   
            }
            numeros.clear();
        }
        
        for (int i = 0; i < estado.length; i++) {
            for (int j = 0; j < estado.length; j++) {
                if (estado[j][i]!=0) {
                    if(numeros.indexOf(estado[j][i])==-1){
                    numeros.add(estado[j][i]);
                }
                else{
                    return false;
                }
                }   
            }
            numeros.clear();
        }
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (estado[i][j]!=0) {
                    if(numeros.indexOf(estado[i][j])==-1){
                    numeros.add(estado[i][j]);
                }
                else{
                    return false;
                }
                }
            }
        }
            numeros.clear();
            
        
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 6; j++) {
                if (estado[i][j]!=0) {
                    if(numeros.indexOf(estado[i][j])==-1){
                    numeros.add(estado[i][j]);
                }
                else{
                    return false;
                }
                }
            }
        }
            numeros.clear();
        
            for (int i = 0; i < 3; i++) {
            for (int j = 6; j < 9; j++) {
                if (estado[i][j]!=0) {
                    if(numeros.indexOf(estado[i][j])==-1){
                    numeros.add(estado[i][j]);
                }
                else{
                    return false;
                }
                }
            }
        }
            numeros.clear();
        
            for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                if (estado[i][j]!=0) {
                    if(numeros.indexOf(estado[i][j])==-1){
                    numeros.add(estado[i][j]);
                }
                else{
                    return false;
                }
                }
            }
        }
            numeros.clear();
        
            for (int i = 3; i < 6; i++) {
            for (int j = 3; j < 6; j++) {
                if (estado[i][j]!=0) {
                    if(numeros.indexOf(estado[i][j])==-1){
                    numeros.add(estado[i][j]);
                }
                else{
                    return false;
                }
                }
            }
        }
            numeros.clear();
        
            for (int i = 3; i < 6; i++) {
            for (int j = 6; j < 9; j++) {
                if (estado[i][j]!=0) {
                    if(numeros.indexOf(estado[i][j])==-1){
                    numeros.add(estado[i][j]);
                }
                else{
                    return false;
                }
                }
            }
        }
            numeros.clear();
        
            for (int i = 6; i < 9; i++) {
            for (int j = 0; j < 3; j++) {
                if (estado[i][j]!=0) {
                    if(numeros.indexOf(estado[i][j])==-1){
                    numeros.add(estado[i][j]);
                }
                else{
                    return false;
                }
                }
            }
        }
            numeros.clear();
        
            for (int i = 6; i < 9; i++) {
            for (int j = 3; j < 6; j++) {
                if (estado[i][j]!=0) {
                    if(numeros.indexOf(estado[i][j])==-1){
                    numeros.add(estado[i][j]);
                }
                else{
                    return false;
                }
                }
            }
        }
            numeros.clear();
        for (int i = 6; i < 9; i++) {
            for (int j = 6; j < 9; j++) {
                if (estado[i][j]!=0) {
                    if(numeros.indexOf(estado[i][j])==-1){
                    numeros.add(estado[i][j]);
                }
                else{
                    return false;
                }
                }
            }
        }
            numeros.clear();
        
        return true;
    }

    public int[][] aplicarRegla(int[][] valores,int i,int j) {
        int valor=valores[i][j];
        for (int  k= 0;  k< 9-valor; k++) {
           valores[i][j]++;
           if (estadoValido(valores)) {
               break;
                
           }
        }
        return valores;
    }
    
    public boolean sePuedeAplicarRegla(int[][] valores,int i,int j){
        int [][] values=valores.clone();
        for (int k = 0; k < valores.length; k++) {
            values[k]=valores[k].clone();
        }
        for (int  k= 0;  k< 9-valores[i][j]; k++) {
           values[i][j]++;
           if (estadoValido(values)) {
                return true;
           }
        }
        return false;
    }
}
