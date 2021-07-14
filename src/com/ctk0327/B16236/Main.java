package com.ctk0327.B16236;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int[][] input;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0,};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        input = new int[N][N];
        visited = new boolean[N][N];
        Queue<Dot> sharkDot = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                input[i][j] = sc.nextInt();
                if (input[i][j] == 9) {
                    sharkDot.add(new Dot(i, j));
                }
            }
        }

        while (!sharkDot.isEmpty()) {
            Dot now = sharkDot.poll();
            int nowX = now.x;
            int nowY = now.y;
        }
    }
}

class Dot {
    int x;
    int y;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
