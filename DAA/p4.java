// Write a program to solve a 0-1 Knapsack problem using dynamic programming or branch and
// bound strategy

import java.util.*;

public class p4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] value = new int[n];
        int[] weight = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value and weight of item " + (i + 1) + ": ");
            value[i] = sc.nextInt();
            weight[i] = sc.nextInt();
        }

        System.out.print("Enter knapsack capacity: ");
        int W = sc.nextInt();

        int[][] dp = new int[n + 1][W + 1];
        // we use a 2D array called a DP table to store the maximum profit for different numbers of items and different capacities.

        // Apply Dynamic Programming
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {              //  j represents the current bag capacity.
                if (weight[i - 1] <= j) {               // check whether the current item's weight can fit inside the current bag capacity.

                    int include = value[i - 1] + dp[i - 1][j - weight[i - 1]];
                    int exclude = dp[i - 1][j];
                    dp[i][j] = Math.max(include, exclude);

                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println("Maximum Profit = " + dp[n][W]);

        // selected items
        int w = W;

        System.out.println("Selected Items:");

        for (int i = n; i > 0; i--) {

            if (dp[i][w] != dp[i - 1][w]) {

                System.out.println("Item " + i);
                w = w - weight[i - 1];
            }
        }

        sc.close();
    }
}


// There are two common DP approaches:
// - Memoization: Top-down approach using recursion and storing calculated results.
// - Tabulation: Bottom-up approach using loops and storing results in a table.
// Our program uses Tabulation.


// First, we take the number of items, their values, weights, and knapsack capacity as input. Then we create a 2D DP table to store the maximum profit for different items and capacities.

// For every item, we check two possibilities: include or exclude. If the item fits, we use Math.max() to choose the option that gives maximum profit. If it does not fit, we exclude it.

// Finally, dp[n][W] gives the maximum profit. We also trace the DP table backwards to display the selected items


// Enter no. of items: 4
// Enter profit and weight for item 1 : 
// 2 3
// Enter profit and weight for item 2 : 
// 3 4
// Enter profit and weight for item 3 : 
// 1 6
// Enter profit and weight for item 4 : 
// 4 5
// knapsack capactiy: 
// 8
// Maximum Profit = 6