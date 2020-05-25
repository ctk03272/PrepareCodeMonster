package com.ctk0327.B16468;

import java.util.Scanner;

public class Main {
    static int dp[][][];
    static int N,L;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        L=sc.nextInt();
        dp=new int[N][L][2];
        System.out.println(getBall(N,L,0)+getBall(N,L,1));
    }

    private static int getBall(int n,int l,int b) {
        int result=0;
        if(l>L){
            return 0;
        }
        if(dp[n][l][b]!=0){
            return dp[n][l][b];
        }

        if(n==1 && l==1){
            return 1;
        }
        if(b==1){
        }else{

        }
        return  result;
    }
}
