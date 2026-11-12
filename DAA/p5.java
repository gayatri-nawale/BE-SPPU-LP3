// Design n-Queens matrix having first Queen placed. Use backtracking to place remaining
// Queens to generate the final n-queen‘s matrix.
import java.util.*;
public class p5 {
    static int count = 0;
    static boolean isSafe(int[][] board, int row, int col, int n) {

        // Check same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }
        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    // Place queens using backtracking
    static void solve(int[][] board, int row, int n) {

        // All queens are placed
        if (row == n) {
            count++;
            System.out.println("Solution " + count + ":");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println();
            return;
        }

        // Try every column in the current row
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 1;
                solve(board, row + 1, n);
                // Backtrack
                board[row][col] = 0;
            }
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of queens: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Enter a positive number.");
        } else {
            int[][] board = new int[n][n];

            solve(board, 0, n);

            if (count == 0) {
                System.out.println("No solution exists.");
            } else {
                System.out.println("Total Solutions = " + count);
            }
        }
        sc.close();
    }
}
