package SecondFiveStepsOfProjects.Recursion;
import FirstFiveStepsOfProject.SingleLinkedList.SingleNode;
public class Recursion {
    public int sum(SingleNode node){
        if (node == null)
            return 0;
        return Integer.parseInt(node.data) + sum(node.next);
    }
//    Max
public int max(SingleNode head) {
    if (head == null) {
        System.out.println("The list is empty");
    }
    return maxHelper(head, Integer.MIN_VALUE);
}

    private int maxHelper(SingleNode node, int currentMax) {
        if (node == null) {
            return currentMax;
        }

        currentMax = Math.max(Integer.parseInt(node.data), currentMax);
        return maxHelper(node.next, currentMax);
    }

//    Max

//    Search

    public boolean search(SingleNode node, String target){
        if (node == null)
            return false;
        if (node.data.equals(target))
            return true;
        return search(node.next,target);
    }
//    Search

//    searchDivisibleBy5And6
    public void searchDivisibleBy5And6(SingleNode node){
        if (node == null)
            return;
        int value = Integer.parseInt(node.data);
        if (value % 5 == 0 && value % 6 == 0)
            System.out.println(value);
        searchDivisibleBy5And6(node.next);
    }
//    searchDivisibleBy5And6

}
