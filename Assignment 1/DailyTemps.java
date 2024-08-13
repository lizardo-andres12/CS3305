// Name: Lizardo Hernandez
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 1
// IDE Name: Intellij

public class DailyTemps {

    // Declaring attributes
    private int[] temps;

    // Default constructor calls overloaded with default value as 0.0
    public DailyTemps() { this(new int[] {0, 0, 0, 0, 0, 0, 0}); }

    // Overloaded constructor sets attribute temps to input array
    public DailyTemps(int[] temps) {
        this.temps = temps;
    }

    /**
     * Sets temperature of one individual day in attribute temps
     *
     * @param day Index of the array corresponding to day to set (0:Monday, 1:Tuesday, ...)
     * @param temp Temperature of that day
     */
    public void setTemp(int day, int temp) {
        temps[day] = temp;
    }

    /**
     * Method to get the number of values in the array below 32
     *
     * @return Occurrences of values below 32 in attribute temps
     */
    public int Freezing() {
        // Create sum variable to count number of days below 32
        int freezing = 0;

        // Check all values in array temps
        for (int temp : temps) {
            if (temp < 32) {
                freezing++;
            }
        }

        return freezing;
    }

    /**
     * Method to get the index of the first occurrence of the highest temperature in attribute temps
     *
     * @return Index of the first occurrence of the highest value in the array
     */
    public int Warmest() {
        // Create highest value index variable
        int highest = 0;

        // Compare all values to find the index of the highest temperature
        for (int i = 1; i < temps.length; i++) {
            if (temps[highest] < temps[i]) {
                highest = i;
            }
        }

        return highest;
    }

    // Print all array cells in list format
    public void printTemps() {
        // Create reference for indexes as String representations of days
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        // loop over all temperatures and print in list format
        for (int i = 0; i < temps.length; i++) {
            if (days[i].length() < 8) {
                System.out.printf("%s\t\t%d\n", days[i], temps[i]);
            } else {
                System.out.printf("%s\t%d\n", days[i], temps[i]);
            }
        }
    }
}
