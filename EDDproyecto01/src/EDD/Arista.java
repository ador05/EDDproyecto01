/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author ador_2005
 */
public class Arista {
    private Vertice vertex1;
    private Vertice vertex2;
    private int tiempo_amistad;
    private Arista pNext;

    public Arista(Vertice vertex1, Vertice vertex2, int tiempo_amistad) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.tiempo_amistad = tiempo_amistad;
    }

    public Vertice getVertex1() {
        return vertex1;
    }

    public void setVertex1(Vertice vertex1) {
        this.vertex1 = vertex1;
    }

    public Vertice getVertex2() {
        return vertex2;
    }

    public void setVertex2(Vertice vertex2) {
        this.vertex2 = vertex2;
    }

    public int getTiempo_amistad() {
        return tiempo_amistad;
    }

    public void setTiempo_amistad(int tiempo_amistad) {
        this.tiempo_amistad = tiempo_amistad;
    }

    public Arista getpNext() {
        return pNext;
    }

    public void setpNext(Arista pNext) {
        this.pNext = pNext;
    }
    
    
    
    
    
    
    
    
}
