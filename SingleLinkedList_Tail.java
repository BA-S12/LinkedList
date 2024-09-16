public class SSL_Tail {
  
     Node head;
    
    Node tail;
    
SSL_Tail(){

    head=tail;

}
    


// inserting  
    public void insert_first(String n){
    if(head==null){
        head=tail=new Node(n);
}

    else if(head==tail){
            head.next=tail;
        head=new Node(n);
    }
    else{

        tail.next=null;
   Node nn=new Node(n);
   nn.next=head;
   head=nn;
    }
    
    }
    public void insert_Last(String n){
        if(head==null){System.out.println("Ther is no tail jast head");}
        else if (head==tail){
        tail=new Node(n);
        head.next=tail;
        }
        else{
    Node nn=new Node(n);
    tail.next=nn;
   tail=nn;
        }
    }
    
    public void insert_After_Node(String n1,String n2){
         if(head==null){System.out.println("Ther is no tail jast head");}
        else if (head==tail){
            if(n1==head.data){
            Node nn=new Node(n2);
          nn.next=tail;
          head.next=nn;}
            else{System.out.println("not vailbel");}
        }
        else if(tail.data==n1){
        this.insert_Last(n2);
        }
        else{
           Node crant=head.next;
 while(crant!=tail){
 if(crant.data==n1){
 Node nn=new Node(n2);
 nn.next=crant.next;
 crant.next=nn;
 }

 crant=crant.next;
 
 }
        }
    }
    
    public void insert_In_Between(String n1,String n2,String n3) {  
        if(head==null){
    System.out.println("not vailbel");
        }

    else if(head==tail){
         System.out.println("not vaibel");
    }
    else{
           Node crant=head.next;
 while(crant!=null){
 if((crant.data==n1)&&(crant.next.data==n2)){
 Node nn=new Node(n3);
 nn.next=crant.next;
crant.next=nn;
 }

 crant=crant.next;
    }
    }
    
}
///inserting
///////////////////////////////    




//deleteing    
    
 public void Delet_first(){
 
     if (head==null){
     System.out.println("is not visebel");
     }
     else if(head==tail){
     System.out.println("Thier is jast one element in the lest so we cannot delet");
     }
     else{
     Node nh=head.next;
     head=null;
     head=nh;
     }
 
 }
 
 
 public void Delet_last(){
      if (head==null){
     System.out.println("Their is no tail");
     }
     else if(head==tail){
     System.out.println("Thier is jast one element in the lest so we cannot delet");
     }
     else{
         Node nt;
         Node crant=head.next;
   while(crant!=null){
   if(crant.next==tail){
   nt=crant;
   tail=null;
   tail=nt;
   tail.next=null;        
   }
  crant=crant.next;
   }
     }
 
 
 }
 
 

 public void Delet_node(String n){
 
   if (head==null){
     System.out.println("Their is no any vairbel");
     }
     else if(head==tail){
     System.out.println("Thier is jast one element in the lest so we cannot delet");
     }
     else{
     Node crant=head;
     
     while(crant!=tail){
         if(crant.next.data==n){
         crant.next=crant.next.next;
         }
             
  crant=crant.next;
           
     }
 
 }
    
 }
 
 
 public void Delet_after_node(String n){
    if (head==null){
     System.out.println("Their is no any vairbel");
     }
     else if(head==tail){
     System.out.println("Thier is jast one element in the lest so we cannot delet");
     }
     else{
     Node crant=head.next;
     
     while(crant!=tail){
         if(crant.data==n){
         crant.next=crant.next.next;
         }
             
  crant=crant.next;
           
     }
 
 }
 
 
 }
 
 ///deleting
 ///////////////////////
 
 
 
 
 
 
 
 //coumnt
    public int count(){
    int n=0;
Node crant=head;
while(crant!=null){
n++;
crant=crant.next;
}
  
  return n;  
    }
//////////////////////////////////
    
  

//Display    
 public void Display_list(){
 Node crant=head;
 
 while(crant!=null){
 
  System.out.println(crant.data);
 crant=crant.next;
 
 }
 
 }  


public void Display_frist(){
System.out.println(head.data);
}


public void Display_last(){
System.out.println(tail.data);
}

public void Display_count(){
System.out.println(this.count());
}


public void Display_pre_suss_node(String n){
Node crant=head;
if((n==tail.data)){
    System.out.println("The pre Node of "+n+" is : "+crant.data);
    System.out.println("The suss Node of "+n+" is : "+tail.next);
}
else if(head.data==n){
System.out.println("The pre Node of "+n+" is : "+"Nothing");
System.out.println("The suss Node of "+n+" is : "+head.next.data);
}
else{
while(crant!=tail){
if(crant.next.data==n){
System.out.println("The pre Node of "+n+" is : "+crant.data);
System.out.println("The suss Node of "+n+" is : "+crant.next.next.data);

}
crant=crant.next;
}
}
}
///Displaying 
////////////////////////



////sarech////

public void Search_Node(String n){
Node crant=head;
boolean i=true;
if(i==true){
while(crant!=null){

if(crant.data==n){
System.out.println("The node is found ");
i=true;
break;
}

crant=crant.next;
i=false;
}}
if(i==false){
System.out.println("The node is not found");
}
}
    
}
