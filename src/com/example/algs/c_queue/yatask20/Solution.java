package com.example.algs.c_queue.yatask20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class MyHeap {

    private final ArrayList<Integer> list = new ArrayList<>();

    int size() {
        return list.size();
    }

    void add(int value) {
        list.add(value);
        int pos = list.size() - 1;
        while (pos > 0 && list.get(pos) < list.get((pos - 1) / 2)) {
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
            int minChildPos = pos * 2 + 1;
            if (list.get(pos * 2 + 2) < list.get(minChildPos)) {
                minChildPos = pos * 2 + 2;
            }
            if (list.get(pos) > list.get(minChildPos)) {
                int buf = list.get(pos);
                list.set(pos, list.get(minChildPos));
                list.set(minChildPos, buf);
                pos = minChildPos;
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
        MyHeap mixHeap = new MyHeap();

        BufferedReader in = new BufferedReader(new FileReader("./input.txt"));
        in.readLine();
        String line = in.readLine();
        String[] tokens = line.split(" ");
        for (String token : tokens) {
            mixHeap.add(Integer.parseInt(token));
        }

        while (mixHeap.size() != 0) {
            System.out.print(mixHeap.poll() + " ");
        }
    }
}
