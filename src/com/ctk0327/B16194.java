package com.ctk0327;

import java.util.Scanner;

public class B16194 {
    static int[] dp;
    static int[] input;
    static int N;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        input=new int[N];
        dp=new int[N];
        for (int i = 0; i < N; i++) {
            input[i]=sc.nextInt();
        }
        int min;
        for (int i = 0; i < N; i++) {
            min=input[i];
            for (int j = 0; j <i ; j++) {
                if(min>dp[j]+input[i-1-j]){
                    min=dp[j]+input[i-1-j];
                }
            }
            dp[i]=min;
        }
        System.out.println(dp[N-1]);
    }
}
