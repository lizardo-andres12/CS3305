// Name: Lizardo Hernandez
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 1
// IDE Name: Intellij

import java.util.Scanner;


public class TestTemps {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] days = {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
        };

        System.out.println("Testing DailyTemps default constructor");
        DailyTemps myDailyTemps = new DailyTemps();
        myDailyTemps.printTemps();

        System.out.println();

        System.out.println("Testing DailyTemps overloaded constructor");
        int[] temps = {52, 32, 31, 67, 89, 90, 54};
        myDailyTemps = new DailyTemps(temps);
        myDailyTemps.printTemps();

        System.out.println();

        System.out.println("Testing method setTemp()");
        System.out.print("Enter the day you wish to change: ");
        String day = sc.nextLine();
        int dayIndex = 0;
        for (int i = 0; i < days.length; i++) {
            if (day.equalsIgnoreCase(days[i])) {
                dayIndex = i;
                break;
            }
        }
        System.out.print("Enter the new temperature of the day: ");
        int temp = Integer.parseInt(sc.nextLine());
        myDailyTemps.setTemp(dayIndex, temp);

        System.out.println();

        System.out.println("Testing method Freezing()");
        System.out.println("Number of freezing days is " + myDailyTemps.Freezing() + " days");

        System.out.println();

        System.out.println("Testing method Warmest()");
        int warmestDay = myDailyTemps.Warmest();
        System.out.println("Warmest day is " + days[myDailyTemps.Warmest()]);

        System.out.println();

        System.out.println("Testing method printTemps()");
        myDailyTemps.printTemps();
    }
}
