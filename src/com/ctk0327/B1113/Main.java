package com.ctk0327.B1113;

import java.util.Scanner;

public class Main {
    static int N, M;
    static int[][] input;
    static boolean[][] visit;
    static int[][] maxWater;
    static int result = 0;

    static final int[] dx = { 0, 0, 1, -1 };
    static final int[] dy = { 1, -1, 0, 0 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        input = new int[N][M];
        maxWater = new int[N][M];

        for (int i = 0; i < N; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < M; j++) {
                input[i][j] = temp.charAt(j) - '0';
            }
        }

        for (int k = 1; k <= 9; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    visit = new boolean[N][M];
                    if (isAvailableWater(i, j, k)) {
                        maxWater[i][j] = k - input[i][j];
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result += maxWater[i][j];
            }
        }
        System.out.println(result);
    }

    private static boolean isAvailableWater(int i, int j, int k) {
        visit[i][j] = true;
        boolean result = true;
        if ((i == 0 || i == N - 1 || j == 0 || j == M - 1) || k - input[i][j] < 0) {
            return false;
        }

        for (int l = 0; l < 4; l++) {
            int nx = i + dx[l];
            int ny = j + dy[l];
            if (input[nx][ny] >= k) {
                result = true;
            } else {
                if (!visit[nx][ny]) {
                    boolean temp = isAvailableWater(nx, ny, k);
                    if (!temp) {
                        result =temp;
                        break;
                    }
                }
            }
        }

        return result;
    }
}
