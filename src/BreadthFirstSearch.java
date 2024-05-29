import java.util.*;

public class BreadthFirstSearch<V> implements Search<V> {
    @Override
    public List<V> search(Vertex<V> start, Vertex<V> goal) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        Map<Vertex<V>, Vertex<V>> previous = new HashMap<>();
        Set<Vertex<V>> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();

            if (current.equals(goal)) {
                return constructPath(previous, goal);
            }

            for (Vertex<V> neighbor : current.getAdjacentVertices().keySet()) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    previous.put(neighbor, current);
                }
            }
        }
        return Collections.emptyList();
    }

    private List<V> constructPath(Map<Vertex<V>, Vertex<V>> previous, Vertex<V> goal) {
        List<V> path = new LinkedList<>();
        for (Vertex<V> at = goal; at != null; at = previous.get(at)) {
            path.add(0, at.getData());
        }
        return path;
    }
}
