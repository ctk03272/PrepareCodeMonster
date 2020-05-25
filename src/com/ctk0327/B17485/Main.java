package com.ctk0327.B17485;

import java.util.Scanner;

public class Main {
    static int N, M;
    static int[][] input;
    static int[][][] dp;
    static int answer=Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        input=new int[N][M];
        dp=new int[N][M][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                input[i][j]=sc.nextInt();
            }
        }
        for (int i = 0; i <M ; i++) {
            for (int j = 0; j <3 ; j++) {
                dp[0][i][j]=input[0][i];
            }
        }
        for (int i = 1; i <N ; i++) {
            for (int j = 0; j <M ; j++) {
                if(j==0){
                    dp[i][j][1]=dp[i-1][j][2]+input[i][j];
                    dp[i][j][2]=Math.min(dp[i-1][j+1][0],dp[i-1][j+1][1])+input[i][j];
                }else if(j==M-1){
                    dp[i][j][0]=Math.min(dp[i-1][j-1][1],dp[i-1][j-1][2])+input[i][j];
                    dp[i][j][1]=dp[i-1][j][0]+input[i][j];
                }else{
                    dp[i][j][0]=Math.min(dp[i-1][j-1][1],dp[i-1][j-1][2])+input[i][j];
                    dp[i][j][1]=Math.min(dp[i-1][j][0],dp[i-1][j][2])+input[i][j];
                    dp[i][j][2]=Math.min(dp[i-1][j+1][0],dp[i-1][j+1][1])+input[i][j];
                }
            }
        }
        for (int i = 0; i <M ; i++) {
            for (int j = 0; j <3 ; j++) {
                if(!(i==0 && j==0) && !(i==M-1 && j==2)){
                    answer=Math.min(answer,dp[N-1][i][j]);
                }
            }
        }
        System.out.println(answer);
    }
}
