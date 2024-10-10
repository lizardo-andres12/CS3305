package assignment6;

public class Test {

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(5);
        bst.insert(4);
        bst.insert(2);
        bst.insert(3);
        bst.insert(6);

        bst.preorder();
    }
}
