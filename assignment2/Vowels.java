// Name: Lizardo Hernandez
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 2
// IDE Name: Intellij

package assignment2;

import java.util.Scanner;


public class Vowels {

    /**
     * Returns the number of times vowels occur within the {@code String} input. This method is not case-sensitive.
     *
     * @param input the user-inputted {@code String} where vowels are to be counted
     * @return number of occurrences of vowels a, e, i, o, u
     */
    public static int countVowels(String input) {
        // convert all letters to lower which allows method to ignore case
        input = input.toLowerCase();

        // base case returns no vowel occurrence
        if (input.isEmpty()) {
            return 0;
        } else {
            // check if first letter is a vowel and return recursive call + 1 if true or else just recursive call
            char cur = input.charAt(0);
            if (cur == 'a' || cur == 'e' || cur == 'i' || cur == 'o' || cur == 'u' ) {
                return 1 + countVowels(input.substring(1));
            }
            return countVowels(input.substring(1));
        }
    }

    public static void main(String[] args) {
        // create necessary variables
        Scanner sc = new Scanner(System.in);
        String menu = """
                ---------MAIN MENU---------
                1. Read input string
                2. Compute number of vowels
                3. Exit program
                
                Enter option number:""";
        String input = "";
        int choice;

        // menu loop
        do {
            // display menu and get input
            System.out.print(menu);
            System.out.print(' ');
            choice = Integer.parseInt(sc.nextLine());

            // match inputs to respective processes
            switch (choice) {
                case 1:
                    System.out.print("Enter input string: ");
                    input = sc.nextLine();
                    break;
                case 2:
                    System.out.printf("You entered string:\t%s\n", input);
                    System.out.printf("Number of vowels:\t%d\n", countVowels(input));
                    break;
                default:
                    if (choice != 3) {
                        System.out.println("Invalid input");
                    }
            }
            System.out.println();
        } while (choice != 3);
    }
}