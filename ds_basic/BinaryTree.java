import java.util.LinkedList;
import java.util.Queue;

// Class to store node data.
class BTNode {
    int key;
    BTNode left, right;

    BTNode(int key) {
        this.key = key;
        this.left = this.right = null;
    }
}

public class BinaryTree {
    // Declare the root.
    BTNode root;

    BinaryTree() {
        // Root is set to null.
        root = null;
    }

    // Inorder traversal.
    void inorder(BTNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }

    // Preorder traversal.
    void preorder(BTNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.key + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Postorder traversal.
    void postorder(BTNode root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.key + " ");
    }

    // Level order traversals.
    void levelOrder(BTNode root) {
        if (root == null) {
            return;
        }

        // Create a FIFO queue to store discovered nodes.
        Queue<BTNode> Q = new LinkedList<BTNode>();
        Q.add(root);

        while (!Q.isEmpty()) {
            // Remove the discovered nodes.
            BTNode ele = Q.peek();
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

    int height(BTNode root) {
        // Height is empty tree is -1.
        if(root == null) {
            return -1;
        }
        return Math.max(height(root.left) + 1 , height(root.right) + 1);
    }

    void insert(BTNode ele) {
        // Insert the element at root if the tree is empty.
        if (root == null) {
            root = ele;
            return;
        }

        // Do lateral traversal and insert at the first empty node.
        Queue<BTNode> Q = new LinkedList<BTNode>();
        Q.add(root);

        while (!Q.isEmpty()) {
            BTNode discover = Q.peek();
            Q.remove();

            // If left is empty, insert the node otherwise keep traversing.
            if (discover.left == null) {
                discover.left = ele;
                break;
            } else {
                Q.add(discover.left);
            }

            // If right is empty, insert the node otherwise keep traversing.
            if (discover.right == null) {
                discover.right = ele;
                break;
            } else {
                Q.add(discover.right);
            }
        }
    }

    void deleteDeepest(int element) {
        Queue<BTNode> Q = new LinkedList<BTNode>();
        Q.add(root);

        // Traverse at level order.
        BTNode dequeuedNode = null;
        while (!Q.isEmpty()) {
            dequeuedNode = Q.peek();
            Q.remove();
            // Check if left exists and is the node to be deleted.
            if (dequeuedNode.left != null) {
                if (dequeuedNode.left.key == element) {
                    dequeuedNode.left = null;
                    return;
                } else {
                    Q.add(dequeuedNode.left);
                }
            }
            // Check if right exists and is the node to be deleted.
            if (dequeuedNode.right != null) {
                if (dequeuedNode.right.key == element) {
                    dequeuedNode.right = null;
                    return;
                } else {
                    Q.add(dequeuedNode.right);
                }
            }
        }
    }

    void delete(int deleteElement) {
        // Return if the tree is empty.
        if (root == null) {
            return;
        }

        // If the tree has only root.
        if (root.left == null && root.right == null) {
            if (root.key == deleteElement) {
                root = null;
                return;
            }
            return;
        }

        // Level order traversal to find the key node and 
        // deepest node (dequeued last from FIFO queue).
        Queue<BTNode> Q = new LinkedList<BTNode>();
        Q.add(root);
        
        BTNode keyNode = null, lastDequeuedNode = null;

        while (!Q.isEmpty()) {
            lastDequeuedNode = Q.peek();
            Q.remove();
            // Find the key node to be deleted.
            if (lastDequeuedNode.key == deleteElement) {
                keyNode = lastDequeuedNode;
            }
            // Traverse further for deepest node (dequeued last from FIFO queue).
            if (lastDequeuedNode.left != null) {
                Q.add(lastDequeuedNode.left);
            } 
            if (lastDequeuedNode.right != null) {
                Q.add(lastDequeuedNode.right);
            }
        }

        // Check if the node to be deleted was found.
        if (keyNode != null) {
            int value = lastDequeuedNode.key;
            // Now delete the deepest value.
            deleteDeepest(lastDequeuedNode.key);
            // Key node value replaced with deepest node.
            keyNode.key = value;
        }
    }

    // Wrappers
    void inorder() { inorder(root); }
    void preorder() { preorder(root); }
    void postorder() { postorder(root); }
    void levelOrder() { levelOrder(root); }
    int height() { return height(root); }

    // Driver function.
    public static void main(String[] args) {

        /**
         * Construct the binary tree.
         *        1
         *     2     3
         *    4 5
         */
        BinaryTree tree = new BinaryTree();
        tree.root = new BTNode(1);
        tree.root.left = new BTNode(2);
        tree.root.right = new BTNode(3);
        tree.root.left.left = new BTNode(4);
        tree.root.left.right = new BTNode(5);

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

        System.out.println("Height \t: " + tree.height());

        /**
         * Insert in binary tree.
         *        1
         *     2     3
         *    4 5   6
         */
        BTNode ele = new BTNode(6);
        System.out.println("Inserting node...");
        tree.insert(ele);

        System.out.print("Level Order \t: ");
        tree.levelOrder();
        System.out.println("");

        /**
         * Delete 1 in binary tree.
         *        6
         *     2     3
         *    4 5
         */
        int deleteEle = 1;
        System.out.println("Deleting node...");
        tree.delete(deleteEle);

        System.out.print("Level Order \t: ");
        tree.levelOrder();
        System.out.println("");
    }
}
