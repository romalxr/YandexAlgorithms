package com.example.algs.f_dfs.yatask31;

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
        boolean[] visited = new boolean[n];
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            tokens = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int v1 = tokens[0];
            int v2 = tokens[1];
//            if (v1 == v2) {
//                continue;
//            }
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        //System.out.println(Arrays.toString(graph));
        final int[] counter = {0};
        dfs(graph, visited, 1, counter);
        System.out.println(counter[0]);

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    private static void dfs(List<Integer>[] graph, boolean[] visited, int now, int[] counter) {
        counter[0]++;
        visited[now] = true;
        for (Integer v : graph[now]) {
            if (visited[v]) {
                continue;
            }
            dfs(graph, visited, v, counter);
        }
    }
}
