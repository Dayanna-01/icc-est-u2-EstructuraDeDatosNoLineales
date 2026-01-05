package trees;

import nodes.Node;

public class Tree<T extends Comparable<T>> {
    Node<T> root;

    public Tree() {
        root = null;
    }

    public void insert(T value) {
        root = insertRecursive(root, value);
    }

    public Node<T> insertRecursive(Node<T> current, T value) {
        return null;
    }
}

