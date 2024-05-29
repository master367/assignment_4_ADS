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

        graph.addEdge("damir","didar",1);
        graph.addEdge("damir","merey",4);
        graph.addEdge("didar","merey",2);
        graph.addEdge("didar","ilyas",5);
        graph.addEdge("merey","ilyas",1);
        graph.addEdge("ilyas","alibi",3);

        Search<String> bfs = new BreadthFirstSearch<>();
        Vertex<String> start = graph.getVertex("damir");
        Vertex<String> goal = graph.getVertex("alibi");
        System.out.println("BFS path: " + bfs.search(start, goal));


        Search<String> dijkstra = new DijkstraSearch<>();
        Vertex<String> startDj = graph.getVertex("damir");
        Vertex<String> goalDj = graph.getVertex("didar");
        System.out.println("Dijkstra path: " + dijkstra.search(startDj, goalDj));
    }
}

