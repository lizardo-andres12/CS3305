// Name: Lizardo Hernandez
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 6
// IDE Name: Intellij

package assignment6.myImplementations;


import assignment5.Queue;

public class BinarySearchTree<E extends Comparable<E>> implements Tree<E> {

    private TreeNode<E> root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public BinarySearchTree(E[] arr) {
        root = null;
        size = 0;

        for (E e : arr) {
            insert(e);
        }
    }

    @Override
    public boolean insert(E data) {
        if (root == null) {
            root = new TreeNode<>(data);
            size++;
            return true;
        } else {
            boolean inserted = insert(data, root);
            size = inserted ? size + 1 : size;
            return inserted;
        }
    }

    @Override
    public boolean remove(E data) {
        if (root == null) {
            return false;
        } else {
            boolean removed = removeIfRoot(data, root);
            size = removed ? size - 1 : size;
            return removed;
        }
    }

    @Override
    public boolean search(E data) {
        return search(data, root) != null;
    }

    @Override
    public void inorder() {
        inorder(root);
    }

    @Override
    public void preorder() {
        preorder(root);
    }

    @Override
    public void postorder() {
        postorder(root);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    public E getMax() {
        return getMax(root);
    }

    public E getMin() {
        return getMin(root);
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

    private boolean removeIfRoot(E data, TreeNode<E> root) {
        if (root.data == data) {
            TreeNode<E> dummyRoot = new TreeNode<>(data);
            dummyRoot.right = root;
            return remove(data, dummyRoot);
        } else {
            return remove(data, root);
        }
    }

    private boolean remove(E data, TreeNode<E> root) {
        TreeNode<E> cur = findParent(data, root);
        if (cur == null) {
            return false;
        } else {
            if (cur.left != null && cur.left.data == data) { // cur left is node to delete
                TreeNode<E> nodeToDelete = cur.left;
                if (nodeToDelete.left == null && nodeToDelete.right == null) { // case 1
                    cur.left = null;
                } else if (nodeToDelete.left == null || nodeToDelete.right == null) { // case 2
                    if (nodeToDelete.left != null) {
                        cur.left = nodeToDelete.left;
                    } else {
                        cur.left = nodeToDelete.right;
                    }
                } else {
                    E max = getMax(nodeToDelete.left);
                    boolean returnValue = remove(max, nodeToDelete);
                    nodeToDelete.data = max; // get max of the node to delete left subtree
                    return returnValue;
                }
            } else { // cur right is node to delete
                TreeNode<E> nodeToDelete = cur.right;
                if (nodeToDelete.left == null && nodeToDelete.right == null) { // case 1
                    cur.right = null;
                } else if (nodeToDelete.left == null || nodeToDelete.right == null) { // case 2
                    if (nodeToDelete.left != null) {
                        cur.right = nodeToDelete.left;
                    } else {
                        cur.right = nodeToDelete.right;
                    }
                } else {
                    E max = getMax(nodeToDelete.left);
                    boolean returnValue = remove(max, nodeToDelete);
                    nodeToDelete.data = max; // get max of the node to delete left subtree
                    return returnValue;
                }
            }
            return true;
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

    public void bfs() {
        Queue<TreeNode<E>> queue = new Queue<>();
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            TreeNode<E> cur = queue.dequeue();
            if (cur.left != null) { queue.enqueue(cur.left); }
            if (cur.right != null) { queue.enqueue(cur.right); }
            System.out.print(cur.data + "  ");
        }
    }

    private E getMax(TreeNode<E> root) {
        if (root.right == null) {
            return root.data;
        } else {
            return getMax(root.right);
        }
    }

    private E getMin(TreeNode<E> root) {
        if (root.left == null) {
            return root.data;
        } else {
            return getMin(root.left);
        }
    }

    private void inorder(TreeNode<E> root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }
    }

    private void preorder(TreeNode<E> root) {
        if (root != null) {
            System.out.println(root.data);
            preorder(root.left);
            preorder(root.right);
        }
    }

    private void postorder(TreeNode<E> root) {
        if (root != null) {
            preorder(root.left);
            preorder(root.right);
            System.out.println(root.data);
        }
    }
}
