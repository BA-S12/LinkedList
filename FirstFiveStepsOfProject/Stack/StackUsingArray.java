package FirstFiveStepsOfProject.Stack;

public class StackUsingArray {
    private int[] stack;
    private int size;
    private int capacity;
    private int top;

    public StackUsingArray(int capacity){
        this.capacity = capacity;
        this.stack= new int[capacity];
        this.size = 0;
        this.top = -1;
    }

    private void insertFirst(int value){
        if (isFull()){
            System.out.println("The stack is full ");
            return;
        }

        for (int i = size; i > 0 ; i--) {
            stack[i] = stack[i-1];
        }
        stack[0] = value;
        size++; top++;
    }

    private void insertLast(int value){
        if (isFull()){
            System.out.println("the stack is full");
            return;
        }
        stack[++top] = value;
        size++;
    }

    public void push(int value){
        insertFirst(value);
    }

    private int deleteFirst(){
        int poppedValue = stack[0];
        if (isEmpty())
            System.out.println("The stack is empty");
        else {
            for (int i = 0; i < size - 1; i++) {
                stack[i] = stack[i + 1];
            }
            size--;
            top--;
        }
         return poppedValue;

    }


    private int deleteLast(){
        int poppedValue = stack[top];
        if (isEmpty())
            System.out.println("The stack is full");

        else{
            size--; top--;
        }
        return poppedValue;
    }

    public int pop(){
       return deleteLast();
    }


    //---------

    public void displayList(){
        if (isEmpty()){
            System.out.println("The stack is empty");
            return;
        }
        for (int i = 0; i <size ; i++) {
            System.out.print(stack[i]+" ");
        }
        System.out.println();
    }

    public void displayFirst(){
        if (isEmpty()){
            System.out.println("The stack is empty");
            return;
        }
        System.out.println("the first element is: "+stack[0]);
    }

    public void displayTail(){
        if (isEmpty()){
            System.out.println("The stack is empty");
            return;
        }
        System.out.println("The last element is: "+ stack[top]);
    }

    public void displayCount(){
        System.out.println(count());
    }

    public void peek(){
        if (isEmpty()){
            System.out.println("The stack is empty");
            return;
        }
        System.out.println("Peek: " + stack[top]);
    }

    public int count() {
        return size;
    }
    public boolean isFull(){
        return size == capacity;
    }
    public boolean isEmpty(){
        return  size == 0;
    }
}
