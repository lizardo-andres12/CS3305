// Name: Lizardo Hernandez
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 1
// IDE Name: Intellij

package assignment1;

public class Rectangle {

    // Declare variables
    private double width;
    private double height;

    // Default constructor will call overloaded and feed default values
    public Rectangle() {
        this(1.00, 1.00);
    }

    // Overloaded constructor
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Return rectangle's width value
    public double getWidth() {
        return width;
    }

    // Return rectangle's height value
    public double getHeight() {
        return height;
    }

    // Return rectangle's area value
    public double getArea() {
        return width * height;
    }

    // Return rectangle's perimeter value
    public double getPerimeter() {
        return 2 * width + 2 * height;
    }

    // Print simple description of data
    public void printRectangle(String objectName) {
        System.out.printf("Rectangle %s is %.1f units wide and %.1f units high.\n",
                objectName, width, height);
    }
}
