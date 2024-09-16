// Name: Lizardo Hernandez
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 4
// IDE Name: Intellij

package assignment4;

import java.util.Scanner;


/**
 * Class containing program entry point and method to check if any given string is a palindrome.
 */
public class CheckPalindrome {

    /**
     * Uses a {@link Stack} to check whether {@code word} is a palindrome. Pushes half of the word left to right onto
     * stack and checks the subsequent pops on the other half of the string from right to left.
     * @param word  The {@link String} word to be checked
     * @return      {@code true} if {@code word} is a palindrome, {@code false} if otherwise
     */
    public static boolean isPalindrome(String word) {
        Stack<Character> stack = new Stack<>();
        int n = word.length();
        int mid = n & 1;
        for (int i = 0; i < n / 2; i++) {
            stack.push(word.charAt(i));
        }

        for (int i = n + mid; i < n; i++) {
            if (stack.top() != word.charAt(word.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Entry point of the application. No command-line arguments are expected. Runs the menu loop and allows user to
     * interact with the program. Asks for menu choice first and then enters switch statement, where corresponding
     * prompts are displayed to execute desired task. User can test various words to see if they are palindromes or not.
     * @param args  The command-line arguments. Expects no arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String menu = """
                -----------------MAIN MENU----------------
                1 – Read input string
                2 – Check palindrome and display output
                3 - Exit program
                
                Enter option number:""";
        String word = "";
        int choice;

        do {
            System.out.print(menu + ' ');
            choice = Integer.parseInt(sc.nextLine());
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.print("Enter the word: ");
                    word = sc.nextLine();
                    System.out.printf("Current word is \"%s\"\n", word);
                    break;
                case 2:
                    System.out.printf("Entered String:\t\"%s\"\n", word);
                    System.out.printf("Judgement:\t\t%s\n", isPalindrome(word) ? "Palindrome" : "Not Palindrome");
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
