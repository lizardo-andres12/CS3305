// Name: Lizardo Hernandez
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 4
// IDE Name: Intellij

package assignment4;


/**
 * A class that implements the Stack ADT using a Linked-List as the underlying data structure. The {@link Node} class is
 * nested within this class. Implements methods:
 * <ul>
 *     <li>push</li>
 *     <li>pop</li>
 *     <li>top</li>
 *     <li>printStack</li>
 *     <li>size</li>
 *     <li>isEmpty</li>
 * </ul>
 * @param <E>   The data type of the Stack.
 */
public class Stack<E> {
    private Node<E> top, bottom;
    private int size;

    /**
     * Default constructor for {@link Stack}. Initializes {@code top} and {@code bottom} to null and {@code size} to 0.
     */
    public Stack () {
        top = null;
        bottom = null;
        size = 0;
    }

    /**
     * Adds param to the top of the stack. If stack contains no nodes, both top and bottom are set to new node
     * containing param. If stack is not empty, node is added to the front of the current list.
     * @param data  The data to be pushed onto the stack.
     */
    public void push(E data) {
        if (top == null) {
            top = bottom = new Node<>(data);
        } else {
            Node<E> node = new Node<>(data);
            node.next = top;
            top = node;

            if (bottom == null) {
                bottom = top;
            }
        }
        size++;
    }

    /**
     * Removes, but does not return, the node {@code top}. If the stack is empty, prints an error message. If not, the
     * first node is removed and {@code top} is set to null. If there was only one node in the stack, {@code bottom} is
     * set to null as well.
     */
    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            if (top == bottom) {
                top = bottom = null;
            } else {
                top = top.next;
            }
            size--;
        }
    }

    /**
     * Returns the data in the node {@code top}. If stack is empty, returns null.
     * @return  The data at the top of the stack.
     */
    public E top() {
        if (!isEmpty()) {
            return top.data;
        } else {
            return null;
        }
    }

    /**
     * Prints the elements of the stack in a single line and a newline character at the end.
     */
    public void printStack() {
        Node<E> cur = top;
        while (cur != null) {
            System.out.print(cur.data + "  ");
            cur = cur.next;
        }
        System.out.println();
    }

    /**
     * Returns the current size of the stack.
     * @return  The number of nodes in the stack.
     */
    public int size() { return size; }

    /**
     * Returns whether the stack has any nodes in it or not.
     * @return  {@code true} if there are no nodes in the stack and {@code false} if else.
     */
    public boolean isEmpty() { return size == 0; }

    /**
     * A nested class that implements a self-referential Node structure used in Linked-List data structures.
     * @param <E>   The data type of the node
     */
    public class Node<E> {
        public E data;
        public Node<E> next;

        /**
         * Default constructor for the class. Sets attribute {@code this.data} to {@code data} and {@code next} to null.
         * @param data  The data to be stored in the node.
         */
        public Node (E data) {
            this.data = data;
            next = null;
        }
    }
}
