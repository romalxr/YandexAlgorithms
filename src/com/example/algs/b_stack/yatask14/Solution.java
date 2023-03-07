package com.example.algs.b_stack.yatask14;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        String line = scanner.nextLine();
        String[] tokens = line.split(" ");
        Stack<Integer> stack = new Stack<>();
        int next = 1;
        for (String token : tokens) {
            int value = Integer.parseInt(token);
            if (!stack.empty() && stack.peek() < value) {
                break;
            }
            stack.push(value);

            while (!stack.empty() && stack.peek() == next) {
                stack.pop();
                next++;
            }
        }
        System.out.println(stack.empty() ? "YES" : "NO");
    }
}
