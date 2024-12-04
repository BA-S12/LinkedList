package SecondFiveStepsOfProjects.Graph;
import FirstFiveStepsOfProject.Queue.Queue;
import java.util.HashMap;
import java.util.Map;

public class Graph {
    private int[][] adjMatrix;
    private Map<String, Integer> vertices;
    private int numOfVertices;
    private int numberOfEdges;
    public Graph(int numberOfVertices){
        this.numOfVertices = numberOfVertices;
        adjMatrix = new int[numberOfVertices][numberOfVertices];
        vertices = new HashMap<>();
    }

    public void addVertex(String vertex){
        if (vertices.size() < numOfVertices){
            vertices.put(vertex,vertices.size());
        }
        else
            System.out.println("You can`t add greeter then: "+ numOfVertices);
    }

    public void addEdge(String source, String target){
        if(vertices.containsKey(source) && vertices.containsKey(target)){
            int sourceIndex = vertices.get(source);
            int targetIndex = vertices.get(target);
            adjMatrix[sourceIndex][targetIndex] = 1;
            numberOfEdges++;
        }
        else {
            System.out.println("One or both vertices is not found");
        }
    }


    public void printGraph(){
        System.out.println("Graph: ");

        for (Map.Entry<String,Integer> entry : vertices.entrySet()){
            String vertex = entry.getKey();
            System.out.print(vertex+ " ==> ");

            int vertexIndex = entry.getValue();
            boolean hasEdge = false;
            for (int i = 0; i <numOfVertices ; i++) {
                if (adjMatrix[vertexIndex][i] == 1){
                    System.out.print(getVertexByIndex(i)+", ");
                    hasEdge = true;
                }
            }
            if (!hasEdge){
                System.out.print("There aren`t edge for this vertex");
            }
            System.out.println();
        }
    }



    public void displayNumberOfVertices(){
        System.out.println("Number of vertices: "+ vertices.size());
    }

    public void displayInDegree(){
        System.out.println("In degree: ");
        for (String vertex : vertices.keySet()){
            int index = vertices.get(vertex);
            int degree = 0;
            for (int i = 0; i <numOfVertices ; i++) {
                degree+= adjMatrix[i][index];
            }
            System.out.println(vertex+ ": "+degree);
        }
    }

    public void displayOutDegree(){
        System.out.println("out degree: ");
        for (String vertex : vertices.keySet()){
            int index = vertices.get(vertex);
            int degree = 0;
            for (int i = 0; i <numOfVertices ; i++) {
                degree+= adjMatrix[index][i];
            }
            System.out.println(vertex+ ": "+degree);
        }
    }

    public void displaySourceVertices(){
        System.out.println("Source Vertices: ");
        for (String vertex: vertices.keySet()){
            int index = vertices.get(vertex);
            boolean isSource = true;

            for (int i = 0; i <numOfVertices ; i++) {
                if (adjMatrix[i][index]== 1){
                    isSource = false;
                    break;
                }
            }
            if (isSource){
                System.out.println(vertex);
            }
        }
    }

    public void displaySinkVertices(){
        System.out.println("Sink Vertices: ");
        for (String vertex: vertices.keySet()){
            int index = vertices.get(vertex);
            boolean isSink = true;

            for (int i = 0; i <numOfVertices ; i++) {
                if (adjMatrix[index][i]== 1){
                    isSink = false;
                    break;
                }
            }
            if (isSink){
                System.out.println(vertex);
            }
        }
    }

    public void displayAllSlingVertices(){
        System.out.println("AllSlingVertices: ");
        for(int j=0;j<=adjMatrix.length-1;j++){
            if(adjMatrix[j][j]==1){
                System.out.print(this.getVertexByIndex(j)+",");
            }
        }
        System.out.println();
    }

    public void displayCompleteGraph() {
        boolean isComplete = true;

        for (int i = 0; i < numOfVertices; i++) {
            for (int j = 0; j < numOfVertices; j++) {
                if (i != j && adjMatrix[i][j] == 0) {
                    isComplete = false;
                    break;
                }
            }
            if (!isComplete) break;
        }

        if (isComplete) {
            System.out.println("The graph is complete.");
        } else {
            System.out.println("The graph is not complete.");
        }
    }


    public void displayConnectedGraph() {
        boolean[] visited = new boolean[numOfVertices];

        dfs(0, visited);

        boolean isConnected = true;
        for (boolean v : visited) {
            if (!v) {
                isConnected = false;
                break;
            }
        }

        if (isConnected) {
            System.out.println("The graph is connected.");
        } else {
            System.out.println("The graph is not connected.");
        }
    }
    public void BFS(String startVertex) {
        if (!vertices.containsKey(startVertex)) {
            System.out.println("Start vertex not found.");
            return;
        }

        boolean[] visited = new boolean[numOfVertices];
        Queue queue = new Queue();
        queue.enqueue(startVertex);

        System.out.println("BFS Traversal:");

        while (!queue.isEmpty()) {
            String currentVertex = queue.peek();
            queue.dequeue();
            int currentIndex = vertices.get(currentVertex);

            if (!visited[currentIndex]) {
                System.out.print(currentVertex + " ");
                visited[currentIndex] = true;

                // Add all unvisited adjacent vertices to the queue
                for (int i = 0; i < numOfVertices; i++) {
                    if (adjMatrix[currentIndex][i] == 1 && !visited[i]) {
                        queue.enqueue(getVertexByIndex(i));
                    }
                }
            }
        }
        System.out.println();
    }

    public void DFS(String startVertex) {
        if (!vertices.containsKey(startVertex)) {
            System.out.println("Start vertex not found.");
            return;
        }

        boolean[] visited = new boolean[numOfVertices];
        System.out.println("DFS Traversal:");
        dfsHelper(startVertex, visited);
        System.out.println();
    }

    public void numberOfEdges(){
        if(this.numberOfEdges==0)
            System.out.println("The graph do not have any Edge");
        else
            System.out.println("The number of Edges is : "+this.numberOfEdges);

    }

    //    Additional methods
    public void printAdjMatrix(){
        System.out.println("Adjacency Matrix: ");

        System.out.print("   ");

        for (String vertex : vertices.keySet()){
            System.out.print(vertex+" ");
        }
        System.out.println();

        for (Map.Entry<String,Integer> rowEntry : vertices.entrySet()){
            System.out.print(rowEntry.getKey()+ " ");
            int rowIndex = rowEntry.getValue();

            for (int i = 0; i <numOfVertices ; i++) {
                System.out.print(adjMatrix[rowIndex][i]+" ");
            }
        System.out.println();

        }
    }

//    Helper Methods
    private String getVertexByIndex(int i){
        for (Map.Entry<String,Integer> entry: vertices.entrySet()){
            if (entry.getValue() == i)
                return entry.getKey();
        }
        return null;
    }
    private void dfs(int index, boolean[] visited) {
        visited[index] = true;
        for (int i = 0; i < numOfVertices; i++) {
            if (adjMatrix[index][i] == 1 && !visited[i]) {
                dfs(i, visited);
            }
        }
    }

    private void dfsHelper(String currentVertex, boolean[] visited) {
        int currentIndex = vertices.get(currentVertex);
        if (visited[currentIndex]) return;

        System.out.print(currentVertex + " ");
        visited[currentIndex] = true;

        for (int i = 0; i < numOfVertices; i++) {
            if (adjMatrix[currentIndex][i] == 1 && !visited[i]) {
                dfsHelper(getVertexByIndex(i), visited);
            }
        }
    }

}
