package com.ctk0327.B1695;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] input;
    static int[][] dp;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new int[N][N];
        input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i],-1);
        }
        System.out.println(printMinPel(0,N-1));
    }

    private static int printMinPel(int x, int y) {
        if(x==y){
            return 0;
        }
        if(dp[x][y]!=-1){
            return dp[x][y];
        }
        if(input[x]==input[y]){
            dp[x][y]=printMinPel(x+1,y-1);
        }else{
            if(y-x==1){
                return dp[x][y]=1;
            }else{
               return  dp[x][y]=Math.min(printMinPel(x+1,y),printMinPel(x,y-1))+1;
            }
        }
        return dp[x][y];
    }
}
