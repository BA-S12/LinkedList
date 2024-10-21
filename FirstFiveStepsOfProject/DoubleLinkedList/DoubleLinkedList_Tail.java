package FirstFiveStepsOfProject.DoubleLinkedList;

public class DoubleLinkedList_Tail {
    DoubleNode head;
    DoubleNode tail;

//  start of Insert methods

    public void insertFirst(String value){
        DoubleNode newNode = new DoubleNode(value);
        if (head == null){
            head =newNode;
            tail = newNode;
        }
        else{
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertLast(String value){
        DoubleNode newNode = new DoubleNode(value);
        if (head == null){
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev =tail;
            tail = newNode;
        }
    }

    public void insertAfterNode(String data, String value) {
        if (head == null) {
            System.out.println("The list is empty");
        } else {
            DoubleNode cur = head;
            while (cur != null && !cur.data.equals(data)) {
                cur = cur.next;
            }

            if (cur != null) {
                DoubleNode newNode = new DoubleNode(value);
                newNode.next = cur.next;
                if (cur.next != null) {
                    cur.next.prev = newNode;
                }
                cur.next = newNode;
                newNode.prev = cur;
                if (cur == tail) {
                    tail = newNode;
                }
            } else {
                System.out.println("Node with data '" + data + "' not found.");
            }
        }
    }



    public void insertInBetween(String value, String node1, String node2) {
        if (head == null) {
            System.out.println("The list is empty");
        } else if (head == tail) {
            System.out.println("The list has only one node");
        } else {
            DoubleNode cur = head;
            while (cur != null && cur.next != null) {
                if (cur.data.equals(node1) && cur.next.data.equals(node2)) {
                    DoubleNode newNode = new DoubleNode(value);
                    newNode.next = cur.next;
                    newNode.prev = cur;
                    cur.next.prev = newNode;
                    cur.next = newNode;
                    return;
                }
                cur = cur.next;
            }
            System.out.println("Nodes not found.");
        }
    }

    //    Ends of inserts Methods
//    Start of deletes Methods
    public void deleteFirst() {
        if (head == null) {
            System.out.println("The list is empty");
        } else {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
        }
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("The list is empty");
        } else if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
        }
    }


    public void deleteNode(String value) {
        if (head == null) {
            System.out.println("The list is empty");
        } else if (head.data.equals(value)) {
            deleteFirst();
        } else {
            DoubleNode cur = head;
            while (cur != null) {
                if (cur.data.equals(value)) {
                    if (cur == tail) {
                        deleteLast();
                    } else {
                        cur.prev.next = cur.next;
                        if (cur.next != null) {
                            cur.next.prev = cur.prev;
                        }
                    }
                    return;
                }
                cur = cur.next;
            }
            System.out.println("Node with value " + value + " not found");
        }
    }


    public void deleteAfterNode(String value) {
        if (head == null) {
            System.out.println("The list is empty");
        } else {
            DoubleNode cur = head;
            while (cur != null) {
                if (cur.data.equals(value)) {
                    if (cur.next != null) {
                        deleteNode(cur.next.data);
                    } else {
                        System.out.println("No node exists after the selected node.");
                    }
                    return;
                }
                cur = cur.next;
            }
            System.out.println("Node with value '" + value + "' not found.");
        }
    }



//    Ends of deletes Methods
//   count methods

    public int count(){
        if (head == null){
            return 0;
        }
        DoubleNode cur = head;
        int length = 0;
        while(cur.next != null){
            length++;
            cur = cur.next;
        }
        return length+1;
    }
//   count methods
        public void computesSum(int n){
    if (head == null){
        System.out.println("the list is empty");
    }
    else if (n>displayCount()){
        System.out.println("the number entered is smallest then size");
    }
    else if (n<=0){
//           throw new InputMismatchException("You must enter number greeter then 0");
        System.out.println("You must enter number greeter then 0");
    }
    else{
        int sum = 0;
        int count = 0;
        DoubleNode cur = head;

        while(cur != null){
            if (count == n)
                break;
            sum+=Integer.parseInt(cur.data);
            count++;
            cur = cur.next;
        }
        System.out.println(sum);
    }


}
//    Search methods

    public void searchNode(String data){
        if (head == null){
            System.out.println("List is empty");
        }
        else{
            if (head.data.equals(data))
                System.out.println("The node founded (:");

            else {
                DoubleNode cur = head;
                boolean found = false;
                while(cur != null){
                    if (cur.data.equals(data)) {
                        System.out.println("The node founded (:");
                        found = true;
                        break;
                    }
                    cur = cur.next;
                }
                if (!found)
                    System.out.println("The node not found ):");
            }

        }
    }

//    Search methods

    //    Start of Displays methods
    public void displayList(){
        if (head == null){
            System.out.println("The list is empty");
            return;
        }
        DoubleNode cur = head;

        while(cur != null){
            System.out.print(cur.data +" -> ");
            cur = cur.next;
        }
        System.out.println();
    }


    public void displayFirst(){
        if (head == null) {
            System.out.println("The list is empty");
        } else {


            System.out.println("First node data: " + head.data);
        }
    }

    public void displayLast() {
        if (head == null) {
            System.out.println("The list is empty");
        } else {


            System.out.println("Last node data: " + tail.data);
        }
    }



    public int displayCount(){
        return count();
    }


    public void displayPreSussNode(String value) {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }

        if (head.data.equals(value)) {
            System.out.println("There is no previous node");
            if (head.next != null) {
                System.out.println("The node after the selected node is: " + head.next.data);
            } else {
                System.out.println("There is no node after the selected node");
            }
            return;
        }

        DoubleNode cur = head;
        while (cur.next != null) {
            if (cur.next.data.equals(value)) {
                System.out.println("The node before the selected node is: " + cur.data);
                if (cur.next.next != null) {
                    System.out.println("The node after the selected node is: " + cur.next.next.data);
                } else {
                    System.out.println("There isn't a node after the node you selected");
                }
                return;
            }
            cur = cur.next;
        }

        System.out.println("The node with the given value was not found in the list.");
    }


    //    Ends of Displays methods


}

