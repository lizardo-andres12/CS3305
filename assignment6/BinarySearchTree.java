package assignment6;

public class BinarySearchTree <E extends Comparable<E>> implements Tree<E> {

    private Node<E> root;
    private int size;

    public E getMax() {
        if (root == null) {
            return null;
        } else {
            Node<E> cur = root;
            while (cur.right != null) {
                cur = cur.right;
            }

            return cur.data;
        }
    }

    public E getMin() {
        if (root == null) {
            return null;
        } else {
            Node<E> cur = root;
            while (cur.left != null) {
                cur = cur.left;
            }

            return cur.data;
        }
    }

    @Override
    public boolean insert(E data) {
        if (root == null) {
            root = new Node<>(data);
            return true;
        } else {
            return insert(data, root);
        }
    }

    private boolean insert(E data, Node<E> root) {
        if (root == null) {
            return false;
        } else {
            if (root.data.compareTo(data) < 0) {
                if (root.left == null) {
                    root.left = new Node<>(data);
                    return true;
                } else {
                    return insert(data, root.left);
                }
            } else if (root.data.compareTo(data) > 0) {
                if (root.right == null) {
                    root.right = new Node<>(data);
                    return true;
                } else {
                    return insert(data, root.right);
                }
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(E data) {
        return false;
    }

    @Override
    public boolean search(E data) {
        return search(data, root);
    }

    private boolean search(E data, Node<E> root) {
        if (root == null) {
            return false;
        } else {
            if (root.data.compareTo(data) == 0) {
                return true;
            } else if (root.data.compareTo(data) < 0) {
                return search(data, root.left);
            } else {
                return search(data, root.right);
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void inorder() {

    }

    @Override
    public void preorder() {

    }

    @Override
    public void postorder() {

    }
}
