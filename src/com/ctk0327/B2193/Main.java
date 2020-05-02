package com.ctk0327.B2193;

import java.util.Scanner;

public class Main {
    static int N;
    static long dp[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new long[N + 1][2];
        dp[1][1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i][1]=dp[i-1][0];
            dp[i][0]=dp[i-1][1]+dp[i-1][0];
        }
        System.out.println(dp[N][0]+dp[N][1]);
    }
}
