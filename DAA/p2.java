// Write a program to implement Huffman Encoding using a greedy strategy.

import java.util.*;

public class p2 {

    // Node of Huffman Tree
    static class Node {
        char ch;
        int freq;
        Node left, right;

        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    // Generate Huffman Codes
    static void printCodes(Node root, String code) {

        if (root == null)
            return;

        // Leaf node
        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " : " + code);
            return;
        }

        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        PriorityQueue<Node> pq =  new PriorityQueue<>( (a, b) -> Integer.compare(a.freq, b.freq)); 
//Stores nodes according to their frequency. The node with the minimum frequency is removed first. -> ascending
//   It works as a Min-Heap.
// The node having the minimum frequency is removed first using poll().


        // Input characters and frequencies
        for (int i = 0; i < n; i++) {
            System.out.print("Enter character and frequency: ");
            char ch = sc.next().charAt(0);
            int freq = sc.nextInt();

            pq.add(new Node(ch, freq));
        }


        // Build Huffman Tree
        while (pq.size() > 1) {

            Node left = pq.poll();
            Node right = pq.poll();

            Node parent = new Node( '\0', left.freq + right.freq   );

            parent.left = left;
            parent.right = right;

            pq.add(parent);
        }

        // Generate Huffman Codes
        Node root = pq.poll();

        System.out.println("\nHuffman Codes:");
        if (root.left == null && root.right == null)
            printCodes(root, "0");
        else
            printCodes(root, "");

        sc.close();
    }
}


// input character no.s -> arrange acco to freq -> input character and freq  create node -> generate huffman tree -> print code