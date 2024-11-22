package assignment9;

import java.util.Scanner;

public class ReachabilityMatrix {
    public static int[][] createMatrix(Scanner sc, int n) {
        int[][] adjMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("Enter A1[%d,%d]:\t", i, j);
                int val = Integer.parseInt(sc.nextLine());
                adjMatrix[i][j] = val >= 1 ? 1 : 0;
            }
            System.out.println("...");
        }

        return adjMatrix;
    }

    public static void printMatrix(int[][] matrix) {
        System.out.println("Input Matrix");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%d\t", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] calculateReachabilityMatrix(int[][] A1, int[][] matrix) {
        return A1;
    }

    public static void inDegrees(int[][] adjMatrix) {
        for (int i = 0; i < adjMatrix.length; i++) {
            int deg = 0;
            for (int j = 0; j < adjMatrix[i].length; j++) {
                if (adjMatrix[j][i] == 1) {
                    deg++;
                }
            }
            System.out.printf("Node %d in-degree is %d\n", (i+1), deg);
        }
    }

    public static void outDegrees(int[][] adjMatrix) {
        for (int i = 0; i < adjMatrix.length; i++) {
            int deg = 0;
            for (int j = 0; j < adjMatrix[i].length; j++) {
                if (adjMatrix[i][j] == 1) {
                    deg++;
                }
            }
            System.out.printf("Node %d in-degree is %d\n", (i+1), deg);
        }
    }

    public static int loops(int[][] adjMatrix) {
        int loop = 0;
        for (int i = 0; i < adjMatrix.length; i++) {
            if (adjMatrix[i][i] == 1) {
                loop++;
            }
        }

        return loop;
    }

    public static int A1Paths(int[][] adjMatrix) {
        int paths = 0;
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix[i].length; j++) {
                if (adjMatrix[i][j] == 1) {
                    paths++;
                }
            }
        }

        return paths;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 6;

        while (n >= 5) {
            System.out.print("Enter amount of nodes in the graph: ");
            n = Integer.parseInt(sc.nextLine());
        }

        int[][] adjMatrix = createMatrix(sc, n);
        inDegrees(adjMatrix);
        System.out.println();
        outDegrees(adjMatrix);
    }
}
