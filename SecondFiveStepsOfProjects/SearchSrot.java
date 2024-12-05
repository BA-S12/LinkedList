public class Search_Srot {
    
   




//start Linear_Search
    
    public void Linear_Searcharray(int [] list, int iteam){
    boolean found=false;
    
    for(int i:list){
    
       if(i==iteam){
       found=true;
       break;
       } 
       else{
       found=false;
           }
       }
   
    if(found ==true)
    System.out.println("The iteam is found :)");
    else
           System.out.println("The iteam is not found :("); 
       
    }
    
    
    
    
    public void Linear_Searchlinkedlist(DoubleLinekedLista linkedlist,int iteam){
    String iteam_for_search=iteam+"";
    linkedlist.searchNode(iteam_for_search);
    }
    
    //end Linear_Search
    
    //start BinarySearch
    public boolean Binary_Searcharray(int[] list,int iteam,int from,int to){
    int mid;
        if(from>to){
return false;
    }
    else{
        mid=(from+to)/2;
        
        if(list[mid]==iteam)
            return true;
        else if(iteam<list[mid])
             return   Binary_Searcharray(list,iteam,from,mid-1);
        else
            return Binary_Searcharray(list,iteam,mid+1,to);
        
        
        }
    
    }
    
    
    public void Binary_SearchListlist(DoubleLinekedLista linkedlist,int iteam, DoubleNode from,DoubleNode to){
int mid;
  
    
    if(from==to){
        if(from.data.equals(iteam+""))
   System.out.println("The Node is found :)");
        else
          System.out.println("The iteam is not found :(");   
    }
    else{
     
    int i=0;
    DoubleNode cur=from;
    while(cur!=to.prev){
    i++;
    cur=cur.next;
    }
    
  mid=i/2;
     
     DoubleNode cur_for_c=from;
     int j=0;
      while(j<=mid){
    j++;
    cur_for_c=cur_for_c.next;
    }
 
     
    if(cur_for_c.data.equals(iteam+"")){
        System.out.println("The Node is found :)");
    }
    
 
    else if((iteam+"").compareTo(cur_for_c.data)<0){
    cur_for_c=cur_for_c.prev;
     Binary_SearchListlist(linkedlist, iteam,  from, cur_for_c);
    }
    
    else{
        cur_for_c=cur_for_c;
     Binary_SearchListlist(linkedlist, iteam, cur_for_c,to);
    }
 }
       }
    
     //end BinarySearch
    
    
    //start Selection Sort 
    
    public void Selection_Sortarry(int[]list){
    for(int i=0;i<=list.length-1;i++){
        for(int j=i;j<list.length;j++){
           if(list[i]>list[j]){
             int t=list[i];
             list[i]=list[j];
             list[j]=t;
              }
         }
   
     }
    
    }
    
    public void Selection_Sortlinkedlist(DoubleLinekedLista linkedlist){
    for(DoubleNode i=linkedlist.head;i!=linkedlist.tail.next;i=i.next){
        for(DoubleNode j=i;j!=linkedlist.tail.next;j=j.next){
            if(i.data.compareTo(j.data)>=1){
                String t=i.data;
                i.data=j.data;
                j.data=t;
              }
          }
      }    
    }
    
      //end Selection Sort 
    
      //start Bubble Sort 
    
    public void Bubble_Sortarray(int[]list){
    for(int i=0;i<list.length;i++){
    
        for(int j=0;j<(list.length-1);j++){
    
        if(list[j]>list[j+1]){
              int t=list[j];
              list[j]=list[j+1];
              list[j+1]=t; 
            }
        }
    }
    
    } 
    
      
   public void Bubble_Sortlinkedlist(DoubleLinekedLista linkedlist){
    for(DoubleNode i=linkedlist.head;i!=linkedlist.tail.next;i=i.next){
        for(DoubleNode j=linkedlist.head;j!=linkedlist.tail;j=j.next){
             if(j.data.compareTo(j.next.data)>=1){
      
                 String t=j.data;
                 j.data=j.next.data;
                 j.next.data=t;
                 }
              }
          }

      }
    
  //End Bubble Sort 
    

    
}
