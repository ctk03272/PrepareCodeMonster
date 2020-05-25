package com.ctk0327.B16562;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N, M, K;
    static int[] cost;
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        cost = new int[N + 1];
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            cost[i] = sc.nextInt();
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            merge(sc.nextInt(), sc.nextInt());
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (find(0) != find(i)) {
                answer += cost[find(i)];
                merge(0, i);
            }
        }
        System.out.println(answer<=K?answer:"Oh no");
    }

    static int find(int u) {
        if (u == parent[u]) { return u; }
        return parent[u] = find(parent[u]);
    }

    static void merge(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return;
        }
        if (cost[a] < cost[b]) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

}
