package com.ctk0327.B1162;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int N, M, K;
    static int[][] dp;
    static int[][] input;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        dp = new int[N + 1][K + 1];
        input = new int[N + 1][N + 1];
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (int i = 0; i <= N; i++) {
            Arrays.fill(input[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int value = sc.nextInt();
            input[from][to] = value;
            input[to][from] = value;
        }

        // DP를 이용하여 다리 건설수에 따라서 을구하여야 겠다고 생각했으나 구현해내지 못함
    }
}

class Node {
    int from;
    int to;
    int dist;

    public Node(int from, int to, int dist) {
        this.from = from;
        this.to = to;
        this.dist = dist;
    }
}