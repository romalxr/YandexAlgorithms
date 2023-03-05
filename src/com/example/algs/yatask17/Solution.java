package com.example.algs.yatask17;

//import com.example.algs.util.LogUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) throws Exception {
        Queue<Integer> queue1 = new ArrayDeque<>();
        Queue<Integer> queue2 = new ArrayDeque<>();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();
        String[] tokens = line.split(" ");
        for (String token : tokens) {
            queue1.add(Integer.parseInt(token));
        }
        line = in.readLine();
        tokens = line.split(" ");
        for (String token : tokens) {
            queue2.add(Integer.parseInt(token));
        }

        final int MAX = 1_000_000;
        int count = 0;
        while (++count < MAX && queue1.size() != 0 && queue2.size() != 0) {
            //LogUtil.addLog(queue1, queue2);

            int v1 = queue1.poll();
            int v2 = queue2.poll();
            if ((v1 > v2 && !(v1 == 9 && v2 == 0)) || (v1 == 0 && v2 == 9)) {
                queue1.add(v1);
                queue1.add(v2);
            } else {
                queue2.add(v1);
                queue2.add(v2);
            }
        }
        if (count == MAX) {
            System.out.println("botva");
        } else if (queue1.size() == 0) {
            System.out.println("second " + (count - 1));
        } else {
            System.out.println("first " + (count - 1));
        }

        //LogUtil.logout();
    }
}
