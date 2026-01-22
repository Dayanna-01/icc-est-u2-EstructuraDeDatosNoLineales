package graphs.implementations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import graphs.Graph;
import graphs.PathFinder;
import graphs.PathResult;
import nodes.Node;

public class BFSPathFinder<T> implements PathFinder<T> {
    @Override
    public PathResult<T> find(Graph<T> graph, Node<T> start, Node<T> end) {
        Queue<Node<T>> queue = new LinkedList<>();
        Set<Node<T>> visited = new HashSet<>();

        Map<Node<T>, Node<T>> parente = new HashMap<>();
        List<Node<T>> visitados = new ArrayList<>();

        queue.add(start);
        visited.add(start);
        parente.put(start, null);

        while (!queue.isEmpty()) {
            Node<T> current = queue.poll();
            visitados.add(current);

            if (current.equals(end)) {
                List<Node<T>> path = new ArrayList<>();
                for (Node<T> at = end; at != null; at = parente.get(at)) {
                    path.add(0, at);
                }
                return new PathResult<>(visitados, path);
            }

            for (Node<T> conocidos : graph.getNeighbors(current)) {
                if (!visited.contains(conocidos)) {
                    visited.add(conocidos);
                    queue.add(conocidos);
                    parente.put(conocidos, current);
                }
            }        
        }
        return new PathResult<>(visitados, List.of());
    }

    // Construye la ruta
    private List<Node<T>> buildPath(Map<Node<T>, Node<T>> parente, Node<T> end) {
        List<Node<T>> path = new ArrayList<>();
        for (Node<T> at = end; at != null; at = parente.get(at)) {
            path.add(0, at);
        }
        Collections.reverse(path);
        return path;
    }

    
}


