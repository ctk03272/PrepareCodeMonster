package com.ctk0327.B15988;

import java.util.Scanner;

public class Main {
    static int T, n;
    static long dp[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < 1000001; i++) {
            dp[i]=(dp[i-1]%1000000009+dp[i-2]%1000000009+dp[i-3]%1000000009)%1000000009;
        }
        while (T > 0) {
            n=sc.nextInt();
            System.out.println(dp[n]);
            T--;
        }
    }
}
