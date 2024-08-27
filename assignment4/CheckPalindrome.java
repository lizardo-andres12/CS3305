// Name: Lizardo Hernandez
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 4
// IDE Name: Intellij

package assignment4;

import java.util.Scanner;


public class CheckPalindrome {

    public static boolean isPalindrome(String word) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < word.length() / 2; i++) {
            stack.push(word.charAt(i));
        }

        for (int i = 0; i < word.length() / 2; i++) {
            if (stack.top() != word.charAt(word.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }

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
