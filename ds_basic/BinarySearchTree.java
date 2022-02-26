// Class to store node data.
class BSTNode {
    int key;
    BSTNode left, right;

    BSTNode(int key) {
        this.key = key;
        this.left = this.right = null;
    }
}

public class BinarySearchTree {
    // Declare the root.
    BSTNode root;
    
    // Initialize empty tree.
    BinarySearchTree() {
        root = null;
    }
    
    // Insert the data and return the node.
    BSTNode insertNode(BSTNode root, int element) {
        // Insert if the tree is empty or the last child node is reached.
        if (root == null) {
            root = new BSTNode(element);
            return root;
        }
        // Recur to right subtree.
        if (root.key < element) {
            root.right = insertNode(root.right, element);
        }
        // Recur to left subtree. 
        else if (root.key > element) {
            root.left = insertNode(root.left, element);
        }
        return root;
    }

    // Inorder: Left, Root, Right.
    void inorder(BSTNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }

    // Wrappers
    void insert(int element) { root = insertNode(root, element); }
    void inorder() { inorder(root); }
    
    public static void main(String[] args) {

        /**
         * Construct Binary Search Tree.
         *         50
         *     30      70
         *   20  40  60  80
         */
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.print("Inorder \t: ");
        tree.inorder();
    }
}
