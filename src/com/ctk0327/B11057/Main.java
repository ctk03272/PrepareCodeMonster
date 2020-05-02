package com.ctk0327.B11057;

import java.util.Scanner;

public class Main {
    static int N;
    static int dp[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new int[N + 1][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= 10007;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += dp[N][i];
        }
        System.out.println(ans%=10007);
    }
}
