package trees.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

class BinaryTree {

    Node root;

    BinaryTree() {
        root = null;
    }

    // Left Right Head
    void printPostOrder(Node node) {

        if (node == null) return;

        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.data + " ");
    }

    // Root Left Right
    void printPreOrder(Node node) {

        if (node == null) return;

        System.out.printf(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    // Left Root Right
    void printInOrder(Node node) {

        if (node == null) return;

        printInOrder(node.left);
        System.out.printf(node.data + " ");
        printInOrder(node.right);
    }

    /**
     * Level order traversal of a tree using recursion
     * */
    private void printLevelOrder (Node root) {

        int height = height(root);

        for (int i = 1; i <= height; i++) {
            printGivenLevel(root, i);
        }
    }

    private void printGivenLevel(Node root, int level) {
        if (root == null) return;

        if (level == 1)
            System.out.printf(root.data + " ");
        else if (level > 1) {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }


    /**
     * Return height of the tree
     * */
    private int height(Node root) {

        if (root == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return (leftHeight > rightHeight) ? leftHeight + 1 : rightHeight + 1;
    }

    /**
     * Level order traversal using queue
     * */
    private void printLevelOrderUsingQueue (Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            System.out.print(node.data + " ");

            if (node.left != null) queue.add(node.left);

            if (node.right != null) queue.add(node.right);
        }
    }

    void printLevelOrder(Node root, boolean usingQueue) {
        if (usingQueue) printLevelOrderUsingQueue(root);
        else printLevelOrder(root);
    }
}
