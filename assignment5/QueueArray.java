// Name: Lizardo Hernandez
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 5
// IDE Name: Intellij

package assignment5;


public class QueueArray<E> {

    private final int MAX_SIZE = 10;
    private E[] queue;
    private int size;
    private int first, last;

    public QueueArray() {
        queue = (E[]) new Object[MAX_SIZE];
        first = 0;
        last = -1;
    }

    public void enqueue(E data) {
        if (size == MAX_SIZE) {
            System.out.println("Queue is full");
        } else {
            last = (last + 1) % MAX_SIZE;
            queue[last] = data;
            size++;
        }
    }

    public E dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return null;
        } else {
            E data = queue[first];
            first = (first + 1) % 10;
            queue[first] = null;
            size--;
            return data;
        }
    }

    public E front() {
        return queue[first];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }

    public void printQueue() {
        for (E data : queue) {
            System.out.print(data + "   ");
        }
    }
}