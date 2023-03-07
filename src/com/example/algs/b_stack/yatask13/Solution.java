package com.example.algs.b_stack.yatask13;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] tokens = line.split(" ");
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "-" -> stack.push(-1 * stack.pop() + stack.pop());
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "*" -> stack.push(stack.pop() * stack.pop());
                default -> stack.push(Integer.parseInt(token));
            }
        }
        System.out.println(stack.pop());
    }
}
