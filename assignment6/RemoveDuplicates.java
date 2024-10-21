// Name: Lizardo Hernandez
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 6
// IDE Name: Intellij

package assignment6;


import java.util.Scanner;

/**
 * Class containing a program entry point and a methods related to removing duplicates. The program's entry point
 * runs a loop to display a menu and allow a user to interact with the program. The user can input array size, array
 * elements, and sort the order of the current array.
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        // Initialize program variables
        Scanner sc = new Scanner(System.in);
        String menu = """
                -----------------MAIN MENU---------------
                1. Read input string
                2. Remove duplicates and display outputs
                3. Exit program
                
                Enter option number:""";
        String text = null;
        int choice;

        // sentinel loop
        do {
            System.out.print(menu + ' ');
            choice = Integer.parseInt(sc.nextLine());
            System.out.println();

            switch (choice) {
                case 1: // Get text to process
                    System.out.print("Enter text: ");
                    text = sc.nextLine();
                    break;
                case 2: // Process text and display output
                    if (text != null) {
                        System.out.println("Original Text:");
                        System.out.println(text);
                        System.out.println();
                        BinarySearchTree<String> bst = new BinarySearchTree<>(text.split(" "));
                        System.out.println("Processed Text:");
                        bst.inorder();
                    } else {
                        System.out.println("Enter text to process first");
                    }
                    break;
                case 3: // Exit program
                    System.out.println("Shutting off...");
            }
            System.out.println();
        } while (choice != 3);
    }
}
