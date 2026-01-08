import javax.print.DocFlavor.STRING;

import graphs.Graph;
import models.Person;
import nodes.Node;
import trees.IntTree;
import trees.Tree;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Dayanna Chacha");
        //runIntTree();
        //runTree();
        runGraph();
    }

    /*public static void runIntTree() {
        IntTree intTree = new IntTree();
        intTree.insert(10);
        intTree.insert(5);
        intTree.insert(3);
        intTree.insert(15);
        System.out.println("Pre Order:");
        intTree.preOrder();
        System.out.println("\nPos Order:");
        intTree.posOrder();
        System.out.println("\nIn Order:");
        intTree.inOrder();
        //System.out.println("\nTamanio del arbol");
        //System.out.println(intTree.size());
    }*/

    /*public static void runTree() {
        Tree<Person> tree = new Tree<Person>();
        tree.insert(new Person("Pablo", 21));
        tree.insert(new Person("Maria", 23));
        tree.insert(new Person("Ana", 25));
        tree.insert(new Person("Pedro", 23));
        tree.insert(new Person("Luis", 19));
        System.out.print("In Order:");
        tree.inOrder();

        int edad = 23; // ejemplo
        System.out.println();
        System.out.print("\nPersonas encontradas por edad:");
        tree.searchByAge(edad);  
    }*/

    public static void runGraph() {
        Graph<String> graph = new Graph<>();
        
        Node<String> nA = new Node<>("A");
        Node<String> nB = new Node<>("B");
        Node<String> nC = new Node<>("C");
        Node<String> nD = new Node<>("D");

        graph.addNode(nA);
        graph.addEdge(nA, nB);
        graph.addEdge(nA, nC);
        graph.addEdge(nB, nD);
        graph.addEdge(nC, nD);
        graph.printGraph();

        // CONECTADOS DE A
        Node<String>[] neighbors = graph.getNeighbors(nA);
        System.out.print("\nNeighbors de A: ");
        for (Node<String> neighbor : neighbors) {
            System.out.print(neighbor + " ");
        }
    }
}

