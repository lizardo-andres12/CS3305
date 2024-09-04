// Name: Lizardo Hernandez
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 3
// IDE Name: Intellij

/*
  This class define a linked list that stores integer values.
  The class does NOT use Head and Tail pointer as the textbook class does.
*/

package assignment3;


public class LinkedList_No_HT
{
   public Node ListName;

   //constructor method to create a list object with a specifc name. 
   public LinkedList_No_HT()
   {
      ListName = null;
   }
  
   //method add node to end of list
   public void addLastNode(int data) 
   {
      if (ListName == null) 
         ListName = new Node(data); //one node list
      else 
      {
         Node temp = ListName;
         while (temp.next != null) 
         {
            temp = temp.next;
         }
         
         temp.next = new Node(data); //link new node as last node
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
   public void addFirstNode(int data)
   {
      if (ListName == null) {
         ListName = new Node(data);
      } else {
         Node node = new Node(data);
         node.next = ListName;
         ListName = node;
      }
   }
     
      
   //method #2: add node at index
   /**
    * Adds data at the index provided as argument. Indexes outside of range 0 to size-1 will not add the
    * data and will print an error message to the console
    *
    * @param index The index where to add the new node in the list
    * @param data  The value of the new node in the list
    */
   public void addAtIndex(int index, int data)
   {
      int n = countNodes();
      if (index < 0 || index >= n) {
         System.out.println("Invalid index, try again");
      } else if (ListName == null || index == 0) {
         addFirstNode(data);
      } else {
         Node left = ListName;
         Node right = ListName.next;
         Node node = new Node(data);

         for (int i = 1; i < index; i++) {
            left = left.next;
            right = right.next;
         }

         left.next = node;
         node.next = right;
      }
   }
      
      
   //method #3: remove first node
   /**
    * Removes the node pointed to by {@code head} and advances the head pointer to the next node.
    * If list is empty, print an error message to the console. If the list has one element, set
    * {@code head} and {@code tail} pointers to null
    */
   public void removeFirstNode()
   {
      if (ListName == null) {
         System.out.println("List is empty");
      } else {
         ListName = ListName.next;
      }
   }
      
      
   //method #4: remove last node
   /**
    * Removes the tail node. The list must be traversed to the node before {@code tail} to remove tail.
    * If the list is empty, print an error message to the console. If there's only one element in the
    * list, set {@code head} and {@code tail} to null
    */
   public void removeLastNode()
   {
      if (ListName == null) {
         System.out.println("List is empty");
      } else if (ListName.next == null) {
         ListName = null;
      } else {
         Node left = ListName;
         Node right = ListName.next;

         while (right.next != null) {
            left = left.next;
            right = right.next;
         }

         left.next = null;
      }
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
   public void removeAtIndex(int index)
   {
      int n = countNodes();
      if (ListName == null) {
         System.out.println("List is empty");
      } else if (index < 0 || index >= n) {
         System.out.println("Invalid index, try again");
      } else if (index == 0) {
         removeFirstNode();
      } else if (index == n - 1) {
         removeLastNode();
      } else {
         Node left = ListName;
         Node right = ListName.next;

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
   public int countNodes()
   {
      int listSize= 0;
      Node cur = ListName;

      while (cur != null) {
         listSize += 1;
         cur = cur.next;
      }
      
      return listSize;
   }

   
   //method #7: printInReverse (must be a Recursive method)
   /**
    * Recursively iterates through the list until the input {@code Node} is null. Once the base case is
    * reached, print the values in returning time
    *
    * @param L The first node of the list to be printed
    */
   public void printInReverseRecursive(Node L)
   {
      if (L != null) {
         printInReverseRecursive(L.next);
         System.out.print(L.data + "   ");
      }
   }

   //================= end of your part ==============

   //method to print out the list
   public void printList()
   {
      Node temp;
      temp = ListName;
      while (temp != null)
      {
         System.out.print(temp.data + "   ");
         temp = temp.next;
      }
   }
  
   //class to create nodes as objects
   private class Node
   {
      private int data;  //data field
      private Node next; //link field
       
      public Node(int item) //constructor method
      {
         data = item;
         next = null;
      }
   }
}

