package graphs;

import java.util.ArrayList;
import java.util.HashMap;
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
    // List<Node<T>> nodes;

    // 2da forma
    private Map<Node<T>, List<Node<T>>> mapa;

    public Graph() {
        this.mapa = new HashMap<Node<T>, List<Node<T>>>();
    }
    
    // Inserta un vertice o un nodo
    public void addNode(Node<T> node) {
        this.mapa.putIfAbsent(node, new ArrayList<>());
        // mapa { N1: [N2], N2: [N1] }
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
        /// get(n2) -> agrega N2 al listado N1
    }

    public void printGraph() {
        for (Node<T> node : mapa.keySet()) {
            System.out.print(node.getValue() + " -> ");
            for (Node<T> conocido : mapa.get(node)) {
                System.out.print(conocido.getValue() + " ");
            }
        }
    }

    public List<Node<T>> getNeighbors(Node<T> node) {
        return mapa.getOrDefault(node, new ArrayList<>());
    }

    // BFS PARA EL PROYECTO
    public void bfs(Node<T> start) {
        Set<Node<T>> visitados = new LinkedHashSet<>();
        Queue<Node<T>> cola = new LinkedList<>();

        visitados.add(start);
        cola.add(start);

        while (!cola.isEmpty()) {
            Node<T> actual = cola.poll();
            System.out.print(actual.getValue());

            for (Node<T> conocido : getNeighbors(actual)) {
                if (!visitados.contains(conocido)) {
                    visitados.add(conocido);
                    cola.add(conocido);
                }
            }
        }
    }

    // DFS PARA EL PROYECTO
    public void dfs(Node<T> start) {
        Set<Node<T>> visitados = new LinkedHashSet<>();
        dfsRecursive(start, visitados);
    }

    private void dfsRecursive(Node<T> actual, Set<Node<T>> visitados) {
        visitados.add(actual);
        System.out.print(actual.getValue());

        for (Node<T> conocido : getNeighbors(actual)) {
            if (!visitados.contains(conocido)) {
                dfsRecursive(conocido, visitados);
            }
        }
    }


    public void addConocido(Node<T> a, Node<T> b) {
        if (!mapa.containsKey(a)) {
            mapa.put(a, new ArrayList<>());
        }
        if (!mapa.containsKey(b)) {
            mapa.put(b, new ArrayList<>());
        }
        mapa.get(a).add(b);
        mapa.get(b).add(a);
    }
}
