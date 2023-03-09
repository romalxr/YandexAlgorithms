package com.example.algs.g_bfs.yatask40;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {

    static int MAX = 0;
    static int point(int x, int y, int m) {
        if (x < 0 || x >= m) {
            return -1;
        }
        return x * MAX + y;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("./input.txt"));
        MAX = Integer.parseInt(in.readLine());
        int m = Integer.parseInt(in.readLine());
        List<Integer>[] graph = new List[m * MAX];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int x = 0; x < m; x++) {
            int[] tokens = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int y1 = tokens[1] - 1;
            int v1 = point(x, y1, m);
            for (int i = 0; i < x; i++) {
                int v1l = point(i, y1, m);
                if (graph[v1l].size() > 0) {
                    graph[v1].add(v1l);
                    graph[v1l].add(v1);
                }
            }

            for (int j = 2; j < tokens.length; j++) {
                v1 = point(x, tokens[j - 1] - 1, m);
                int y2 = tokens[j] - 1;
                int v2 = point(x, y2, m);
                graph[v1].add(v2);
                graph[v2].add(v1);

                for (int i = 0; i < x; i++) {
                    int v2l = point(i, y2, m);
                    if (graph[v2l].size() > 0) {
                        graph[v2].add(v2l);
                        graph[v2l].add(v2);
                    }
                }
            }
        }
        //System.out.println(Arrays.toString(graph));

        int[] tokens = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int y1 = tokens[0] - 1;
        int y2 = tokens[1] - 1;

        int[] distance = new int[m * MAX];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            int v1 = point(i, y1, m);
            if(graph[v1].size() > 0) {
                distance[v1] = 1;
                deque.add(v1);
            }
        }

        while (!deque.isEmpty()){
            int now = deque.poll();
            bfs(graph, deque, distance, now);
        }

        //System.out.println(Arrays.toString(distance));

        int min = 70;
        for (int i = 0; i < m; i++) {
            int v2 = point(i, y2, m);
            if (distance[v2] != 0 && distance[v2] < min) {
                min = distance[v2];
            }
        }
        if (min == 70) {
            System.out.println(-1);
        } else {
            System.out.println(min - 1);
        }
    }

    private static void bfs(List<Integer>[] graph, Deque<Integer> deque, int[] distance, int now) {
        for (Integer v : graph[now]) {
            int r = 0;
            if (Math.abs(now - v) >= MAX) {
                r = 1;
            }
            if (distance[v] == 0 || distance[v] > distance[now] + r) {
                distance[v] = distance[now] + r;
                if (r == 1) {
                    deque.add(v);
                } else {
                    deque.addFirst(v);
                }
            }
        }
    }
}
