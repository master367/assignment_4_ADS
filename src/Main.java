public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();

        graph.addVertex("damir");
        graph.addVertex("didar");
        graph.addVertex("merey");
        graph.addVertex("ilyas");
        graph.addVertex("alibi");

        System.out.println(graph.getVertex("merey"));
        System.out.println(graph.getVertices());

        graph.addEdge("damir","merey",6);
        graph.addEdge("damir","damir",4);
        graph.addEdge("merey","ilyas",2);
        graph.addEdge("ilyas","damir",1);
        graph.addEdge("ilyas","alibi",6);

        Search<String> bfs = new BreadthFirstSearch<>();
        Vertex<String> start = graph.getVertex("damir");
        Vertex<String> goal = graph.getVertex("alibi");

        System.out.println("BFS path: " + bfs.search(start, goal));
    }
}