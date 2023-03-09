package com.example.algs.g_bfs.yatask39;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("./input.txt"));
        int n = Integer.parseInt(in.readLine());
        int[] walls = new int[n * n * n];

        int start = 0;
        for (int i = 0; i < n; i++) {
            in.readLine();
            for (int j = 0; j < n; j++) {
                String line = in.readLine();
                for (int k = 0; k < n; k++) {
                    char c = line.charAt(k);
                    switch (c) {
                        case '#' -> walls[point(i, j, k, n)] = 1;
                        case 'S' -> start = point(i, j, k, n);
                    }
                }
            }
        }

        int[] xMov = {-1, +1, +0, +0, +0, +0};
        int[] yMov = {+0, +0, -1, +1, +0, +0};
        int[] zMov = {+0, +0, +0, +0, -1, +1};

        List<Integer>[] graph = new List[n * n * n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int v1 = point(i, j, k, n);
                    if (walls[point(i, j, k, n)] != 0) {
                        continue;
                    }
                    for (int p = 0; p < xMov.length; p++) {
                        int x = i + xMov[p];
                        int y = j + yMov[p];
                        int z = k + zMov[p];
                        int v2 = point(x, y, z, n);
                        if (v2 < 0) {
                            continue;
                        }
                        if (walls[point(x, y, z, n)] == 0) {
                            graph[v1].add(v2);
                        }
                    }
                }
            }
        }
        //System.out.println(Arrays.toString(graph));

        int[] distance = new int[n * n * n];
        Queue<Integer> queue = new ArrayDeque<>();
        distance[start] = 1;
        queue.add(start);
        while (!queue.isEmpty()){
            int now = queue.poll();
            bfs(graph, queue, distance, now);
        }

        int min = Integer.MAX_VALUE;
        int i = 0;
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                int v = point(i, j, k, n);
                if (distance[v] != 0 && distance[v] < min) {
                    min = distance[v];
                }
            }
        }

        System.out.println(min - 1);
    }

    private static void bfs(List<Integer>[] graph, Queue<Integer> queue, int[] distance, int now) {
        for (Integer v : graph[now]) {
            if (distance[v] == 0) {
                distance[v] = distance[now] + 1;
                queue.add(v);
            }
        }
    }

    static int point (int x, int y, int z, int size) {
        if (x < 0 || x >= size || y < 0 || y >= size || z < 0 || z >= size) {
            return -1;
        }
        return x * size * size + y * size + z;
    }
}
