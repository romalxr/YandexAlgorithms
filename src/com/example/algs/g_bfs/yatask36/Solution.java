package com.example.algs.g_bfs.yatask36;

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

        int[] pathLength = new int[n];
        Queue<Integer> queue = new ArrayDeque<>();
        pathLength[v1] = 1;
        queue.add(v1);
        while (!queue.isEmpty()){
            int nextV = queue.poll();
            bfs(graph, pathLength, queue, nextV);
        }
        System.out.println(pathLength[v2] - 1);
    }

    private static void bfs(List<Integer>[] graph, int[] pathLength, Queue<Integer> queue, int now) {
        for (Integer v : graph[now]) {
            if (pathLength[v] == 0) {
                pathLength[v] = pathLength[now] + 1;
                queue.add(v);
            }
        }
    }
}
