package assignment6.myImplementations;

public class Test {
    public static void printTree(BinarySearchTree<Integer> bst) {
        bst.preorder();
        System.out.println();
        bst.inorder();
        System.out.println('\n');
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(5);
        bst.insert(1);
        bst.insert(2);
        bst.insert(9);
        bst.insert(7);
        bst.insert(11);
        bst.insert(6);
        bst.insert(8);
        bst.insert(13);

        printTree(bst);
        bst.remove(5);
        printTree(bst);
        bst.bfs();
    }
}
