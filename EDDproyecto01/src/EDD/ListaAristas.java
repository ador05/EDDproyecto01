/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author ador_2005
 */
public class ListaAristas {
    
    private Arista pFirst;
    private Arista pLast;
    private int size;

    public ListaAristas(Arista pFirst, Arista pLast, int size) {
        this.pFirst = pFirst;
        this.pLast = pLast;
        this.size = size;
    }

    public ListaAristas() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }

    public Arista getpFirst() {
        return pFirst;
    }

    public void setpFirst(Arista pFirst) {
        this.pFirst = pFirst;
    }

    public Arista getpLast() {
        return pLast;
    }

    public void setpLast(Arista pLast) {
        this.pLast = pLast;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public boolean IsEmpty(){
        return pFirst == null;
    }
    
    public void insertar_final(int id1, int id2, int size2){
        
        Vertice vertice1 = new Vertice(id1);
        Vertice vertice2 = new Vertice(id2);

        Arista nuevo = new Arista(vertice1, vertice2, size2);
        
        
        if (IsEmpty()){
            
            pFirst = nuevo;
            pLast = nuevo;
        }else{
            Arista aux = pLast;
            aux.setpNext(nuevo);
            pLast = nuevo;  
        }
        size++;
    }
    public void ShowElement(){
        if (IsEmpty()){
            System.out.println("Esta lista esta vacia");
        }else{
            Arista temporal;
            temporal = pFirst;
            String mostrar_completo = "";
            for (int i = 0; i < size; i++) {
                mostrar_completo += "ID Vertice1: " + temporal.getVertex1().getID()+"\nID Vertice2: "+ temporal.getVertex2().getID()+"\n"+ "tiempo de amistad: " + temporal.getTiempo_amistad()+ "\n";
                temporal = temporal.getpNext();
                System.out.println(mostrar_completo);
                mostrar_completo = "";
            }
            
        }
    }
    
    
    
    
}
