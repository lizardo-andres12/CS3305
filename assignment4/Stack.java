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
 * @param <E>   The data type of the Stack
 */
public class Stack<E> {

    private Node<E> top, bottom;
    private int size;

    public Stack () {
        top = null;
        bottom = null;
        size = 0;
    }

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

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else if (top == bottom) {
            top = bottom = null;
        } else {
            top = top.next;
        }
        size--;
    }

    public E top() {
        if (!isEmpty()) {
            return top.data;
        } else {
            return null;
        }
    }

    public void printStack() {
        Node<E> cur = top;
        while (cur != null) {
            System.out.print(cur.data + "  ");
            cur = cur.next;
        }
        System.out.println();
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public class Node<E> {
        public E data;
        public Node<E> next;

        public Node (E data) {
            this.data = data;
            next = null;
        }
    }
}
