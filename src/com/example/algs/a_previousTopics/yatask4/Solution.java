package com.example.algs.a_previousTopics.yatask4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("./input.txt"));

        int n = scanner.nextInt();
        int varMax = scanner.nextInt();
        int petyaRyad = scanner.nextInt();
        int petyaSeat = scanner.nextInt();

        int petyaPlace = (petyaRyad - 1) * 2 + petyaSeat;
        int vasyaPlaceFront = petyaPlace - varMax;
        int vasyaPlaceBack = petyaPlace + varMax;

        if (vasyaPlaceFront < 1 && vasyaPlaceBack > n) {
            System.out.println(-1);
            return;
        }
        int vasyaRyadFront = (vasyaPlaceFront + 1) / 2;
        int vasyaRyadBack = (vasyaPlaceBack + 1) / 2;
        int distFront = petyaRyad - vasyaRyadFront;
        int distBack = vasyaRyadBack - petyaRyad;

        if (vasyaPlaceFront < 1 || (distBack <= distFront && vasyaPlaceBack <= n)) {
            System.out.println(vasyaRyadBack + " " + (2 - (vasyaPlaceBack % 2)));
        } else {
            System.out.println(vasyaRyadFront + " " + (2 - (vasyaPlaceFront % 2)));
        }
    }
}
