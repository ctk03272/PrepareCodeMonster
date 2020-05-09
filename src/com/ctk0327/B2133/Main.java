package com.ctk0327.B2133;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int dp[] = new int[N + 1];
        dp[0]=1;
        if (N >= 2) {
            dp[2] = 3;
        }

        if (N >= 4) {
            dp[4] = 3 * 3 + 2;
        }

        for (int i = 5; i <= N; i++) {
            if(i%2!=0){
                continue;
            }
            dp[i] += dp[i - 2] * 3;
            for (int j = 4; j <= i; j++) {
                dp[i] += dp[i - j] * 2;
            }
        }
        System.out.println(dp[N]);
    }
}
