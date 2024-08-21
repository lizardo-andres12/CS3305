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
    public void addAtIndex(int index, int data) {
        int numNodes = countNodes();
        if (index < 0 || index >= numNodes) {
            System.out.println("Invalid index, try again");
            return;
        }

        Node node = new Node(data);
        Node left = head;
        Node right = head.next;

        if (head == null || index == 0) {
            addFirstNode(data);
        } else if (index == numNodes - 1) {
            addLastNode(data);
        }

        for (int i = 1; i < index; i++) {
            left = left.next;
            right = right.next;
        }

        left.next = node;
        node.next = right;
    }

    //method #3: remove first node
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
    public void removeLastNode() {
        if (tail == null) {
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
    public int countNodes() {
        int listSize = 0;

        Node cur = head;
        while (cur != null) {
           listSize++;
           cur = cur.next;
        }

        //this methods returns the list size
        return listSize;
    }

    //method #7: printInReverse  (Recursive method)
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

