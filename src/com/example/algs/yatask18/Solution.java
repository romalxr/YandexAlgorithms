package com.example.algs.yatask18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("./input.txt"));
        Deque<Integer> deque = new ArrayDeque<>();

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
                case "size" -> System.out.println(deque.size());
                case "push_front" -> {
                    value = Integer.parseInt(tokens[1]);
                    deque.addFirst(value);
                    System.out.println("ok");
                }
                case "push_back" -> {
                    value = Integer.parseInt(tokens[1]);
                    deque.add(value);
                    System.out.println("ok");
                }
                case "pop_front" -> System.out.println(deque.size() == 0 ? "error" : deque.poll());
                case "pop_back" -> System.out.println(deque.size() == 0 ? "error" : deque.pollLast());
                case "front" -> System.out.println(deque.size() == 0 ? "error" : deque.peek());
                case "back" -> System.out.println(deque.size() == 0 ? "error" : deque.getLast());
                case "clear" -> {
                    deque.clear();
                    System.out.println("ok");
                }
                default -> throw new IllegalStateException("Unexpected value: " + command);
            }
        }
    }
}
