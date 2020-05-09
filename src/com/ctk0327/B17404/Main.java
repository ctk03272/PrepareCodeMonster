package com.ctk0327.B17404;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int color[][] = new int[N][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                color[i][j] = sc.nextInt();
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int start = 0; start < 3; start++) {
            int dp[] = new int[N];
            dp[0] = color[0][start];
            int prev = start;
            for (int i = 1; i < N-1; i++) {
                if (prev == 0) {
                    dp[i] = Math.min(dp[i - 1] + color[i][1], dp[i - 1] + color[i][2]);
                    prev = color[i][1] > color[i][2] ? 1 : 2;
                } else if (prev == 1) {
                    dp[i] = Math.min(dp[i - 1] + color[i][0], dp[i - 1] + color[i][2]);
                    prev = color[i][0] > color[i][2] ? 0 : 2;
                } else {
                    dp[i] = Math.min(dp[i - 1] + color[i][0], dp[i - 1] + color[i][1]);
                    prev = color[i][0] > color[i][1] ? 0: 1;
                }
            }
            dp[N-1]=Integer.MAX_VALUE;
            for (int i = 0; i <3 ; i++) {
                if(i!=prev && i!=start){
                    dp[N-1]=Math.min(dp[N-1],dp[N-2]+color[N-1][i]);
                }
            }
            ans = Math.min(ans, dp[N - 1]);
        }

        System.out.println(ans);
    }
}
