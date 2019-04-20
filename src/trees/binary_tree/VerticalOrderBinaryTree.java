package trees.binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VerticalOrderBinaryTree {

    private static Map<Integer, List<Integer>> resultMap = new TreeMap<>();

    // Trick is pre-order traversal with keep track of level
    public void verticalOrder(Node node, int level) {

        if (node == null) return;

        resultMap.computeIfPresent(level, (k,v) -> {
            v.add(node.key);
            return v;
        });
        resultMap.putIfAbsent(level, new ArrayList<Integer>(){{
            add(node.key);
        }});

        verticalOrder(node.left, level - 1);
        verticalOrder(node.right, level + 1);

    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        VerticalOrderBinaryTree verticalOrderBinaryTree = new VerticalOrderBinaryTree();
        verticalOrderBinaryTree.verticalOrder(root, 0);

        resultMap.forEach((k,v) -> {
            System.out.println( k + " -> " + v.toString());
        });


    }
}
