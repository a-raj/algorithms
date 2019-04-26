package trees.binary_tree.bst;

import trees.binary_tree.Node;

import java.util.*;

// Top view of a Binary Tree
public class TopViewBT {

    // to keep track of visited node
    private static Set<Integer> set = new HashSet<>();

    public void topView(Node node, int level) {
        // base case
        if (node == null) return;

        Queue<LevelNode> queue = new LinkedList<>();
        
        // Add root node with level 0
        queue.add(new LevelNode(node, 0));

        while (!queue.isEmpty()) {

            LevelNode levelNode = queue.remove();
            int newLevel = levelNode.level;
            Node newNode = levelNode.node;

            // Check if the present level is visited or not
            if (!set.contains(newLevel)) {

                System.out.print(newNode.key + " ");
                set.add(newLevel);
            }

            if (newNode.left != null) {
                queue.add(new LevelNode( newNode.left,  newLevel - 1));
            }

            if (newNode.right != null) {
                queue.add(new LevelNode(newNode.right, newLevel - 1));
            }
        }
    }


    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        TopViewBT topViewBT = new TopViewBT();
        topViewBT.topView(root, 0);
    }
    
    
    class LevelNode {
        int level;
        Node node;

        LevelNode(Node node, int level) {
            this.level = level;
            this.node = node;
        }
    }
}
