package FirstFiveStepsOfProject.Queue;

import FirstFiveStepsOfProject.SingleLinkedList.SingleLinkedList_Tail;

public class Queue {

    private SingleLinkedList_Tail linkedList = new SingleLinkedList_Tail();

    public void enqueue(String value){
        linkedList.insertLast(value);
        linkedList.displayList();
        System.out.println(linkedList.displayCount());
        System.out.println("---------------");
    }

    public void dequeue(){
        linkedList.deleteFirst();
        linkedList.displayList();
        System.out.println(linkedList.displayCount());
        System.out.println("---------------");
    }

    public String peek(){
         return linkedList.displayFirst();
    }

    public boolean isEmpty(){
        return linkedList.isEmpty();
    }

    public int size(){
        return linkedList.displayCount();
    }

    public void reverseQueue(){
        String reverseQueue[]=new String[this.size()];
        for(int i=0;i<reverseQueue.length;i++){
            reverseQueue[i]=linkedList.head.data;
            linkedList.deleteFirst();

        }
        for(int i=0;i<reverseQueue.length;i++){
            linkedList.insertFirst(reverseQueue[i]); // we use insertFirst to be opposite the enqueue // if we use insertFirst in enqueue it`s must use insertLast
        }
        linkedList.displayList();
    }
}
