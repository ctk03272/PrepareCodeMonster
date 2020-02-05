package com.ctk0327.B3830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] parent;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = bf.readLine()) != "0 0") {
            StringTokenizer st = new StringTokenizer(input, " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            parent = new int[N + 1];
            distance = new int[N + 1];
            for (int i = 0; i <= N; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < M; i++) {
                String a = st.nextToken();
                if (a == "!") {

                } else {

                }
            }
        }
    }

    static int find(int u) {
        if (u == parent[u]) {
            return u;
        }
        return parent[u] = find(parent[u]);
    }

    static void merge(int u, int v)
    {

        u = find(u);
        v = find(v);

        parent[v] = u;
    }
}
