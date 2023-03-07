package com.example.algs.c_queue.yatask19;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class MyHeap {

    private final ArrayList<Integer> list = new ArrayList<>();

    void add(int value) {
        list.add(value);
        int pos = list.size() - 1;
        while (pos > 0 && list.get(pos) > list.get((pos - 1) / 2)) {
            int buf = list.get(pos);
            list.set(pos, list.get((pos - 1) / 2));
            list.set((pos - 1) / 2, buf);
            pos = (pos - 1) / 2;
        }
        //System.out.println(Arrays.toString(list.toArray()));
    }
    int poll() {
        if (list.size() == 0) {
            throw new IndexOutOfBoundsException();
        }
        int ans = list.get(0);
        list.set(0, list.get(list.size() - 1));
        int pos = 0;
        while (pos * 2 + 1 < list.size() - 1) {
            int maxChildPos = pos * 2 + 1;
            if (list.get(pos * 2 + 2) > list.get(maxChildPos)) {
                maxChildPos = pos * 2 + 2;
            }
            if (list.get(pos) < list.get(maxChildPos)) {
                int buf = list.get(pos);
                list.set(pos, list.get(maxChildPos));
                list.set(maxChildPos, buf);
                pos = maxChildPos;
            } else {
                break;
            }
        }
        list.remove(list.size() - 1);
        //System.out.println(Arrays.toString(list.toArray()));
        return ans;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        MyHeap maxHeap = new MyHeap();

        BufferedReader in = new BufferedReader(new FileReader("./input.txt"));
        int n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            String line = in.readLine();
            //System.out.println(line);
            String[] tokens = line.split(" ");
            int command = Integer.parseInt(tokens[0]);

            switch (command) {
                case 0 -> {
                    int value = Integer.parseInt(tokens[1]);
                    maxHeap.add(value);
                }
                case 1 -> System.out.println(maxHeap.poll());
                default -> throw new IllegalStateException("Unexpected value: " + command);
            }
            //System.out.println(" } h " + i + " " + line);
        }
    }
}
