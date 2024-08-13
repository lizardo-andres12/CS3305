// Name: Lizardo Hernandez
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 2
// IDE Name: Intellij

import java.util.Arrays;
import java.util.Scanner;

public class AverageGrades {

    /**
     * Recursively find the average of a list of grades. This method works based off of a recurrence relation
     * found to be An = ((n-1)An-1 + Xn) / n where n is the number of grades, An is the average of the first n
     * grades, and X is a list of grades. Will return 0 if given an empty array
     *
     * @param grades the array of {@code int} grades to be averaged
     * @return the average of all values in grades. Mathematically would be An where n is length.
     */
    public static double findAverage(int[] grades) {
        if (grades.length == 0) {
            return 0;
        } else {
            int n = grades.length;
            double grade = grades[n-1];
            // recurrence relation
            return ((n-1) * findAverage(Arrays.copyOfRange(grades, 0, n-1)) + grade) / n;
        }
    }

    public static void main(String[] args) {
        // create necessary variables
        Scanner sc = new Scanner(System.in);
        String menu = """
                --------MAIN MENU-------
                1. Read class size
                2. Read class grades
                3. Compute class average
                4. Exit program
                
                Enter option number:""";
        int[] classGrades = new int[0];
        int classSize = 0;
        int choice;

        // menu loop
        do {
            // display menu and get input
            System.out.print(menu);
            System.out.print(' ');
            choice = Integer.parseInt(sc.nextLine());

            // match input to respective process
            switch (choice) {
                case 1:
                    System.out.print("Enter the class size: ");
                    classSize = Integer.parseInt(sc.nextLine());
                    break;
                case 2:
                    classGrades = new int[classSize];
                    for (int i = 0; i < classGrades.length; i++) {
                        System.out.printf("Enter grade %d: ", i + 1);
                        classGrades[i] = Integer.parseInt(sc.nextLine());
                    }
                    break;
                case 3:
                    System.out.printf("You entered class size\t%d\n", classSize);
                    System.out.print("You entered grades\t\t");
                    for (int i = 0; i < classGrades.length; i++) {
                        System.out.print(classGrades[i] + " ");
                    }
                    System.out.printf("\nClass average:\t\t\t%.2f\n", findAverage(classGrades));
                    break;
                default:
                    if (choice != 4) {
                        System.out.println("Invalid input");
                    }
            }
            System.out.println();
        } while (choice != 4);
    }
}
