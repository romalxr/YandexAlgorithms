package com.example.algs.a_previousTopics.yatask3;

import java.io.*;
import java.util.*;
import java.util.function.BiFunction;

public class Solution {
    public static void main(String[] args) throws IOException {
        System.setOut(new PrintStream("output.txt"));

        BufferedReader in = new BufferedReader(new FileReader("./input.txt"));
        //int n = Integer.parseInt(in.readLine());
        in.readLine();
        TreeSet<Integer> set = new TreeSet<>();
        Arrays.stream(in.readLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(set::add);

        List<Integer> list = new ArrayList<>(set);

        //int k = Integer.parseInt(in.readLine());
        in.readLine();
        //long s = new Date().getTime();
        Arrays.stream(in.readLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(i -> System.out.println(rBinSearch(0, list.size(), check(),
                        Map.of("list", list, "value", i))));
//              collections binSearch is ok too
//                .forEach(i -> {
//                    int ind = Collections.binarySearch(list, i);
//                    System.out.println(ind < 0 ? -1 - ind : ind);
//                });
        //System.out.println("t: " + (new Date().getTime() - s));
    }

    static int rBinSearch(int l, int r, BiFunction<Integer, Map<String, Object>, Boolean> func, Map<String, Object> params) {
        while (l < r) {
            int m = (l + r + 1) / 2;
            if (func.apply(m, params)) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    static int lBinSearch(int l, int r, BiFunction<Integer, Map<String, Object>, Boolean> func, Map<String, Object> params) {
        while (l < r) {
            int m = (l + r) / 2;
            if (func.apply(m, params)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private static BiFunction<Integer, Map<String, Object>, Boolean> check() {
        return (i, params) -> {
            List<Integer> list = (List<Integer>) params.get("list");
            int value = (int) params.get("value");
            return list.get(i - 1) < value;
        };
    }
}
