// Name: Lizardo Hernandez
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 3
// IDE Name: Intellij

/*
This class define a linked list that stores integer values.
*/

package assignment3;


public class LinkedList {
    public Node head, tail;

    //constructor method to create a list of object with head, tail, and size.
    public LinkedList() {
        head = null;
        tail = null;
    }

    //method add node to end of list
    public void addLastNode(int data) {
        if (tail == null)
            head = tail = new Node(data); //empty list
        else {
            tail.next = new Node(data); //link new node as last node
            tail = tail.next; //make tail pointer points to last node
        }
    }

    //======== Your part to complete for this assignment =========

    //method #1: add first node
    /**
     * Adds data to the beginning of the list. If list is empty, head and tail pointers are initialized
     * to the new node with the data given
     *
     * @param data The value of the new node in the list
     */
    public void addFirstNode(int data) {
        if (head == null) {
            head = tail = new Node(data);
            return;
        }

        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    //method #2: add node at index

    /**
     * Adds data at the index provided as argument. Indexes outside of range 0 to size-1 will not add the
     * data and will print an error message to the console
     *
     * @param index The index where to add the new node in the list
     * @param data The value of the new node in the list
     */
    public void addAtIndex(int index, int data) {
        int numNodes = countNodes();
        if (index < 0 || index >= numNodes) {
            System.out.println("Invalid index, try again");
            return;
        } else if (head == null || index == 0) {
            addFirstNode(data);
        } else if (index == numNodes - 1) {
            addLastNode(data);
        }

        Node node = new Node(data);
        Node left = head;
        Node right = head.next;

        for (int i = 1; i < index; i++) {
            left = left.next;
            right = right.next;
        }

        left.next = node;
        node.next = right;
    }

    //method #3: remove first node
    /**
     * Removes the node pointed to by {@code head} and advances the head pointer to the next node.
     * If list is empty, print an error message to the console. If the list has one element, set
     * {@code head} and {@code tail} pointers to null
     */
    public void removeFirstNode() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        head = head.next;

        if (head == null) {
            tail = null;
        }
    }

    //method #4: remove last node
    /**
     * Removes the tail node. The list must be traversed to the node before {@code tail} to remove tail.
     * If the list is empty, print an error message to the console. If there's only one element in the
     * list, set {@code head} and {@code tail} to null
     */
    public void removeLastNode() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        } else if (head.next == null) {
            head = tail = null;
            return;
        }

        Node cur = head;
        while (cur.next != tail) {
            cur = cur.next;
        }

        cur.next = null;
        tail = cur;
    }

    //method #5: remove node at index
    /**
     * Removes node at specific index. If list is empty, print an error message to the console. If the
     * index is not in the range of 0 to size-1, print and error message to the console. Use two
     * temporary pointers to know when the target index is found and the node before is found to do
     * the insert
     *
     * @param index The 0-based index where the new node should be
     */
    public void removeAtIndex(int index) {
        int numNodes = countNodes();
        if (head == null) {
            System.out.println("List is empty");
        } else if (index < 0 || index >= numNodes) {
            System.out.println("Invalid index, try again");
        } else if (index == 0) {
            removeFirstNode();
        } else if (index == numNodes - 1) {
            removeLastNode();
        } else {
            Node left = head;
            Node right = head.next;

            for (int i = 1; i < index; i++) {
                left = left.next;
                right = right.next;
            }

            left.next = right.next;
        }
    }

    //method #6: countNodes
    /**
     * Traverses the list and totals the number of nodes linked in the list
     *
     * @return The number of nodes linked from head to tail
     */
    public int countNodes() {
        int listSize = 0;

        Node cur = head;
        while (cur != null) {
           listSize++;
           cur = cur.next;
        }

        // this methods returns the list size
        return listSize;
    }

    //method #7: printInReverse  (Recursive method)
    /**
     * Recursively iterates through the list until the input {@code Node} is null. Once the base case is
     * reached, print the values in returning time
     *
     * @param L The first node of the list to be printed
     */
    public void printInReverse(Node L) {
       if (L != null) {
          printInReverse(L.next);
          System.out.print(L.data + "   ");
       }
    }

    //================= end of your part ==============

    //method to print out the list
    public void printList() {
        Node temp;
        temp = head;
        while (temp != null) {
            System.out.print(temp.data + "   ");
            temp = temp.next;
        }
    }

    //class to create nodes as objects
    private class Node {
        private int data;  //data field
        private Node next; //link field

        public Node(int item) //constructor method
        {
            data = item;
            next = null;
        }
    }
}

