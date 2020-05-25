package com.ctk0327.B11724;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer>[] ar;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ar = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            ar[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            ar[a].add(b);
            ar[b].add(a);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(ar[i]);
        }
        int ans = 0;
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (visited[i] == false) {
                ans++;
                bfs(i);
            }
        }
        System.out.println(ans);
    }

    //bfs를 통하여 구할 경우
    private static void bfs(int i) {
        Queue<Integer> q = new LinkedList<>();
        if (visited[i])
            return;
        q.add(i);
        visited[i] = true;
        while (!q.isEmpty()) {
            int temp = q.remove();
            for (int y : ar[temp]) {
                if (visited[y] == false) {
                    q.add(y);
                    visited[y] = true;
                }
            }
        }
    }

    //dfs를 통하여 구할 경우
    private static void dfs(int v) {
        if (visited[v])
            return;
        visited[v] = true;
        for (int y : ar[v]) {
            if (visited[y] == false)
                dfs(y);
        }
    }
}