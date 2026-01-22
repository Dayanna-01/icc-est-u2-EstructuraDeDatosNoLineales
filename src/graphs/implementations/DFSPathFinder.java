package graphs.implementations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import graphs.Graph;
import graphs.PathFinder;
import graphs.PathResult;
import nodes.Node;

public class DFSPathFinder<T> implements PathFinder<T> {

    private Set<Node<T>> visited;
    private Map<Node<T>, Node<T>> parente;
    private List<Node<T>> visitados;
    private boolean found;

    @Override
    public PathResult<T> find(Graph<T> graph, Node<T> start, Node<T> end) {

        visited = new HashSet<>();
        parente = new HashMap<>();
        visitados = new ArrayList<>();
        found = false;

        parente.put(start, null);
        dfs(graph, start, end);

        List<Node<T>> path = new ArrayList<>();
        if (found) {
            for (Node<T> at = end; at != null; at = parente.get(at)) {
                path.add(0, at);
            }
        }

        return new PathResult<>(visitados, path);
    }

    private void dfs(Graph<T> graph, Node<T> current, Node<T> end) {
        if (found) return;

        visited.add(current);
        visitados.add(current); 

        if (current.equals(end)) {
            found = true;
            return;
        }

        for (Node<T> vecino : graph.getNeighbors(current)) {
            if (!visited.contains(vecino)) {
                parente.put(vecino, current);
                dfs(graph, vecino, end);
            }
        }
    }
}
