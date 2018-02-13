package trees.binary_tree;

public class BinaryTreeTraversal {

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.right = new Node(5);
        tree.root.left.left = new Node(4);

        tree.root.right.left = new Node(11);
        tree.root.right.right = new Node(15);

        System.out.println("In-Order Traversal");
        tree.printInOrder(tree.root);

        System.out.println("\nPre-Order Traversal");
        tree.printPreOrder(tree.root);

        System.out.println("\nPost-Order Traversal");
        tree.printPostOrder(tree.root);

        System.out.println("\nLevel-Order Traversal using recursion");
        tree.printLevelOrder(tree.root, false);

        System.out.println("\nLevel-Order Traversal using Queue");
        tree.printLevelOrder(tree.root, true);


    }

}
