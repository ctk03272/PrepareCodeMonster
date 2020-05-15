package com.ctk0327.B2225;

import java.util.Scanner;

public class Main {
    static int N, K;
    static long mod;
    static long dp[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        mod=10000000000L;
        dp = new long[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            dp[i][1] = 1;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                for (int k = 0; k <=i ; k++) {
                    dp[i][j]+=dp[i-k][j-1]%mod;
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
