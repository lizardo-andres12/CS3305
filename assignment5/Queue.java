// Name: Lizardo Hernandez
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 5
// IDE Name: Intellij

package assignment5;

import assignment4.Stack;

/**
 * A class that implements the Queue ADT using a Linked-List as the underlying data structure. The {@link Queue} class
 * is nested within this class. Implements methods:
 * <ul>
 *     <li>enqueue</li>
 *     <li>dequeue</li>
 *     <li>front</li>
 *     <li>printQueue</li>
 *     <li>size</li>
 *     <li>isEmpty</li>
 * </ul>
 * @param <E>   The data type of the Queue.
 */
public class Queue<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    /**
     * Default constructor for {@link Stack}. Initializes {@code top} and {@code bottom} to null and {@code size} to 0.
     */
    public Queue() {
        this.first = this.last = null;
        this.size = 0;
    }


    /**
     * Adds param to the end of the queue. If queue contains no nodes, both first and last are set to new node
     * containing param. If queue is not empty, node is added to the end of the current list. {@code size} is
     * incremented by one.
     * @param data  The data to be added into the queue.
     */
    public void enqueue(E data) {
        if (first == null) {
            first = last = new Node<>(data);
        } else {
            Node<E> node = new Node<>(data);
            last.next = node;
            last = node;
        }
        size++;
    }

    /**
     * Removes and returns, the node {@code first}. If the queue is empty, prints an error message. If not, the
     * first node is removed and {@code first} is set to {@code first.next}. If there was only one node in the queue,
     * both {@code first} and {@code last} are set to null as well. {@code size} is decremented.
     */
    public E dequeue() {
        if (first == null) {
            System.out.println("Queue is empty");
            return null;
        } else {
            E data = first.data;
            first = first.next;

            if (first == null) {
                last = null;
            }

            size--;
            return data;
        }
    }

    /**
     * Returns the data in the node {@code first}. If queue is empty, returns null.
     * @return  The data at the front of the queue.
     */
    public E front() {
        if (first == null) {
            System.out.println("Queue is empty");
            return null;
        } else {
            return first.data;
        }
    }

    /**
     * Returns the current size of the queue.
     * @return  The number of nodes in the queue.
     */
    public int size() {
        return size;
    }

    /**
     * Returns whether the queue has any elements in it or not.
     * @return  {@code true} if there are no nodes in the queue and {@code false} if else.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Prints the elements of the stack in a single line and a newline character at the end.
     */
    public void printQueue()
    {
        Node<E> temp = first;
        while (temp != null) {
            System.out.print(temp.data + "    ");
            temp = temp.next;
        }
    }

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
        public Node(E data) {
            this.data = data;
            next = null;
        }
    }
}
