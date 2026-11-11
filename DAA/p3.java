// Write a program to solve a fractional Knapsack problem using a greedy method.

import java.util.*;

class Item {
    int value, weight;          //value or profit
    double ratio;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
        ratio = (double) value / weight;
    }
}

public class p3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value and weight of item " + (i + 1) + ": ");
            int value = sc.nextInt();
            int weight = sc.nextInt();

            items[i] = new Item(value, weight);
        }

        System.out.print("Enter knapsack capacity: ");
        int K = sc.nextInt();

        // Sort items in descending order of value/weight ratio
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio) );

        double totalProfit = 0;

        // Select items using Greedy method
        for (int i = 0; i < n; i++) {
            if (items[i].weight <= K) {
                totalProfit += items[i].value;
                K -= items[i].weight;
            } else {
                double fraction = (double) K / items[i].weight;
                totalProfit += items[i].value * fraction;
                K = 0;
                break;
            }
        }
        System.out.println("Maximum Profit = " + totalProfit);
        sc.close();
    }
}


// Enter number of items: 5

// Enter value and weight of item 1: 60 10
// Enter value and weight of item 2: 100 20
// Enter value and weight of item 3: 120 30
// Enter value and weight of item 4: 80 40
// Enter value and weight of item 5: 150 15

// Enter knapsack capacity: 60
