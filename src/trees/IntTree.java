package trees;

import nodes.Node;

public class IntTree {

    private Node<Integer> root;
    private int size = 0;

    public IntTree() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRecursive(root, value);
        size++;
    }

    public Node<Integer> insertRecursive(Node<Integer> current, int value) {
        if (current == null) {
            return new Node<>(value);
        }

        if (value < current.getValue()) {
            current.setLeft(insertRecursive(current.getLeft(), value));
        } else if (value > current.getValue()) {
            current.setRight(insertRecursive(current.getRight(), value));
        }

        return current;
    }

    // Pre Order
    public void preOrder(){
        preOrderRecursive(root);
    }
    private void preOrderRecursive(Node<Integer> node){
        if (node != null){
            System.out.print(node.getValue() + " ");
            preOrderRecursive(node.getLeft());
            preOrderRecursive(node.getRight());
        }
    }

    // Pos Order
    public void posOrder(){
        posOrderRecursive(root);
    }
    private void posOrderRecursive(Node<Integer> node){
        if (node != null){
            posOrderRecursive(node.getLeft());
            posOrderRecursive(node.getRight());
            System.out.print(node.getValue() + " ");
        }
    }

    // In Order
    public void inOrder(){
        inOrderRecursive(root);
    }
    private void inOrderRecursive(Node<Integer> node){
        if (node != null){
            inOrderRecursive(node.getLeft());
            System.out.print(node.getValue() + " ");
            inOrderRecursive(node.getRight());
        }
    }

    public int size() {
        return size;
    }
}
