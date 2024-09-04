// Name: Lizardo Hernandez
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 3
// IDE Name: Intellij

package assignment3;

import java.util.Scanner;


public class myTest_No_HT {
    public static void main(String[] args) {
        // initialize necessary variables
        Scanner sc = new Scanner(System.in);
        LinkedList_No_HT myList = new LinkedList_No_HT();
        String menu = """
                ---------MAIN MENU--------
                1 – Add First Node
                2 – Add Last Node
                3 – Add At Index
                4 – Remove First Node
                5 – Remove Last Node
                6 – Remove At Index
                7 – Print List Size
                8 – Print List (Forward)
                9 – Print List (In Reverse)
                10- Exit program
                \s
                Enter option number:""";
        int choice = 0;
        int data, index;

        // start menu loop
        do {
            // print menu and get input from user
            System.out.print(menu);
            System.out.print(' ');
            choice = Integer.parseInt(sc.nextLine());
            System.out.println();

            // match choice to operation
            switch (choice) {
                // add to the head of linked list
                case 1:
                    System.out.print("Enter the value to be stored:\t");
                    data = Integer.parseInt(sc.nextLine());

                    System.out.printf("Adding %d as first node\n", data);
                    System.out.printf("List content before adding %d is:\t", data);
                    myList.printList();
                    System.out.println();
                    myList.addFirstNode(data);
                    System.out.printf("List content after adding %d is:\t", data);
                    myList.printList();
                    System.out.println();
                    break;
                // add to the end of the linked list
                case 2:
                    System.out.print("Enter the value to be stored:\t");
                    data = Integer.parseInt(sc.nextLine());

                    System.out.printf("Adding %d as last node\n", data);
                    System.out.printf("List content before adding %d is:\t", data);
                    myList.printList();
                    System.out.println();
                    myList.addLastNode(data);
                    System.out.printf("List content after adding %d is:\t", data);
                    myList.printList();
                    System.out.println();
                    break;
                // add at specific index of list
                case 3:
                    System.out.print("Enter the value to be stored:\t");
                    data = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter the index to be stored at:\t");
                    index = Integer.parseInt(sc.nextLine());

                    System.out.printf("Adding %d at index %d\n", data, index);
                    System.out.printf("List content before adding %d is:\t", data);
                    myList.printList();
                    System.out.println();
                    myList.addAtIndex(index, data);
                    System.out.printf("List content after adding %d is:\t", data);
                    myList.printList();
                    System.out.println();
                    break;
                // remove head from list
                case 4:
                    System.out.println("Method removeFirstNode()");
                    System.out.print("List content before removing first node is:\t");
                    myList.printList();
                    System.out.println();
                    myList.removeFirstNode();
                    System.out.print("List content after removing first node is:\t");
                    myList.printList();
                    System.out.println();
                    break;
                // remove tail from list
                case 5:
                    System.out.println("Method removeLastNode()");
                    System.out.print("List content before removing last node is:\t");
                    myList.printList();
                    System.out.println();
                    myList.removeLastNode();
                    System.out.print("List content after removing last node is:\t");
                    myList.printList();
                    System.out.println();
                    break;
                // remove value at specific index
                case 6:
                    System.out.print("Enter the index to remove:\t");
                    index = Integer.parseInt(sc.nextLine());

                    System.out.println("Method removeAtIndex()");
                    System.out.printf("List content before removing at index %d is:\t", index);
                    myList.printList();
                    System.out.println();
                    myList.removeAtIndex(index);
                    System.out.printf("List content after removing at index %d is:\t", index);
                    myList.printList();
                    System.out.println();
                    break;
                // print the list size
                case 7:
                    System.out.printf("List size is: %d\n", myList.countNodes());
                    break;
                // print list from left to right
                case 8:
                    System.out.print("Printing list forward:\t");
                    myList.printList();
                    System.out.println();
                    break;
                // print list from right to left (recursive)
                case 9:
                    System.out.print("Printing list in reverse:\t");
                    myList.printInReverseRecursive(myList.ListName);
                    System.out.println();
                    break;
                // print end program indicator
                case 10:
                    System.out.println("Shutting down...");
                    break;
                // invalid option indicator
                default:
                    System.out.println("Invalid input, please try again");
            }
            System.out.println();
        } while (choice != 10);
    }
}
    
