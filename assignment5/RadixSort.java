// Name: Lizardo Hernandez
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 5
// IDE Name: Intellij

package assignment5;


import java.util.Arrays;
import java.util.Scanner;

/**
 * Class containing a program entry point and a methods related to implementing radix sort. The program's entry point
 * runs a loop to display a menu and allow a user to interact with the program. The user can input array size, array
 * elements, and sort the order of the current array.
 */
public class RadixSort {

    /**
     * Extracts the number of digits of the largest number in {@code param}.
     * @param nums  The array of integers input by the user.
     * @return      The number of digits of the largest number in {@code param}.
     */
    public static int countDigits(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int k = 0;
        while (max > 0) {
            max /= 10;
            k++;
        }

        return k;
    }

    public static int extractDigit(int num, int power) {
        return (int) ((num / Math.pow(10, power)) % 10);
    }

    /**
     * Creates an array of 10 {@link Queue} objects to store numbers processed by the {@code radixSort()} method.
     * @return  An array of size 10 filled with {@link Queue} objects.
     */
    public static Queue[] getBuckets() {
        Queue<Integer>[] buckets = new Queue[10];
        for (int i = 0; i < 10; i++) {
            buckets[i] = new Queue<>();
        }

        return buckets;
    }

    /**
     * Sorts the input array in place using the radix sort, or bucket sort, algorithm. For every digit in the largest
     * number in {@code param}, number in {@code param} are sorted by that digit (ones, tens, hundreds, ...). Numbers
     * are enqueued in an array at index digit where digit is the ith digit of that respective number. They are then
     * dequeued from left to right and placed back in {@code param} in sequential order.
     * @param nums  The array to be sorted. Null or invalid arrays are caught in sentinel loop.
     */
    public static void radixSort(int[] nums) {
        Queue<Integer>[] buckets = getBuckets();
        int k = countDigits(nums);
        int shift = 1;

        for (int i = 0; i < k; i++) {
            int curQueue = 0;
            for (int num : nums) {
                int digit = extractDigit(num, i);
                buckets[digit].enqueue(num);
            }

            for (int j = 0; j < nums.length; j++) {
                while (buckets[curQueue].isEmpty()) {
                    curQueue++;
                }
                nums[j] = buckets[curQueue].dequeue();
            }

            System.out.printf("Sort on digit %d is %s\n", shift, Arrays.toString(nums));
            shift *= 10;
        }
    }

    /**
     * Entry point of the application. No command-line arguments are expected. Runs the menu loop and allows user to
     * interact with the program. Asks for menu choice first and then enters switch statement, where corresponding
     * prompts are displayed to execute desired task. User can enter sizes for the array and values to store in the
     * array.
     * @param args  The command-line arguments. Expects no arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String menu = """
                ---------------MAIN MENU---------------
                1 – Read array size
                2 – Read array values
                3 – Run Radix Sort and print outputs
                4 – Exit program
                
                Enter option number:""";
        int[] nums = new int[0];
        int size = 0;
        int choice;

        do {
            System.out.print(menu + ' ');
            choice = Integer.parseInt(sc.nextLine());
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.print("Enter the number of elements to enter: ");
                    size = Integer.parseInt(sc.nextLine());

                    nums = new int[size];
                    break;
                case 2:
                    if (nums.length == 0) {
                        System.out.println("Define the list size before attempting to insert");
                    } else {
                        for (int i = 0; i < nums.length; i++) {
                            System.out.printf("Enter number %d: ", i + 1);
                            nums[i] = Integer.parseInt(sc.nextLine());
                        }
                    }
                    break;
                case 3:
                    if (nums.length == 0) {
                        System.out.println("Cannot sort an empty list");
                    } else {
                        System.out.printf("Executing radix sort on array %s\n", Arrays.toString(nums));
                        radixSort(nums);
                        System.out.printf("Sorted array is %s\n", Arrays.toString(nums));
                    }
                    break;
                case 4:
                    System.out.println("Shutting off...");
                    break;
                default:
                    System.out.println("Invalid option, try again");
            }
            System.out.println();
        } while (choice != 4);
    }
}