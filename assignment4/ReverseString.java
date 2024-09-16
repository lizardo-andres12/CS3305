// Name: Lizardo Hernandez
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 4
// IDE Name: Intellij

package assignment4;

import java.util.Scanner;


/**
 * Class containing a program entry point and a method to reverse the order of any given string of words.
 */
public class ReverseString {

    /**
     * Uses {@link Stack} to reverse the word order of a string. {@code words} is split by spaces and stored as
     * an array called {@code wordList}. From left to right, words from {@code wordList} are pushed onto the stack and
     * then popped and stored in the output variable
     * @param words The {@code String} of words to reverse order
     * @return      The word-order reversal of {@code words}
     */
    public static String reverseString(String words) {
        Stack<String> stack = new Stack<>();
        String[] wordList = words.split(" ");
        String output = "";

        for (String word : wordList) {
            stack.push(word);
        }

        while(!stack.isEmpty()) {
            output += stack.top() + ' ';
            stack.pop();
        }

        output += '\b';

        return output;
    }

    /**
     * Entry point of the application. No command-line arguments are expected. Runs the menu loop and allows user to
     * interact with the program. Asks for menu choice first and then enters switch statement, where corresponding
     * prompts are displayed to execute desired task. User can enter various phrases to reverse.
     * @param args  The command-line arguments. Expects no arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String menu = """
                -----------------MAIN MENU---------------
                1 – Read input string of words
                2 – Reverse string and display outputs
                3 - Exit program
                
                Enter option number:""";
        String words = "";
        int choice;

        do {
            System.out.print(menu + ' ');
            choice = Integer.parseInt(sc.nextLine());
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.print("Enter the string of words: ");
                    words = sc.nextLine();
                    System.out.printf("Current string is \"%s\"\n", words);
                    break;
                case 2:
                    System.out.printf("Entered String string:\t\"%s\"\n", words);
                    System.out.printf("Reversed string:\t\"%s\"\n", reverseString(words));
                    break;
                case 3:
                    System.out.println("Shutting down...");
                    break;
                default:
                    System.out.println("Invalid input, try again");
            }
            System.out.println();
        } while (choice != 3);
    }
}
