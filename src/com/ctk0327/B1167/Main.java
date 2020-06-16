package com.ctk0327.B1167;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Edge>[] list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<Edge>();
        }
        for (int i = 1; i <= N; i++) {
            int x = sc.nextInt();
            while (true) {
                int y = sc.nextInt();
                if (y == -1) {
                    break;
                } else {
                    int z = sc.nextInt();
                    list[x].add(new Edge(y, z));
                }
            }
        }
        int[] dist = bfs(N, list, 1);
        int start = 1;
        for (int i = 2; i <= N; i++) {
            if (dist[i] > dist[start]) {
                start = i;
            }
        }
        dist = bfs(N, list, start);
        int ans = dist[1];
        for (int i = 2; i <= N; i++) {
            if (ans < dist[i]) {
                ans = dist[i];
            }
        }
        System.out.println(ans);

    }

    private static int[] bfs(int n, ArrayList<Edge>[] list, int i) {
        boolean[] check = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Queue<Integer> que = new LinkedList<>();
        check[i] = true;
        que.add(i);
        while (!que.isEmpty()) {
            int x = que.remove();
            for (Edge edge : list[x]) {
                int to = edge.to;
                int cost = edge.cost;
                if (check[to] == false) {
                    dist[to] = dist[x] + cost;
                    que.add(to);
                    check[to] = true;
                }
            }
        }
        return dist;
    }
}

class Edge {
    int to;
    int cost;

    public Edge(int to, int cost) {
        super();
        this.to = to;
        this.cost = cost;
    }

}