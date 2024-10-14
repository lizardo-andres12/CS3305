package assignment6.myImplementations;

public class TreeNode<E> {
    public E data;
    public TreeNode<E> left, right;

    public TreeNode(E data) {
        this.data = data;
        left = right = null;
    }
}
