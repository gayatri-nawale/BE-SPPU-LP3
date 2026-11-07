// Write a program to generate Fibonacci numbers using recursive and
// non-recursive (iterative) methods and analyze their time and space
// complexity.
import java.util.Scanner;

public class p1 {

    // Non-Recursive (Iterative) Method
    public static void nonrecursive(int n) {

        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int c = a + b;
            a = b;
            b = c;
        }
    }

    // Recursive Method
    public static int recursive(int n) {
        if (n <= 1)
            return n;
        else
            return recursive(n - 1) + recursive(n - 2);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Enter no. of terms to display in series: ");
        n = sc.nextInt();

        System.out.println("Fibonacci Series (Recursive):");
        long startRecursive = System.nanoTime();
        for (int i = 0; i < n; i++) {
            System.out.print(recursive(i) + " ");
        }
        long endRecursive = System.nanoTime();
        long recursiveTime = endRecursive - startRecursive;
        System.out.println("\nRecursive Execution Time: " + (recursiveTime / 1000000.0) + " milliseconds");

        System.out.println();

        System.out.println("Fibonacci Series (Non-Recursive):");
        long startIterative = System.nanoTime();
        nonrecursive(n);
        long endIterative = System.nanoTime();
        long iterativeTime = endIterative - startIterative;
        System.out.println("\nNon-Recursive Execution Time: " + (iterativeTime / 1000000.0) + " milliseconds");
        System.out.println();

        // To get the Fibonacci number at the nth index
        // System.out.println("Fibonacci number at index " + n + " is: " + recursive(n));
        sc.close();
    }
}


