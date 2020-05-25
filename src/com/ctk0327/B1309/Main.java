package com.ctk0327.B1309;

import java.util.Scanner;

public class Main {
    static int N;
    static int[][] dp;
    static int mod;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        mod=9901;
        dp = new int[N + 1][3];
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;
        for (int i = 2; i <=N ; i++) {
            dp[i][0]=(dp[i-1][0]+dp[i-1][1]+dp[i-1][2])%mod;
            dp[i][1]=(dp[i-1][0]+dp[i-1][2])%mod;
            dp[i][2]=(dp[i-1][0]+dp[i-1][1])%mod;
        }
        System.out.println((dp[N][0]+dp[N][2]+dp[N][2])%mod);
    }
}
