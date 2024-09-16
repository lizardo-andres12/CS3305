// Name: Lizardo Hernandez
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 4
// IDE Name: Intellij

package assignment4;

import java.util.Scanner;


/**
 * Class with a program entry point. The entry point will run a sentinel loop to display a menu and allow user to enter
 * choices corresponding to options. Those choices can also prompt for further relevant information and print outputs
 * to the console
 */
public class TestMyStack {

    /**
     * Entry point of the application. No command-line arguments are expected. Runs the menu loop and allows user to
     * interact with the program. Asks for menu choice first and then enters switch statement, where corresponding
     * prompts are displayed to execute desired task. User can enter various phrases to reverse.
     * @param args  The command-line arguments. Expects no arguments
     */
    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        String menu = """
                --------MAIN MENU-------
                1 – Push element
                2 – Pop element
                3 – Get top element
                4 – Get stack size
                5 – Is empty stack?
                6 - Print stack
                7 - Exit program
                
                Enter option number:""";
        int choice, data;

        do {
            System.out.print(menu + ' ');
            choice = Integer.parseInt(sc.nextLine());
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push to top of the stack:\t");
                    data = Integer.parseInt(sc.nextLine());

                    System.out.printf("Stack before pushing: \t", data);
                    myStack.printStack();
                    myStack.push(data);
                    System.out.printf("Stack after pushing:\t", data);
                    myStack.printStack();
                    break;
                case 2:
                    System.out.printf("Stack before popping:\t");
                    myStack.printStack();
                    myStack.pop();
                    System.out.printf("Stack after popping:\t");
                    myStack.printStack();
                    break;
                case 3:
                    System.out.printf("Stack top: %d\t\n", myStack.top());
                    myStack.printStack();
                    break;
                case 4:
                    System.out.print("Current Stack:\t");
                    myStack.printStack();
                    System.out.printf("Stack's current size: %d\n", myStack.size());
                    break;
                case 5:
                    System.out.print("Current Stack:\t");
                    myStack.printStack();
                    System.out.println("Is stack empty: " + myStack.isEmpty());
                    break;
                case 6:
                    System.out.print("Current Stack:\t");
                    myStack.printStack();
                    break;
                case 7:
                    System.out.println("Shutting down ...");
                    break;
                default:
                    System.out.println("Invalid input, try again");
            }
            System.out.println();
        } while (choice != 7);
    }
}
