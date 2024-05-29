import java.util.HashMap;
import java.util.Map;

public class WeightedGraph<V>{
    private Map<V, Vertex<V>> vertices;
    public WeightedGraph(){
        this.vertices = new HashMap<>();
    }
    public void addVertex(V data){
        vertices.put(data,new Vertex<>(data));
    }
    public Vertex<V> getVertex(V data){
        return vertices.get(data);
    }
    public Map<V, Vertex<V>> getVertices() {
        return vertices;
    }


}

