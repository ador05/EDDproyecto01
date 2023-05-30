/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author ador_2005
 */
public class Nodo {
    private Object element;
    private Nodo pnext;
    private Nodo pbefore;

    public Nodo(Object element, Nodo pnext) {
        this.element = element;
        this.pnext = pnext;
    }
    

    public Nodo(Object element) {
        this.element = element;
        this.pnext = null;
        this.pbefore = null;
    }
    
    public Nodo(Nodo pnext) {
        this.pnext = pnext;
        this.element = null;
                
    }

    /**
     * @return the element
     */
    public Object getElement() {
        return element;
    }

    /**
     * @param element the element to set
     */
    public void setElement(Object element) {
        this.element = element;
    }

    public Nodo getPnext() {
        return pnext;
    }

    public void setPnext(Nodo pnext) {
        this.pnext = pnext;
    }

    public Nodo getPbefore() {
        return pbefore;
    }

    public void setPbefore(Nodo pbefore) {
        this.pbefore = pbefore;
    }
    
    
    
    
    
}


