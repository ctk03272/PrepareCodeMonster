package com.ctk0327.B13016;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static ArrayList<Edge>[] edges;
    static int[][] dis;
    static int start;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        edges = new ArrayList[N + 1];
        dis = new int[3][N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            edges[from].add(new Edge(to, cost));
            edges[to].add(new Edge(from, cost));
        }
        start = 1;
        bfs(0);
        for (int i = 2; i <= N; i++) {
            if (dis[0][i] > dis[0][start]) {
                start = i;
            }
        }
        bfs(1);
        int newStart = dis[1][1];
        for (int i = 2; i <= N; i++) {
            if (newStart < dis[1][i]) {
                newStart = dis[1][i];
                start = i;
            }
        }
        bfs(2);
        for (int i = 1; i <=N ; i++) {
            System.out.println(Math.max(dis[1][i],dis[2][i]));
        }
    }

    private static void bfs(int i) {
        boolean[] chek = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        chek[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int x = queue.remove();
            for (Edge edge : edges[x]) {
                int to = edge.to;
                int cost = edge.cost;
                if (chek[to] == false) {
                    dis[i][to] = dis[i][x] + cost;
                    queue.add(to);
                    chek[to] = true;
                }
            }
        }
    }
}

class Edge {
    int to;
    int cost;

    public Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}