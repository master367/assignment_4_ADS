import java.util.List;

public interface Search<V>{
    List<V> search(Vertex<V> start, Vertex<V> goal);
}

