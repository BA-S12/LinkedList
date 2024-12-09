package SecondFiveStepsOfProjects.SerachAndSorting;

import FirstFiveStepsOfProject.DoubleLinkedList.DoubleLinkedList_Tail;
import SecondFiveStepsOfProjects.Tree.BST;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        Array arr = new Array();


        int[] array = {3,1,2,5,4,3,6,8,6};

//        arr.linearSearch(array,3);
//        arr.binarySearch(array,8, 0, array.length-1);

        System.out.println(Arrays.toString(array));
       arr.heapSort(array);
        System.out.println(Arrays.toString(array));



        BST tree = new BST();

        tree.insert(20);
        tree.insert(21);
        tree.insert(20);
        tree.insert(22);
        tree.insert(9);
        tree.insert(10);
        tree.insert(8);
        tree.insert(7);
        tree.insert(6);

        heapSort heap= new heapSort();

        heap.heapSort();

        System.out.println(tree.inOrderTraversal());

        DoubleLinkedList_Tail list = new DoubleLinkedList_Tail();
        LinkedList list1 = new LinkedList();

        list.insertLast("3");
        list.insertLast("1");
        list.insertLast("2");
        list.insertLast("5");
        list.insertLast("4");
        list.insertLast("3");
        list.insertLast("6");
        list.insertLast("8");
        list.insertLast("6");

        list.displayList();
        list1.insertionSort(list);
        list.displayList();




    }
}
