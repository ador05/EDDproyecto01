package disconnectedgraph;

import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author mariavictoriadasilva
 * @param <T>
 */
public class Lista<T> {
    //Campos de la clase

    private Nodo<T> pFirst;

    private int size;

    /**
     * Constructor de la clase
     */
    public Lista() {

        this.pFirst = null;

        this.size = 0;
    }

    /**
     *
     * @return valor de tipo boolean
     */
    public boolean esVacio() {

        return pFirst == null;
    }

    /**
     *
     * @param x
     */
    public void agregarElemento(T x) {

        Nodo<T> node = new Nodo<>();

        node.setInfo(x);

        if (esVacio()) {

            pFirst = node;

        } else {

            Nodo aux = pFirst;

            while (aux.getpNext() != null) {

                aux = aux.getpNext();
            }
            aux.setpNext(node);
//            pLast = node;
        }

        size++;

    }

    public void removeDuplicates() {
        Nodo temp = pFirst;

        if (esVacio()) {
            return;
        }

        while (temp.getpNext() != null) {
            while (temp.getInfo() == temp.getpNext().getInfo()) {

                temp.setpNext(temp.getpNext().getpNext());
                if (temp.getpNext() == null) {
                    break;
                }
            }
            temp = temp.getpNext();
            if (temp == null) {
                break;
            }
        }
    }

    public T buscarPorIndice(int index) {

        Nodo temp = pFirst;
        int counter = 0;

        while (temp != null) {

            if (counter == index) {
                break;
            }
            temp = temp.getpNext();
            counter++;
        }
        return (T) temp.getInfo();
    }

    public void removeElement(Integer x) {

        Nodo aux = pFirst;
        while ((Integer) aux.getInfo() != x) {

            aux = aux.getpNext();
        }
        aux.setpNext(aux.getpNext().getpNext());

    }

    /**
     *
     * @param x
     * @return indica la posicion de cierto elemento en la lista retorno de tipo
     * entero
     */
    public int buscarPosicion(T x) {

        int posicion = -1;

        Nodo<T> aux = pFirst;

        while (aux != null) {

            if (aux.getInfo().equals(x)) {

                return ++posicion;

            }
            posicion++;

            aux = aux.getpNext();
        }
        return -1;

    }

    /**
     *
     * @param x
     */
    public void agregarAlInicio(T x) {
        Nodo<T> node = new Nodo<>();

        node.setInfo(x);

        if (esVacio()) {
            pFirst = node;
            size++;

        } else {

            Nodo<T> aux = pFirst;

            node.setpNext(aux);

            pFirst = node;
            size++;

        }
    }

    /**
     *
     * @param referencia
     * @return det ipo booleano, saber si un nodo se encuentra en la lista
     */
    public boolean Buscar(T referencia) {

        Nodo<T> node = new Nodo<>();

        node.setInfo(referencia);

        Nodo<T> aux = pFirst;

        while (aux != null) {
            if (aux.getInfo().equals(node.getInfo())) {
                return true;
            }
            aux = aux.getpNext();
        }
        return false;
    }

    /**
     *
     * @param value
     * @param posicion
     */
    public void insertar(T value, int posicion) {

        Nodo<T> nodo = new Nodo<>();

        nodo.setInfo(value);

        if (posicion == 0 || esVacio()) {
            nodo = pFirst;
            pFirst = nodo;
            // System.out.println(nodo.getInfo());
        } else {

            Nodo<T> aux = pFirst;

            for (int i = 0; i < posicion - 1; i++) {

                aux = aux.getpNext();
            }
            nodo.setpNext(aux.getpNext());

            aux.setpNext(nodo);
        }

        size++;
    }

    /**
     * Se elimina el primer elemento de la lista
     */
    public void eliminarPrimero() {

        if (!esVacio()) {

            pFirst = pFirst.getpNext();

            size = size - 1;
        } else {
            System.out.print("La lista esta vacia");
        }

    }

    /**
     *
     * @return apuntador al primer elemento de la lista, de tipo Nodo
     */
    public Nodo<T> getpFirst() {
        return pFirst;
    }

    /**
     *
     * @param pFirst
     */
    public void setpFirst(Nodo<T> pFirst) {
        this.pFirst = pFirst;
    }

    /**
     *
     * @param nodo
     */
    public void eliminarElemento(int x) {
        Nodo nodo = new Nodo();

        nodo.setInfo(x);
        if (nodo == pFirst) {
            pFirst = pFirst.getpNext();
        }

        Nodo<T> aux = pFirst;

        if (!esVacio()) {
//            if(Buscar(nodo.getInfo())){
            while (aux.getpNext().getInfo() != nodo.getInfo()) {

                aux = aux.getpNext();
//            if (Buscar(nodo.getInfo())){
//                Nodo aux = pFirst;
//                while(aux.getpNext().getInfo() != nodo.getInfo()){
//                    
//                    aux = aux.getpNext();
//                }
//                aux.setpNext(nodo.getpNext());
//                

            }
            aux.setpNext(aux.getpNext().getpNext());
            size = size - 1;

//            }else{System.out.println("No existe el valor que desea eliminar");}
        }
    }

