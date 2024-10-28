// Generic code for class priority_queue_heap for Assignment 7 
// Name: Lizardo Hernandez
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 7
// IDE Name: Intellij

package assignment7;

public class PQ_heap <E extends Comparable<E>>
{
    private Heap<E> pq;
	// Constructor method
   PQ_heap() {
       pq = new Heap<>();
   }

   // Overloaded constructor
   PQ_heap(E[] list) {
       pq = new Heap<>();
       for (E data : list) {
           pq.add(data);
       }
   }
	
	// Return true if priority queue is empty; otherwise return false
   public boolean is_empty() {
       return pq.getSize() == 0;
   }
	
	// Return true if priority queue is full; otherwise return false
   public boolean is_full() {
       return pq.getSize() == pq.getCapacity();
   }

	// Return (don't remove) the front element from the priority queue
	// Precondition: priority queue is not empty.
   public E front() {
       if (pq.getSize() != 0) {
           return pq.getFront();
       } else {
           return null;
       }
   }

	// return number of elements in the queue
   public int size() {
       return pq.getSize();
   }
   
	// Remove the largest value from this priority queue and return it.
	// Precondition: priority queue is not empty.
   public E dequeue() {
       if (pq.getSize() != 0) {
           return pq.remove();
       } else {
           return null;
       }
   }

	// Inserts the 'value' into the priority queue.
	// Precondition: priority queue is not full
   public void enqueue(E value) {
       if (pq.getSize() < pq.getCapacity()) {
           pq.add(value);
       }
   }

   public void print() {
       System.out.println(pq);
   }

   public void verbosePrint() {
        pq.verbosePrint();
   }
};
