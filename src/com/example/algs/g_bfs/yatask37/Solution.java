package com.example.algs.g_bfs.yatask37;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("./input.txt"));
        int n = Integer.parseInt(in.readLine());
        n++;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int v1 = 1; v1 < n; v1++) {
            int[] tokens = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < tokens.length; j++) {
                if (tokens[j] == 1) {
                    int v2 = j + 1;
                    graph[v1].add(v2);
                }
            }
        }
        //System.out.println(Arrays.toString(graph));

        int[] tokens = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int v1 = tokens[0];
        int v2 = tokens[1];

        int[] lengths = new int[n];
        int[] from = new int[n];
        Queue<Integer> queue = new ArrayDeque<>();
        lengths[v1] = 1;
        queue.add(v1);
        while (!queue.isEmpty()){
            int now = queue.poll();
            bfs(graph, queue, lengths, from, now);
        }
        System.out.println(lengths[v2] - 1);

        if (lengths[v2] - 1 > 0) {
            int prev = v2;
            List<Integer> path = new ArrayList<>();
            while (prev != 0) {
                path.add(prev);
                prev = from[prev];
            }
            //System.out.println(Arrays.toString(from));
            rPrintArray(path.toArray());
        }
    }

    private static void bfs(List<Integer>[] graph, Queue<Integer> queue, int[] lengths, int[] from, int now) {
        for (Integer v : graph[now]) {
            if (lengths[v] == 0) {
                lengths[v] = lengths[now] + 1;
                from[v] = now;
                queue.add(v);
            }
        }
    }

    public static void rPrintArray(Object[] array) {
        int iMax = array.length - 1;
        StringBuilder b = new StringBuilder();
        for (int i = iMax; ; i--) {
            b.append(array[i]);
            if (i == 0) {
                break;
            }
            b.append(" ");
        }
        System.out.println(b);
    }
}
