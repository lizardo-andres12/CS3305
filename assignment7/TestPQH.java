// Name: Lizardo Hernandez
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 7
// IDE Name: Intellij

package assignment7;

import java.util.Scanner;

/**
 * Class with a program entry point. The entry point will run a sentinel loop to display a menu and allow user to enter
 * choices corresponding to options. Those choices can also prompt for further relevant information and print outputs
 * to the console
 */
public class TestPQH {

    /**
     * Entry point of the application. No command-line arguments are expected. Runs the menu loop and allows user to
     * interact with the program. Asks for menu choice first and then enters switch statement, where corresponding
     * prompts are displayed to execute desired task. User can enter various phrases to reverse.
     * @param args  The command-line arguments. Expects no arguments
     */
    public static void main(String[] args) {
        // Initialize program variables
        Scanner sc = new Scanner(System.in);
        PQ_heap<Integer> intPQ = new PQ_heap<>();
        PQ_heap<String> strPQ = new PQ_heap<>();
        String menu = """
                ----------------MAIN MENU---------------
                0. Enter Queue Type (integer or string)
                1. Enqueue Element
                2. Dequeue Element
                3. Check is_Full
                4. Check is_Empty
                5. Print PQueue Size
                6. Display Front Element
                7. Print PQueue Elements
                8. Exit program
                
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
                    case 1: // enqueue data to PQ
                        System.out.print("Enter data element: ");
                        if (dtype) { // string dtype
                            input = sc.nextLine();
                            System.out.println("Testing method Enqueue Element");
                            System.out.print("PQ before enqueueing:\t");
                            strPQ.print();
                            strPQ.enqueue(input);
                            System.out.println();
                            System.out.print("PQ after enqueueing:\t");
                            strPQ.print();
                        } else { // int dtype
                            otherInput = Integer.parseInt(sc.nextLine());
                            System.out.println("Testing method Enqueue Element");
                            System.out.print("PQ before enqueueing:\t");
                            intPQ.print();
                            intPQ.enqueue(otherInput);
                            System.out.println();
                            System.out.print("PQ after enqueueing:\t");
                            intPQ.print();
                        }
                        break;
                    case 2: // dequeue front from PQ
                        System.out.println("Testing method dequeue");
                        if (dtype) { // string dtype
                            System.out.print("PQ before dequeueing:\t");
                            strPQ.print();
                            System.out.println();
                            if (strPQ.dequeue() != null) {
                                System.out.print("PQ after dequeueing:\t");
                                strPQ.print();
                            } else {
                                System.out.println("Queue is empty");
                            }
                        } else { // int dtype
                            System.out.print("PQ before dequeueing:\t");
                            intPQ.print();
                            System.out.println();
                            if (intPQ.dequeue() != null) {
                                System.out.print("PQ after dequeueing:\t");
                                intPQ.print();
                            } else {
                                System.out.println("Queue is empty");
                            }
                        }
                        break;
                    case 3: // check if PQ is full
                        System.out.println("Testing method Full");
                        if (dtype) { // string dtype
                            System.out.println("PQ full?:\t"+ strPQ.is_full());
                        } else { // int dtype
                            System.out.println("PQ full?:\t"+ intPQ.is_full());
                        }
                        break;
                    case 4: // check if PQ is empty
                        System.out.println("Testing method Empty");
                        if (dtype) {
                            System.out.println("PQ empty?:\t" + strPQ.is_empty());
                        } else {
                            System.out.println("PQ empty?:\t" + intPQ.is_empty());
                        }
                        break;
                    case 5: // get PQ size
                        System.out.println("Testing method Size");
                        if (dtype) { // string dtype
                            System.out.println("PQ size:\t" + strPQ.size());
                        } else { // int dtype
                            System.out.println("PQ size:\t" + intPQ.size());
                        }
                        break;
                    case 6: // check front
                        System.out.println("Testing method Front");
                        if (dtype) {
                            if (strPQ.front() != null) {
                                System.out.println("PQ is empty");
                            } else {
                                System.out.println("PQ front:\t" + strPQ.front());
                            }
                        } else {
                            if (intPQ.front() != null) {
                                System.out.println("PQ is empty");
                            } else {
                                System.out.println("PQ front:\t" + intPQ.front());
                            }
                        }
                        break;
                    case 7: // print priority queue
                        System.out.println("Testing method Print");
                        if (dtype) {
                            strPQ.verbosePrint();
                        } else {
                            intPQ.verbosePrint();
                        }
                        break;
                    case 8: // exit the loop
                        System.out.println("Shutting off...");
                        break;
                    default:
                        System.out.println("Invalid option, try again");
                }
                System.out.println();
            }
        } while (choice != 8);
    }
}
