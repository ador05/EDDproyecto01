/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author ador_2005
 */
public class ListaVertices {
    
    private Vertice pFirst;
    private Vertice pLast;
    private int size;

    public ListaVertices() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
        
    
    }
    public Vertice getInicio(){
        return pFirst;
    }
    public int getSize(){
        return size;
    }
    
    public void Empty(){
        pFirst = null;
        pLast = null;
        size = 0;
    }
    
    public boolean EsVacio(){
        return pFirst == null; 
    }
    public void insertar_final(int id, String user){
        
        Vertice nuevo = new Vertice(id,user);
        if (EsVacio()){
            
            pFirst = nuevo;
            pLast = nuevo;
        }else{
            Vertice aux = pLast;
            aux.setpNext(nuevo);
            pLast = nuevo;  
        }
        size++;
    }
    
    public void insertar_inicio(int id, String user){
        Vertice nuevo = new Vertice(id,user);
        if (EsVacio()){
            pFirst = nuevo;
            pLast = nuevo;
            size++;    
        }else{
            Vertice aux = pFirst;
            aux.setpNext(pFirst.getpNext());
            pFirst = nuevo;
            pFirst.setpNext(aux);
            
                
                
            }
        size++;
        }
    
    
    public void Imprimir(){
        if(!EsVacio()){
            Vertice aux = pFirst;
            for (int i = 0; i < size; i++) {
                System.out.println(aux.getUsername()+ " ");
                aux = aux.getpNext();
            }
        }else{
            System.out.println("La lista esta vacia");
        }
        
    }
    
    
    public void EliminarInicio(){
        if (!EsVacio()){
            pFirst = pFirst.getpNext();
            size = size-1;
        }
    }
    
    public void ShowElement(){
        if (EsVacio()){
            System.out.println("Esta lista esta vacia");
        }else{
            Vertice temporal;
            temporal = pFirst;
            String mostrar_completo = "";
            for (int i = 0; i < size; i++) {
                mostrar_completo += "Usuario: " + temporal.getUsername()+"\nID: "+ temporal.getID()+"\n";
                temporal = temporal.getpNext();
                System.out.println(mostrar_completo);
                mostrar_completo = "";
            }
            
        }
    }
    
    
}
