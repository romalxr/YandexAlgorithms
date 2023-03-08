package com.example.algs.f_dfs.yatask34;

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
        }

        int[] visited = new int[n];
        List<Integer> vertices = new ArrayList<>();
        final boolean[] hasCycle = {false};
        for (int i = 1; i < n; i++) {
            if (hasCycle[0]) {
                break;
            }
            if (visited[i] != 0) {
                continue;
            }
            dfs(graph, visited, i, vertices, hasCycle);
        }
        if (hasCycle[0]) {
            System.out.println(-1);
        } else {
            rPrintArray(vertices.toArray());
        }
    }

    private static void dfs(List<Integer>[] graph, int[] visited, int now, List<Integer> vertices, final boolean[] hasCycle) {
        visited[now] = 1;
        for (Integer v : graph[now]) {
            if (hasCycle[0]) {
                break;
            }
            if (visited[v] == 0) {
                dfs(graph, visited, v, vertices, hasCycle);
            } else if (visited[v] == 1) {
                hasCycle[0] = true;
            }
        }
        vertices.add(now);
        visited[now] = 2;
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
