// Class Heap.java
// Textbook - Listing 23.9, Page 878
// Name: Lizardo Hernandez
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 7
// IDE Name: Intellij

package assignment7;

public class Heap<E extends Comparable<E>> {
    private java.util.ArrayList<E> list = new java.util.ArrayList<E>();
    private final int CAPACITY = 100;

    /**
     * Create a default heap
     */
    public Heap() {
    }

    /**
     * Create a heap from an array of objects
     */
    public Heap(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            add(objects[i]);
    }

    /**
     * Add a new object into the heap
     */
    public void add(E newObject) {
        if (list.size() < CAPACITY) {
            list.add(newObject); // Append to the heap
            int currentIndex = list.size() - 1; // The index of the last node

            while (currentIndex > 0) {
                int parentIndex = (currentIndex - 1) / 2;
                // Swap if the current object is greater than its parent
                if (list.get(currentIndex).compareTo(
                        list.get(parentIndex)) > 0) {
                    E temp = list.get(currentIndex);
                    list.set(currentIndex, list.get(parentIndex));
                    list.set(parentIndex, temp);
                } else
                    break; // the tree is a heap now

                currentIndex = parentIndex;
            }
        }
    }

    /**
     * Remove the root from the heap
     */
    public E remove() {
        if (list.size() == 0) return null;

        E removedObject = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        int currentIndex = 0;
        while (currentIndex < list.size()) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            // Find the maximum between two children
            if (leftChildIndex >= list.size()) break; // The tree is a heap
            int maxIndex = leftChildIndex;
            if (rightChildIndex < list.size()) {
                if (list.get(maxIndex).compareTo(
                        list.get(rightChildIndex)) < 0) {
                    maxIndex = rightChildIndex;
                }
            }

            // Swap if the current node is less than the maximum
            if (list.get(currentIndex).compareTo(
                    list.get(maxIndex)) < 0) {
                E temp = list.get(maxIndex);
                list.set(maxIndex, list.get(currentIndex));
                list.set(currentIndex, temp);
                currentIndex = maxIndex;
            } else
                break; // The tree is a heap
        }

        return removedObject;
    }

    /**
     * Return top element in heap
     *
     * @return top element
     */
    public E getFront() {
        return list.getFirst();
    }

    /**
     * Get the number of nodes in the tree
     */
    public int getSize() {
        return list.size();
    }

    /**
    * Get the capacity of Heap class
    */
    public int getCapacity() {
        return CAPACITY;
    }

    public void verbosePrint() {
      for (int i = 0; i < list.size(); i++) {
        E left = 2 * i + 1 < list.size() ? list.get(2 * i + 1) : null;
        E right = 2 * i + 2 < list.size() ? list.get(2 * i + 2) : null;
        String toPrint = "Index " + i + ":\t" + list.get(i);
        if (left != null) {
          toPrint += "\t" + left;
        }
        if (right != null) {
          toPrint += "\t" + right;
        }
        System.out.println(toPrint);
      }
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
