package SecondFiveStepsOfProjects.Graph;

public class TestGraph {

    public static void main(String[] args) {
        Graph graph = new Graph(5);

        // Add vertices
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");


        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("C", "D");
        graph.addEdge("D", "E");
        graph.addEdge("E", "A");
//        graph.addEdge("E", "E");


        // Print the graph
        graph.printGraph();

        // Display the number of vertices
        graph.displayNumberOfVertices();

        // Display in-degree of each vertex
        graph.displayInDegree();

        // Display out-degree of each vertex
        graph.displayOutDegree();

        // Display source vertices (vertices with no incoming edges)
        graph.displaySourceVertices();

        // Display sink vertices (vertices with no outgoing edges)
        graph.displaySinkVertices();

        // Display all vertices with self-loops
        graph.displayAllSlingVertices();

        // Check if the graph is complete (every vertex has an edge to every other vertex)
        graph.displayCompleteGraph();

        // Check if the graph is strongly connected
        graph.displayConnectGraph();

        // Perform BFS starting from vertex "A"
        graph.BFS("A");

        // Perform DFS starting from vertex "A"
        graph.DFS("A");

        // Print the adjacency matrix representing the graph
        graph.printAnotherFormat();

        // Display the number of edges in the graph
        graph.numberOfEdges();
    }
}
