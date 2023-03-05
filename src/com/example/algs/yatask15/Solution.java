package com.example.algs.yatask15;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Stack;
//import java.util.Date;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        //long ts1 = new Date().getTime();

        Scanner scanner = new Scanner(new FileReader("./input.txt"));
        String line = scanner.nextLine();
        int n = Integer.parseInt(line);
        line = scanner.nextLine();
        String[] tokens = line.split(" ");

        //System.out.println(new Date().getTime()- ts1);

        int[] result = new int[n];
        int[] rates = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int ind = 0; ind < n; ind++) {
            int rate = Integer.parseInt(tokens[ind]);
            result[ind] = -1;
            rates[ind] = rate;

            while (!stack.empty() && rates[stack.peek()] > rate) {
                result[stack.pop()] = ind;
            }
            stack.push(ind);
        }

        //System.out.println(new Date().getTime()- ts1);

        int iMax = result.length - 1;
        StringBuilder b = new StringBuilder();
        for (int i = 0; ; i++) {
            b.append(result[i]);
            if (i == iMax) {
                break;
            }
            b.append(" ");
        }
        System.out.println(b);

        //System.out.println(new Date().getTime()- ts1);
    }
}
