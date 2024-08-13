// Name: Lizardo Hernandez
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 1
// IDE Name: Intellij

import java.util.Scanner;


public class TestRectangle {

    /**
     * Tests all methods in Rectangle class using rectangle object
     *
     * @param rect Rectangle object holding information to be displayed
     * @param objectName Name of the rectangle object to be printed
     */
    public static void testData(Rectangle rect, String objectName) {
        System.out.println("Testing method getWidth() on object " + objectName);
        System.out.printf("%s width:%.2f\n\n", objectName, rect.getWidth());

        System.out.println("Testing method getHeight() on object " + objectName);
        System.out.printf("%s height:%.2f\n\n", objectName, rect.getHeight());

        System.out.println("Testing method getArea() on object " + objectName);
        System.out.printf("%s area:%.2f\n\n", objectName, rect.getArea());

        System.out.println("Testing method getPerimeter() on object " + objectName);
        System.out.printf("%s perimeter:%.2f\n\n", objectName, rect.getPerimeter());

        System.out.println("Testing method printRectangle() on object " + objectName);
        rect.printRectangle(objectName);

        System.out.println();
    }

    /**
     * Prints rectangle information in a list format
     *
     * @param rect Rectangle object holding information to be displayed
     * @param objectName Name of the rectangle object to be printed
     */
    public static void prettyPrintData(Rectangle rect, String objectName) {
        System.out.println(objectName);

        // Print underscores equal to character length of objectName
        for (int i = 0; i < objectName.length(); i++) {
            System.out.print('-');

            // print newline character on last iteration
            if (i == objectName.length() - 1) {
                System.out.print('\n');
            }
        }

        // Display data contained in rect using Rectangle class methods
        System.out.printf("Width:\t\t%.2f\n", rect.getWidth());
        System.out.printf("Height:\t\t%.2f\n", rect.getHeight());
        System.out.printf("Area:\t\t%.2f\n", rect.getArea());
        System.out.printf("Perimeter:\t%.2f\n", rect.getPerimeter());

        // Space out data from summary
        System.out.println();

        // Print summary
        rect.printRectangle(objectName);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Declare and initialize default rectangle
        Rectangle myRectangle = new Rectangle();

        // Get data from user to pass to overloaded constructor
        System.out.print("Enter width for your rectangle: ");
        double userWidth = Double.parseDouble(sc.nextLine());
        System.out.print("Enter height for your rectangle: ");
        double userHeight = Double.parseDouble(sc.nextLine());
        System.out.println();

        // Create custom rectangle with user input
        Rectangle yourRectangle = new Rectangle(userWidth, userHeight);

        // Display test and data
        System.out.println("***Test Data***");
        testData(yourRectangle, "yourRectangle");
        prettyPrintData(myRectangle, "myRectangle");
        prettyPrintData(yourRectangle, "yourRectangle");
    }
}
