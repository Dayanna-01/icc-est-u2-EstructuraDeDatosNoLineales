import models.Person;
import trees.IntTree;
import trees.Tree;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Dayanna Chacha");
        //runIntTree();
        runTree();
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

    public static void runTree() {
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
    }
}
