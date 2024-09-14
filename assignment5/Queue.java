// Name: Lizardo Hernandez
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 5
// IDE Name: Intellij

package assignment5;


public class Queue<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    public Queue() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

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

    public E front() {
        if (first == null) {
            System.out.println("Queue is empty");
            return null;
        } else {
            return first.data;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printQueue()
    {
        Node<E> temp = first;
        while (temp != null) {
            System.out.print(temp.data + "    ");
            temp = temp.next;
        }
    }

    public class Node<E> {
        public E data;
        public Node<E> next;

        public Node(E data) {
            this.data = data;
            next = null;
        }
    }
}
