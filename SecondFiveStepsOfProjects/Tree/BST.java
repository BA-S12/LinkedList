package SecondFiveStepsOfProjects.Tree;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BST {

   public TreeNode root;
   private int size;
   private int rightSize;
   private int leftSize;
//      insert methods
    public void insert(int value){
        root =  insert(root,value);
        size++;
    }
    private TreeNode insert(TreeNode node, int value){
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
        int maxValue = node.data;
        while (node.right !=null){
            node = node.right;
            maxValue = node.data;
        }
        return maxValue;
    }
    private int minValue(TreeNode node){
        int minValue = node.data;
        while (node.left !=null){
            node = node.left;
            minValue = node.data;
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
    private TreeNode delete(TreeNode node, int value) {
        if (node == null) return null;

        if (value < node.data) {
            node.left = delete(node.left, value);
        } else if (value > node.data) {
            node.right = delete(node.right, value);
        } else {
            // Node to be deleted found
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
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



        public int displayDegreeNode(int value) {
            TreeNode node = findNode(root, value);
            if (node == null) {
                System.out.println("Node with value " + value + " does not exist in the tree.");
                return -1;
            }
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
//not in exam

//    Ends of printing Methods
//    Traversing Methods

    public void inOrderLeftRight() {
        inOrderLeftRight(root);
    }
    private void inOrderLeftRight(TreeNode node) {
        if (node == null) return;
        inOrderLeftRight(node.left);
        System.out.print(node.data + " ");
        inOrderLeftRight(node.right);
    }

    public void inOrderRightLeft() {
        inOrderRightLeft(root);
    }
    private void inOrderRightLeft(TreeNode node) {
        if (node == null) return;
        inOrderRightLeft(node.right);
        System.out.print(node.data + " ");
        inOrderRightLeft(node.left);
    }

    // Pre-order LeftRight traversal
    public void preOrderLeftRight() {
        preOrderLeftRight(root);
    }
    private void preOrderLeftRight(TreeNode node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrderLeftRight(node.left);
        preOrderLeftRight(node.right);
    }

    // Pre-order RightLeft traversal
    public void preOrderRightLeft() {
        preOrderRightLeft(root);
    }
    private void preOrderRightLeft(TreeNode node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrderRightLeft(node.right);
        preOrderRightLeft(node.left);
    }

    // Post-order LeftRight traversal
    public void postOrderLeftRight() {
        postOrderLeftRight(root);
    }
    private void postOrderLeftRight(TreeNode node) {
        if (node == null) return;
        postOrderLeftRight(node.left);
        postOrderLeftRight(node.right);
        System.out.print(node.data + " ");
    }

    // Post-order RightLeft traversal
    public void postOrderRightLeft() {
        postOrderRightLeft(root);
    }
    private void postOrderRightLeft(TreeNode node) {
        if (node == null) return;
        postOrderRightLeft(node.right);
        postOrderRightLeft(node.left);
        System.out.print(node.data + " ");
    }

    public void levelOrderLeftRight() {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.data + " ");
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }


    public void levelOrderRightLeft() {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.data + " ");
            if (current.right != null) queue.add(current.right);
            if (current.left != null) queue.add(current.left);
        }
    }

    public void size(){
        if(root==null)
            System.out.println("The tree is empty");
        else
            System.out.println("The size of tree is "+this.size);
    }


    public void findMax(){
        if(root==null)
            System.out.println("The tree is empty, so we cannot do this method");
        else
            System.out.println("The MaxNode in tree is: "+this.FindMaxTree(root).data);
    }
//    Helper Methods
    private TreeNode FindMaxTree(TreeNode Node){
    if(Node.right==null)
        return Node;
    else
        return FindMaxTree(Node.right);

}
    private TreeNode FindMinTree(TreeNode Node){

        if(Node.left==null)
            return Node;
        else
            return FindMinTree(Node.left);

    }
//    Helper Methods

    public void findMin(){

        if(root==null)
            System.out.println("The tree is empty, so we cannot do this method");
        else
            System.out.println("The MinNode in tree is: "+this.FindMinTree(root).data);
    }

    public void numberOfEdge(){
        if(size==0)
            System.out.println("The number of edge is : 0 because the tree is null");
        else
            System.out.println("The number of edges is :"+(size-1));
    }


    public void sizeLeft(){
        if(root.left==null)
            System.out.println("The size is 0 so becose thear is no any elemnt on the left");
        else{

            System.out.println("The size of left is " +(sizeLeftTree(root.left)+1));
        }
    }

    public void sizeRight() {
        if (root.right == null)
            System.out.println("The size is 0 so becose thear is no any elemnt on the left");
        else {

            System.out.println("The size of left is " + (sizeRightTree(root.right) + 1));
        }
    }
        public void search ( int value){
            if (root == null)
                System.out.println("The tree is empty  ");
            else {
                if (searchTree(root, value))
                    System.out.println("The node is found :)");
                else
                    System.out.println("The node is not found :(");
            }

        }

//        Helper methods
        private int sizeLeftTree (TreeNode node){

            if (node == null) {
                return 0;
            } else {

                sizeLeftTree(node.left);
                sizeLeftTree(node.right);
                return leftSize++;

            }
        }
        private int sizeRightTree (TreeNode node){

            if (node == null) {
                return 0;
            } else {

                sizeRightTree(node.left);
                sizeRightTree(node.right);
                return rightSize++;

            }
        }
        private boolean searchTree (TreeNode node,int nodeSearch){
            if (node == null)
                return false;
            else if (node.data == nodeSearch)
                return true;
            else {

                return searchTree(node.left, nodeSearch) || searchTree(node.right, nodeSearch);

            }
        }

    private TreeNode findNode(TreeNode node, int value) {
        if (node == null) return null;
        if (node.data == value) return node;
        TreeNode leftSearch = findNode(node.left, value);
        if (leftSearch != null) return leftSearch;
        return findNode(node.right, value);
    }
//        Helper methods


    public void mirror() {
        root = mirrorTree(root);
            inOrderLeftRight();
    }
    private TreeNode mirrorTree(TreeNode node) {
        if (node == null) return null;

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        mirrorTree(node.left);
        mirrorTree(node.right);

        return node;
    }

//    Ends of Traversing Methods


//    For heap sort
// In-order Traversal to Extract Elements
public List<Integer> inOrderTraversal() {
    List<Integer> result = new ArrayList<>();
    inOrderTraversalRec(root, result);
    return result;
}

    private void inOrderTraversalRec(TreeNode node, List<Integer> result) {
        if (node != null) {
            inOrderTraversalRec(node.left, result);
            result.add(node.data);
            inOrderTraversalRec(node.right, result);
        }
    }


}
