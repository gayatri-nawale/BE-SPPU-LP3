
import java.util.*;

public class nqueengame {
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

    // Display chessboard
    static void displayBoard(int[][] board, int n) {
        System.out.println("\nChessboard:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of queens: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Enter a positive number.");
            sc.close();
            return;
        }

        int[][] board = new int[n][n];
        int row = 0;
        while (row < n) {
            displayBoard(board, n);
            System.out.println("\nPlace queen in row " + (row + 1));
            System.out.print("Enter column (1 to " + n + ") or 0 to backtrack: ");
            int col = sc.nextInt();

            // Backtrack
            if (col == 0) {
                if (row > 0) {
                    row--;
                    for (int j = 0; j < n; j++) {
                        board[row][j] = 0;
                    }
                    System.out.println("Backtracking! Previous queen removed.");
                } else {
                    System.out.println("No previous row available.");
                }
            } else if (col < 1 || col > n) {
                System.out.println("Invalid column! Try again.");
            } else if (isSafe(board, row, col - 1, n)) {
                board[row][col - 1] = 1;
                System.out.println("Safe move! Queen placed.");
                row++;
            } else {
                System.out.println("Not safe! Try another column.");
            }
        }
        System.out.println("\nCongratulations! Solution found.");
        displayBoard(board, n);
        sc.close();
    }
}
