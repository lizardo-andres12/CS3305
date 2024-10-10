package assignment6;

public class BinarySearchTree <E extends Comparable<E>> implements Tree<E> {

    private Node<E> root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public BinarySearchTree(E[] arr) {
        root = null;
        size = 0;

        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
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
            if (data.compareTo(root.data) < 0) { // if data is smaller
                if (root.left == null) {
                    root.left = new Node<>(data);
                    return true;
                } else {
                    return insert(data, root.left);
                }
            } else if (data.compareTo(root.data) > 0) { // if data is larger
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
    public boolean remove(E data) {
        return findParent(data, root) != null;
    }

    @Override
    public boolean search(E data) {
        return search(data, root) != null;
    }

    private Node<E> search(E data, Node<E> root) {
        if (root == null) {
            return null;
        } else {
            if (root.data.compareTo(data) == 0) {
                return root;
            } else if (root.data.compareTo(data) < 0) {
                return search(data, root.left);
            } else {
                return search(data, root.right);
            }
        }
    }

    public Node<E> findParent(E data, Node<E> root) {
        if (root == null) {
            return null;
        } else {
            if (root.data.compareTo(data) > 0) {
                if (root.left == null) {
                    return null;
                } else if (root.left.data.compareTo(data) == 0) {
                    return root;
                } else {
                    return findParent(data, root.left);
                }
            } else {
                if (root.right == null) {
                    return null;
                } else if (root.right.data.compareTo(data) == 0) {
                    return root;
                } else {
                    return findParent(data, root.right);
                }
            }
        }
    }

    @Override
    public void inorder() {
        inorder(root);
    }

    private void inorder(Node<E> root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }
    }

    @Override
    public void preorder() {
        preorder(root);
    }

    private void preorder(Node<E> root) {
        if (root != null) {
            System.out.println(root.data);
            preorder(root.left);
            preorder(root.right);
        }
    }

    @Override
    public void postorder() {
        postorder(root);
    }

    private void postorder(Node<E> root) {
        if (root != null) {
            preorder(root.left);
            preorder(root.right);
            System.out.println(root.data);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
