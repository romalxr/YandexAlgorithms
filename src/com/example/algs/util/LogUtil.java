package com.example.algs.util;

import java.util.Arrays;
import java.util.Queue;

public class LogUtil {

    private static final StringBuilder logLine1 = new StringBuilder();
    private static final StringBuilder logLine2 = new StringBuilder();

    public static void addLog(Queue<Integer> queue1, Queue<Integer> queue2) {
        int logCount = 0;
        for (Integer val : queue1) {
            logLine1.append(val);
            logCount++;
        }
        logLine1.append("_".repeat(Math.max(0, 10 - logCount)));
        logLine1.append(" ");

        logCount = 0;
        for (Integer val : queue2) {
            logLine2.append(val);
            logCount++;
        }
        logLine2.append("_".repeat(Math.max(0, 10 - logCount)));
        logLine2.append(" ");
    }

    public static void logout() {

        System.out.println(logLine1);
        System.out.println(logLine2);
    }

    public static void printDp(int[][] dp) {
        System.out.println("dp:");
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("---");
    }
}
