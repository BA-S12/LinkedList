package LinkedList;
public class Stack {
    private SingleLinkedList_Tail singleLinkedList = new SingleLinkedList_Tail();


    public void push(String value) {
        singleLinkedList.insertFirst(value);
        singleLinkedList.displayList();
        System.out.println(singleLinkedList.displayCount());
        System.out.println("---------------");
    }
    public String pop(){
        String poppedValue = singleLinkedList.displayFirst();
        singleLinkedList.deleteFirst();
        singleLinkedList.displayList();
        System.out.println("---------------");

        return poppedValue;
    }
    public String peek(){
        return "the top element: "+singleLinkedList.displayFirst();
    }

    public boolean isEmpty(){
         return singleLinkedList.isEmpty();
    }

    public int size(){
        return singleLinkedList.displayCount();
    }
}
