import trees.IntTree;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Dayanna Chacha");
        runIntTree();
    }

    public static void runIntTree() {
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
        System.out.println("\nTamanio del arbol");
        System.out.println(intTree.size());
    }
}
