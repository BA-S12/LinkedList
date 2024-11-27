package SecondFiveStepsOfProjects.Graph;

public class TestGraph {

    public static void main(String[] args) {
        Graph graph = new Graph(5);

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");


        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "D");
        graph.addEdge("D", "E");
        graph.addEdge("A", "B");

        graph.printGraph();
        graph.displayNumberOfVertices();
        graph.displayInDegree();
        graph.displayOutDegree();
        graph.displaySourceVertices();
        graph.displaySinkVertices();

        graph.printAdjMatrix();
    }
}
