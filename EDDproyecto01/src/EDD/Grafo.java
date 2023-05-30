/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author olvei
 */
public class Grafo {
    private int[][] matrizadjacencia;
    private int size;
    private ListaVertices vertices;
    private int cantidadrelaciones;
    
    //constructor
    public Grafo(ListaVertices vertices2) {
        int numerovertices = vertices2.getSize();
        int relacion_max =0;
        Vertice aux = vertices2.getInicio();
        
        for (int i = 0; i < numerovertices; i++) {
            if(aux.getID()> relacion_max){
                relacion_max = aux.getID();
            }
            
            aux = aux.getpNext();
        }
        
        this.matrizadjacencia = new int[relacion_max][relacion_max];
        this.size = relacion_max;
        this.vertices = vertices2;
        cantidadrelaciones = 0;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCantidadrelaciones() {
        return cantidadrelaciones;
    }

    
    //metodos
    public void AgregarRelacion(Arista arista){
        Vertice id1 = arista.getVertex1();
        Vertice id2 = arista.getVertex2();
        int size2 = arista.getTiempo_amistad();
        
        matrizadjacencia[id1.getID() - 1][id2.getID()- 1] = size2;  
        cantidadrelaciones++;
    }
    
    public boolean TieneRelacion(Vertice vertice1, Vertice vertice2){
        int id1 = vertice1.getID();
        int id2 = vertice2.getID();
        return matrizadjacencia[id1][id2] != 0;
    }
    
    public int TiempoAmistar(Vertice vertice1, Vertice vertice2){
        int id1 = vertice1.getID();
        int id2 = vertice2.getID();
        int tiemporelacion;
        
        if (matrizadjacencia[id1][id2] != 0){
            tiemporelacion = matrizadjacencia[id1][id2];
        }else{
            tiemporelacion = 0;
        }
        return tiemporelacion;
    }
    
    public void AgregarRelaciones(ListaAristas relaciones1){
        Arista aux = relaciones1.getpFirst();
        int size2;
        Vertice id1;
        Vertice id2;
        
        for (int i = 0; i < relaciones1.getSize(); i++) {
            id1 = aux.getVertex1();
            id2 = aux.getVertex2();
            size2 = aux.getTiempo_amistad();
            matrizadjacencia[id1.getID() - 1][id2.getID() - 1] = size2;
            cantidadrelaciones++;
            aux = aux.getpNext();
        }
        
    }
    
    public void ImprimirGrafo() {
        Vertice vertice1;
        Vertice vertice2;
        String mostrar_comp = "";
        String username1 = "";
        String username2= "";
        
        for (int i = 0; i < size; i++) {
            
            for (int j = 0; j < size; j++) {
                
                if (matrizadjacencia[i][j] != 0){
                    
                    Vertice aux = vertices.getInicio();
                    for (int k = 0; k < vertices.getSize(); k++) {
                        if(aux.getID() == i+1){
                            username1 = aux.getUsername();
                        }
                        aux = aux.getpNext();
                    }
                    
                    Vertice aux2 = vertices.getInicio();
                    for (int k = 0; k < vertices.getSize(); k++) {
                        if(aux2.getID() == j+1){
                            username2 = aux2.getUsername();
                        }
                        aux2 = aux2.getpNext();
                    }
                    
                    System.out.println("El usuario: "+ username1 + "y el usuario: "+ username2+"Han tenido un tiempo de amista de: " + matrizadjacencia[i][j]);
                }
                
            }
        }
    }
    
    
}