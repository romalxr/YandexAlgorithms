package com.example.algs.yatask19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            String line = in.readLine();
            String[] tokens = line.split(" ");
            int command = Integer.parseInt(tokens[0]);
            switch (command) {
                case 0 -> {
                    int value = Integer.parseInt(tokens[1]);
                    maxHeap.add(value);
                }
                case 1 -> System.out.println(maxHeap.poll());
                default -> throw new IllegalStateException("Unexpected value: " + command);
            }
        }
    }
}
