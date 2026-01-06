package trees;

import models.Person;
import nodes.Node;

public class Tree<T extends Comparable<T>> {

    private Node<T> root;

    public Tree() {
        this.root = null;
    }

    // Metodo insertar
    public void insert(T value) {
        root = insertRecursive(root, value);
    }
    public Node<T> insertRecursive(Node<T> current, T value) {
        if (current == null) {
            return new Node<>(value); 
        }
        Comparable<T> compValue = (Comparable<T>) value;
        if (compValue.compareTo(current.getValue()) < 0) {
            current.setLeft(insertRecursive(current.getLeft(), value));
        } else if (compValue.compareTo(current.getValue()) > 0) {
            current.setRight(insertRecursive(current.getRight(), value));
        }

        return current;        
    }

    // In Order
    public void inOrder(){
        inOrderRecursive(root);
    }
    private void inOrderRecursive(Node<T> node){
        if (node != null){
            inOrderRecursive(node.getLeft());
            System.out.print(node.getValue() + " ");
            inOrderRecursive(node.getRight());
        }
    }

    //para buscar personas
    public T search(T value) {
        return searchRecursive(root, value);
    }   

    private T searchRecursive(Node<T> root2, T value) {
        if (root2 == null) {
            return null;
        }
        Comparable<T> compValue = (Comparable<T>) value;
        if (compValue.compareTo(root2.getValue()) < 0) {
            return searchRecursive(root2.getLeft(), value);
        } else if (compValue.compareTo(root2.getValue()) > 0) {
            return searchRecursive(root2.getRight(), value);
        } else {
            return root2.getValue();
        }
    }

    // Buscar personas por edad
    public void searchByAge(int age) {
        searchByAgeRecursive(root, age);
    }

    private void searchByAgeRecursive(Node<T> node, int age) {
        if (node != null) {
            searchByAgeRecursive(node.getLeft(), age);
            if (node.getValue() instanceof Person) {
                Person p = (Person) node.getValue();
                if (p.getAge() == age) {
                    System.out.print(p);
                }
            }
            searchByAgeRecursive(node.getRight(), age);
        }
    }  
}
