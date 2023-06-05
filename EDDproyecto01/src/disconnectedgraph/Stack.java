/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package disconnectedgraph;

/**
 *
 * @author mariavictoriadasilva
 * @param <T>
 */
public class Stack<T> {
    
    private Nodo<T> pTop;
    
    int size;
    
    /**
     *
     */
    public Stack(){
        
        this.pTop = null;
    
        this.size = 0;
    }
    
    /**
     *
     * @return
     */
    public boolean isEmpty(){
    
        return this.pTop == null;
    }
    
    /**
     *
     * @param data
     */
    public void push(T data){
        
        Nodo<T> node = new Nodo<>();
        
        node.setInfo(data);
        
       node.setpNext(this.pTop);
       
       this.pTop = node;
       
       size++;
    }
    
    /**
     *Desapila el ultimo elemento en ingresar a la pila
     * @return tipo de dato T
     */
    public T pop(){
    
        if(!isEmpty()){
        Nodo<T> aux = this.pTop;
        this.pTop = this.pTop.getpNext();
        
        size--;
        return aux.getInfo();
    }else{
            System.out.println("Pila vacía");
        }
        return null;
    }
    
    /**
     *Imprime los elementos de la pila
     */
    public void printStack(){
    
        Nodo<T> aux = this.pTop;
        
        while(aux != null){
            
            System.out.println(aux.getInfo());
            
            aux = aux.getpNext();
        }
        
        if(isEmpty()){
        
            System.out.println("Stack Empty");
        }
    }
    
    /**
     */
    public void emptyStack(){
    
        while(this.pTop != null){
        
            this.pTop = this.pTop.getpNext();
            
            //size--;
        }
        System.out.println("Empty");

    }
    
    public static void main(String[] args){
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 1; i <= 10; i++) {
            stack1.push(i);
            
        }
        
        Nodo aux = stack1.pTop;
        while(aux != null){
            if((int)aux.getInfo() % 2 == 0){
                if(aux != stack1.pTop){
                    int temp = stack1.pTop.getInfo();
                    stack1.pTop.setInfo((int)aux.getInfo());
                    aux.setInfo(temp);
                    
                }
                stack2.push(stack1.pop());
            }
            aux = aux.getpNext();
        }
        
        Nodo aux1 = stack2.pTop;
        while(aux1 != null){
            System.out.println(aux1.getInfo());
            aux1 = aux1.getpNext();
        }
        System.out.println("-----------------------------");
        System.out.println("AHORA LA PILA DE LOS IMPARES");
        System.out.println("-----------------------------");
         
        Nodo aux2 = stack1.pTop;
        while(aux2 != null){
            System.out.println(aux2.getInfo());
            aux2 = aux2.getpNext();
        }
        
    }
}
