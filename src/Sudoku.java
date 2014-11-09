
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
        arbol=new Arbol(new NodoArbol(valores,null,null));
        
        NodoArbol actual=arbol.getRaiz();
        int[][] valoresActual=actual.getEstado();
        //while(terminado(valoresActual)){
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (valoresActual[i][j]==0) {
                        valoresActual=this.aplicarRegla(valoresActual, i, j);
                    }  
                }
            }
        return valoresActual;
        //}
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
        for (int k = 1 ; k < 10; k++) {
            valores[i][j]=k;
            if (estadoValido(valores)) {
                break;
            }
        }
        return valores;
    }
}
