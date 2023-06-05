/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package disconnectedgraph;

/**
 *
 * @author mariavictoriadasilva
 */
public class Graph {

    private Lista<Object[]> vertices;
    private Integer[][] matrix;

    public Graph() {

        this.vertices = new Lista<>();

        matrix = new Integer[vertices.size()][vertices.size()];

    }

    public void insertVertex(String[] array) {

        if (!search(vertices, array[0])) {
            vertices.agregarElemento(new String[]{array[0], array[1]});
        }

        Integer[][] newEdge = new Integer[vertices.size()][vertices.size()];

        if (this.matrix != null) {
            for (int i = 0; i < this.matrix.length; i++) {
                for (int j = 0; j < this.matrix.length; j++) {
                    newEdge[i][j] = this.matrix[i][j];

                }

            }
        }
        this.matrix = newEdge;

    }

    public boolean search(Lista<Object[]> vertices, String s) {
        Nodo aux = vertices.getpFirst();

        while (aux != null) {

            String[] array = (String[]) aux.getInfo();

            if (s.charAt(0) == '@') {

                if (array != null && array.length > 0 && array[1].equals(s)) {
                    return true;
                }

            } else {

                if (array != null && array.length > 0 && array[0].equals(s)) {
                    return true;
                }

            }
            aux = aux.getpNext();
        }
        return false;
    }

    public int getPosition(Lista<Object[]> vertices, String s) {
        int position = -1;
        Nodo aux = vertices.getpFirst();
        int currentPosition = 0;
        while (aux != null) {
            String[] array = (String[]) aux.getInfo();
            if (array != null && array.length > 0 && array[0].equals(s)) {
                position = currentPosition;
                break;
            }
            aux = aux.getpNext();
            currentPosition++;
        }
        return position;
    }

    public void addEdge(String src, String dest, String w) {

        int weight = Integer.valueOf(w);

        int srcPos = getPosition(vertices, src);
        int destPos = getPosition(vertices, dest);

//        UNDIRECTED GRAPH
        matrix[srcPos][destPos] = weight;

        matrix[destPos][srcPos] = weight;
    }

    public Lista<Object[]> getVertices() {
        return vertices;
    }

    public void setVertices(Lista<Object[]> vertices) {
        this.vertices = vertices;
    }

    public Integer[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(Integer[][] matrix) {
        this.matrix = matrix;
    }

    public int calcularIslasBFS() {
        int IslasBFS = 0;
        Lista visitados = new Lista();

        for (int i = 0; i < vertices.size(); i++) {
            if (!esVisitadoBFS(visitados, i)) {
                IslasBFS++;
                bfs(i, visitados);
            }
        }

        return IslasBFS;
    }

    private boolean esVisitadoBFS(Lista visitados, int indice) {
        Nodo aux = visitados.getpFirst();

        while (aux != null) {
            int visitado = (int) aux.getInfo();
            if (visitado == indice) {
                return true;
            }
            aux = aux.getpNext();
        }

        return false;
    }

    private void bfs(int inicio, Lista visitados) {
        Queue cola = new Queue();
        cola.enqueue(inicio);

        while (!cola.isEmpty()) {
            int actual = (int) cola.dequeue();

            if (!esVisitadoBFS(visitados, actual)) {
                visitados.agregarElemento((actual));

                for (int i = 0; i < vertices.size(); i++) {
                    if (matrix[actual][i] != null && !esVisitadoBFS(visitados, i)) {
                        cola.enqueue(i);
                    }
                }
            }
        }
    }

    public int calcularIslasDFS() {
        int islasDFS = 0;
        Lista visitados = new Lista();

        for (int i = 0; i < vertices.size(); i++) {
            if (!esVisitadoDFS(visitados, i)) {
                islasDFS++;
                dfs(i, visitados);
            }
        }

        return islasDFS;
    }

    private boolean esVisitadoDFS(Lista visitados, int indice) {
        Nodo aux = visitados.getpFirst();

        while (aux != null) {
            int visitado = (int) aux.getInfo();
            if (visitado == indice) {
                return true;
            }
            aux = aux.getpNext();
        }

        return false;
    }

    private void dfs(int inicio, Lista visitados) {
        Stack pila = new Stack<>();
        pila.push(inicio);

        while (!pila.isEmpty()) {
            int actual = (int) pila.pop();

            if (!esVisitadoDFS(visitados, actual)) {
                visitados.agregarElemento(actual);

                for (int i = vertices.size() - 1; i >= 0; i--) {
                    if (matrix[actual][i] != null && !esVisitadoDFS(visitados, i)) {
                        pila.push(i);
                    }
                }
            }
        }
    }
    public Lista<int[]> encontrarPuentesDFS() {
    Lista<int[]> puentes = new Lista<>();
    int n = vertices.size();
    Lista<Boolean> visitados = new Lista<>();
    Lista<Integer> descubrimiento = new Lista<>();
    Lista<Integer> menorDescubrimiento = new Lista<>();
    int tiempo = 0;

    for (int i = 0; i < n; i++) {
        visitados.agregarElemento(false);
        descubrimiento.agregarElemento(0);
        menorDescubrimiento.agregarElemento(0);
    }

    for (int i = 0; i < n; i++) {
        if (!visitados.buscarPorIndice(i)) {
            encontrarPuentesDFS2(i, -1, visitados, descubrimiento, menorDescubrimiento, tiempo, puentes);
        }
    }

    return puentes;
}

private void encontrarPuentesDFS2(int actual, int padre, Lista<Boolean> visitados, Lista<Integer> descubrimiento,
        Lista<Integer> menorDescubrimiento, int tiempo, Lista<int[]> puentes) {
    visitados.establecerElemento(actual, true);
    descubrimiento.establecerElemento(actual, tiempo);
    menorDescubrimiento.establecerElemento(actual, tiempo);
    tiempo++;

    for (int vecino = 0; vecino < vertices.size(); vecino++) {
        if (matrix[actual][vecino] != null) {
            if (!visitados.buscarPorIndice(vecino)) {
                encontrarPuentesDFS2(vecino, actual, visitados, descubrimiento, menorDescubrimiento, tiempo, puentes);
                menorDescubrimiento.establecerElemento(actual, Math.min(menorDescubrimiento.buscarPorIndice(actual), menorDescubrimiento.buscarPorIndice(vecino)));
                if (menorDescubrimiento.buscarPorIndice(vecino) > descubrimiento.buscarPorIndice(actual)) {
                    puentes.agregarElemento(new int[] { actual, vecino });
                }
            } else if (vecino != padre) {
                menorDescubrimiento.establecerElemento(actual, Math.min(menorDescubrimiento.buscarPorIndice(actual), descubrimiento.buscarPorIndice(vecino)));
            }
        }
    }
}

}
