package com.example.algs.a_previousTopics.yatask7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("./input.txt"));

        int[] tokens = Arrays.stream(in.readLine().split(":")).mapToInt(Integer::parseInt).toArray();
        int startTime = tokens[0] * 60 * 60 + tokens[1] * 60 + tokens[2];

        tokens = Arrays.stream(in.readLine().split(":")).mapToInt(Integer::parseInt).toArray();
        int rightTime = tokens[0] * 60 * 60 + tokens[1] * 60 + tokens[2];

        tokens = Arrays.stream(in.readLine().split(":")).mapToInt(Integer::parseInt).toArray();
        int endTime = tokens[0] * 60 * 60 + tokens[1] * 60 + tokens[2];

        if (endTime < startTime) {
            endTime += 86400;
        }

        int delay = (endTime - startTime + 1) / 2;
        rightTime += delay;

        if (rightTime >= 86400) {
            rightTime -= 86400;
        }

        int hh = rightTime / (60 * 60);
        rightTime -= hh * (60 * 60);

        int mm = rightTime / (60);
        rightTime -= mm * (60);

        int ss = rightTime;

        System.out.printf("%02d:%02d:%02d", hh, mm, ss);
    }
}
