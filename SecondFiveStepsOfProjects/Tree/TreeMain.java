package SecondFiveStepsOfProjects.Tree;

public class TreeMain {
    public static void main(String[] args) {

        BST bst = new BST();

        // Insert nodes into the BST
        System.out.println("Inserting nodes into the BST...");
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
        bst.insert(90);





//        to delete a node
//        is general methods delete any node if it is leaf, has one child, or has two child
        bst.delete(20);

        // Display root node
        System.out.println("Root node: " + bst.displayRoot());

        // Display nodes with degree 2
        System.out.println("Nodes with degree 2: " + bst.displayAllDegree2());

        // Display leaf nodes
        System.out.println("Leaf nodes: " + bst.displayAllDegree0());

        // Search for a node
        int searchValue = 3;
        bst.search(searchValue);


        // Test tree properties
        System.out.println("Is full tree: " + bst.displayIsFullTree());
        System.out.println("Is balanced tree: " + bst.displayIsBalancedTrees());

        // Traversals


        System.out.println("Pre-order Traversal (Left-Right): ");
        bst.preOrderLeftRight();

        System.out.println("\nIn-order Traversal (Left-Right): ");
        bst.inOrderLeftRight();


        System.out.println("\nPost-order Traversal (Left-Right): ");
        bst.postOrderLeftRight();


        bst.findMax();
        bst.findMin();
        bst.sizeLeft();
        bst.sizeRight();
        bst.numberOfEdge();
        bst.size();

        System.out.println(bst.displayDegreeNode(50));




    }
}
