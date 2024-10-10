package assignment6;

public interface Tree <E extends Comparable<E>> {
    public boolean insert(E data);
    public boolean isEmpty();
    public boolean remove(E data);
    public boolean search(E data);
    public int size();
    public void inorder();
    public void preorder();
    public void postorder();
}
