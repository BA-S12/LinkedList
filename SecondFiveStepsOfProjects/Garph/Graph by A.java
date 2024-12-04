public class Graph {
 private String[][] adjMatrix;
private int virtex;
private int numberofEdges;
private Queue_LL q;
   
 
 public Graph(int virtex){
 this.virtex=virtex;
 adjMatrix=new String[virtex+1][virtex+1];
 for(int i=1;i<adjMatrix.length;i++){
     adjMatrix[0][i]=("v"+i);}
 
  for(int i=1;i<adjMatrix.length;i++){
     adjMatrix[i][0]=("v"+i);}
  
  adjMatrix[0][0]="-";
  
  for(int r=1;r<adjMatrix.length;r++){
for(int c=1;c<adjMatrix[r].length;c++){
    adjMatrix[r][c]="-";
}

}
 
 }
 
public void addEdge(String source, String target){
    int row=0;
    int col=0;
    
    for(int i=1;i<adjMatrix.length;i++){
    if(adjMatrix[i][0].equals(source)){
    row=i;
    }
    else{}
    }
    
     for(int i=1;i<adjMatrix.length;i++){
    if(adjMatrix[0][i].equals(target)){
    col=i;
    }
    else{}
    }
     
    if((row!=0)&&(col!=0)){
    adjMatrix[row][col]="T";
    numberofEdges++;
    }
    else{
        System.out.println("One or both vertices is not found");
    }
}

public void printgraph(){

   for(int i=1;i<=adjMatrix.length-1;i++){
   System.out.print(adjMatrix[i][0]+" ==> ");
   for(int j=1;j<=adjMatrix.length-1;j++){
       if(adjMatrix[i][j]!=null){
           if(adjMatrix[i][j].equals("T"))
      System.out.print(adjMatrix[0][j]+" , ");
       }
       else{}}
System.out.println();
   }
   
   System.out.println();

}

public void print(){
    
    System.out.println();
for(int r=0;r<adjMatrix.length;r++){
for(int c=0;c<adjMatrix[r].length;c++){
    System.out.print(adjMatrix[r][c]+" ");
}
System.out.println();
}
System.out.println();
}


public void DisplayAllSlingVertices(){
   System.out.println("AllSlingVertices : ");
   int cont=0;
for(int i=1;i<=adjMatrix.length-1;i++){
    cont=0;
   for(int j=1;j<=adjMatrix.length-1;j++){
       if(adjMatrix[i][j]!=null){
           if(adjMatrix[i][j].equals("T"))
               cont++;   
       }
       else{}
   }
   if(cont>0)
       System.out.print(adjMatrix[i][0]+" , ");
   else{}
   }
      System.out.println();

}
 



public void  DisplayConnectGraph(){
boolean conect=false;
int row=1;
int col=row+1;

while((row!=adjMatrix.length)&&(col!=adjMatrix.length)){
if(adjMatrix[row][col].equals("T")){
conect=true;
row++;
col++;
}
else if((row==adjMatrix.length-1)&&(adjMatrix[row][1].equals("T"))){
conect=true;
break;
}
else{conect=false;
break;
}
}
if(conect==true)
    System.out.println("The graph is  conect");
else
    System.out.println("The graph is not conect");


}

public void DisplayCompleteGraph(){
boolean complet=false;

for(int r=0;r<adjMatrix.length;r++){
for(int c=0;c<adjMatrix[r].length;c++){
  if(adjMatrix[r][c].equals("T"))
      complet=true;
  else
      break;
}

}
if(complet==true)
    System.out.println("The graph is  conect");
else
    System.out.println("The graph is not conect");

}






public void DFS(){
//////

}

public void BFS(){
    System.out.print("The BFS is:"+" ");
    q=new Queue_LL();
   for(int i=1;i<=adjMatrix.length-1;i++){
       if((q.searchqueue(adjMatrix[i][0])==false)){
   q.enqueue(adjMatrix[i][0]);

       }
       else{}
   for(int j=1;j<=adjMatrix.length-1;j++){
       if(adjMatrix[i][j]!=null){
           if(adjMatrix[i][j].equals("T")&&q.searchqueue(adjMatrix[i][j])==false)
       q.enqueue(adjMatrix[0][j]);
       }
       else{}}
   System.out.print(q.gettop()+" ");
   q.dequeue();
   }
   
   System.out.println();
}

public void numberofEdges(){
if(this.numberofEdges==0)
    System.out.println("The graph do not have any Edge");
else
    System.out.println("The number of Edges is : "+this.numberofEdges);

}


public void BFS(String Virtex){


for(int i=0;i<this.adjMatrix.length-1;i++){
    if((this.getVertexByIndex(i)==Virtex)&&(q.search(Virtex)==false)){
q.Sp_enqueue(Virtex);
   for(int j=0;j<this.adjMatrix[i].length;j++){
    if((this.adjMatrix[i][j]==1)&&q.search(this.getVertexByIndex(j))==false){
    q.Sp_enqueue(this.getVertexByIndex(j));
    }
    
    
    }
}
 


}

if(q.size()==0){

    

}
else{

System.out.print(q.getTop()+",");


q.Sp_dequeue();
BFS(q.getTop());

}
}
         
}
