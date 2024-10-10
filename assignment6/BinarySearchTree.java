package assignment6;

public class BinarySearchTree <E extends Comparable<E>> implements Tree<E> {

    private TreeNode<E> root;
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
            root = new TreeNode<>(data);
            return true;
        } else {
            return insert(data, root);
        }
    }

    private boolean insert(E data, TreeNode<E> root) {
        if (root == null) {
            return false;
        } else {
            if (data.compareTo(root.data) < 0) { // if data is smaller
                if (root.left == null) {
                    root.left = new TreeNode<>(data);
                    return true;
                } else {
                    return insert(data, root.left);
                }
            } else if (data.compareTo(root.data) > 0) { // if data is larger
                if (root.right == null) {
                    root.right = new TreeNode<>(data);
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

    private TreeNode<E> search(E data, TreeNode<E> root) {
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

    public TreeNode<E> findParent(E data, TreeNode<E> root) {
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

    private void inorder(TreeNode<E> root) {
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

    private void preorder(TreeNode<E> root) {
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

    private void postorder(TreeNode<E> root) {
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
