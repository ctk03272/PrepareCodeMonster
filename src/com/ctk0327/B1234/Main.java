package com.ctk0327.B1234;

import java.util.Scanner;

public class Main {
    static int N;
    static int R, G, B;
    static int sum;
    static long[][][][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();
        G = sc.nextInt();
        B = sc.nextInt();
        sum = R + G + B;
        dp = new long[N + 1][R + 1][G + 1][B + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= R; j++) {
                for (int k = 1; k <= G; k++) {
                    for (int l = 1; l <= B; l++) {
                        dp[i][j][k][l] = -1;
                    }
                }
            }
        }
        long answer = getSolve(N, R, G, B);
        System.out.println(answer == 1 ? 0 : answer);
    }

    private static long getSolve(int n, int r, int g, int b) {
        if (n == 1) {
            return 1;
        }
        if (dp[n][r][g][b] != -1) {
            return dp[n][r][g][b];
        }

        int result = 0;
        if (n % 3 == 0) {
            if (r + n / 3 <= R && g + n / 3 <= G && b + n / 3 <= B) {
                result += getSolve(n - 1, r + n / 3, g + n / 3, b + n / 3) * get3(n);
            }
        }
        if (n % 2 == 0) {
            if (r + n / 2 <= R && g + n / 2 <= G) {
                result += getSolve(n - 1, r + n / 2, g + n / 2, b) * get2(n);
            }
            if (g + n / 2 <= G && b + n / 2 <= B) {
                result += getSolve(n - 1, r, g + n / 2, b + n / 2) * get2(n);
            }
            if (r + n / 2 <= R && b + n / 2 <= B) {
                result += getSolve(n - 1, r + n / 2, g, b + n / 2) * get2(n);
            }
        }
        dp[n][r][g][b] = result;
        return result;
    }

    private static long get3(int n) {
        long result = 1;
        long temp = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        for (int i = 1; i <= n / 3; i++) {
            temp *= i;
        }
        return result / temp / temp / temp;
    }

    private static long get2(int n) {
        long result = 1;
        long temp = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        for (int i = 1; i <= n / 2; i++) {
            temp *= i;
        }
        return result / temp / temp;
    }
}
