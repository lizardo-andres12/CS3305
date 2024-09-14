// Name: Lizardo Hernandez
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 5
// IDE Name: Intellij

package assignment5;


import java.util.Arrays;
import java.util.Scanner;

public class RadixSort {

    public static int getK(int[] nums) {
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

    public static Queue[] getBuckets() {
        Queue<Integer>[] buckets = new Queue[10];
        for (int i = 0; i < 10; i++) {
            buckets[i] = new Queue<>();
        }

        return buckets;
    }

    public static void radixSort(int[] nums) {
        Queue<Integer>[] buckets = getBuckets();
        int k = getK(nums);
        int shift = 1;

        for (int i = 0; i < k; i++) {
            int curQueue = 0;
            for (int num : nums) {
                int digit = num / shift % 10;
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