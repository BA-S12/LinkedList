package LinkedList;

public class SingleLinkedList_Tail {
    SingleNode head;
    SingleNode tail;

//  start of Insert methods

    public void insertFirst(String value){
        SingleNode newNode = new SingleNode(value);
        if (head == null){
            head =newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertLast(String value){
        SingleNode newNode = new SingleNode(value);
        if (head == null){
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void insertAfterNode(String data, String value) {
        if (head == null) {
            System.out.println("The list is Empty ):");
        } else {
            SingleNode cur = head;


            while (cur != null && !cur.data.equals(data)) {
                cur = cur.next;
            }

            // If we found the node, insert the new node after it
            if (cur != null) {
                SingleNode newNode = new SingleNode(value);
                newNode.next = cur.next; // Point the new node to the next node
                cur.next = newNode; // Link the current node to the new node
            } else {
                System.out.println("Node with data '" + data + "' not found.");
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
            SingleNode cur = head;

            while(cur.next != null){

                if (cur.data.equals(node1) && cur.next.data.equals(node2)){
                    SingleNode newNode = new SingleNode(value);
                    newNode.next = cur.next;
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

    //    Ends of inserts Methods
//    Start of deletes Methods
    public void deleteFirst(){
        if (head ==null){
            System.out.println("The list is empty");
        }
        else {
            head = head.next;
        }
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("The list is empty");
        } else if (head.next == null) {
            head = null;
            tail = null;
        } else {
            SingleNode cur = head;
            while (cur.next.next != null) {
                cur = cur.next;
            }
            cur.next = null;
            tail = cur;
        }
    }


    public void deleteNode(String value) {
        if (head == null) {
            System.out.println("The list is empty");
        } else if (head.data.equals(value)) {
            deleteFirst();
        } else {
            SingleNode cur = head;
            boolean found = false;
            while (cur.next != null) {
                if (cur.next.data.equals(value)) {
                    cur.next = cur.next.next;
                    found = true;
                    if (cur.next == null) {
                        tail = cur;
                    }
                    break;
                }
                cur = cur.next;
            }

            if (!found) {
                System.out.println("Node with value " + value + " not found");
            }
        }
    }



    public void deleteAfterNode(String value) {
        if (head == null) {
            System.out.println("The list is empty");
        } else {
            SingleNode cur = head;
            boolean found = false;

            while (cur != null) {
                if (cur.data.equals(value)) {
                    if (cur.next != null) {
                        if (cur.next.next == null) {
                            tail = cur;
                        }
                        cur.next = cur.next.next;
                        found = true;
                    } else {
                        System.out.println("There is no node after the node you selected");
                        found = true;
                    }
                    break;
                }
                cur = cur.next;
            }

            if (!found) {
                System.out.println("Node with value " + value + " not found");
            }
        }
    }



//    Ends of deletes Methods
//   count methods

    public int count(){
        if (head == null){
            return 0;
        }
        SingleNode cur = head;
        int length = 0;
        while(cur.next != null){
            length++;
            cur = cur.next;
        }
        return length+1;
    }
//   count methods

//    Search methods

    public void searchNode(String data){
        if (head == null){
            System.out.println("List is empty");
        }
        else{
            if (head.data.equals(data))
                System.out.println("The node founded (:");

            else {
                SingleNode cur = head;
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
        SingleNode cur = head;

        while(cur != null){
            System.out.print(cur.data +" -> ");
            cur = cur.next;
        }
        System.out.println();
    }


    public String displayFirst(){
        return head == null ? "The list is empty" :  head.data;
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

        SingleNode cur = head;
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

