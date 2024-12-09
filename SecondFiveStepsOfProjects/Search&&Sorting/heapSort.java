package SecondFiveStepsOfProjects.SerachAndSorting;

import SecondFiveStepsOfProjects.Tree.BST;
import SecondFiveStepsOfProjects.Tree.TreeNode;

public class heapSort extends BST {

    private void heapify(TreeNode node) {
        if (node == null) return;

        int largest = node.data;
        TreeNode largestNode = node;

        if (node.left != null && node.left.data > largest) {
            largest = node.left.data;
            largestNode = node.left;
        }


        if (node.right != null && node.right.data > largest) {
            largest = node.right.data;
            largestNode = node.right;
        }

        if (largestNode != node) {
            int temp = node.data;
            node.data = largestNode.data;
            largestNode.data = temp;

            heapify(largestNode);
        }
    }


    public void heapSort() {

        heapifyTree(root);

        heapSortHelper(root);
    }

    private void heapifyTree(TreeNode node) {
        if (node == null) return;

        heapifyTree(node.left);
        heapifyTree(node.right);

        heapify(node);
    }

    private void heapSortHelper(TreeNode node) {
        if (node == null) return;

        heapSortHelper(node.left);
        heapSortHelper(node.right);

        heapify(node);
    }
}
