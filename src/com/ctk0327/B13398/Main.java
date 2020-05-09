package com.ctk0327.B13398;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[] input=new int[N];
        int dp[][]=new int[N][2];
        for (int i = 0; i <N ; i++) {
            input[i]=sc.nextInt();
        }
        dp[0][0]=input[0];
        dp[0][1]=0;
        // input이 1개만 있을경우 최소한 1개는 선택해야함.. 어거 때문에 틀렸었음;;
        int result=input[0];
        for (int i = 1; i <N ; i++) {
            // 한개도 빼지 않는 경우 최대값과
            if(dp[i-1][0]>0){
                dp[i][0]=dp[i-1][0]+input[i];
            }else{
                dp[i][0]=input[i];
            }
            // 한개를 뺄 경우 최대값을 따로 구한다
            dp[i][1]=Math.max(dp[i-1][1]+input[i],dp[i-1][0]);
            if(result<dp[i][0]){
                result=dp[i][0];
            }
            if(result<dp[i][1]){
                result=dp[i][1];
            }
        }
        System.out.println(result);
    }
}
