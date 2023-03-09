package com.example.algs.g_bfs.yatask38;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {

    static int point(int x, int y, int n, int m) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return -1;
        }
        return x * m + y;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("./input.txt"));
        int[] tokens = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = tokens[0];
        int m = tokens[1];
        int s = tokens[2] - 1;
        int t = tokens[3] - 1;
        int q = tokens[4];

        int start = point(s, t, n, m);

        List<Integer>[] graph = new List[n * m];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] xMov = {-2, -2, -1, -1, +1, +1, +2, +2};
        int[] yMov = {-1, +1, -2, +2, -2, +2, -1, +1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int v1 = point(i, j, n, m);
                for (int p = 0; p < xMov.length; p++) {
                    int x = i + xMov[p];
                    int y = j + yMov[p];
                    int v2 = point(x, y, n, m);
                    if (v2 < 0) {
                        continue;
                    }
                    graph[v1].add(v2);
                }
            }
        }
        //System.out.println(Arrays.toString(graph));

        int[] lengths = new int[n * m];
        Queue<Integer> queue = new ArrayDeque<>();
        lengths[start] = 1;
        queue.add(start);
        while (!queue.isEmpty()){
            int now = queue.poll();
            bfs(graph, queue, lengths, now);
        }

        int sum = 0;
        boolean good = true;
        for (int i = 0; i < q; i++) {
            tokens = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = tokens[0] - 1;
            int y = tokens[1] - 1;
            int v1 = point(x, y, n, m);
            if (lengths[v1] > 0) {
                sum += lengths[v1] - 1;
            } else {
                good = false;
                break;
            }
        }

        if (!good) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
        }
    }

    private static void bfs(List<Integer>[] graph, Queue<Integer> queue, int[] lengths, int now) {
        for (Integer v : graph[now]) {
            if (lengths[v] == 0) {
                lengths[v] = lengths[now] + 1;
                queue.add(v);
            }
        }
    }
}
