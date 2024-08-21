// Name: Lizardo Hernandez
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 3
// IDE Name: Intellij

package assignment3;

import java.util.Scanner;


public class myTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList myList = new LinkedList();
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
                Enter option number: \s""";
        int choice = 0;

        do {
           System.out.print(menu);
           System.out.print(' ');
           choice = Integer.parseInt(sc.nextLine());

           switch (choice) {
              case 1:
           }
        } while (choice != 10);
    }
}
    
