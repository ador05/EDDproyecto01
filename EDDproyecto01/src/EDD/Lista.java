/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author ador_2005
 */
public class Lista {
    
    private Nodo pFirst;
    private Nodo pLast;
    private int size;

    public Lista() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
        
    }
    
    public void Empty(){
        pFirst = null;
        pLast = null;
        size = 0;
    }
    
    public boolean EsVacio(){
        return pFirst == null; 
    }
    public void insertar_final(Object data){
        
        Nodo nuevo = new Nodo(data);
        if (EsVacio()){
            
            pFirst = nuevo;
            pLast = nuevo;
        }else{
            Nodo aux = pLast;
            aux.setPnext(nuevo);
            pLast = nuevo;  
        }
        size++;
    }
    
    public void insertar_inicio(Object data){
        Nodo nuevo = new Nodo(data);
        if (EsVacio()){
            pFirst = nuevo;
            pLast = nuevo;
            size++;    
        }else{
            Nodo aux = pFirst;
            aux.setPnext(pFirst.getPnext());
            pFirst = nuevo;
            pFirst.setPnext(aux);
            
                
                
            }
        size++;
        }
    
    
    public void Imprimir(){
        if(!EsVacio()){
            Nodo aux = pFirst;
            for (int i = 0; i < size; i++) {
                System.out.println(aux.getElement()+ " ");
                aux = aux.getPnext();
            }
        }else{
            System.out.println("La lista esta vacia");
        }
        
    }
    
    
    public void EliminarInicio(){
        if (!EsVacio()){
            pFirst = pFirst.getPnext();
            size = size-1;
        }
    }

    public Nodo getpFirst() {
        return pFirst;
    }

    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    public Nodo getpLast() {
        return pLast;
    }

    public void setpLast(Nodo pLast) {
        this.pLast = pLast;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
    
    
}