package SecondFiveStepsOfProjects.Recursion;

import FirstFiveStepsOfProject.SingleLinkedList.SingleLinkedList_Tail;

public class RecursionTest {
    public static void main(String[] args) {
        SingleLinkedList_Tail list = new SingleLinkedList_Tail();
        Recursion recursion = new Recursion();

        list.insertLast("30");
        list.insertLast("60");
        list.insertLast("15");
        list.insertLast("100");
        list.insertLast("90");

        list.displayList();
        System.out.println("Sum of list: " + recursion.sum(list.head));
        System.out.println("Max of list: " + recursion.max(list.head));

        System.out.println("Searching for '15': " + (recursion.search(list.head, "15") ? "Found" : "Not found"));
        System.out.println("Searching for '45': " + (recursion.search(list.head, "45") ? "Found" : "Not found"));

        recursion.searchDivisibleBy5And6(list.head);


    }
}
