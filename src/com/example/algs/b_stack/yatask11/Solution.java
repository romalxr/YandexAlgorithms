package com.example.algs.b_stack.yatask11;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();
        boolean exit = false;
        while (!exit && scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] tokens = line.split(" ");
            if (tokens.length == 0) {
                continue;
            }

            String command = tokens[0];
            int value;
            switch (command) {
                case "exit" -> {
                    System.out.println("bye");
                    exit = true;
                }
                case "size" -> System.out.println(stack.size());
                case "push" -> {
                    value = Integer.parseInt(tokens[1]);
                    stack.push(value);
                    System.out.println("ok");
                }
                case "pop" -> System.out.println(stack.empty() ? "error" : stack.pop());
                case "back" -> System.out.println(stack.empty() ? "error" : stack.peek());
                case "clear" -> {
                    stack.clear();
                    System.out.println("ok");
                }
                default -> throw new IllegalStateException("Unexpected value: " + command);
            }
        }
    }
}
