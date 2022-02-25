import java.util.LinkedList;
import java.util.Queue;

// Class to store node data.
class Node {

    int key;
    Node left, right;

    Node(int key) {
        this.key = key;
        this.left = this.right = null;
    }

}

public class BinaryTree {

    // Declare the root.
    Node root;

    BinaryTree() {
        // Root is set to null.
        root = null;
    }

    // Inorder traversal.
    void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }

    // Preorder traversal.
    void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.key + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Postorder traversal.
    void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.key + " ");
    }

    // Level order traversals.
    void levelOrder(Node root) {

        if (root == null) {
            return;
        }

        // Create a FIFO queue to store discovered nodes.
        Queue<Node> Q = new LinkedList<Node>();
        Q.add(root);

        while (!Q.isEmpty()) {
            // Remove the discovered nodes.
            Node ele = Q.peek();
            Q.remove();

            // Add thier children.
            System.out.print(ele.key + " ");
            if (ele.left != null) {
                Q.add(ele.left);
            }
            if (ele.right != null) {
                Q.add(ele.right);
            }
        }
    }

    // Wrappers
    void inorder() { inorder(root); }
    void preorder() { preorder(root); }
    void postorder() { postorder(root); }
    void levelOrder() { levelOrder(root); }

    // Driver function.
    public static void main(String[] args) {

        /**
         * Construct the binary tree.
         *        1
         *     2     3
         *   4   5
         */

        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.print("Inorder \t: ");
        tree.inorder();
        System.out.println("");

        System.out.print("Preorder \t: ");
        tree.preorder();
        System.out.println("");

        System.out.print("Postorder \t: ");
        tree.postorder();
        System.out.println("");

        System.out.print("Level Order \t: ");
        tree.levelOrder();
        System.out.println("");

    }

}