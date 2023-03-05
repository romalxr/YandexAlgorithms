package com.example.algs.yatask16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new ArrayDeque<>();

        boolean exit = false;
        while (!exit && in.ready()) {
            String line = in.readLine();
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
                case "size" -> System.out.println(queue.size());
                case "push" -> {
                    value = Integer.parseInt(tokens[1]);
                    queue.add(value);
                    System.out.println("ok");
                }
                case "pop" -> System.out.println(queue.size() == 0 ? "error" : queue.poll());
                case "front" -> System.out.println(queue.size() == 0 ? "error" : queue.peek());
                case "clear" -> {
                    queue.clear();
                    System.out.println("ok");
                }
                default -> throw new IllegalStateException("Unexpected value: " + command);
            }
        }
    }
}
