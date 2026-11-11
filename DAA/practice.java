import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.concurrent.PriorityBlockingQueue;

// public class practice {
//     public static void nonrecursive(int n) {
//         int a = 0, b = 1;
//         for (int i = 0; i < n; i++) {
//             System.out.print(a + " ");
//             int c = a + b;
//             a = b;
//             b = c;
//         }
//     }

//     public static void nonrecursiveNthTerm(int n) {
//         int a = 0, b = 1;
//         for (int i = 1; i < n; i++) {

//             int c = a + b;
//             a = b;
//             b = c;
//         }
//         System.out.print(a + " "); // based on position
//     }

//     public static int recursive(int n) {
//         if (n <= 1)
//             return n;
//         else
//             return recursive(n - 1) + recursive(n - 2);
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n;
//         System.out.print("Enter no. of terms to display in fibo series: ");
//         n = sc.nextInt();

//         double start = System.nanoTime();
//         nonrecursive(n);
//         double end = System.nanoTime();
//         double executiontime = end - start;
//         System.out.println("For non recursive exceution time is : " + (executiontime / 1000000) + " milliseconds ");

//         System.out.println();

//         nonrecursiveNthTerm(n);

//         System.out.println();

//         double startrec = System.nanoTime();
//         for (int i = 0; i < n; i++) {
//             System.out.print(recursive(i) + " ");
//         }
//         double endrec = System.nanoTime();
//         double executiontimerecurr = endrec - startrec;
//         System.out.println("For  recursive exceution time is : " + (executiontimerecurr / 1000000) + " milliseconds ");

//         System.out.println();

//         System.out.print(recursive(n - 1) + " ");
//     }

// }

// public class practice {
//     static class Node {
//         int freq;
//         char ch;
//         Node left, right;

//         Node(char ch, int freq) {
//             this.ch = ch;
//             this.freq = freq;
//         }
//     }

//     static void printCodes(Node root, String code) {

//         if (root == null)
//             return;

//         if (root.left == null && root.right == null) {
//             System.out.println(root.ch + " : " + code);
//             return;
//         }

//         printCodes(root.left, code + "0");
//         printCodes(root.right, code + "1");
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n;
//         System.out.println("Enter no. of nodes: ");
//         n = sc.nextInt();

//         PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.freq, a.freq));

//         for (int i = 0; i < n; i++) {
//             System.out.print("Enter character and freqency " + (i + 1) + " : ");
//             char ch = sc.next().charAt(0);
//             int freq = sc.nextInt();
//             pq.add(new Node(ch, freq));
//         }

//         while (pq.size() > 1) {

//             Node left = pq.poll();
//             Node right = pq.poll();

//             Node parent = new Node('\0', left.freq + right.freq);

//             parent.left = left;
//             parent.right = right;

//             pq.add(parent);

//         }

//         Node root = pq.poll();

//         System.out.println("\nHuffman Codes:");
//         if (root.left == null && root.right == null)
//             printCodes(root, "0");
//         else
//             printCodes(root, "");

//     }
// }

// public class practice {
//     static class Item {
//         int profit, weight;
//         double ratio;

//         Item(int profit, int weight) {
//             this.profit = profit;
//             this.weight = weight;
//             ratio = profit / (weight * 1.0);
//         }
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n;
//         System.out.println("Enter no. of items : ");
//         n = sc.nextInt();

//         Item items[] = new Item[n];

//         for (int i = 0; i < n; i++) {
//             System.out.print("Enter profit and weight of " + (i + 1) + " item: ");
//             int profit = sc.nextInt();
//             int weight = sc.nextInt();
//             items[i] = new Item(profit, weight);
//         }

//         System.out.print("Enter knapsack capacity: ");
//         int k = sc.nextInt();

//         // sort by ratio
//         Arrays.sort(items, (a, b) -> (Double.compare(b.ratio, a.ratio)));

//         double totalProfit = 0;

//         for (int i = 0; i < n; i++) {
//             if (items[i].weight <= k) {
//                 totalProfit += items[i].profit;
//                 k -= items[i].weight;

//             } else {
//                 double fraction = (double) k / items[i].weight;
//                 totalProfit = totalProfit + items[i].profit * fraction;
//                 k = 0;
//                 break;
//             }
//         }
//         System.out.println("Maximum profit is: " + totalProfit);

//     }
// }

public class practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of items: ");
        int n = sc.nextInt();

        int profit[] = new int[n];
        int weight[] = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter profit and weight for item " + (i + 1) + " : ");
            profit[i] = sc.nextInt();
            weight[i] = sc.nextInt();
        }

        System.out.println("knapsack capactiy: ");
        int k = sc.nextInt();

        int dp[][] = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (weight[i - 1] <= j) {
                    int include = profit[i - 1] + dp[i - 1][j - weight[i-1]];
                    int exclude = dp[i - 1][j];
                    dp[i][j] = Math.max(include, exclude);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

                System.out.println("Maximum Profit = " + dp[n][k]);
    }
}

