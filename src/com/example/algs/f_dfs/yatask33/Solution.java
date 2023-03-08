package com.example.algs.f_dfs.yatask33;

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

        int[] colors = new int[n];
        final boolean[] result = {true};
        for (int i = 1; i < n; i++) {
            if (!result[0]) {
                break;
            }
            if (colors[i] != 0) {
                continue;
            }
            dfs(graph, colors, i, 1, result);
        }

        System.out.println(result[0] ? "YES" : "NO");
    }

    private static void dfs(List<Integer>[] graph, int[] colors, int now, int color, final boolean[] result) {
        colors[now] = color;
        for (Integer v : graph[now]) {
            if (!result[0]) {
                break;
            }
            if (colors[v] == 0) {
                dfs(graph, colors, v, 3 - color, result);
            } else if(colors[v] == color) {
                result[0] = false;
            }
        }
    }
}
