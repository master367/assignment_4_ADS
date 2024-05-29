import java.util.*;

public class DijkstraSearch<V> implements Search<V> {
    @Override
    public List<V> search(Vertex<V> start, Vertex<V> goal) {
        Map<Vertex<V>, Double> distances = new HashMap<>();
        Map<Vertex<V>, Vertex<V>> previous = new HashMap<>();
        PriorityQueue<Vertex<V>> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        Set<Vertex<V>> visited = new HashSet<>();

        for (Vertex<V> vertex : start.getAdjacentVertices().keySet()) {
            distances.put(vertex, Double.MAX_VALUE);
        }
        distances.put(start, 0.0);
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            visited.add(current);

            if (current.equals(goal)) {
                return constructPath(previous, goal);
            }

            for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double weight = entry.getValue();

                if (visited.contains(neighbor)) continue;

                double newDist = distances.get(current) + weight;
                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    previous.put(neighbor, current);
                    queue.add(neighbor);
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
