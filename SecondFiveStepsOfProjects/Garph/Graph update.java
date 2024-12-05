import java.util.HashMap;
import java.util.Map;

public class Graph {
    private int[][] adjMatrix;
    private Map<String, Integer> vertices;
    private int numOfVertices;
    private int numberofEdges;
    private boolean connect;
    private boolean complet;
    private Queue q=new Queue();
    private String[] v=new String[this.numOfVertices];

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
            numberofEdges++;
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
    
    
    
    
    
   public void DisplayAllSlingVertices(){
   System.out.println("AllSlingVertices : ");
   

 
   for(int j=0;j<=adjMatrix.length-1;j++){
       if(adjMatrix[j][j]==1){
        
           System.out.print(this.getVertexByIndex(j)+" , ");    
       }
       else{}
   }
  System.out.println();
   }
 


 



public void  DisplayCompleteGraph(){
 complet=false;

if(this.connect==false){
System.out.println("The graph is not connected so is not complet");
}
else{

for(int c=0;c<adjMatrix.length;c++){
  if(adjMatrix[c][c]==(1))
      complet=true;
  else
      break;
}
if(complet==true)
  System.out.println("The graph is  Complet");
else
    System.out.println("The graph is not Complet"); 
}


}

public void DisplayConnectGraph(){
 connect=false;

for(int r=0;r<adjMatrix.length;r++){
for(int c=0;c<adjMatrix[r].length;c++){
  if(adjMatrix[r][c]==(1))
      connect=true;
  else
      break;
}

}
if(connect==true){
    System.out.println("The graph is  Connect");
}
else{
    System.out.println("The graph is not Connect");}

}






public void DFS(){
//////

}

public void BFS(String Virtex){
////
    
}
   

    

   
   



public void numberofEdges(){
if(this.numberofEdges==0)
    System.out.println("The graph do not have any Edge");
else
    System.out.println("The number of Edges is : "+this.numberofEdges);

}
         



//    Helper Methods
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
    private String getVertexByIndex(int i){
        for (Map.Entry<String,Integer> entry: vertices.entrySet()){
            if (entry.getValue() == i)
                return entry.getKey();
        }
        return null;
    }
    
    
    

}
