package SecondFiveStepsOfProjects.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BST {

   private TreeNode root;

//      insert methods
    public void insert(int value){
        root =  insert(root,value);
    }
    public TreeNode insert(TreeNode node, int value){
        if (node == null){
            node = new TreeNode(value);
            return node;
        }
        if (value < node.data){
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }
        return node;
    }
//    Ends of insert Methods

//    Deleting Methods
    //  Helper methods
    private boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }
    private boolean hasOneChild(TreeNode node){
        return ((node.right!=null && node.left == null) || (node.right==null && node.left != null));
    }
    private int maxValue(TreeNode node){
        int maxValue = root.data;
        while (root.right !=null){
            root = root.right;
            maxValue = root.data;
        }
        return maxValue;
    }
    private int minValue(TreeNode node){
        int minValue = root.data;
        while (root.left !=null){
            root = root.left;
            minValue = root.data;
        }
        return minValue;
    }

    private TreeNode deleteLeafNode(TreeNode node){
        return null;
    }
    private TreeNode deleteNodeWithOneChild(TreeNode node){
        return (node.left != null) ? node.left: node.right;
    }
    private TreeNode deleteNodeWithMoreThenOneChild(TreeNode node){
        node.data = maxValue(node.left);

        node.left = delete(node.left, node.data);
        return node;
    }

    private TreeNode deleteNode(TreeNode node){
        if (isLeaf(node))
            return deleteLeafNode(node);
        else if (hasOneChild(node))
            return deleteNodeWithOneChild(node);
        else
            return deleteNodeWithMoreThenOneChild(node);
    }
    public TreeNode delete(TreeNode node, int value) {
        if (node == null) return null;

        if (value < node.data) {
            node.left = delete(node.left, value);
        } else if (value > node.data) {
            node.right = delete(node.right, value);
        } else {
            // Node to be deleted found
            if (node.left == null && node.right == null) {
                return null; // No children, delete by returning null
            } else if (node.left == null) {
                return node.right; // One child (right), return right child
            } else if (node.right == null) {
                return node.left; // One child (left), return left child
            } else {
                // Two children: replace with in-order successor (smallest in right subtree)
                node.data = minValue(node.right);
                node.right = delete(node.right, node.data);
            }
        }
        return node;
    }


    //  Ends of Helper methods

public void delete(int value) {
    root = delete(root, value);
}
//    Ends of Deleting Methods


//    printing Methods
      // Helper Methods
        private void findLeaves(TreeNode node, List<Integer> result){
            if (node == null) return;
            if (node.left == null && node.right == null) {
                result.add(node.data);
            }
            findLeaves(node.left, result);
            findLeaves(node.right, result);
        }

    private void findDegree1Nodes(TreeNode node, List<Integer> result) {
        if (node == null) return;
        if ((node.left == null && node.right != null) || (node.left != null && node.right == null)) {
            result.add(node.data);
        }
        findDegree1Nodes(node.left, result);
        findDegree1Nodes(node.right, result);
    }

    private void findDegree2Nodes(TreeNode node, List<Integer> result) {
        if (node == null) return;
        if (node.left != null && node.right != null) {
            result.add(node.data);
        }
        findDegree2Nodes(node.left, result);
        findDegree2Nodes(node.right, result);
    }

    private int countLeaves(TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return countLeaves(node.left) + countLeaves(node.right);
    }

    private int countDegree1Nodes(TreeNode node) {
        if (node == null) return 0;
        int count = 0;
        if ((node.left == null && node.right != null) || (node.left != null && node.right == null)) {
            count = 1;
        }
        return count + countDegree1Nodes(node.left) + countDegree1Nodes(node.right);
    }

    private int countDegree2Nodes(TreeNode node) {
        if (node == null) return 0;
        int count = 0;
        if (node.left != null && node.right != null) {
            count = 1;
        }
        return count + countDegree2Nodes(node.left) + countDegree2Nodes(node.right);
    }

    private boolean isFullTree(TreeNode node) {
        if (node == null) return true;
        if ((node.left == null && node.right != null) || (node.left != null && node.right == null)) return false;
        return isFullTree(node.left) && isFullTree(node.right);
    }

    private int getDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.left;
        }
        return depth;
    }

    private boolean isPerfectTree(TreeNode node, int depth, int level) {
        if (node == null) return true;
        if (node.left == null && node.right == null) return depth == level + 1;
        if (node.left == null || node.right == null) return false;
        return isPerfectTree(node.left, depth, level + 1) && isPerfectTree(node.right, depth, level + 1);
    }

    private boolean isBalanced(TreeNode node) {
        if (node == null) return true;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        if (Math.abs(leftHeight - rightHeight) > 1) return false;
        return isBalanced(node.left) && isBalanced(node.right);
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }
      // Ends of Helper Methods
    public int displayRoot(){
        return (root == null) ?-1:root.data;
    }


    public List<Integer> displayAllDegree0(){
        List<Integer> result =new ArrayList<>();
        findLeaves(root,result);
        return result;
    }

    public List<Integer> displayAllDegree1(){
        List<Integer> result = new ArrayList<>();
        findDegree1Nodes(root, result);
        return result;
    }
    public List<Integer> displayAllDegree2(){
        List<Integer> result = new ArrayList<>();
        findDegree2Nodes(root, result);
        return result;
    }

    public int displayNumbersOfLeavesNode() {
        return countLeaves(root);
    }

    public int displayNumbersOfNeitherNode() {
        return countDegree1Nodes(root);
    }

    public int displayNumbersOfFullNode() {
        return countDegree2Nodes(root);
    }


    public int displayDegreeNode(TreeNode node) {
        if (node == null) return -1;
        int degree = 0;
        if (node.left != null) degree++;
        if (node.right != null) degree++;
        return degree;
    }

    public boolean displayIsFullTree() {
        return isFullTree(root);
    }

    public boolean displayIsCompleteTree() {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean end = false;
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) {
                end = true;
            } else {
                if (end) return false;
                queue.add(current.left);
                queue.add(current.right);
            }
        }
        return true;
    }

    public boolean displayIsPerfectTree() {
        int depth = getDepth(root);
        return isPerfectTree(root, depth, 0);
    }

    public boolean displayIsBalancedTrees() {
        return isBalanced(root);
    }

//    Ends of printing Methods
//    Traversing Methods
     // Helper Methods    
     // Ends of Helper Methods    
//    Ends of Traversing Methods


}
