package assignment6;

public class Node<E extends Comparable<E>> {
    public E data;
    public Node<E> left, right;

    public Node(E data) {
        this.data = data;
        left = right = null;
    }
}
