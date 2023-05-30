/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author ador_2005
 */
public class Vertice {
    private int iD;
    private String username;
    private Vertice pNext;
    
    
    //Constructor

    public Vertice(int iD, String username) {
        this.iD = iD;
        this.username = username;
        this.pNext = null;
    }

    public Vertice(int iD) {
        this.iD = iD;
    }
    

    public int getID() {
        return iD;
    }

    public void setID(int iD) {
        this.iD = iD;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Vertice getpNext() {
        return pNext;
    }

    public void setpNext(Vertice pNext) {
        this.pNext = pNext;
    }
    
    
    
}
