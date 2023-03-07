package com.example.algs.b_stack.yatask12;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        String line = scanner.nextLine();

        for (char c : line.toCharArray()) {
            Character checked = null;
            switch (c) {
                case '(', '[', '{' -> stack.push(c);
                case ')' -> checked = '(';
                case ']' -> checked = '[';
                case '}' -> checked = '{';
                default -> throw new IllegalStateException("Unexpected value: " + c);
            }
            if (checked != null) {
                if (stack.empty() || !checked.equals(stack.pop())) {
                    stack.push(' ');
                    break;
                }
            }
        }
        System.out.println(stack.empty() ? "yes" : "no");
    }
}
