package com.ctk0327.B1693;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer> lines[];
    static int N;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        lines = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            lines[i] = new ArrayList<>();
        }
        dp = new int[N + 1][21];
        for (int i = 0; i < N - 1; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            lines[from].add(to);
            lines[to].add(from);
        }
        int ans = getAnswer(0, 1, 1);
        for (int i = 2; i <= 20; i++) {
            ans = Math.min(ans, getAnswer(0, 1, i));
        }
        System.out.println(ans);
    }

    private static int getAnswer(int prev, int now, int color) {
        if (dp[now][color] != 0) {
            return dp[now][color];
        }
        int answer = 0;
        for (int next : lines[now]) {
            int min = Integer.MAX_VALUE;
            if (next != prev) {
                for (int i = 1; i <= 20; i++) {
                    if (color != i) {
                        min = Math.min(min, getAnswer(now, next, i));
                    }
                }
                answer += min;
            }
        }
        return dp[now][color] = answer + color;
    }
}
