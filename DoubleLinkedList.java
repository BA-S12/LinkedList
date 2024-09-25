
package team_worke_test;


public class DoubleLinkedList {
   
    DoubleNode head;
    DoubleNode tail;
    

    
    
    //Start Of inserting
        public void insertFirst(String n){
    if(head==null){
        head=tail=new DoubleNode(n);
}

    else if(head==tail){
            
            tail=head;
        head=new DoubleNode(n);
        tail.prev=head;
        head.next=tail;
    }
    else{

   DoubleNode nn=new DoubleNode(n);
   nn.next=head;
   head.prev=nn;
   head=nn;
    }
        }
        
       public void insertLast(String value){
        DoubleNode newNode = new DoubleNode(value);
        if (head == null){
            head = newNode;
            tail = newNode;
        }
        
        else if(head==tail){
        tail=newNode;
        tail.next=null;
        head.next=tail;
        tail.prev=head;
        
        }

        else {
            tail.next = newNode;
            newNode.prev=tail;
            tail = newNode;
        }
    }

          public void insertAfterNode(String n1,String n2){
         if(head==null){System.out.println("Ther is no tail jast head");}
        else if (head==tail){
            if(n1==head.data){
           DoubleNode nn=new DoubleNode(n2);
          nn.next=tail;
          tail.prev=nn;
          nn.prev=head;
          head.next=nn;}
            else{System.out.println("not vailbel");}
        }
        else if(tail.data==n1){
        this.insertLast(n2);
        }
        else{
        DoubleNode crant=head;
 while(crant!=tail){
 if(crant.data==n1){
DoubleNode newNode=new DoubleNode(n2);
newNode.next=crant.next;
crant.next.prev=newNode;
newNode.prev=crant;
crant.next=newNode;
 }

 crant=crant.next;
 
 }
        }
    }
          
           public void insertInBetween(String value,String node1,String node2){
        if (head == null){
            System.out.println("The list is empty");
        }
        else if (head == head.next) {
            System.out.println("The list just have one Node");
        }
        else{
           DoubleNode cur = head;

            while(cur.next != null){

                if (cur.data.equals(node1) && cur.next.data.equals(node2)){
                    DoubleNode newNode = new DoubleNode(value);
                    newNode.next = cur.next;
                    cur.next.prev=newNode;
                    newNode.prev=cur;
                    cur.next = newNode;
                    break;
                }
                cur = cur.next;
            }
            if (cur.next == null){
                System.out.println("The one or both of node is not found");
            }
        }

    }
           ///end Of inserting
    
           
           
           
        //start Of Dleting
            public void deleteFirst(){
 
     if (head==null){
     System.out.println("is not visebel");
     }
     else if(head==tail){
     System.out.println("Thier is jast one element in the lest so we cannot delet");
     }
     else{
   head=head.next;
   head.prev=null;
     }
 
 }
            
            public void deleteLast() {
        if (head == null) {
            System.out.println("The list is empty");
        } else if (head.next == null) {
            head = null;
            tail = null;
        } 
        else {
        tail=tail.prev;
        tail.next=null;
    }
            }   
       
            public void deletNode(String n){
 
   if (head==null){
     System.out.println("Their is no any vairbel");
     }
     else if(head==tail){
     System.out.println("Thier is jast one element in the lest so we cannot delet");
     }
     else if(head.data==n){
     this.deleteFirst();
     }
     else if(tail.data==n){
     this.deleteLast();
     }
     else{
     DoubleNode cur=head.next;
     while(cur!=tail){
     if(cur.data==n){
     cur.prev.next.next.prev=cur.prev;
     cur.prev.next=cur.next;
     break;
     }
     cur=cur.next;
     }
     
     }
    
 }
   public void deletAfterNode(String n){
    if (head==null){
     System.out.println("Their is no any vairbel");
     }
     else if(head==tail){
     System.out.println("Thier is jast one element in the lest so we cannot delet");
     }
     else{
     DoubleNode crant=head.next;
     
     while(crant!=tail){
         if(crant.data==n){
          crant.next.next.prev=crant;   
         crant.next=crant.next.next;
         break;
       
         }
           crant=crant.next;       
 

     
     }

 }

 
 }
   
   private int count(){
   int c=0;
   if(head==null)
   {return c;}
   else if(head==tail)
   {
       c=1;
   return c;
   }
   else{
   DoubleNode cur=head;
   while(cur!=null){
   c++;
     cur=cur.next;
   }
 return c;
   }
   }
            
        public void displayList(){
        if (head == null){
            System.out.println("The list is empty");
            return;
        }
        DoubleNode cur = head;

        while(cur!= null){
            System.out.print(cur.data +" -> ");
            cur = cur.next;
        }
        System.out.println();
    
       }
        
          public void displayFirst(){
        System.out.println( head == null ? "The list is empty" :  head.data);
    }
        
        public void displayLast() {
        if (head == null) {
            System.out.println("The list is empty");
        } else {


            System.out.println("Last node data: " + tail.data);
        }
    }
        
        public void displayCount(){
        System.out.println("The nuber of element in lest is "+this.count());
    }
   
     public void displayPreSussNode(String n){
DoubleNode crant=head;
if((n==tail.data)){
    System.out.println("The pre Node of "+n+" is : "+tail.prev.data);
    System.out.println("Thear is no any suss node after this node");
}
else if(head.data==n){
System.out.println("Thear is no any pre node ");
System.out.println("The suss Node of "+n+" is : "+head.next.data);
}
else{
while(crant!=tail){
if(crant.data==n){
System.out.println("The pre Node of "+n+" is : "+crant.prev.data);
System.out.println("The suss Node of "+n+" is : "+crant.next.data);

}
crant=crant.next;
}
}
} 
      public int computesSum(int n){
        int sum = 0;
        int count = 0;
        DoubleNode cur = head;

        while(cur != tail){
            if (count == n)
                break;
            sum+=Integer.parseInt(cur.data);
            count++;
            cur = cur.next;
        }
        return sum;

    }
}