    /**
     * Elimina el ultimo elemento de la lista
     */
    public void eliminarUltimo() {

        if (!esVacio()) {

            Nodo<T> aux = pFirst;
            //Nodo ultimo = null;
            while (aux.getpNext().getpNext() != null) {

                aux = aux.getpNext();
            }

            aux.getpNext().getpNext();

            size = size - 1;

        }
    }

    /**
     *
     * @return retorna un tipo de dato entero referente al tamaño de la lista
     */
    public int size() {
        return size;
    }

    public Object getLastElement() {

        Nodo aux = pFirst;
        int pos = 0;

        while (aux.getpNext() != null) {

            aux = aux.getpNext();
            pos++;
        }
        return aux.getInfo();

    }

    /**
     * Imprime los elementos de la lista
     */
    public void imprimirValores() {
        if (!esVacio()) {
            Nodo aux = pFirst;

            while (aux != null) {
                System.out.print(aux.getInfo() + "->");
                aux = aux.getpNext();
            }
        } else {
            System.out.print("La lista esta vacia");
        }

    }

    /**
     * Vacia la lista por completo
     */
    public void vaciarLista() {

        if (!esVacio()) {
            while (pFirst != null) {
                pFirst = pFirst.getpNext();

            }
        }
    }

    /**
     *
     * @param position
     * @param low
     * @param high
     */
    public void checkBounds(int position, int low, int high) {
        if (position > high || position < low) {
            throw new IndexOutOfBoundsException(position + "");
        }
    }

    /**
     * Elimina un Nodo buscandolo por la posicion ingresada por el usuario
     *
     * @param position
     */
    public void deleteNth(int position) {
        checkBounds(position, 0, size - 1);
        if (position == 0) {
            Nodo destroy = pFirst;
            pFirst = pFirst.getpNext();
            destroy = null;
            /* clear to let GC do its work */
            size--;
            return;
        }
        Nodo cur = pFirst;
        for (int i = 0; i < position - 1; ++i) {
            cur = cur.getpNext();
        }

        Nodo destroy = cur.getpNext();
        cur.setpNext(cur.getpNext().getpNext());
        destroy = null; // clear to let GC do its work

        size--;

    }

    /**
     *
     * @param k
     */
    public void swapNodes(int k) {
        Nodo prevNodeAux = null, prevNodeAuxOne = null;
        Lista list = new Lista();

        Nodo aux = pFirst;
        int i = 1;
        while (aux != null) {
            prevNodeAux = aux;
            aux = aux.getpNext();
            i++;

            if (i == k) {
                break;
            }

        }

        Nodo auxOne = pFirst;
        int j = 1;
        while (auxOne != null) {
            prevNodeAuxOne = auxOne;
            auxOne = auxOne.getpNext();
            j++;
            if (j == size - (k)) {
                break;
            }
        }

        System.out.println(aux.getpNext().getInfo());
        System.out.println(auxOne.getpNext().getInfo());

        if (aux != null && auxOne != null) {

            if (prevNodeAux != null) {

                //prevNodeAux = auxOne;
                auxOne.setpNext(prevNodeAux.getpNext().getpNext());
            } else {
                pFirst = auxOne;
            }

            if (prevNodeAuxOne != null) {
                // prevNodeAuxOne = aux;
                aux.setpNext(prevNodeAuxOne.getpNext().getpNext());
            } else {
                pFirst = aux;
            }

        }

    }

    /**
     *
     * @return tipo de dato Nodo
     */
    public Nodo invertirLista() {
        Nodo new_head = null;
        Nodo curr = pFirst;
        Nodo prev = null;
        Nodo tmp_curr = null;
        while (true) {
            tmp_curr = curr.getpNext();
            curr.setpNext(prev);

            if (tmp_curr == null) {
                break;
            }
            curr = tmp_curr;
        }
        return curr;

    }

    public Nodo reverseLinkedList() {

        Nodo prev = null;

        while (this.pFirst != null) {
            Nodo node_next = this.pFirst.getpNext();
            this.pFirst.setpNext(prev);
            prev = this.pFirst;
            this.pFirst = node_next;

        }
        return prev;
    }

    public void establecerElemento(int indice, T elemento) {
        checkBounds(indice, 0, size - 1);
        Nodo<T> aux = pFirst;
        for (int i = 0; i < indice; i++) {
            aux = aux.getpNext();
        }
        aux.setInfo(elemento);
    }

}
