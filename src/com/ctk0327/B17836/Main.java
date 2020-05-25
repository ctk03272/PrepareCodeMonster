package com.ctk0327.B17836;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static boolean getGram;
    static Queue<Pair> que;
    static int N, M, T;
    static int gramX = -1, gramY = -1;
    static int[][] input, dp;
    static int withOutGram = Integer.MAX_VALUE, withGram = Integer.MAX_VALUE;
    static final int[] dx = { 0, 0, 1, -1 };
    static final int[] dy = { 1, -1, 0, 0 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        T = sc.nextInt();
        input = new int[N][M];
        dp = new int[N][M];
        que = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                input[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }
        }
        if (input[0][0] == 0) {
            que.add(new Pair(0, 0));
            dp[0][0] = 0;
        }

        while (!que.isEmpty()) {
            Pair pair = que.poll();
            int x = pair.x;
            int y = pair.y;
            if (input[x][y] == 2) {
                getGram = true;
                gramX = x;
                gramY = y;
            }
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if ((input[nx][ny] == 0 || input[nx][ny] == 2)) {
                        if (dp[nx][ny] == -1 || dp[x][y] + 1 < dp[nx][ny]) {
                            que.add(new Pair(nx, ny));
                            dp[nx][ny] = dp[x][y] + 1;

                        }
                    }
                }
            }
        }
        int result = 0;
        withOutGram = dp[N - 1][M - 1];
        if (getGram) {
            withGram = dp[gramX][gramY] + ((N - 1) - gramX) + ((M - 1) - gramY);
        }
        if (withOutGram == -1) {
            if (getGram) {
                result = withGram;
            } else {
                result = withOutGram;
            }
        } else {
            result = withGram < withOutGram ? withGram : withOutGram;
        }
        System.out.println(result != -1 && result <= T ? result : "Fail");
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}