// Name: Lizardo Hernandez
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 1
// IDE Name: Intellij

package assignment8;

import java.util.Scanner;

/**
 * Class that implements methods related to hashing and hash tables.
 */
public class HashFunctions {
    /**
     * Division method hashing with linear probing
     * @param Table The hash table to store keys.
     * @param key The key to be hashed
     */
    public static void HF1(int[][] Table, int key) {
        int probes = 0;
        int place = Math.abs(key % Table.length);

        while (Table[place][0] != 0) {
            place = (place + 1) % Table.length;
            probes++;
        }
        Table[place][0] = key;
        Table[place][1] = probes;
    }

    /**
     * Division method hashing with quadratic probing
     * @param Table The hash table to store keys
     * @param key The key to be hashed
     */
    public static void HF2(int[][] Table, int key) {
        int probes = 0;
        int place = Math.abs(key % Table.length);

        while (Table[place][0] != 0) {
            int subtract = probes * probes;
            int square = ++probes * probes;
            place = Math.abs((place - subtract + square) % Table.length);
        }
        Table[place][0] = key;
        Table[place][1] = probes;
    }

    /**
     * Division method hashing with double hashing. Second has function is {@code H2}.
     * @param Table The hash table to store keys
     * @param key The key to be hashed
     */
    public static void HF3(int[][] Table, int key) {
        int h1 = (key % 50), h2 = H2(key);
        int place;

        for (int i = 0; i <= 50; i++) {
            place = (h1 + i * h2) % Table.length;
            if (Table[place][0] == 0) {
                Table[place][0] = key;
                Table[place][1] = i;
                return;
            }
        }
        System.out.printf("Unable to hash key %d to the table\n", key);
    }

    /**
     * HF4 implements a custom hash function designed to improve performance.
     *
     * Hash Function:
     * We use the Multiplicative Hashing method with a custom constant A:
     *    hash = floor(tableSize * ((key * A) % 1))
     * where A is chosen to distribute the keys uniformly.
     *
     * Collision Resolution:
     * We use Quadratic Probing for collision resolution:
     *    index = (hash + i^2) % tableSize
     * for i = 1, 2, 3, ...
     *
     * This method aims to distribute the keys more uniformly and reduce the number of probes.
     *
     * @param Table The hash table to store the key in
     * @param key The key to be hashed
     */
    public static void HF4(int[][] Table, int key) {
        double A = (Math.sqrt(5) - 1) / 2;
        int hash = (int) (Table.length * ((key * A) % 1));
        int probes = 0;
        int index = hash;
        int i = 1;
        boolean placed = false;

        while (probes < 11) {
            if (Table[index][0] == 0) {
                Table[index][0] = key;
                Table[index][1] = probes;
                placed = true;
                break;
            } else {
                probes++;
                int H2 = 1 + (key % (Table.length - 1));
                index = (hash + i * H2) % Table.length;
                i++;
            }

        }
        if (!placed) {
            System.out.println("Unable to hash key " + key + " to the table.");
        }
    }

    /**
     * Secondary hash function HF3 double hash
     * @param key The key to be hashed
     * @return The hashed value
     */
    public static int H2(int key) {
        return Math.abs(30 - key % 25);
    }

    /**
     * Function to sum the probes needed to store all keys in main into hash table
     * @param Table The hash table to store the keys in
     * @return The total number of probes
     */
    public static int sumProbes(int[][] Table) {
        int sum = 0;
        for (int i = 0; i < Table.length; i++) {
            sum += Table[i][1];
        }
        return sum;
    }

    /**
     * Formatted print of hash table with number of probes at the bottom
     * @param Table The hash table with all keys stored in it
     * @param probes The total number of probes needed to store all keys in hash table
     */
    public static void prettyPrint(int[][] Table, int probes) {
        System.out.println("""
                    Index\tKey\tprobes
                    ------------------------""");
        for (int i = 0; i < Table.length; i++) {
            System.out.printf("\t%d\t%d\t%d\n", i, Table[i][0], Table[i][1]);
        }
        System.out.println("""
                    ------------------------

                    Sum of probe values =""" + ' ' + probes + " probes.");
    }

    /**
     * Entry point for program. Initializes the hash table in variable {@code Table} and the int array {@code keys}
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] Table = new int[50][2];
        int[] keys = {1234, 8234, 7867, 1009, 5438, 4312, 3420, 9487, 5418, 5299,
                5078, 8239, 1208, 5098, 5195, 5329, 4543, 3344, 7698, 5412,
                5567, 5672, 7934, 1254, 6091, 8732, 3095, 1975, 3843, 5589,
                5439, 8907, 4097, 3096, 4310, 5298, 9156, 3895, 6673, 7871,
                5787, 9289, 4553, 7822, 8755, 3398, 6774, 8289, 7665, 5523};
        String menu = """
            -----MAIN MENU--------------------------------------
            1. Run HF1 (Division method with Linear Probing)
            2. Run HF2 (Division method with Quadratic Probing)
            3. Run HF3 (Division method with Double Hashing)
            4. Run HF4 (Student Designed HF)
            5. Exit program
            
            Enter option number:""";
        int choice, probes = 0;

        do {
            System.out.print(menu + ' ');
            choice = Integer.parseInt(sc.nextLine());
            System.out.println();

            switch (choice) {
                case 1: // Run HF1
                    for (int key : keys) {
                        HF1(Table, key);
                    }
                    probes = sumProbes(Table);
                    System.out.println("Hash table resulted by HF1\n");
                    prettyPrint(Table, probes);
                    break;

                case 2: // Run HF2
                    for (int key : keys) {
                        HF2(Table, key);
                    }
                    probes = sumProbes(Table);
                    System.out.println("Hash table resulted by HF2\n");
                    prettyPrint(Table, probes);
                    break;

                case 3: // Run HF3
                    for (int key : keys) {
                        HF3(Table, key);
                    }
                    probes = sumProbes(Table);
                    System.out.println("Hash table resulted by HF3\n");
                    prettyPrint(Table, probes);
                    break;

                case 4: // Run HF4
                    for (int key : keys) {
                        HF4(Table, key);
                    }
                    probes = sumProbes(Table);
                    System.out.println("Hash table resulted by HF4\n");
                    prettyPrint(Table, probes);
                    break;

                default:
                    System.out.println("Invalid input, try again");
            }
            System.out.println();

            // Clear table for multiple uses
            for (int i = 0; i < Table.length; i++) {
                Table[i][0] = 0;
                Table[i][1] = 0;
            }
        } while (choice != 5);
    }
}
