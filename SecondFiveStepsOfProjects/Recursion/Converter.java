package SecondFiveStepsOfProjects.Recursion;


import FirstFiveStepsOfProject.DoubleLinkedList.DoubleLinkedList_Tail;
import FirstFiveStepsOfProject.DoubleLinkedList.DoubleNode;


public class Converter {
   private DoubleLinkedList_Tail list = new DoubleLinkedList_Tail();

    //Method convert from linkedList to array in DoubleLinkedList
    public String[] ConvertLinkedListToArray(DoubleLinkedList_Tail list){
        String[] a;
        if(list.count()==0)
            return a=null;
        else{

            a=new String[list.count()];
            DoubleNode cur=list.head;
            for(int i=0;i<a.length;i++){
                a[i]=cur.data;
                cur=cur.next;
            }

            return a;
        }


    }


    public DoubleLinkedList_Tail ConvertArrayToLinkedList(String[] a){
        if(a[0]==null)
            return list=null;
        else{
            for(String i:a){
                if(i==null)
                    break;
                else
                    list.insertLast(i);}
            return list;
        }
    }

}


