package trees.binary_tree.bst;


import trees.binary_tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class BST {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public BST() {
        this.root = null;
    }

    void insert(int key){
        root = insertRecursive(root, key);
    }

    // Recursive function to insert the new key in BST
    private Node insertRecursive(Node root, int key) {

        //base case : if tree is empty then create the node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // if root
        if (root.key > key) {
            root.left = insertRecursive(root.left, key);
        }
        else if (root.key < key) {
            root.right = insertRecursive(root.right, key);
        }
        return root;
    }


    void printLevelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.printf(node.key + " ");

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }


    void deleteKey(int key) {
        root = deleteKeyRec(root, key);
    }


    private Node deleteKeyRec(Node root, int key) {

        // base case : if tree is empty
        if (root == null) return root;

        // recurse down the tree
        if (root.key < key) {
            root.right = deleteKeyRec(root.right, key);
        }
        else if (root.key > key) {
            root.left = deleteKeyRec(root.left, key);
        }

        // if key is same as the root's key then this node is to be deleted
        else {
            // node with only one child or no child
            if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }

            // Node with 2 children : delete the in-order successor (smallest in the right sub-tree)
            root.key = minValue(root.right);

            //delete the in-order successor
            root.right = deleteKeyRec(root.right, root.key);
        }
        return root;
    }


    private int minValue(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }
}
