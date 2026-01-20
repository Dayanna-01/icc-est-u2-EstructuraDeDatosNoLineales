package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import nodes.Node;
public class Graph<T> {
    // 1ra forma
    // Trabaja con listado en adyancencia
    //List<Node<T>> nodes;

    // 2da forma
    private Map<Node<T>, List<Node<T>>> mapa;

    public Graph() {
        this.mapa = new HashMap<Node<T>, List<Node<T>>>();  
    }
    
    // Inserta un vertice o un nodo 
    public void addNode(Node<T> node) {
        this.mapa.putIfAbsent(node, new ArrayList<>());
        //mapa { N1: [N2], N2: [N1], n2: [N1]}
    }

    // Grafo no dirigido
    public void addEdge(Node<T> n1, Node<T> n2) {
        addNode(n1);
        addNode(n2);
        // Metodo 1
        // List<Node<T>> listadoNodo1 = this.mapa.get(n1);
        // listadoNodo1.add(n2);
        mapa.get(n1).add(n2);
        mapa.get(n2).add(n1);
        /// Del mapa obtengo el listado
        /// get(n1) -> listado N1
        /// get(n2) -> agrega N2 alistado N1
    }

    public void printGraph() {
        for (Map.Entry<Node<T>, List<Node<T>>> entry : mapa.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for (Node<T> neighbor : entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public Node<T>[] getNeighbors(Node<T> node) {
    List<Node<T>> neighbors = mapa.get(node);
    return neighbors.toArray(new Node[0]);
}

public void bfs(Node<T> start) {
    Set<Node<T>> visitados = new LinkedHashSet<>();
    Queue<Node<T>> queue = new LinkedList<>();

    visitados.add(start);
    queue.add(start);

    while (!queue.isEmpty()) { //Pra romper, vacia cola
        Node<T> current = queue.poll();
        System.out.println(current.getValue() + " ");
        
        for (Node<T> conocido : getNeighbors(current)) {
            if (!visitados.contains(conocido)) {
                visitados.add(current);
                queue.add(current);

            }
        }
    }
}


}
