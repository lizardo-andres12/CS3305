// Name: Lizardo Hernandez
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 6
// IDE Name: Intellij

package assignment6;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class with a program entry point. The entry point will run a sentinel loop to display a menu and allow user to enter
 * choices corresponding to options. Those choices can also prompt for further relevant information and print outputs
 * to the console
 */
public class MyTestBST {

    /**
     * Entry point of the application. No command-line arguments are expected. Runs the menu loop and allows user to
     * interact with the program. Asks for menu choice first and then enters switch statement, where corresponding
     * prompts are displayed to execute desired task. User can enter various phrases to reverse.
     * @param args  The command-line arguments. Expects no arguments
     */
    public static void main(String[] args) {
        // Initialize program variables
        Scanner sc = new Scanner(System.in);
        BinarySearchTree<String> stringBST = new BinarySearchTree<>();
        BinarySearchTree<Integer> intBST = new BinarySearchTree<>();
        String menu = """
                ----------------MAIN MENU---------------
                  0. Enter Tree Data Type (integer or string)
                  1. Insert Data Element
                  2. Delete Data Element
                  3. Search for Data Element
                  4. Print Tree Size
                  5. Path from Root to Data Element
                  6. Check if Empty Tree
                  7. Print Preorder Traversal
                  8. Print Inorder Traversal
                  9. Print Postorder Traversal
                  10. Exit program
                
                Enter option number:""";
        int choice, otherInput;
        String input;
        boolean initialized = false, dtype = false;

        // Sentinel loop
        do {
            System.out.print(menu + ' ');
            choice = Integer.parseInt(sc.nextLine());
            System.out.println();

            // force the user to start with 0
            if (!initialized) {
                if (choice == 0) {
                    System.out.print("Enter data type (integer or string): ");
                    String type = sc.nextLine();
                    if (type.equalsIgnoreCase("string")) {
                        dtype = true;
                        initialized = true;
                    } else if (type.equalsIgnoreCase("integer")) {
                        initialized = true;
                    } else {
                        System.out.println("Invalid data type");
                    }
                } else {
                    System.out.println("You must choose choice 0 first");
                }
                System.out.println();
            } else { // Enter main menu loop
                switch (choice) {
                    case 0: // reset data type
                        System.out.print("Enter data type (integer or string): ");
                        String type = sc.nextLine();
                        if (type.equalsIgnoreCase("string")) {
                            dtype = true;
                        } else if (type.equalsIgnoreCase("integer")) {
                            continue;
                        } else {
                            System.out.println("Invalid data type");
                        }
                        break;
                    case 1: // insert dtype element to tree
                        System.out.print("Enter data element: ");
                        if (dtype) { // string dtype
                            input = sc.nextLine();
                            System.out.println("Testing method Insert Data Element (Option 1)");
                            System.out.print("BST before inserting " + input + " (Inorder):\t");
                            stringBST.inorder();
                            stringBST.insert(input);
                            System.out.println();
                            System.out.print("BST after inserting " + input + " (Inorder):\t");
                            stringBST.inorder();
                        } else { // int dtype
                            otherInput = Integer.parseInt(sc.nextLine());
                            System.out.println("Testing method Insert Data Element (Option 1)");
                            System.out.print("BST before inserting " + otherInput + " (Inorder):\t");
                            intBST.inorder();
                            intBST.insert(otherInput);
                            System.out.println();
                            System.out.print("BST after inserting " + otherInput + " (Inorder):\t");
                            intBST.inorder();
                        }
                        break;
                    case 2: // remove dtype element from tree
                        System.out.print("Enter data element: ");
                        if (dtype) { // string dtype
                            input = sc.nextLine();
                            System.out.println("Testing method Delete Data Element (Option 2)");
                            System.out.print("BST before deleting " + input + " (Inorder):\t");
                            stringBST.inorder();
                            System.out.println();
                            if (stringBST.remove(input)) {
                                System.out.print("BST after deleting " + input + " (Inorder):\t");
                                stringBST.inorder();
                            } else {
                                System.out.println("Element " + input + " is not in the tree");
                            }
                        } else { // int dtype
                            otherInput = Integer.parseInt(sc.nextLine());
                            System.out.println("Testing method Delete Data Element (Option 2)");
                            System.out.print("BST before deleting " + otherInput + " (Inorder):\t");
                            intBST.inorder();
                            System.out.println();
                            if (intBST.remove(otherInput)) {
                                System.out.print("BST after deleting " + otherInput + " (Inorder):\t");
                                intBST.inorder();
                            } else {
                                System.out.println("Element " + otherInput + " is not in the tree");
                            }
                        }
                        break;
                    case 3: // search for element in tree
                        System.out.print("Enter data element: ");
                        if (dtype) { // string dtype
                            input = sc.nextLine();
                            System.out.println("Testing method Search for Data Element (Option 3)");
                            System.out.println("Is " + input + " in the tree? " + stringBST.search(input));
                        } else { // int dtype
                            otherInput = Integer.parseInt(sc.nextLine());
                            System.out.println("Testing method Search for Data Element (Option 3)");
                            System.out.println("Is " + otherInput + " in the tree? " + intBST.search(otherInput));
                        }
                        break;
                    case 4: // get size of dtype tree
                        System.out.println("Testing method Tree size (Option 4)");
                        if (dtype) {
                            System.out.println("Tree size: " + stringBST.size());
                        } else {
                            System.out.println("Tree size: " + intBST.size());
                        }
                        break;
                    case 5: // get ArrayList path to element node
                        System.out.print("Enter data element: ");
                        if (dtype) { // string dtype
                            input = sc.nextLine();
                            System.out.println("Testing method Path from Root to Data Element (Option 5)");
                            if (stringBST.search(input)) {
                                ArrayList<TreeNode<String>> path = stringBST.path(input);
                                System.out.print("Path from root to " + input + "\t");
                                for (TreeNode<String> node : path) {
                                    System.out.print(node.data + ' ');
                                }
                            } else {
                                System.out.println("Element " + input + " is not in the list");
                            }
                        } else { // int dtype
                            otherInput = Integer.parseInt(sc.nextLine());
                            System.out.println("Testing method Path from Root to Data Element (Option 5)");
                            if (intBST.search(otherInput)) {
                                ArrayList<TreeNode<Integer>> path = intBST.path(otherInput);
                                System.out.print("Path from root to " + otherInput + "\t");
                                for (TreeNode<Integer> node : path) {
                                    System.out.print(node.data + ' ');
                                }
                            } else {
                                System.out.println("Element " + otherInput + " is not in the list");
                            }
                        }
                        break;
                    case 6: // check empty
                        System.out.println("Testing method Check if Empty Tree (Option 6)");
                        if (dtype) {
                            System.out.println("Is empty tree? " + stringBST.isEmpty());
                        } else {
                            System.out.println("Is empty tree? " + intBST.isEmpty());
                        }
                        break;
                    case 7: // preorder traversal
                        System.out.println("Testing method Preorder Traversal (Option 7)");
                        System.out.print("Preorder: ");
                        if (dtype) {
                            stringBST.preorder();
                        } else {
                            intBST.preorder();
                        }
                        break;
                    case 8: // inorder traversal
                        System.out.println("Testing method Inorder Traversal (Option 8)");
                        System.out.print("Inorder: ");
                        if (dtype) {
                            stringBST.inorder();
                        } else {
                            intBST.inorder();
                        }
                        break;
                    case 9: // postorder traversal
                        System.out.println("Testing method Postorder Traversal (Option 9)");
                        System.out.print("Postorder: ");
                        if (dtype) {
                            stringBST.postorder();
                        } else {
                            intBST.postorder();
                        }
                        break;
                    case 10: // exit the loop
                        System.out.println("Shutting off...");
                        break;
                    default:
                        System.out.println("Invalid option, try again");
                }
                System.out.println();
            }
        } while (choice != 10);
    }
}
