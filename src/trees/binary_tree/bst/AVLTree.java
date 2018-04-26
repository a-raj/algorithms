package trees.binary_tree.bst;

public class AVLTree {

    NodeAVL root;

    int height(NodeAVL node){
        if (node == null) return 0;

        return node.getHeight();
    }

    // Right rotate subtree with root y
    NodeAVL rightRotate(NodeAVL y) {

        NodeAVL x = y.getLeft();
        NodeAVL T2 = x.getRight();

        // Perform rotation
        x.setRight(y);
        y.setLeft(T2);

        // Update heights
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);

        // Return new Root
        return x;
    }


    // left rotate subtree with root x
    NodeAVL leftRotate(NodeAVL x) {

        NodeAVL y = x.getRight();
        NodeAVL T2 = y.getLeft();

        // Perform rotation
        y.setLeft(x);
        x.setRight(T2);

        // update height
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);

        return y;
    }

    int getBalance(NodeAVL n) {
        if (n == null) return 0;

        return height(n.getLeft()) - height(n.getRight());
    }

    NodeAVL insert(NodeAVL node, int key) {

        // 1. Perform the normal BST insertion
        if (node == null)
            return new NodeAVL(key);

        if (key < node.getKey())
            node.setLeft(insert(node.getLeft(), key));

        if (key > node.getKey())
            node.setRight(insert(node.getRight(), key));

        // Duplicate keys are not allowed
        else
            return node;

        // 2. Update height of this ancestor node
        node.setHeight(1 + Math.max(height(node.getLeft()),  height(node.getRight())));

        // 3. Get balance factor of this ancestor node to check whether this node became unbalance
        int balance = getBalance(node);

        // if this node become unbalance then there are 4 cases

        // Left Left case
        if (balance > 1 && key < node.getLeft().getKey())
            return rightRotate(node);

        // Right Right case
        if (balance < -1 && key > node.getRight().getKey())
            return leftRotate(node);

        // Left Right rotate
        if (balance > 1 && key > node.getLeft().getKey()) {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }

        // Right Left rotate
        if (balance < -1 && key < node.getRight().getKey()) {
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }

        // Return unchanged node
        return node;
    }




}
class NodeAVL {

    private int height;
    private int key;

    private NodeAVL left = null;
    private NodeAVL right = null;


    NodeAVL(int key) {
        this.setKey(key);
        this.setHeight(1);
    }

    int getHeight() {
        return height;
    }

    void setHeight(int height) {
        this.height = height;
    }

    int getKey() {
        return key;
    }

    private void setKey(int key) {
        this.key = key;
    }

    NodeAVL getLeft() {
        return left;
    }

    void setLeft(NodeAVL left) {
        this.left = left;
    }

    NodeAVL getRight() {
        return right;
    }

    void setRight(NodeAVL right) {
        this.right = right;
    }
}
