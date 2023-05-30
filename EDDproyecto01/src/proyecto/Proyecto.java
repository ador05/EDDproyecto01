/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto;
import Funciones.Funciones;
import EDD.ListaVertices;
import EDD.Vertice;
import EDD.ListaAristas;
import EDD.Grafo;
/**
 *
 * @author ador_2005
 */
public class Proyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Funciones func = new Funciones();
        
        ListaVertices usuarios2 = func.LeerUsuarios();
//        usuarios2.ShowElement();
        
        ListaAristas relaciones2 = func.LeerRelaciones();
//        relaciones2.ShowElement();
        
        Grafo grafo1 = new Grafo(usuarios2);
        
        grafo1.AgregarRelaciones(relaciones2);
        
        grafo1.ImprimirGrafo();
        
        
        
        

      
        
        
        
        
    }
    
}
