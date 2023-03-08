package com.example.algs.f_dfs.yatask32;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("./input.txt"));
        int[] tokens = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = tokens[0];
        int m = tokens[1];
        n++;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            tokens = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int v1 = tokens[0];
            int v2 = tokens[1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        boolean[] visited = new boolean[n];
        List<List<Integer>> components = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            List<Integer> vertices = new ArrayList<>();
            dfs(graph, visited, i, vertices);
            components.add(vertices);
        }

        System.out.println(components.size());
        components.forEach(l -> {
            System.out.println(l.size());
            printArray(l.toArray());
        });
    }

    public static void printArray(Object[] array) {
        int iMax = array.length - 1;
        StringBuilder b = new StringBuilder();
        for (int i = 0; ; i++) {
            b.append(array[i]);
            if (i == iMax) {
                break;
            }
            b.append(" ");
        }
        System.out.println(b);
    }

    private static void dfs(List<Integer>[] graph, boolean[] visited, int now, List<Integer> vertices) {
        vertices.add(now);
        visited[now] = true;
        for (Integer v : graph[now]) {
            if (visited[v]) {
                continue;
            }
            dfs(graph, visited, v, vertices);
        }
    }
}
