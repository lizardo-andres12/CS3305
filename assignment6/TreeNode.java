package assignment6;

public class TreeNode<E> {
    public E data;
    public TreeNode<E> left, right;

    public TreeNode(E data) {
        this.data = data;
        left = right = null;
    }
}
