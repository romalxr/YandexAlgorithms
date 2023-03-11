package com.example.algs.a_previousTopics.yatask6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("./input.txt"));
        TreeMap<Integer, Integer> map = new TreeMap<>();

        //int m = Integer.parseInt(in.readLine());
        in.readLine();
        int n = Integer.parseInt(in.readLine());

        for (int i = 0; i < n; i++) {
            int[] tokens = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = tokens[0];
            int b = tokens[1];

            //delete sectors;
            var head = map.headMap(a);

            if (!head.isEmpty() && map.get(head.lastKey()) >= a) {
                map.remove(head.lastKey());
            }

            var tail = map.tailMap(a);
            List<Integer> delKeys = new ArrayList<>();
            for (Integer k : tail.keySet()) {
                if (k > b) {
                    break;
                }
                delKeys.add(k);
            }

            for (Integer delKey : delKeys) {
                map.remove(delKey);
            }

            map.put(a, b);
        }
        System.out.println(map.size());
    }
}
