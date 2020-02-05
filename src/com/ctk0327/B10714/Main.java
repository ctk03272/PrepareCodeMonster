package com.ctk0327.B10714;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static long answer;
    static int N;
    static int[] input;
    static long[][][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        input = new int[N];
        answer = 0;
        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        dp = new long[N][N][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <N; j++) {
                Arrays.fill(dp[i][j], -1);

            }
        }
        for (int i = 0; i < N; i++) {
            boolean[] isEaten = new boolean[N];
            isEaten[i] = true;
            dfs(i, false, input[i], 1, isEaten, i, i);
        }
        System.out.println(answer);
    }

    private static void dfs(int now, boolean isJoi, long sum, int count, boolean[] isEaten, int start,
                            int end) {
        if (count == N) {
            if (sum > answer) {
                answer = sum;
            }
            return;
        }
        int isJoiNum = isJoi ? 0 : 1;
        if (dp[start][end][isJoiNum] != -1) {
            return;
        }
        dp[start][end][isJoiNum] = sum;
        int pick = -1;
        boolean isChangesStart = true;
        for (int i = 0; i < N; i++) {
            if (isEaten[i]) {
                int prev = i == 0 ? N - 1 : i - 1;
                int next = i == N - 1 ? 0 : i + 1;
                if (isJoi) {
                    if (!isEaten[prev]) {
                        isEaten[prev] = true;
                        dfs(prev, !isJoi, sum + input[prev], count + 1, isEaten, prev, end);
                        isEaten[prev] = false;
                    }
                    if (!isEaten[next]) {
                        isEaten[next] = true;
                        dfs(next, !isJoi, sum + input[next], count + 1, isEaten, start, next);
                        isEaten[next] = false;
                    }
                } else {
                    if (!isEaten[prev] && (pick == -1 || input[prev] > input[pick])) {
                        pick = prev;
                    }
                    if (!isEaten[next] && (pick == -1 || input[next] > input[pick])) {
                        pick = next;
                        isChangesStart = false;
                    }
                }
            }
        }
        if (!isJoi) {
            isEaten[pick] = true;
            if (isChangesStart) {
                dfs(pick, !isJoi, sum, count + 1, isEaten, pick, end);
            } else {
                dfs(pick, !isJoi, sum, count + 1, isEaten, start, pick);
            }
            isEaten[pick] = false;
        }
    }
}
