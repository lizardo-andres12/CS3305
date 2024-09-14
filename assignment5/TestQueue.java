// Name: Lizardo Hernandez
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 1
// IDE Name: Intellij

package assignment5;

import java.util.Scanner;

public class TestQueue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new Queue<>();

        // Uncomment to test array-based implementation
        // QueueArray<Integer> queue = new QueueArray<>();
        String menu = """
                --------MAIN MENU--------
                1 – Enqueue element
                2 – Dequeue element
                3 – Get front element
                4 – Get queue size
                5 – Is Empty queue?
                6 - Print queue
                7 - Exit program
                
                Enter option number:""";
        int choice, data;

        do {
            System.out.print(menu + ' ');
            choice = Integer.parseInt(sc.nextLine());
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to be entered in queue: ");
                    data = Integer.parseInt(sc.nextLine());

                    System.out.print("Queue before enqueue: ");
                    queue.printQueue();
                    System.out.println();

                    queue.enqueue(data);

                    System.out.print("Queue after enqueue: ");
                    queue.printQueue();
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Queue before dequeue: ");
                    queue.printQueue();
                    System.out.println();

                    System.out.printf("Dequeued value: %d\n", queue.dequeue());

                    System.out.print("Queue after dequeue: ");
                    queue.printQueue();
                    System.out.println();
                    break;
                case 3:
                    System.out.printf("Current front of queue: %d\n", queue.front());
                    break;
                case 4:
                    System.out.printf("Current queue size: %d\n", queue.size());
                    break;
                case 5:
                    if (queue.isEmpty()) {
                        System.out.println("Queue is currently empty");
                    } else {
                        System.out.println("Queue is not empty");
                    }
                    break;
                case 6:
                    System.out.print("Current queue: ");
                    queue.printQueue();
                    System.out.println();
                    break;
                case 7:
                    System.out.println("Shutting off...");
                    break;
                default:
                    System.out.println("Invalid option, try again");
            }
            System.out.println();
        } while (choice != 7);
    }
}
