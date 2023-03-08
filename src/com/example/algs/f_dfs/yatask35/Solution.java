package com.example.algs.f_dfs.yatask35;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        int[] visited = new int[n];
        final int[] vCycle = {0, 0};
        List<Integer> path = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (vCycle[0] != 0) {
                break;
            }
            if (visited[i] != 0) {
                continue;
            }
            dfs(graph, visited, i, 0, vCycle, path);
        }
        if (vCycle[0] != 0) {
            System.out.println("YES");
            System.out.println(path.size());
            printArray(path.toArray());
        } else {
            System.out.println("NO");
        }
    }

    private static void dfs(List<Integer>[] graph, int[] visited, int now, int prev, final int[] vCycle, List<Integer> path) {
        visited[now] = 1;
        for (Integer v : graph[now]) {
            if (vCycle[0] != 0) {
                break;
            }
            if (visited[v] == 0) {
                dfs(graph, visited, v, now, vCycle, path);
            } else if (v != prev && visited[v] == 1) {
                vCycle[0] = v;
            }
        }
        visited[now] = 2;
        if (vCycle[0] != 0 && vCycle[1] == 0) {
            path.add(now);
            if (vCycle[0] == now) {
                vCycle[1] = 1;
            }
        }
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
}
