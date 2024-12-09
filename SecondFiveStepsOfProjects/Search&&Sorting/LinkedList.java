package SecondFiveStepsOfProjects.SerachAndSorting;

import FirstFiveStepsOfProject.DoubleLinkedList.DoubleLinkedList_Tail;
import FirstFiveStepsOfProject.DoubleLinkedList.DoubleNode;

public class LinkedList {
        private void swap(DoubleNode node1, DoubleNode node2) {
            String temp = node1.data;
            node1.data = node2.data;
            node2.data = temp;
        }

        public void linearSearch(DoubleLinkedList_Tail linkedList, int item){
            String item_for_search = item + "";
            linkedList.searchNode(item_for_search);
        }

        public void binarySearch(DoubleLinkedList_Tail linkedList, int item, DoubleNode from, DoubleNode to){
            int mid;
            if(from == to){
                if(from.data.equals(item + ""))
                    System.out.println("The Node is found :)");
                else
                    System.out.println("The item is not found :(");
            }
            else {
                int i = 0;
                DoubleNode cur = from;
                while(cur != to.prev){
                    i++;
                    cur = cur.next;
                }

                mid = i / 2;

                DoubleNode cur_for_c = from;
                int j = 0;
                while(j <= mid){
                    j++;
                    cur_for_c = cur_for_c.next;
                }

                if(cur_for_c.data.equals(item + "")){
                    System.out.println("The Node is found :)");
                }
                else if((item + "").compareTo(cur_for_c.data) < 0){
                    cur_for_c = cur_for_c.prev;
                    binarySearch(linkedList, item, from, cur_for_c);
                }
                else {
                    cur_for_c = cur_for_c;
                    binarySearch(linkedList, item, cur_for_c, to);
                }
            }
        }

        public void selectionSort(DoubleLinkedList_Tail linkedList){
            for(DoubleNode i = linkedList.head; i != linkedList.tail.next; i = i.next){
                for(DoubleNode j = i; j != linkedList.tail.next; j = j.next){
                    if(i.data.compareTo(j.data) >= 1){
                        swap(i, j);
                    }
                }
            }
        }

        public void bubbleSort(DoubleLinkedList_Tail linkedList){
            for(DoubleNode i = linkedList.head; i != linkedList.tail.next; i = i.next){
                for(DoubleNode j = linkedList.head; j != linkedList.tail; j = j.next){
                    if(j.data.compareTo(j.next.data) >= 1){
                        swap(j, j.next);
                    }
                }
            }
        }

    public void insertionSort(DoubleLinkedList_Tail linkedList) {
        if (linkedList.head == null) {
            return;
        }

        DoubleNode cur = linkedList.head.next;
        while (cur != null) {
            DoubleNode key = cur;
            DoubleNode prev = cur.prev;


            while (prev != null && prev.data.compareTo(key.data) > 0) {
                prev = prev.prev;
            }

            if (prev != cur.prev) {

                if (key.next != null) {
                    key.next.prev = key.prev;
                }
                if (key.prev != null) {
                    key.prev.next = key.next;
                }

                if (prev == null) {
                    key.next = linkedList.head;
                    linkedList.head.prev = key;
                    linkedList.head = key;
                } else {

                    key.prev = prev;
                    key.next = prev.next;
                    if (prev.next != null) {
                        prev.next.prev = key;
                    }
                    prev.next = key;
                }
            }

            cur = cur.next;
        }
    }



    public void mergeSort(DoubleLinkedList_Tail linkedList) {
        if (linkedList.head == null || linkedList.head.next == null) {
            return;
        }

        DoubleNode middle = getMiddle(linkedList.head);
        DoubleNode secondHalf = middle.next;
        middle.next = null;

        mergeSortRecursive(linkedList, linkedList.head);
        mergeSortRecursive(linkedList, secondHalf);

        linkedList.head = merge(linkedList.head, secondHalf);
    }

    private void mergeSortRecursive(DoubleLinkedList_Tail linkedList, DoubleNode node) {
        if (node == null || node.next == null) {
            return;
        }

        DoubleNode middle = getMiddle(node);
        DoubleNode secondHalf = middle.next;
        middle.next = null;

        mergeSortRecursive(linkedList, node);
        mergeSortRecursive(linkedList, secondHalf);

        node = merge(node, secondHalf);
    }


    private DoubleNode merge(DoubleNode left, DoubleNode right) {
        if (left == null) return right;
        if (right == null) return left;


        if (Integer.parseInt(left.data) < Integer.parseInt(right.data)) {
            left.next = merge(left.next, right);
            left.next.prev = left;
            left.prev = null;
            return left;
        } else {
            right.next = merge(left, right.next);
            right.next.prev = right;
            right.prev = null;
            return right;
        }
    }

    private DoubleNode getMiddle(DoubleNode head) {
        if (head == null) return null;

        DoubleNode slow = head;
        DoubleNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }







    public void quickSort(DoubleLinkedList_Tail linkedList) {
        quickSortHelper(linkedList.head, linkedList.tail.prev);
    }

    private void quickSortHelper(DoubleNode low, DoubleNode high) {
        if (low != null && high != null && low != high && low != high.next) {

            DoubleNode pivot = partition(low, high);

            quickSortHelper(low, pivot.prev);
            quickSortHelper(pivot.next, high);
        }
    }

    private DoubleNode partition(DoubleNode low, DoubleNode high) {
        String pivot = high.data;
        DoubleNode i = low.prev;
        for (DoubleNode j = low; j != high; j = j.next) {
            if (j.data.compareTo(pivot) < 0) {
                i = (i == null) ? low : i.next;
                swap(i, j);
            }
        }
        i = (i == null) ? low : i.next;
        swap(i, high);
        return i;
    }
    }



