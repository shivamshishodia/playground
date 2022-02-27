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

    // Keep traversing left to find the next successor.
    int minValue(BSTNode root) {
        int min = root.key;
        while (root.left != null) {
            min = root.left.key;
            root = root.left;
        }
        return min;
    }

    BSTNode deleteNode(BSTNode root, int element) {
        // Check if the tree is empty.
        if (root == null) {
            return root;
        }
        // Traverse subtress to find the node to be deleted.
        if (element < root.key) {
            // When the node is found, .left will be assinged null value.
            root.left = deleteNode(root.left, element);
        }
        else if (element > root.key) {
            // When the node is found, .right will be assinged null value.
            root.right = deleteNode(root.right, element);
        } 
        // Node to be deleted is found.
        else {
            // Node has no child, or it has one child.
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Node has two children, find inorder successor and delete.
            root.key = minValue(root.right);
            root.right = deleteNode(root.right, root.key);
        }
        return root;
    }

    // Wrappers
    void insert(int element) { root = insertNode(root, element); }
    void delete(int element) { root = deleteNode(root, element); }
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
        System.out.println("");
        
        System.out.println("Deleting nodes...");
        
        tree.delete(20);
        System.out.print("Inorder \t: ");
        tree.inorder();
        System.out.println("");
        
        tree.delete(30);
        System.out.print("Inorder \t: ");
        tree.inorder();
        System.out.println("");

        tree.delete(50);
        System.out.print("Inorder \t: ");
        tree.inorder();
    }
}
